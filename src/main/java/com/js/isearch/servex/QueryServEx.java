package com.js.isearch.servex;

/**
* last update time:"18-06-06 22:10:54"
* last update user:pku
*/

import com.js.isearch.orm.Query;
import com.js.isearch.daoimplex.QueryDaoimplEx;
import com.js.isearch.daoex.QueryDaoEx;
import java.util.List;
import com.js.common.util.PageList;

public class QueryServEx{

private QueryDaoEx queryDaoEx;

public QueryServEx(){
this.queryDaoEx =new QueryDaoimplEx();
}

public static QueryServEx n(){
return new QueryServEx();
}

public int save(Query query){
return this.queryDaoEx.save(query);
}
public int saveAutoId(Query query){
return this.queryDaoEx.saveAutoId(query);
}

public int saveAutoReturnId(Query query){
return this.queryDaoEx.saveAutoReturnId(query);
}


public Query get(long queryId){
return this.queryDaoEx.get(queryId);
}

public int delete(long queryId){
return this.queryDaoEx.delete(queryId);
}

public int update(Query query){
return this.queryDaoEx.update(query);
}

public List find(String hql){
return null;
}

public List<Query> findAll(){
return this.queryDaoEx.findAll();
}

public PageList<Query> findByPage(int pageNo,int total){
return this.queryDaoEx.findByPage(pageNo,total);
}

public PageList<Query> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.queryDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}

}
