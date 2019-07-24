package com.js.cluster.nginx.backserver.controller;

import com.js.cluster.nginx.backserver.lab.UserFactory;
import com.js.cluster.nginx.backserver.orm.User;
import com.js.common.sort.QuickSort;
import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SortController extends ControllerAdaper {

    //测试网页的热部署,测试快速排序
    public void fast(){
        User user = new User();
        user.setUserId(1);
        user.setAge(20);
        user.setUserName("canava");
        User user1 = new User();
        user1.setUserId(2);
        user1.setAge(30);
        user1.setUserName("kenny");

        User user2 = new User();
        user2.setUserId(3);
        user2.setAge(25);
        user2.setUserName("john");
        List<User> list = new ArrayList<>();
        list.add(user);list.add(user1);list.add(user2);
       setAttr("name","hi123");
        QuickSort.sort(list);
        setAttr("list",list);
    }

    //测试网页的热部署,测试快速排序
    public void quick(){
        int pageNo = getIntPara("pageNo",1);
        List<User> list = UserFactory.getManaUsers(44);
        PageList<User> userList = UserFactory.getManyUsersPage(list,pageNo);

        setAttr("name","hi123");
        //QuickSort.sort(list);
        setAttr("userList",userList);
        String actionUrl ="/boot/sort/quick?1=1";
        setPageInfo(userList,actionUrl);
    }

}
