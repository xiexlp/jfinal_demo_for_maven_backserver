package com.js.isearch.servex;

/**
* last update time:"18-06-07 18:10:44"
* last update user:pku
*/

import com.js.isearch.orm.QueryLog;
import com.js.isearch.daoimplex.QueryLogDaoimplEx;
import com.js.isearch.daoex.QueryLogDaoEx;
import java.util.List;
import com.js.common.util.PageList;

public class QueryLogServEx{

private QueryLogDaoEx queryLogDaoEx;

public QueryLogServEx(){
this.queryLogDaoEx =new QueryLogDaoimplEx();
}

public static QueryLogServEx n(){
return new QueryLogServEx();
}

public int save(QueryLog queryLog){
return this.queryLogDaoEx.save(queryLog);
}
public int saveAutoId(QueryLog queryLog){
return this.queryLogDaoEx.saveAutoId(queryLog);
}

public int saveAutoReturnId(QueryLog queryLog){
return this.queryLogDaoEx.saveAutoReturnId(queryLog);
}


public QueryLog get(long logId){
return this.queryLogDaoEx.get(logId);
}

public int delete(long logId){
return this.queryLogDaoEx.delete(logId);
}

public int update(QueryLog queryLog){
return this.queryLogDaoEx.update(queryLog);
}

public List<QueryLog> find(String hql){
return this.queryLogDaoEx.find(hql);
}

public List<QueryLog> findAll(){
return this.queryLogDaoEx.findAll();
}

public PageList<QueryLog> findByPage(int pageNo,int total){
return this.queryLogDaoEx.findByPage(pageNo,total);
}

public PageList<QueryLog> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.queryLogDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}

}
