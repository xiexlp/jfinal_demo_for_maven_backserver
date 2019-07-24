package com.js.isearch.ormex;

/**
* last update time:"19-06-22 18:12:37"
* last update user:pku
*/

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.js.common.util.TimeUtil;
public class CurrencyPriceEx{

private int currencyPriceId;
private int currencyId;
private String name;
private String symbol;
private double currentPrice;
private double priceChange;
private int dexId;
private String dexName;
private long createTime;
private long updateTime;
private long volume;
private long circulatingVolume;
private double marketCap;
private int rankMarketCap;
private long batchTime;
private String infoUrl;


public CurrencyPriceEx(){}

                                                                
public int getCurrencyPriceId(){
    return currencyPriceId;
}

public void setCurrencyPriceId(int currencyPriceId){
this.currencyPriceId = currencyPriceId;
}




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




public double getCurrentPrice(){
    return currentPrice;
}

public void setCurrentPrice(double currentPrice){
this.currentPrice = currentPrice;
}




public double getPriceChange(){
    return priceChange;
}

public void setPriceChange(double priceChange){
this.priceChange = priceChange;
}




public int getDexId(){
    return dexId;
}

public void setDexId(int dexId){
this.dexId = dexId;
}




public String getDexName(){
    return dexName;
}

public void setDexName(String dexName){
this.dexName = dexName;
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




public double getMarketCap(){
    return marketCap;
}

public void setMarketCap(double marketCap){
this.marketCap = marketCap;
}




public int getRankMarketCap(){
    return rankMarketCap;
}

public void setRankMarketCap(int rankMarketCap){
this.rankMarketCap = rankMarketCap;
}




public long getBatchTime(){
    return batchTime;
}

public void setBatchTime(long batchTime){
this.batchTime = batchTime;
}




public String getInfoUrl(){
    return infoUrl;
}

public void setInfoUrl(String infoUrl){
this.infoUrl = infoUrl;
}






public CurrencyPriceEx buildCurrencyPriceId(int currencyPriceId){
this.currencyPriceId = currencyPriceId;
return this;
}
public CurrencyPriceEx buildCurrencyId(int currencyId){
this.currencyId = currencyId;
return this;
}
public CurrencyPriceEx buildName(String name){
this.name = name;
return this;
}
public CurrencyPriceEx buildSymbol(String symbol){
this.symbol = symbol;
return this;
}
public CurrencyPriceEx buildCurrentPrice(double currentPrice){
this.currentPrice = currentPrice;
return this;
}
public CurrencyPriceEx buildPriceChange(double priceChange){
this.priceChange = priceChange;
return this;
}
public CurrencyPriceEx buildDexId(int dexId){
this.dexId = dexId;
return this;
}
public CurrencyPriceEx buildDexName(String dexName){
this.dexName = dexName;
return this;
}
public CurrencyPriceEx buildCreateTime(long createTime){
this.createTime = createTime;
return this;
}
public CurrencyPriceEx buildUpdateTime(long updateTime){
this.updateTime = updateTime;
return this;
}
public CurrencyPriceEx buildVolume(long volume){
this.volume = volume;
return this;
}
public CurrencyPriceEx buildCirculatingVolume(long circulatingVolume){
this.circulatingVolume = circulatingVolume;
return this;
}
public CurrencyPriceEx buildMarketCap(double marketCap){
this.marketCap = marketCap;
return this;
}
public CurrencyPriceEx buildRankMarketCap(int rankMarketCap){
this.rankMarketCap = rankMarketCap;
return this;
}
public CurrencyPriceEx buildBatchTime(long batchTime){
this.batchTime = batchTime;
return this;
}
public CurrencyPriceEx buildInfoUrl(String infoUrl){
this.infoUrl = infoUrl;
return this;
}








}