package com.js.isearch.serv;

/**
* last update time:"18-05-08 15:19:39"
* last update user:pku
*/

import com.js.isearch.orm.Topic;
import com.js.isearch.daoimpl.TopicDaoimpl;
import com.js.isearch.dao.TopicDao;
import com.js.isearch.servex.TopicServEx;
import java.util.List;
import com.js.common.util.PageList;

public class TopicServ extends TopicServEx{

private TopicDao topicDao;

public TopicServ(){
this.topicDao =new TopicDaoimpl();
}

public static TopicServ n(){
return new TopicServ();
}


    public static void main(String[] args) {
        List<Topic> topicList = TopicServ.n().findAll();
        for(Topic topic:topicList){
            System.out.println("title:"+topic.getTitle()+" content:"+topic.getContent());
        }


    }

}
