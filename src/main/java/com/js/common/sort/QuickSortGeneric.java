package com.js.common.sort;

import com.js.cluster.nginx.backserver.orm.User;

public class QuickSortGeneric {

    public static void main(String[] args) {
        User user =new User();
        user.buildUserName("canava").buildUserId(1).buildAge(20);
        System.out.println(user.getUserName());
    }


}
