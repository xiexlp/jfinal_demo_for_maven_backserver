package com.js.isearch.ormex;

/**
* last update time:"18-06-06 22:11:06"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class QueryLogEx{

private long logId;
private String query;
private String ip;
private String terminal;
private String webUrl;
private long createTime;
private int indexStatus;

Map<String,Object> map=null;

public QueryLogEx(){}

public long getLogId(){
return logId;
}

public void setLogId(long logId){
this.logId = logId;
}
public String getQuery(){
return query;
}

public void setQuery(String query){
this.query = query;
}
public String getIp(){
return ip;
}

public void setIp(String ip){
this.ip = ip;
}
public String getTerminal(){
return terminal;
}

public void setTerminal(String terminal){
this.terminal = terminal;
}
public String getWebUrl(){
return webUrl;
}

public void setWebUrl(String webUrl){
this.webUrl = webUrl;
}
public long getCreateTime(){
return createTime;
}

public void setCreateTime(long createTime){
this.createTime = createTime;
}
public int getIndexStatus(){
return indexStatus;
}

public void setIndexStatus(int indexStatus){
this.indexStatus = indexStatus;
}


public Map getMap(){
    if(map==null){
        map = new HashMap<>();
    }
    return map;
}


public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("log_id",this.getLogId());
        map.put("query",this.getQuery());
        map.put("ip",this.getIp());
        map.put("terminal",this.getTerminal());
        map.put("web_url",this.getWebUrl());
        map.put("create_time",this.getCreateTime());
        map.put("index_status",this.getIndexStatus());
    }
return map;
}


}