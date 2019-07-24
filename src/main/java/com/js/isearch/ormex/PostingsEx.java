package com.js.isearch.ormex;

/**
* last update time:"18-09-27 16:21:57"
* last update user:pku
*/

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.js.common.util.TimeUtil;
public class PostingsEx{

private long postingId;
private long tokenId;
private String token;
private long docId;
private String tablename;
private String dbname;
private int frequency;
private String positions;
private long createTime;
private long updateTime;
private int tokenSize;
private String fieldname;
private int fieldnameType;

private Map<String,Object> map=new HashMap();

public PostingsEx(){}

                                                    
public long getPostingId(){
    return postingId;
}

public void setPostingId(long postingId){
this.postingId = postingId;
}


        public long getPostingIdMap(){
        return Long.parseLong((String)map.get("posting_id"));
    }


public long getTokenId(){
    return tokenId;
}

public void setTokenId(long tokenId){
this.tokenId = tokenId;
}


        public long getTokenIdMap(){
        return Long.parseLong((String)map.get("token_id"));
    }


public String getToken(){
    return token;
}

public void setToken(String token){
this.token = token;
}


        public String getTokenMap(){
        return (String)map.get("token");
    }


public long getDocId(){
    return docId;
}

public void setDocId(long docId){
this.docId = docId;
}


        public long getDocIdMap(){
        return Long.parseLong((String)map.get("doc_id"));
    }


public String getTablename(){
    return tablename;
}

public void setTablename(String tablename){
this.tablename = tablename;
}


        public String getTablenameMap(){
        return (String)map.get("tablename");
    }


public String getDbname(){
    return dbname;
}

public void setDbname(String dbname){
this.dbname = dbname;
}


        public String getDbnameMap(){
        return (String)map.get("dbname");
    }


public int getFrequency(){
    return frequency;
}

public void setFrequency(int frequency){
this.frequency = frequency;
}


            public int getFrequencyMap(){
       return Integer.parseInt((String)map.get("frequency"));
    }


public String getPositions(){
    return positions;
}

public void setPositions(String positions){
this.positions = positions;
}


        public String getPositionsMap(){
        return (String)map.get("positions");
    }


public long getCreateTime(){
    return createTime;
}

public void setCreateTime(long createTime){
this.createTime = createTime;
}


        public long getCreateTimeMap(){
        return Long.parseLong((String)map.get("create_time"));
    }


public long getUpdateTime(){
    return updateTime;
}

public void setUpdateTime(long updateTime){
this.updateTime = updateTime;
}


        public long getUpdateTimeMap(){
        return Long.parseLong((String)map.get("update_time"));
    }


public int getTokenSize(){
    return tokenSize;
}

public void setTokenSize(int tokenSize){
this.tokenSize = tokenSize;
}


            public int getTokenSizeMap(){
       return Integer.parseInt((String)map.get("token_size"));
    }


public String getFieldname(){
    return fieldname;
}

public void setFieldname(String fieldname){
this.fieldname = fieldname;
}


        public String getFieldnameMap(){
        return (String)map.get("fieldname");
    }


public int getFieldnameType(){
    return fieldnameType;
}

public void setFieldnameType(int fieldnameType){
this.fieldnameType = fieldnameType;
}


            public int getFieldnameTypeMap(){
       return Integer.parseInt((String)map.get("fieldname_type"));
    }




public PostingsEx buildPostingId(long postingId){
this.postingId = postingId;
return this;
}
public PostingsEx buildTokenId(long tokenId){
this.tokenId = tokenId;
return this;
}
public PostingsEx buildToken(String token){
this.token = token;
return this;
}
public PostingsEx buildDocId(long docId){
this.docId = docId;
return this;
}
public PostingsEx buildTablename(String tablename){
this.tablename = tablename;
return this;
}
public PostingsEx buildDbname(String dbname){
this.dbname = dbname;
return this;
}
public PostingsEx buildFrequency(int frequency){
this.frequency = frequency;
return this;
}
public PostingsEx buildPositions(String positions){
this.positions = positions;
return this;
}
public PostingsEx buildCreateTime(long createTime){
this.createTime = createTime;
return this;
}
public PostingsEx buildUpdateTime(long updateTime){
this.updateTime = updateTime;
return this;
}
public PostingsEx buildTokenSize(int tokenSize){
this.tokenSize = tokenSize;
return this;
}
public PostingsEx buildFieldname(String fieldname){
this.fieldname = fieldname;
return this;
}
public PostingsEx buildFieldnameType(int fieldnameType){
this.fieldnameType = fieldnameType;
return this;
}






public Map getMap(){
if(map==null){
map = new HashMap();
}
return map;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("posting_id",this.getPostingId());
        map.put("token_id",this.getTokenId());
        map.put("token",this.getToken());
        map.put("doc_id",this.getDocId());
        map.put("tablename",this.getTablename());
        map.put("dbname",this.getDbname());
        map.put("frequency",this.getFrequency());
        map.put("positions",this.getPositions());
        map.put("create_time",this.getCreateTime());
        map.put("update_time",this.getUpdateTime());
        map.put("token_size",this.getTokenSize());
        map.put("fieldname",this.getFieldname());
        map.put("fieldname_type",this.getFieldnameType());
    }
return map;
}


}