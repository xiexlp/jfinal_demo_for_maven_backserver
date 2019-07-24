package com.js.isearch.ormex;

/**
* last update time:"19-07-03 14:07:37"
* last update user:pku
*/

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.js.common.util.TimeUtil;
public class CurrencyInfoEx{

private int currencyId;
private String name;
private String symbol;
private long volume;
private long circulatingVolume;
private double initPrice;
private long initDate;
private String url;
private String currencyDesc;
private int srcWebId;
private String currencyIdName;
private String detailLink;
private String masterLink;


public CurrencyInfoEx(){}

                                                    
public int getCurrencyId(){
    return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}




public String getName(){
    return name;
}

public void setName(String name){
this.name = name;
}




public String getSymbol(){
    return symbol;
}

public void setSymbol(String symbol){
this.symbol = symbol;
}




public long getVolume(){
    return volume;
}

public void setVolume(long volume){
this.volume = volume;
}




public long getCirculatingVolume(){
    return circulatingVolume;
}

public void setCirculatingVolume(long circulatingVolume){
this.circulatingVolume = circulatingVolume;
}




public double getInitPrice(){
    return initPrice;
}

public void setInitPrice(double initPrice){
this.initPrice = initPrice;
}




public long getInitDate(){
    return initDate;
}

public void setInitDate(long initDate){
this.initDate = initDate;
}




public String getUrl(){
    return url;
}

public void setUrl(String url){
this.url = url;
}




public String getCurrencyDesc(){
    return currencyDesc;
}

public void setCurrencyDesc(String currencyDesc){
this.currencyDesc = currencyDesc;
}




public int getSrcWebId(){
    return srcWebId;
}

public void setSrcWebId(int srcWebId){
this.srcWebId = srcWebId;
}




public String getCurrencyIdName(){
    return currencyIdName;
}

public void setCurrencyIdName(String currencyIdName){
this.currencyIdName = currencyIdName;
}




public String getDetailLink(){
    return detailLink;
}

public void setDetailLink(String detailLink){
this.detailLink = detailLink;
}




public String getMasterLink(){
    return masterLink;
}

public void setMasterLink(String masterLink){
this.masterLink = masterLink;
}






public CurrencyInfoEx buildCurrencyId(int currencyId){
this.currencyId = currencyId;
return this;
}
public CurrencyInfoEx buildName(String name){
this.name = name;
return this;
}
public CurrencyInfoEx buildSymbol(String symbol){
this.symbol = symbol;
return this;
}
public CurrencyInfoEx buildVolume(long volume){
this.volume = volume;
return this;
}
public CurrencyInfoEx buildCirculatingVolume(long circulatingVolume){
this.circulatingVolume = circulatingVolume;
return this;
}
public CurrencyInfoEx buildInitPrice(double initPrice){
this.initPrice = initPrice;
return this;
}
public CurrencyInfoEx buildInitDate(long initDate){
this.initDate = initDate;
return this;
}
public CurrencyInfoEx buildUrl(String url){
this.url = url;
return this;
}
public CurrencyInfoEx buildCurrencyDesc(String currencyDesc){
this.currencyDesc = currencyDesc;
return this;
}
public CurrencyInfoEx buildSrcWebId(int srcWebId){
this.srcWebId = srcWebId;
return this;
}
public CurrencyInfoEx buildCurrencyIdName(String currencyIdName){
this.currencyIdName = currencyIdName;
return this;
}
public CurrencyInfoEx buildDetailLink(String detailLink){
this.detailLink = detailLink;
return this;
}
public CurrencyInfoEx buildMasterLink(String masterLink){
this.masterLink = masterLink;
return this;
}








}