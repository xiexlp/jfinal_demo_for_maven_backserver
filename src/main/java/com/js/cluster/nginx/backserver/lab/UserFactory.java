package com.js.cluster.nginx.backserver.lab;

import com.js.cluster.nginx.backserver.orm.User;
import com.js.common.sort.QuickSort;
import com.js.common.util.PageList;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/***
 * 模拟排序
 *
 */
public class UserFactory {
    /**
     * 得到排序的总列表
     * @param size
     * @return
     */
    public static List<User> getManaUsers(int size){
            User user = null;
            List<User> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                String name = RandomStringUtils.randomAlphabetic(5);
                int age = RandomUtils.nextInt(1,80);
                long id = i;
                user = new User().buildUserId(id).buildUserName(name).buildAge(age);
                list.add(user);
            }
            //排序
            QuickSort.sort(list);
            return list;
        }

    /***
     * 分页得到使用的对象列表
     * @param list 总列表，已经排好序
     * @param pageNo 当前页
     * @return
     */
    public static PageList<User> getManyUsersPage(List list,int pageNo){
            //int size =32;
            User user = null;
            PageList<User> userList = new PageList<>(pageNo);
            /**
             * 从list 中分页截取
             */
            interceptList(list,userList);

            //userList.setTotal(size);
            return userList;
        }

    /***
     * 从已经排序号的list中截取
     * @param list
     * @return
     */
    public static void interceptList(List list,PageList pageList){
            int total = list.size();
            pageList.setTotal(total);
            int offSet = pageList.getOffset();
            int pageSize = pageList.getPageSize();


            for(int i=offSet;(i<offSet+pageSize)&&i<total;i++){
                Object user1 = list.get(i);
                if(user1!=null)
                    pageList.add(list.get(i));
            }
    }


}
