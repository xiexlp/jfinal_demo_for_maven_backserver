package com.js.cluster.nginx.backserver.controller;

import com.js.common.config.SortConfig;
import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.QueryLog;
import com.js.isearch.serv.QueryLogServ;


public class QueryLogController extends ControllerAdaper {
    
    //测试网页的热部署
    public void index() {
        int pageNo = getIntPara("pageNo",1);

        //对字段排序
        String fieldname = getStrPara("fieldname","create_time");
        int sort = getIntPara("sort", SortConfig.SORT_ASC);
        boolean asc = false;
        if(sort==SortConfig.SORT_ASC) asc= true;

        PageList<QueryLog> queryLogList = QueryLogServ.n().findByPageOrder(pageNo, 5000,"create_time",asc);
        StringBuffer actionUrlSb = new StringBuffer("/queryLog/index?1=1&fieldname=").append(fieldname).append("&sort=").append(sort);
        //String actionUrl = "/token/index?1=1&fieldname="+fieldname+"&sort="+sort;
        setPageInfo(queryLogList, actionUrlSb.toString());
         setAttr("name", "hi123");
         setAttr("queryloglist", queryLogList);

         setAttr("fieldname", fieldname);
         setAttr("sort",sort);
    }

}
