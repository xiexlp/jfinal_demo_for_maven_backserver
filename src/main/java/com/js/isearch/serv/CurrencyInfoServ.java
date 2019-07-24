package com.js.isearch.serv;

/**
* last update time:"19-06-20 18:05:56"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.daoimpl.CurrencyInfoDaoimpl;
import com.js.isearch.dao.CurrencyInfoDao;
import com.js.isearch.servex.CurrencyInfoServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyInfoServ extends CurrencyInfoServEx{

private CurrencyInfoDao currencyInfoDao;
private static CurrencyInfoServ currencyInfoServ;

public CurrencyInfoServ(){
this.currencyInfoDao =new CurrencyInfoDaoimpl();
}

public static CurrencyInfoServ newInstance(){
currencyInfoServ =new CurrencyInfoServ();
return currencyInfoServ;
}


public static CurrencyInfoServ n(){

    if(currencyInfoServ==null){
        return new CurrencyInfoServ();
    }else return currencyInfoServ;

}

}
