package com.js.isearch.daoex;

/**
* last update time:"18-06-06 22:10:51"
* last update user:pku
*/

import com.js.isearch.orm.Query;
import java.util.List;
import com.js.common.util.PageList;

public interface QueryDaoEx{

public int save(Query query);
public int saveAutoId(Query query);

public int saveAutoReturnId(Query query);


public Query get(long queryId);

public int delete(long queryId);

public int update(Query query);

public List find(String hql);

public List<Query> findAll();

public PageList<Query> findByPage(int pageNo,int total);

public PageList<Query> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
