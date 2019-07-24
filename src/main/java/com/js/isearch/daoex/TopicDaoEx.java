package com.js.isearch.daoex;

/**
* last update time:"18-05-08 15:19:42"
* last update user:pku
*/

import com.js.isearch.orm.Topic;
import java.util.List;
import com.js.common.util.PageList;

public interface TopicDaoEx{

public int save(Topic topic);
public int saveAutoId(Topic topic);

public int saveAutoReturnId(Topic topic);


public Topic get(int topicId);

public int delete(int topicId);

public int update(Topic topic);

public List find(String hql);

public List<Topic> findAll();

public PageList<Topic> findByPage(int pageNo,int total);

}
