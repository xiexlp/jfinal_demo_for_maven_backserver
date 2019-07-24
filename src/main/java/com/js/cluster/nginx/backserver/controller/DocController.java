package com.js.cluster.nginx.backserver.controller;

import com.alibaba.fastjson.JSON;
import com.js.common.config.SortConfig;
import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.index.DataMove;
import com.js.isearch.index.IndexDemo;
import com.js.isearch.orm.Doc;
import com.js.isearch.orm.Postings;
import com.js.isearch.serv.DocServ;
import com.js.isearch.serv.PostingsServ;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


public class DocController extends ControllerAdaper {


    //测试网页的热部署
    public void index() {
        int pageNo = getIntPara("pageNo", 1);

        //对字段排序
        String fieldname = getStrPara("fieldname","create_time");
        int sort = getIntPara("sort", SortConfig.SORT_ASC);
        boolean asc = false;
        if(sort==SortConfig.SORT_ASC) asc= true;

        PageList<Doc> docList = DocServ.n().findByAllPageOrder(pageNo, 300,fieldname,asc);
        StringBuffer actionUrlSb = new StringBuffer("/boot/doc/index?1=1&fieldname=").append(fieldname).append("&sort=").append(sort);
        setPageInfo(docList, actionUrlSb.toString());
        setAttr("docList",docList);
        setAttr("fieldname",fieldname);
        setAttr("sort",sort);
    }



    //测试网页的热部署
    public void docdetail() {
        int docId = getIntPara("docId");
        Doc t = DocServ.n().get(docId);
        setAttr("name","hi123");
        setAttr("t",t);

        //把当前文档的索引页显示出来
        int pageNo = getIntPara("pageNo", 1);
        PageList<Postings> postingsList = PostingsServ.n().findByDocIdPage(docId, pageNo, 100);
        String actionUrl = "/boot/doc/docdetail?docId=" + docId;
        setPageInfo(postingsList, actionUrl);
        setAttr("postingsList",postingsList);
    }


    //测试网页的热部署
    public void docupdate() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
            int docId = getIntPara("docId");
            Doc t = DocServ.n().get(docId);
            setAttr("doc",t);
        } else if (method.equalsIgnoreCase("POST")) {
            Doc doc = getDocFromRequestEdit();
            int r = DocServ.n().update(doc);
            if (r > 0) redirect("/doc/index");
        }
    }


    //springboot
    public Doc getDocFromRequestEdit() {
        Doc doc = new Doc();
        long docId = getLongPara("docId", 0);
        doc.setDocId(docId);
        String title = getStrPara("title", "");
        doc.setTitle(title);
        int titleSize = getIntPara(  "titleSize", 0);
        doc.setTitleSize(titleSize);
        String body = getStrPara(  "body", "");
        doc.setBody(body);
        int bodySize = getIntPara(  "bodySize", 0);
        doc.setBodySize(bodySize);
        String tablename = getStrPara(  "tablename", "");
        doc.setTablename(tablename);
        String dbname = getStrPara(  "dbname", "");
        doc.setDbname(dbname);
        String fieldname = getStrPara(  "fieldname", "");
        doc.setFieldname(fieldname);
        long fieldId = getLongPara(  "fieldId", 0);
        doc.setFieldId(fieldId);
        String url = getStrPara(  "url", "");
        doc.setUrl(url);
        String host = getStrPara(  "host", "");
        doc.setHost(host);
        long createTime = getLongPara(  "createTime", 0);
        doc.setCreateTime(createTime);
        long updateTime = System.currentTimeMillis();
        doc.setUpdateTime(updateTime);
        String indexStatus = getStrPara(  "indexStatus", "");
        doc.setIndexStatus(indexStatus);
        int indexStage = getIntPara(  "indexStage", 0);
        doc.setIndexStage(indexStage);
        return doc;
    }

    /***
     * 根据文档的id和fieldname对文档进行局部索引
     * @param request
     * @return
     */
    public int indexcreate(HttpServletRequest request) {
        int docId = getIntPara(  "docId");
        String fieldname = getStrPara(  "fieldname");
        Doc t = DocServ.n().get(docId);
        int r = IndexDemo.indexADoc(t, fieldname);
        return r;
    }

    /***
     * 根据文档的id对文档进行索引,包括标题和内容两个字段
     * @param request
     * @return
     */

    public int indexdoc(HttpServletRequest request) {
        int docId = getIntPara(  "docId");
        //String fieldname = getStrPara(  "fieldname");
        Doc t = DocServ.n().get(docId);
        int r1 = IndexDemo.indexADoc(t, "title");
        int r2 = IndexDemo.indexADoc(t, "content");
        return r2;
    }


    /***
     * 批量对为索引的文档进行索引
     * @param request
     * @return
     */
    public int indexdocbat(HttpServletRequest request) {
        int sum = IndexDemo.indexAllDoc();
        return sum;
    }


    /***
     * 文档从原数据库转移到本库，并更新文档的索引状态
     * @param request
     * @return
     */
    public int docmove(HttpServletRequest request) {
        //int docId = getIntPara(  "docId");
        //String fieldname = getStrPara(  "fieldname");
        int num=DataMove.move();
        return num;
    }

    /****
     * 
     * 所有的文档的索引阶段进行升级
     * @param request
     * @return
     */
    public int updateindexstage(HttpServletRequest request){
        DocServ docServ = DocServ.n();
        List<Doc> docList = docServ.findAll();
        int sum=0;
        for(Doc doc:docList){
            int size =0;
            Map<String,Integer> indexStatusMap =null;
            String currentStatus = doc.getIndexStatus();
            if(currentStatus!=null&&!currentStatus.equalsIgnoreCase("0")){
                indexStatusMap = JSON.parseObject(currentStatus,Map.class);
                size = indexStatusMap.size();
                sum++;
            }else if(currentStatus.equalsIgnoreCase("0")){
                size =0;
            }
            //全部更新
            System.out.println("当前 stage"+doc.getIndexStage() +" 索引size:"+size+" 更新为:"+size);
            docServ.updateIndexStageByDocId(size,doc.getDocId());
        }
        return sum;
    }


    public void searchresult(HttpServletRequest request) {
        String query = getStrPara(  "query", "");
    }


    public void search(HttpServletRequest request) {
    }


}
