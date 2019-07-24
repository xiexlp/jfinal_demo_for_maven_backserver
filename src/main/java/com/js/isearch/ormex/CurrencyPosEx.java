package com.js.isearch.ormex;

/**
* last update time:"19-07-03 14:56:15"
* last update user:pku
*/

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.js.common.util.TimeUtil;
public class CurrencyPosEx{

private int currencyPosId;
private String currencyName;
private String symbol;
private String logoUrl;
private double currentPrice;
private double priceChange;
private long volume;
private double marketCap;
private double roi;
private int nodeNum;
private int requiredNum;
private double mnWorth;
private long createTime;
private long updateTime;
private String infoUrl;
private int currencyId;
private long batchTime;
private String detailLink;


public CurrencyPosEx(){}

                                                                        
public int getCurrencyPosId(){
    return currencyPosId;
}

public void setCurrencyPosId(int currencyPosId){
this.currencyPosId = currencyPosId;
}




public String getCurrencyName(){
    return currencyName;
}

public void setCurrencyName(String currencyName){
this.currencyName = currencyName;
}




public String getSymbol(){
    return symbol;
}

public void setSymbol(String symbol){
this.symbol = symbol;
}




public String getLogoUrl(){
    return logoUrl;
}

public void setLogoUrl(String logoUrl){
this.logoUrl = logoUrl;
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




public long getVolume(){
    return volume;
}

public void setVolume(long volume){
this.volume = volume;
}




public double getMarketCap(){
    return marketCap;
}

public void setMarketCap(double marketCap){
this.marketCap = marketCap;
}




public double getRoi(){
    return roi;
}

public void setRoi(double roi){
this.roi = roi;
}




public int getNodeNum(){
    return nodeNum;
}

public void setNodeNum(int nodeNum){
this.nodeNum = nodeNum;
}




public int getRequiredNum(){
    return requiredNum;
}

public void setRequiredNum(int requiredNum){
this.requiredNum = requiredNum;
}




public double getMnWorth(){
    return mnWorth;
}

public void setMnWorth(double mnWorth){
this.mnWorth = mnWorth;
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




public String getInfoUrl(){
    return infoUrl;
}

public void setInfoUrl(String infoUrl){
this.infoUrl = infoUrl;
}




public int getCurrencyId(){
    return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}




public long getBatchTime(){
    return batchTime;
}

public void setBatchTime(long batchTime){
this.batchTime = batchTime;
}




public String getDetailLink(){
    return detailLink;
}

public void setDetailLink(String detailLink){
this.detailLink = detailLink;
}






public CurrencyPosEx buildCurrencyPosId(int currencyPosId){
this.currencyPosId = currencyPosId;
return this;
}
public CurrencyPosEx buildCurrencyName(String currencyName){
this.currencyName = currencyName;
return this;
}
public CurrencyPosEx buildSymbol(String symbol){
this.symbol = symbol;
return this;
}
public CurrencyPosEx buildLogoUrl(String logoUrl){
this.logoUrl = logoUrl;
return this;
}
public CurrencyPosEx buildCurrentPrice(double currentPrice){
this.currentPrice = currentPrice;
return this;
}
public CurrencyPosEx buildPriceChange(double priceChange){
this.priceChange = priceChange;
return this;
}
public CurrencyPosEx buildVolume(long volume){
this.volume = volume;
return this;
}
public CurrencyPosEx buildMarketCap(double marketCap){
this.marketCap = marketCap;
return this;
}
public CurrencyPosEx buildRoi(double roi){
this.roi = roi;
return this;
}
public CurrencyPosEx buildNodeNum(int nodeNum){
this.nodeNum = nodeNum;
return this;
}
public CurrencyPosEx buildRequiredNum(int requiredNum){
this.requiredNum = requiredNum;
return this;
}
public CurrencyPosEx buildMnWorth(double mnWorth){
this.mnWorth = mnWorth;
return this;
}
public CurrencyPosEx buildCreateTime(long createTime){
this.createTime = createTime;
return this;
}
public CurrencyPosEx buildUpdateTime(long updateTime){
this.updateTime = updateTime;
return this;
}
public CurrencyPosEx buildInfoUrl(String infoUrl){
this.infoUrl = infoUrl;
return this;
}
public CurrencyPosEx buildCurrencyId(int currencyId){
this.currencyId = currencyId;
return this;
}
public CurrencyPosEx buildBatchTime(long batchTime){
this.batchTime = batchTime;
return this;
}
public CurrencyPosEx buildDetailLink(String detailLink){
this.detailLink = detailLink;
return this;
}








}