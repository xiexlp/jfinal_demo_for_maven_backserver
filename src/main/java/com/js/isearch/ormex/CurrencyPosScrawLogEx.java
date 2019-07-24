package com.js.isearch.ormex;

/**
* last update time:"19-06-21 17:13:15"
* last update user:pku
*/

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.js.common.util.TimeUtil;
public class CurrencyPosScrawLogEx{

private int currencyPosScrawLogId;
private long posBatchTime;
private int posBatchNum;


public CurrencyPosScrawLogEx(){}

            
public int getCurrencyPosScrawLogId(){
    return currencyPosScrawLogId;
}

public void setCurrencyPosScrawLogId(int currencyPosScrawLogId){
this.currencyPosScrawLogId = currencyPosScrawLogId;
}




public long getPosBatchTime(){
    return posBatchTime;
}

public void setPosBatchTime(long posBatchTime){
this.posBatchTime = posBatchTime;
}




public int getPosBatchNum(){
    return posBatchNum;
}

public void setPosBatchNum(int posBatchNum){
this.posBatchNum = posBatchNum;
}






public CurrencyPosScrawLogEx buildCurrencyPosScrawLogId(int currencyPosScrawLogId){
this.currencyPosScrawLogId = currencyPosScrawLogId;
return this;
}
public CurrencyPosScrawLogEx buildPosBatchTime(long posBatchTime){
this.posBatchTime = posBatchTime;
return this;
}
public CurrencyPosScrawLogEx buildPosBatchNum(int posBatchNum){
this.posBatchNum = posBatchNum;
return this;
}








}