package com.js.isearch.ormex;

/**
* last update time:"18-06-06 22:10:50"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class QueryEx{

private long queryId;
private String query;
private long createTime;
private long updateTime;
private long queryNum;
private String token;

Map<String,Object> map=null;

public QueryEx(){}

public long getQueryId(){
return queryId;
}

public void setQueryId(long queryId){
this.queryId = queryId;
}
public String getQuery(){
return query;
}

public void setQuery(String query){
this.query = query;
}
public long getCreateTime(){
return createTime;
}

public void setCreateTime(long createTime){
this.createTime = createTime;
}
public long getUpdateTime(){
return updateTime;
}

public void setUpdateTime(long updateTime){
this.updateTime = updateTime;
}
public long getQueryNum(){
return queryNum;
}

public void setQueryNum(long queryNum){
this.queryNum = queryNum;
}
public String getToken(){
return token;
}

public void setToken(String token){
this.token = token;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("query_id",this.getQueryId());
        map.put("query",this.getQuery());
        map.put("create_time",this.getCreateTime());
        map.put("update_time",this.getUpdateTime());
        map.put("query_num",this.getQueryNum());
        map.put("token",this.getToken());
    }
return map;
}


}