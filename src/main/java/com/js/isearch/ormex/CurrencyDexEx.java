package com.js.isearch.ormex;

/**
* last update time:"19-06-20 18:03:58"
* last update user:pku
*/

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.js.common.util.TimeUtil;
public class CurrencyDexEx{

private int dexId;
private String name;
private String url;
private String logoUrl;


public CurrencyDexEx(){}

                
public int getDexId(){
    return dexId;
}

public void setDexId(int dexId){
this.dexId = dexId;
}




public String getName(){
    return name;
}

public void setName(String name){
this.name = name;
}




public String getUrl(){
    return url;
}

public void setUrl(String url){
this.url = url;
}




public String getLogoUrl(){
    return logoUrl;
}

public void setLogoUrl(String logoUrl){
this.logoUrl = logoUrl;
}






public CurrencyDexEx buildDexId(int dexId){
this.dexId = dexId;
return this;
}
public CurrencyDexEx buildName(String name){
this.name = name;
return this;
}
public CurrencyDexEx buildUrl(String url){
this.url = url;
return this;
}
public CurrencyDexEx buildLogoUrl(String logoUrl){
this.logoUrl = logoUrl;
return this;
}








}