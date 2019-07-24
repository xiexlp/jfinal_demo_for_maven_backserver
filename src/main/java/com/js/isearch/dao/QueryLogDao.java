package com.js.isearch.dao;

/**
* last update time:"18-06-06 16:31:07"
* last update user:pku
*/

import com.js.isearch.orm.QueryLog;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.daoex.QueryLogDaoEx;

public interface QueryLogDao extends QueryLogDaoEx{

    public List<QueryLog> findNames(List<String> names,String hql);

    public PageList<QueryLog> findNamesPage(List<String> names,String hql,int pageNo,int total);

    public int updateSet(String set,String where);

    public int deleteWhere(String where);

}
