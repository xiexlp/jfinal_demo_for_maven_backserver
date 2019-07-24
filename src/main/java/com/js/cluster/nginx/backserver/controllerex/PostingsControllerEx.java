package com.js.cluster.nginx.backserver.controllerex;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.Postings;
import com.js.isearch.serv.PostingsServ;

import java.util.List;
import java.sql.Timestamp;
import java.sql.Date;

public class PostingsControllerEx extends ControllerAdaper {


    public void postingsnew() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+manus.size());
            //setAttr("manus",manus);
            //render("postingsnew.html");
        } else if (method.equalsIgnoreCase("POST")) {
            //User user = getUserFromRequest();
            Postings postings = getPostingsFromRequest();
            //int r = UserServ.n().saveAutoId(user);

            int r = PostingsServ.n().saveAutoId(postings);


            if (r > 0) {
                redirect("/boot/postings/postingss");
            } else {
                System.out.println("新增失败");
            }
        }
    }


    public void postingsPartAdd() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
            //List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+manus.size());
            //setAttr("manus",manus);
            //render("postingsnew.html");
        } else if (method.equalsIgnoreCase("POST")) {
            //User user = getUserFromRequest();
            Postings postings = getPostingsFromRequest();
            //int r = UserServ.n().saveAutoId(user);

            int r = PostingsServ.n().saveAutoId(postings);


            if (r > 0) {
                redirect("/boot/postings/postingss");
            } else {
                System.out.println("新增失败");
            }
        }
    }


    public void postingsedit() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
            //System.out.println("group size:"+groups.size());
            //int userID= getIntPara("userID", 1);
            int postingId = getIntPara("postingId", 1);
            if (postingId == 0) {
                System.out.println("出错");
                return;
            }
            Postings postings = PostingsServ.n().get(postingId);
            //setAttr("groups",groups);
            setAttr("postings", postings);
            //render("postingsedit.html");
        } else if (method.equalsIgnoreCase("POST")) {
            Postings postings = getPostingsFromRequestEdit();
            if (postings == null) {
                System.out.println("id不存在");
                return;
            }
            PostingsServ postingsServ = PostingsServ.n();
            int r = 0;
            r = postingsServ.update(postings);
            if (r > 0) redirect("/boot/postings/postingss");
            else {
                System.out.println("出错");
            }
        }
    }


    public void postingsPartUpdate() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
            int postingId = getIntPara("postingId", 1);
            if (postingId == 0) {
                System.out.println("出错");
                return;
            }
            Postings postings = PostingsServ.n().get(postingId);
            setAttr("postings", postings);
        } else if (method.equalsIgnoreCase("POST")) {
            Postings postings = getPostingsFromRequestEdit();
            if (postings == null) {
                System.out.println("id不存在");
                return;
            }
            PostingsServ postingsServ = PostingsServ.n();
            int r = 0;
            r = postingsServ.update(postings);
            if (r > 0) redirect("/boot/postings/postingss");
            else {
                System.out.println("出错");
            }
        }
    }


    //controller list方法，放在controller里面
    public void postingslist() {
        int pageNo = getIntPara("pageNo", 1);
        PageList<Postings> postingslist = PostingsServ.n().findByPage(pageNo, 21);
        setAttr("postingslist", postingslist);
        System.out.println("list size:" + postingslist.size());
        String actionUrl = "postingslist?1=1";
        setPageInfo(postingslist, actionUrl);
        //render("postingslist.html");
    }


    //controller list方法，放在controller里面
    public void postingsPartPage() {
        int pageNo = getIntPara("pageNo", 1);
        PageList<Postings> postingslist = PostingsServ.n().findByPage(pageNo, 21);
        setAttr("postingslist", postingslist);
        System.out.println("list size:" + postingslist.size());
        String actionUrl = "postingsPartPage?1=1";
        setPageInfo(postingslist, actionUrl);
        //render("postingss.html");
    }

    //放在controller delete方法
    public void postingsdel() {
        //int departID = getIntPara("departID",0);

        int postingId = getIntPara("postingId", 1);
        if (postingId == 0) {
            System.out.println("出错");
            return;
        }


        int r = PostingsServ.n().delete(postingId);
        if (r > 0) redirect("/boot/postings/postingslist");
    }

    public Postings getPostingsFromRequest() {
        Postings postings = new Postings();
        long tokenId = System.currentTimeMillis();
        postings.setTokenId(tokenId);
        String token = getStrPara("token", "");
        postings.setToken(token);
        long docId = System.currentTimeMillis();
        postings.setDocId(docId);
        String tablename = getStrPara("tablename", "");
        postings.setTablename(tablename);
        String dbname = getStrPara("dbname", "");
        postings.setDbname(dbname);
        int frequency = getIntPara("frequency", 0);
        postings.setFrequency(frequency);
        String positions = getStrPara("positions", "");
        postings.setPositions(positions);
        long createTime = System.currentTimeMillis();
        postings.setCreateTime(createTime);
        long updateTime = System.currentTimeMillis();
        postings.setUpdateTime(updateTime);
        int tokenSize = getIntPara("tokenSize", 0);
        postings.setTokenSize(tokenSize);
        String fieldname = getStrPara("fieldname", "");
        postings.setFieldname(fieldname);
        int fieldnameType = getIntPara("fieldnameType", 0);
        postings.setFieldnameType(fieldnameType);
        return postings;
    }


    public Postings getPostingsFromRequestEdit() {
        Postings postings = new Postings();
        long postingId = System.currentTimeMillis();
        postings.setPostingId(postingId);
        long tokenId = System.currentTimeMillis();
        postings.setTokenId(tokenId);
        String token = getStrPara("token", "");
        postings.setToken(token);
        long docId = System.currentTimeMillis();
        postings.setDocId(docId);
        String tablename = getStrPara("tablename", "");
        postings.setTablename(tablename);
        String dbname = getStrPara("dbname", "");
        postings.setDbname(dbname);
        int frequency = getIntPara("frequency", 0);
        postings.setFrequency(frequency);
        String positions = getStrPara("positions", "");
        postings.setPositions(positions);
        long createTime = System.currentTimeMillis();
        postings.setCreateTime(createTime);
        long updateTime = System.currentTimeMillis();
        postings.setUpdateTime(updateTime);
        int tokenSize = getIntPara("tokenSize", 0);
        postings.setTokenSize(tokenSize);
        String fieldname = getStrPara("fieldname", "");
        postings.setFieldname(fieldname);
        int fieldnameType = getIntPara("fieldnameType", 0);
        postings.setFieldnameType(fieldnameType);
        return postings;
    }

}

