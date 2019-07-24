package com.js.cluster.nginx.backserver.controller;

import com.alibaba.fastjson.JSON;
import com.js.cluster.nginx.backserver.orm.User;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    //测试热部署
    public List<User> go(String callback){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("hello go8080为什么不自动部署，应该可以吧111？");
        User user = new User();
        user.setUserId(1);
        user.setUserName("canava");
        User user1 = new User();
        user1.setUserId(2);
        user1.setUserName("kenny");
        List<User> list = new ArrayList();
        list.add(user);list.add(user1);
        return list;
    }

    public String users(String callback){
        User user = new User();
        user.setUserId(1);
        user.setUserName("canava");
        User user1 = new User();
        user1.setUserId(2);
        user1.setUserName("kenny");
        List<User> list = new ArrayList();
        list.add(user);list.add(user1);
        return callback+"("+ JSON.toJSONString(list)+")";
    }

    //测试网页的热部署
    public void test(){
        System.out.println("test method");
    }




}
