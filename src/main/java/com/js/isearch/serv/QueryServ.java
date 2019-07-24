package com.js.isearch.serv;

/**
* last update time:"18-06-06 16:04:54"
* last update user:pku
*/

import com.js.isearch.orm.Query;
import com.js.isearch.daoimpl.QueryDaoimpl;
import com.js.isearch.dao.QueryDao;
import com.js.isearch.servex.QueryServEx;
import java.util.List;
import com.js.common.util.PageList;

public class QueryServ extends QueryServEx{

private QueryDao queryDao;

public QueryServ(){
this.queryDao =new QueryDaoimpl();
}

public static QueryServ n(){
return new QueryServ();
}

}
