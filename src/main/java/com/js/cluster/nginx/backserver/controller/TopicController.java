package com.js.cluster.nginx.backserver.controller;

import com.js.cluster.nginx.backserver.orm.User;
import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.Topic;
import com.js.isearch.serv.TopicServ;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


public class TopicController extends ControllerAdaper{


    //测试网页的热部署
    public void index(){
        PageList<Topic> topicList = TopicServ.n().findByPage(1,111);
        String actionUrl = "/topic?";
        setPageInfo(topicList,actionUrl);
        setAttr("name","hi123");
        setAttr("topicList",topicList);
    }


    public void topicdetail(HttpServletRequest request){
        int topicId= getIntPara("topicId");
        Topic t= TopicServ.n().get(topicId);
        setAttr("name","hi123");
        setAttr("t",t);
    }



    public void indexdoc(HttpServletRequest request){

    }

}
