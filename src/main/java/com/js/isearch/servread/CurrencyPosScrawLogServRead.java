package com.js.isearch.servread;

/**
* last update time:"19-06-21 17:13:33"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPosScrawLog;
import com.js.isearch.daoimpl.CurrencyPosScrawLogDaoimpl;
import com.js.isearch.dao.CurrencyPosScrawLogDao;
import com.js.isearch.servex.CurrencyPosScrawLogServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPosScrawLogServRead extends CurrencyPosScrawLogServEx{

private CurrencyPosScrawLogDao currencyPosScrawLogDao;

private static CurrencyPosScrawLogServRead currencyPosScrawLogServRead= new CurrencyPosScrawLogServRead();

public CurrencyPosScrawLogServRead(){
this.currencyPosScrawLogDao =new CurrencyPosScrawLogDaoimpl();
}

public static CurrencyPosScrawLogServRead n(){
    if(currencyPosScrawLogServRead!=null) return currencyPosScrawLogServRead;
    else {
    currencyPosScrawLogServRead = new CurrencyPosScrawLogServRead();
    }
    return currencyPosScrawLogServRead;
}

public static CurrencyPosScrawLogServRead newInstance(){
    return new CurrencyPosScrawLogServRead();
}

}
