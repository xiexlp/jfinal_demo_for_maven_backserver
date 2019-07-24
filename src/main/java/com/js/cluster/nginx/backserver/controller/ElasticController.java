package com.js.cluster.nginx.backserver.controller;


import com.js.cluster.nginx.backserver.orm.User;
import com.js.common.util.ControllerAdaper;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ElasticController extends ControllerAdaper{

    //测试网页的热部署
    public void index(){
        System.out.println("test method");
        User user = new User();
        user.setUserId(1);
        user.setUserName("canava");
        User user1 = new User();
        user1.setUserId(2);
        user1.setUserName("kenny");
        List<User> list = new ArrayList();
        list.add(user);list.add(user1);
        setAttr("list",list);
    }

    public void indexcreate(HttpServletRequest request){
        String tablename = request.getParameter("tablename");
        if(tablename.equalsIgnoreCase("topic")){
            tablename ="ejf_"+tablename;
        }
        System.out.println("tablename:"+tablename);
        //TopicElasticDao.indexCreate(tablename);
    }



}
