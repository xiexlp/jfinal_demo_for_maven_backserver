package com.js.isearch.ormex;

/**
* last update time:"19-06-21 14:44:39"
* last update user:pku
*/

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.js.common.util.TimeUtil;
public class CurrencyStatusEx{

private int currencyStatusId;
private int posPanelNum;
private int pricePanelNum;
private long posLastBatchTime;
private long priceLastBatchTime;
private long createTime;
private long updateTime;


public CurrencyStatusEx(){}

                            
public int getCurrencyStatusId(){
    return currencyStatusId;
}

public void setCurrencyStatusId(int currencyStatusId){
this.currencyStatusId = currencyStatusId;
}




public int getPosPanelNum(){
    return posPanelNum;
}

public void setPosPanelNum(int posPanelNum){
this.posPanelNum = posPanelNum;
}




public int getPricePanelNum(){
    return pricePanelNum;
}

public void setPricePanelNum(int pricePanelNum){
this.pricePanelNum = pricePanelNum;
}




public long getPosLastBatchTime(){
    return posLastBatchTime;
}

public void setPosLastBatchTime(long posLastBatchTime){
this.posLastBatchTime = posLastBatchTime;
}




public long getPriceLastBatchTime(){
    return priceLastBatchTime;
}

public void setPriceLastBatchTime(long priceLastBatchTime){
this.priceLastBatchTime = priceLastBatchTime;
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






public CurrencyStatusEx buildCurrencyStatusId(int currencyStatusId){
this.currencyStatusId = currencyStatusId;
return this;
}
public CurrencyStatusEx buildPosPanelNum(int posPanelNum){
this.posPanelNum = posPanelNum;
return this;
}
public CurrencyStatusEx buildPricePanelNum(int pricePanelNum){
this.pricePanelNum = pricePanelNum;
return this;
}
public CurrencyStatusEx buildPosLastBatchTime(long posLastBatchTime){
this.posLastBatchTime = posLastBatchTime;
return this;
}
public CurrencyStatusEx buildPriceLastBatchTime(long priceLastBatchTime){
this.priceLastBatchTime = priceLastBatchTime;
return this;
}
public CurrencyStatusEx buildCreateTime(long createTime){
this.createTime = createTime;
return this;
}
public CurrencyStatusEx buildUpdateTime(long updateTime){
this.updateTime = updateTime;
return this;
}








}