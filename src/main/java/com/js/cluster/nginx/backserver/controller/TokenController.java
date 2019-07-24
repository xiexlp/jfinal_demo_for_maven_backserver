package com.js.cluster.nginx.backserver.controller;

import com.js.common.config.SortConfig;
import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.index.IndexDemo;
import com.js.isearch.orm.Token;
import com.js.isearch.serv.TokenServ;



public class TokenController extends ControllerAdaper {


    //测试网页的热部署
    public void index() {
        int pageNo = getIntPara("pageNo",1);

        //对字段排序
        String fieldname = getStrPara("fieldname","doc_count");
        int sort = getIntPara("sort", SortConfig.SORT_ASC);
        boolean asc = false;
        if(sort==SortConfig.SORT_ASC) asc= true;

        PageList<Token> tokenList = TokenServ.n().findByAllPageOrder(pageNo, 5000,"doc_count",asc);
        StringBuffer actionUrlSb = new StringBuffer("/token/index?1=1&fieldname=").append(fieldname).append("&sort=").append(sort);
        //String actionUrl = "/token/index?1=1&fieldname="+fieldname+"&sort="+sort;
        setPageInfo(tokenList, actionUrlSb.toString());
        setAttr("name", "hi123");
        setAttr("tokenList", tokenList);

        setAttr("fieldname", fieldname);
        setAttr("sort",sort);
    }


    //测试网页的热部署
    public void tokendetail() {
        int tokenId = getIntPara("tokenId");
        Token t = TokenServ.n().get(tokenId);
        setAttr("name", "hi123");
        setAttr("t", t);
    }


    public void searchresult(){
        String query = getStrPara("query","");
    }


    public void search(){

    }


}
