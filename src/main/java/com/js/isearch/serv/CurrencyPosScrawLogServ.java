package com.js.isearch.serv;

/**
* last update time:"19-06-21 17:13:13"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPosScrawLog;
import com.js.isearch.daoimpl.CurrencyPosScrawLogDaoimpl;
import com.js.isearch.dao.CurrencyPosScrawLogDao;
import com.js.isearch.servex.CurrencyPosScrawLogServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPosScrawLogServ extends CurrencyPosScrawLogServEx{

private CurrencyPosScrawLogDao currencyPosScrawLogDao;
private static CurrencyPosScrawLogServ currencyPosScrawLogServ;

public CurrencyPosScrawLogServ(){
this.currencyPosScrawLogDao =new CurrencyPosScrawLogDaoimpl();
}

public static CurrencyPosScrawLogServ newInstance(){
currencyPosScrawLogServ =new CurrencyPosScrawLogServ();
return currencyPosScrawLogServ;
}


public static CurrencyPosScrawLogServ n(){

    if(currencyPosScrawLogServ==null){
        return new CurrencyPosScrawLogServ();
    }else return currencyPosScrawLogServ;

}

}
