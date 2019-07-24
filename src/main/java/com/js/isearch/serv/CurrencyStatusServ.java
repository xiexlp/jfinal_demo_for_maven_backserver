package com.js.isearch.serv;

/**
* last update time:"19-06-21 14:44:47"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.daoimpl.CurrencyStatusDaoimpl;
import com.js.isearch.dao.CurrencyStatusDao;
import com.js.isearch.servex.CurrencyStatusServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyStatusServ extends CurrencyStatusServEx{

private CurrencyStatusDao currencyStatusDao;
private static CurrencyStatusServ currencyStatusServ;

public CurrencyStatusServ(){
this.currencyStatusDao =new CurrencyStatusDaoimpl();
}

public static CurrencyStatusServ newInstance(){
currencyStatusServ =new CurrencyStatusServ();
return currencyStatusServ;
}


public static CurrencyStatusServ n(){

    if(currencyStatusServ==null){
        return new CurrencyStatusServ();
    }else return currencyStatusServ;

}

}
