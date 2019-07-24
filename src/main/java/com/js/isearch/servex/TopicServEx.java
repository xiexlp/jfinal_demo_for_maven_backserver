package com.js.isearch.servex;

/**
* last update time:"18-05-08 15:19:45"
* last update user:pku
*/

import com.js.isearch.orm.Topic;
import com.js.isearch.daoimplex.TopicDaoimplEx;
import com.js.isearch.daoex.TopicDaoEx;
import java.util.List;
import com.js.common.util.PageList;

public class TopicServEx{

private TopicDaoEx topicDaoEx;

public TopicServEx(){
this.topicDaoEx =new TopicDaoimplEx();
}

public static TopicServEx n(){
return new TopicServEx();
}

public int save(Topic topic){
return this.topicDaoEx.save(topic);
}
public int saveAutoId(Topic topic){
return this.topicDaoEx.saveAutoId(topic);
}

public int saveAutoReturnId(Topic topic){
return this.topicDaoEx.saveAutoReturnId(topic);
}


public Topic get(int topicId){
return this.topicDaoEx.get(topicId);
}

public int delete(int topicId){
return this.topicDaoEx.delete(topicId);
}

public int update(Topic topic){
return this.topicDaoEx.update(topic);
}

public List find(String hql){
return null;
}

public List<Topic> findAll(){
return this.topicDaoEx.findAll();
}

public PageList<Topic> findByPage(int pageNo,int total){
return this.topicDaoEx.findByPage(pageNo,total);
}

}
