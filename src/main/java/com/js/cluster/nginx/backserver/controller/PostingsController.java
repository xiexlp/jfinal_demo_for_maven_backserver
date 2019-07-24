package com.js.cluster.nginx.backserver.controller;


import com.alibaba.fastjson.JSON;
import com.js.cluster.nginx.backserver.orm.DocResult;
import com.js.cluster.nginx.backserver.orm.Hit;
import com.js.cluster.nginx.backserver.orm.Position;
import com.js.cluster.nginx.backserver.orm.WordPos;
import com.js.common.sort.QuickSort;
import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageInfo;
import com.js.common.util.PageList;
import com.js.common.util.Pager;
import com.js.isearch.index.HighLighter;
import com.js.isearch.index.HitScore;
import com.js.isearch.index.JcsegService;
import com.js.isearch.index.SearchDemo;
import com.js.isearch.orm.Doc;
import com.js.isearch.orm.Postings;
import com.js.isearch.orm.QueryLog;
import com.js.isearch.serv.DocServ;
import com.js.isearch.serv.PostingsServ;
import com.js.isearch.serv.QueryLogServ;
import org.lionsoul.jcseg.core.IWord;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class PostingsController extends ControllerAdaper{

  
    //测试网页的热部署
    public  void index() {
        int pageNo = getIntPara("pageNo",1);
        PageList<Postings> postingsList = PostingsServ.n().findByAllPage(pageNo, 111);
        String actionUrl = "/boot/postings/index?1=1";
        setPageInfo(postingsList, actionUrl);
        setAttr("name", "hi123");
        setAttr("postingsList", postingsList);
    }



    //测试网页的热部署
    public  void postingsdetail() {
        int postingsId = getIntPara(  "postingsId");
        Postings t = PostingsServ.n().get(postingsId);
        setAttr("name", "hi123");
        setAttr("t", t);
    }

   
    /***
     * 删除索引
     */
    public int postingsdel(){
        int docId= getIntPara( "docId");
        int r=PostingsServ.n().deleteByDocId(docId);
        r=DocServ.n().updateUpdateTimeIndexStatusByDocId(System.currentTimeMillis(),"0",docId);
        return r;
    }

    public  void list(){
        int docId= getIntPara( "docId",1);
        int pageNo = getIntPara( "pageNo",1);
        PageList<Postings> postingsList = PostingsServ.n().findByDocIdPage(docId,pageNo,100);
        String actionUrl = "/boot/postings/list?1=1";
        setPageInfo(postingsList, actionUrl);
        setAttr("name", "hi123");
        setAttr("postingsList", postingsList);
    }

    private QueryLog getQueryLog(String query){
        QueryLog queryLog = new QueryLog();
        queryLog.setCreateTime(System.currentTimeMillis());
        queryLog.setQuery(query);
        queryLog.setIp(getRequest().getRemoteHost());
        queryLog.setTerminal(getRequest().getRequestURI());
        queryLog.setWebUrl(getRequest().getRequestURI());
        return  queryLog;
    }

    public void search2json(){
        String query = getStrPara( "query");
        int pageNo = getIntPara( "pageNo",1);

        QueryLog queryLog = getQueryLog(query);
        int result=QueryLogServ.n().saveAutoId(queryLog);
        if(result>0) System.out.println("用户查询日志已经记录");

        //分词工具类
        SearchDemo searchDemo = new SearchDemo();
        //解析用户输入
        List<String> queryList = searchDemo.seperator(query);
        PostingsServ postingsServ = new PostingsServ();

        Map<Long,Hit> mapDocId2Hit = new HashMap<>();
        List<Hit> hitList = new ArrayList<>();
        DocServ docServ = DocServ.n();
        Doc doc =null;
        DocResult docResult=null;
        Hit hit = null;
        Position position=null;
        for(String q:queryList){
            System.out.println("搜索的词:"+q);
            List<Postings> postingsList = postingsServ.findDocIdPositionsFieldnameByToken(q);
            //Map<DocResult,List<Integer>> docIdPostionListMap = new HashMap<>();
            for(Postings p:postingsList){
                long docId = p.getDocId();
                String fieldname = p.getFieldname();
                position = new Position(fieldname,q);
                doc = docServ.get(docId);
                //如果已经存在则取出来,不存在则新建一个
                hit = mapDocId2Hit.get(docId);
                if(hit==null){
                    System.out.println("不存在hit");
                    hit = new Hit(doc);
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    hitList.add(hit);
                    //放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                //已经存在
                }else{
                    System.out.println("已经存在hit");
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    //放入进去，更新的hit放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                }
            }
        }
        System.out.println("hitList size:"+hitList.size());
        setAttr("hitList", hitList);
        renderJson(hitList);
    }

    /**
     * 提供的微服务
     */
    public void searchmicroservice(){
        String query = getStrPara( "query");
        int pageNo = getIntPara( "pageNo",1);

        QueryLog queryLog = getQueryLog(query);
        int result=QueryLogServ.n().saveAutoId(queryLog);
        if(result>0) System.out.println("用户查询日志已经记录");

        //分词工具类
        //SearchDemo searchDemo = new SearchDemo();
        //解析用户输入
       // List<String> queryList = searchDemo.seperator(query);

        //解析用户输入
        List<IWord> queryList = JcsegService.getInstance().seperateByJcseg(query);

//        for(String q:queryList){
//            System.out.println("分词:"+q);
//        }

        for(IWord q:queryList){
            System.out.println("分词:"+q.getValue());
        }

        PostingsServ postingsServ = new PostingsServ();

        Map<Long,Hit> mapDocId2Hit = new HashMap<>();
        List<Hit> hitList = new ArrayList<>();
        DocServ docServ = DocServ.n();
        Doc doc =null;
        DocResult docResult=null;
        Hit hit = null;
        Position position=null;
        for(IWord w:queryList){
            String q = w.getValue();
            System.out.println("搜索的词:"+q);

            List<Postings> postingsList = postingsServ.findDocIdPositionsFieldnameByToken(q);
            //Map<DocResult,List<Integer>> docIdPostionListMap = new HashMap<>();
            for(Postings p:postingsList){
                long docId = p.getDocId();
                String fieldname = p.getFieldname();
                position = new Position(fieldname,q);
                doc = docServ.get(docId);

                //如果已经存在则取出来,不存在则新建一个
                hit = mapDocId2Hit.get(docId);
                if(hit==null){
                    System.out.println("不存在hit");

                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    int positionNum= posList.size();
                    if(fieldname.equals("title")) doc.addScore(2*positionNum);
                    else if(fieldname.equals("content")) doc.addScore(1.5*positionNum);

                    System.out.println("fieldname:"+fieldname+"id:"+docId+" size:"+positionNum);
                    hit = new Hit(doc);
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    hitList.add(hit);
                    //放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                    //已经存在
                }else{
                    System.out.println("已经存在hit");
                    //hit = new Hit(doc);
                    //hit = mapDocId2Hit.get(docId);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    int positionNum = posList.size();
                    System.out.println("fieldname:"+fieldname+" id:"+docId+" size:"+positionNum);
                    //增加hitCount
                    hit.setHitCount(hit.getHitCount()+positionNum);
                    if(fieldname.equals("title")) hit.addScore(2*positionNum);
                    else if(fieldname.equals("content")) hit.addScore(1.5*positionNum);

                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    //已经存在了，不需要增加进去了吧
                    //hitList.add(hit);
                    //放入进去，更新的hit放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                }
            }
        }
        System.out.println("hitList size:"+hitList.size());

        //Collection<Hit> resultHitSet =mapDocId2Hit.values();
        //List<Hit> resultHitList =new ArrayList<>();

        QuickSort.sort(hitList);
        for(Hit h:hitList){
            System.out.println("得分:"+h.getScore());
        }
        int total = hitList.size();
        PageInfo pageInfo = new PageInfo(pageNo,total);
        int fromIndex = (pageNo-1)*pageInfo.pageSize;
        //List<Hit> hitSubList = hitList.subList(fromIndex,fromIndex+pageInfo.pageSize);
        PageList<Hit> hitPageList = new PageList<>(pageNo,total);
        for(int i=0;i<pageInfo.pageSize;i++){
            int index = (pageNo-1)*pageInfo.pageSize+i;
            if(index>=total){
                break;
            }
            hitPageList.add(hitList.get(index));
        }

        //"http://localhost/boot/lion/searchmicroservice?query=android";

        String actionUrl = "/boot/lion/searchmicroservice?query="+query;
        Pager pager = new Pager();
        setPageInfo(hitPageList,actionUrl,pager);
        pager.setHitList(hitPageList);
        setAttr("hitPageList", hitPageList);
        String pagerJson = JSON.toJSONString(pager);
        System.out.println("hitPageListJson:"+pagerJson);
        renderJson(pager);
    }

    public void search(){
        String query = getStrPara( "query");
        int pageNo = getIntPara( "pageNo",1);

        QueryLog queryLog = getQueryLog(query);
        int result=QueryLogServ.n().saveAutoId(queryLog);
        if(result>0) System.out.println("用户查询日志已经记录");

        //分词工具类
        //SearchDemo searchDemo = new SearchDemo();
        //解析用户输入
        //List<String> queryList = searchDemo.seperator(query);
        List<IWord> queryList = JcsegService.getInstance().seperateByJcseg(query);

//        for(String q:queryList){
//            System.out.println("分词结果:"+q);
//        }

        for(IWord q:queryList){
            System.out.println("分词结果:"+q.getValue());
        }


        PostingsServ postingsServ = new PostingsServ();

        Map<Long,Hit> mapDocId2Hit = new HashMap<>();
        List<Hit> hitList = new ArrayList<>();
        DocServ docServ = DocServ.n();
        Doc doc =null;
        DocResult docResult=null;
        Hit hit = null;
        Position position=null;
        for(IWord w:queryList){
            String q= w.getValue();
            System.out.println("搜索的词:"+q);
            List<Postings> postingsList = postingsServ.findDocIdPositionsFieldnameByToken(q);
            //Map<DocResult,List<Integer>> docIdPostionListMap = new HashMap<>();
            for(Postings p:postingsList){
                long docId = p.getDocId();
                String fieldname = p.getFieldname();
                position = new Position(fieldname,q);
                doc = docServ.get(docId);

                //如果已经存在则取出来,不存在则新建一个
                hit = mapDocId2Hit.get(docId);
                if(hit==null){
                    System.out.println("不存在hit");

                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    int positionNum= posList.size();
                    if(fieldname.equals("title")) doc.addScore(2*positionNum);
                    else if(fieldname.equals("content")) doc.addScore(1.5*positionNum);

                    System.out.println("fieldname:"+fieldname+"id:"+docId+" size:"+positionNum);
                    hit = new Hit(doc);
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    hitList.add(hit);
                    //放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                    //已经存在
                }else{
                    System.out.println("已经存在hit");
                    //hit = new Hit(doc);
                    //hit = mapDocId2Hit.get(docId);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    int positionNum = posList.size();
                    System.out.println("fieldname:"+fieldname+" id:"+docId+" size:"+positionNum);
                    //增加hitCount
                    hit.setHitCount(hit.getHitCount()+positionNum);
                    if(fieldname.equals("title")) hit.addScore(2*positionNum);
                    else if(fieldname.equals("content")) hit.addScore(1.5*positionNum);

                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    //已经存在了，不需要增加进去了吧
                    //hitList.add(hit);
                    //放入进去，更新的hit放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                }
            }
        }
        System.out.println("hitList size:"+hitList.size());

        //Collection<Hit> resultHitSet =mapDocId2Hit.values();
        //List<Hit> resultHitList =new ArrayList<>();

        QuickSort.sort(hitList);
        for(Hit h:hitList){
            System.out.println("得分:"+h.getScore());
        }
        int total = hitList.size();
        PageInfo pageInfo = new PageInfo(pageNo,total);
        int fromIndex = (pageNo-1)*pageInfo.pageSize;
        //List<Hit> hitSubList = hitList.subList(fromIndex,fromIndex+pageInfo.pageSize);
        PageList<Hit> hitPageList = new PageList<>(pageNo,total);
        for(int i=0;i<pageInfo.pageSize;i++){
            int index = (pageNo-1)*pageInfo.pageSize+i;
            if(index>=total){
                break;
            }
            hitPageList.add(hitList.get(index));
        }
        String actionUrl = "/boot/postings/search?query="+query;
        setPageInfo(hitPageList,actionUrl);
        setAttr("hitPageList", hitPageList);
    }


    //@ResponseBody
    public void searchrest(){
        String query = getStrPara( "query");

        QueryLog queryLog = getQueryLog( query);
        int result1=QueryLogServ.n().saveAutoId(queryLog);
        if(result1>0) System.out.println("用户查询日志已经记录");

        int pageNo = getIntPara( "pageNo",1);
        // void view = new  void("/postings/search.html");
        //分词工具类
        SearchDemo searchDemo = new SearchDemo();
        //解析用户输入
        List<String> queryList = searchDemo.seperator(query);
        PostingsServ postingsServ = new PostingsServ();

        Map<Long,Hit> mapDocId2Hit = new HashMap<>();
        List<Hit> hitList = new ArrayList<>();
        DocServ docServ = DocServ.n();
        Doc doc =null;
        DocResult docResult=null;
        Hit hit = null;
        Position position=null;
        for(String q:queryList){
            System.out.println("搜索的词:"+q);
            List<Postings> postingsList = postingsServ.findDocIdPositionsFieldnameByToken(q);
            for(Postings p:postingsList){
                long docId = p.getDocId();
                String fieldname = p.getFieldname();
                position = new Position(fieldname,q);
                doc = docServ.get(docId);
                //如果已经存在则取出来,不存在则新建一个
                hit = mapDocId2Hit.get(docId);
                if(hit==null){
                    System.out.println("不存在hit");
                    hit = new Hit(doc);
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    hitList.add(hit);
                    //放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                    //已经存在
                }else{
                    System.out.println("已经存在hit");
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    //放入进去，更新的hit放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                }
            }
        }
        System.out.println("hitList size:"+hitList.size());
        String result = JSON.toJSONString(hitList);
        System.out.println("json result rest:"+result);
        //setAttr("hitList", hitList);
    }


    public void searchfastjson(){
        String query = getStrPara( "query");

        QueryLog queryLog = getQueryLog( query);
        int result1=QueryLogServ.n().saveAutoId(queryLog);
        if(result1>0) System.out.println("用户查询日志已经记录");

        int pageNo = getIntPara( "pageNo",1);
        // void view = new  void("/postings/search.html");
        //分词工具类
        SearchDemo searchDemo = new SearchDemo();
        //解析用户输入
        List<String> queryList = searchDemo.seperator(query);
        PostingsServ postingsServ = new PostingsServ();

        Map<Long,Hit> mapDocId2Hit = new HashMap<>();
        List<Hit> hitList = new ArrayList<>();
        DocServ docServ = DocServ.n();
        Doc doc =null;
        DocResult docResult=null;
        Hit hit = null;
        Position position=null;
        for(String q:queryList){
            System.out.println("搜索的词:"+q);
            List<Postings> postingsList = postingsServ.findDocIdPositionsFieldnameByToken(q);
            for(Postings p:postingsList){
                long docId = p.getDocId();
                String fieldname = p.getFieldname();
                position = new Position(fieldname,q);
                doc = docServ.get(docId);
                //如果已经存在则取出来,不存在则新建一个
                hit = mapDocId2Hit.get(docId);
                if(hit==null){
                    System.out.println("不存在hit");
                    hit = new Hit(doc);
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    hitList.add(hit);
                    //放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                    //已经存在
                }else{
                    System.out.println("已经存在hit");
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    //放入进去，更新的hit放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                }
            }
        }
        System.out.println("hitList size:"+hitList.size());
        String result = JSON.toJSONString(hitList);
        System.out.println("json result123:"+result);
        setAttr("hitList", hitList);
    }


    /***
     * 使用ik分词搜索
     * @return
     */
    public  void iksearch(){
        String query = getStrPara( "query");

        QueryLog queryLog = getQueryLog( query);
        int result=QueryLogServ.n().saveAutoId(queryLog);
        if(result>0) System.out.println("用户查询日志已经记录");

        int pageNo = getIntPara( "pageNo",1);
        //分词工具类
        SearchDemo searchDemo = new SearchDemo();
        //解析用户输入
        List<WordPos> queryList = searchDemo.ikseperate(query);
        PostingsServ postingsServ = new PostingsServ();

        Map<Long,Hit> mapDocId2Hit = new HashMap<>();
        List<Hit> hitList = new ArrayList<>();
        DocServ docServ = DocServ.n();
        Doc doc =null;
        DocResult docResult=null;
        Hit hit = null;
        Position position=null;
        for(WordPos q:queryList){
            System.out.println("搜索的词:"+q.getWord());
            List<Postings> postingsList = postingsServ.findDocIdPositionsFieldnameByToken(q.getWord());
            System.out.println("posting list size:"+postingsList.size());
            //Map<DocResult,List<Integer>> docIdPostionListMap = new HashMap<>();
            for(Postings p:postingsList){
                long docId = p.getDocId();
                String fieldname = p.getFieldname();
                position = new Position(fieldname,q);
                doc = docServ.get(docId);
                //如果已经存在则取出来,不存在则新建一个
                hit = mapDocId2Hit.get(docId);
                if(hit==null){
                    System.out.println("不存在hit");
                    hit = new Hit(doc);
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    int posLen = postionArray.length;
                    List<Integer> posList = new ArrayList<>();
                    Integer[] posIntegerArray= new Integer[posLen];
                    for(int i=0;i<posLen;i++){
                        Integer posi = Integer.parseInt(postionArray[i]);
                        posList.add(posi);
                        posIntegerArray[i] = posi;
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    hitList.add(hit);
                    //放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                    //已经存在
                }else{
                    System.out.println("已经存在hit");
                    //hit = new Hit(doc);
                    String postions = p.getPositions();
                    String[] postionArray= postions.split(",");
                    List<Integer> posList = new ArrayList<>();
                    for(String pos:postionArray){
                        Integer posi = Integer.parseInt(pos);
                        posList.add(posi);
                    }
                    position.setPosList(posList);
                    hit.getPostionList().add(position);
                    HighLighter.highLighter(hit);
                    //放入进去，更新的hit放入进去
                    mapDocId2Hit.put(hit.getDocId(),hit);
                }
            }
        }
        System.out.println("hitList size:"+hitList.size());
        HitScore.scoreHitList(hitList);

        setAttr("hitList", hitList);
    }


    public void searchjson(){
        String query = getStrPara( "query");

        QueryLog queryLog = getQueryLog( query);
        int result=QueryLogServ.n().saveAutoId(queryLog);
        if(result>0) System.out.println("用户查询日志已经记录");

        int pageNo = getIntPara( "pageNo",1);
        //分词工具类
        SearchDemo searchDemo = new SearchDemo();
        List<String> queryList = searchDemo.seperator(query);
        PostingsServ postingsServ = new PostingsServ();
        StringBuffer sb = new StringBuffer();
        Set<Long> docIdSet = new HashSet<>();
        Map<String,Map<DocResult,List<Integer>>> queryDocIdPostionsMap=new HashMap<>();
        DocServ docServ = DocServ.n();
        Doc doc =null;
        DocResult docResult=null;
        for(String q:queryList){
            System.out.println("搜索的词:"+q);
            List<Postings> postingsList = postingsServ.findDocIdPositionsFieldnameByToken(q);
            Map<DocResult,List<Integer>> docIdPostionListMap = new HashMap<>();
            for(Postings p:postingsList){
                docIdSet.add(p.getDocId());
                long docId = p.getDocId();
                String fieldname = p.getFieldname();
                doc = docServ.get(docId);
                docResult = new DocResult(doc,fieldname);
                String postions = p.getPositions();
                String[] postionArray= postions.split(",");
                List<Integer> posList = new ArrayList<>();
                for(String pos:postionArray){
                    Integer posi = Integer.parseInt(pos);
                    posList.add(posi);
                }
                docIdPostionListMap.put(docResult,posList);
            }
            queryDocIdPostionsMap.put(q,docIdPostionListMap);
            //sb.append(q).append(":");
        }
         renderJson(queryDocIdPostionsMap);
    }


}
