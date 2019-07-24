package com.js.isearch.ormex;

/**
* last update time:"18-05-14 15:20:11"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class TokenEx{

private long tokenId;
private String token;
private int tokenSize;
private int docCount;
private int positionCount;
private String docs;

public TokenEx(){}

public long getTokenId(){
return tokenId;
}

public void setTokenId(long tokenId){
this.tokenId = tokenId;
}
public String getToken(){
return token;
}

public void setToken(String token){
this.token = token;
}
public int getTokenSize(){
return tokenSize;
}

public void setTokenSize(int tokenSize){
this.tokenSize = tokenSize;
}
public int getDocCount(){
return docCount;
}

public void setDocCount(int docCount){
this.docCount = docCount;
}
public int getPositionCount(){
return positionCount;
}

public void setPositionCount(int positionCount){
this.positionCount = positionCount;
}
public String getDocs(){
return docs;
}

public void setDocs(String docs){
this.docs = docs;
}

public Map toMap(){
Map map = new HashMap();
map.put("token_id",this.getTokenId());
map.put("token",this.getToken());
map.put("token_size",this.getTokenSize());
map.put("doc_count",this.getDocCount());
map.put("position_count",this.getPositionCount());
map.put("docs",this.getDocs());
return map;
}


}