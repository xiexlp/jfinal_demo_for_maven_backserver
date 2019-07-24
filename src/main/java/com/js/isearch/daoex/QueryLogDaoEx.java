package com.js.isearch.daoex;

/**
* last update time:"18-06-07 18:13:05"
* last update user:pku
*/

import com.js.isearch.orm.QueryLog;
import java.util.List;
import com.js.common.util.PageList;

public interface QueryLogDaoEx{

public int save(QueryLog queryLog);
public int saveAutoId(QueryLog queryLog);

public int saveAutoReturnId(QueryLog queryLog);


public QueryLog get(long logId);

public int delete(long logId);

public int update(QueryLog queryLog);

public List<QueryLog> find(String hql);

public List<QueryLog> findAll();

public PageList<QueryLog> findByPage(int pageNo,int total);

public PageList<QueryLog> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
