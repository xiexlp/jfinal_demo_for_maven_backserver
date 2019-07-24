package com.js.isearch.ormex;

/**
* last update time:"18-05-25 16:03:57"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class DocEx{

private long docId;
private String title;
private int titleSize;
private String body;
private int bodySize;
private String tablename;
private String dbname;
private String fieldname;
private long fieldId;
private String url;
private String host;
private long createTime;
private long updateTime;
private String indexStatus;
private int indexStage;

Map<String,Object> map=null;

public DocEx(){}

public long getDocId(){
return docId;
}

public void setDocId(long docId){
this.docId = docId;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public int getTitleSize(){
return titleSize;
}

public void setTitleSize(int titleSize){
this.titleSize = titleSize;
}
public String getBody(){
return body;
}

public void setBody(String body){
this.body = body;
}
public int getBodySize(){
return bodySize;
}

public void setBodySize(int bodySize){
this.bodySize = bodySize;
}
public String getTablename(){
return tablename;
}

public void setTablename(String tablename){
this.tablename = tablename;
}
public String getDbname(){
return dbname;
}

public void setDbname(String dbname){
this.dbname = dbname;
}
public String getFieldname(){
return fieldname;
}

public void setFieldname(String fieldname){
this.fieldname = fieldname;
}
public long getFieldId(){
return fieldId;
}

public void setFieldId(long fieldId){
this.fieldId = fieldId;
}
public String getUrl(){
return url;
}

public void setUrl(String url){
this.url = url;
}
public String getHost(){
return host;
}

public void setHost(String host){
this.host = host;
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
public String getIndexStatus(){
return indexStatus;
}

public void setIndexStatus(String indexStatus){
this.indexStatus = indexStatus;
}
public int getIndexStage(){
return indexStage;
}

public void setIndexStage(int indexStage){
this.indexStage = indexStage;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("doc_id",this.getDocId());
        map.put("title",this.getTitle());
        map.put("title_size",this.getTitleSize());
        map.put("body",this.getBody());
        map.put("body_size",this.getBodySize());
        map.put("tablename",this.getTablename());
        map.put("dbname",this.getDbname());
        map.put("fieldname",this.getFieldname());
        map.put("field_id",this.getFieldId());
        map.put("url",this.getUrl());
        map.put("host",this.getHost());
        map.put("create_time",this.getCreateTime());
        map.put("update_time",this.getUpdateTime());
        map.put("index_status",this.getIndexStatus());
        map.put("index_stage",this.getIndexStage());
    }
return map;
}


}