package com.js.cluster.nginx.backserver.controller;

import com.js.cluster.nginx.backserver.orm.User;
import com.js.common.util.ControllerAdaper;

import java.util.ArrayList;
import java.util.List;


public class LionController extends ControllerAdaper{

    //测试网页的热部署
    public void s(){
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

    //测试网页的热部署
    public void index(){
        User user = new User();
        user.setUserId(1);
        user.setUserName("canava");
        User user1 = new User();
        user1.setUserId(2);
        user1.setUserName("kenny1");
        List<User> list = new ArrayList();
        list.add(user);list.add(user1);
        setAttr("list",list);
    }




}
