package com.js.isearch.serv;

/**
* last update time:"18-06-06 16:31:09"
* last update user:pku
*/

import com.js.isearch.orm.QueryLog;
import com.js.isearch.daoimpl.QueryLogDaoimpl;
import com.js.isearch.dao.QueryLogDao;
import com.js.isearch.servex.QueryLogServEx;
import java.util.List;
import com.js.common.util.PageList;

public class QueryLogServ extends QueryLogServEx{

private QueryLogDao queryLogDao;

public QueryLogServ(){
this.queryLogDao =new QueryLogDaoimpl();
}

public static QueryLogServ n(){
return new QueryLogServ();
}


    public List<QueryLog> findNames(List<String> names,String hql){
       return queryLogDao.findNames(names,hql);
    }

    public PageList<QueryLog> findNamesPage(List<String> names,String hql,int pageNo,int total){
        return queryLogDao.findNamesPage(names,hql,pageNo,total);
    }

    public int updateSet(String set,String where){
        return queryLogDao.updateSet(set,where);
    }

    public int deleteWhere(String where){
        return queryLogDao.deleteWhere(where);
    }

}
