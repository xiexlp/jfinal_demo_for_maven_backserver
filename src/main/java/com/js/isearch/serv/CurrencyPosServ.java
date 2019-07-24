package com.js.isearch.serv;

/**
* last update time:"19-06-20 22:08:48"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.daoimpl.CurrencyPosDaoimpl;
import com.js.isearch.dao.CurrencyPosDao;
import com.js.isearch.servex.CurrencyPosServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPosServ extends CurrencyPosServEx{

private CurrencyPosDao currencyPosDao;
private static CurrencyPosServ currencyPosServ;

public CurrencyPosServ(){
this.currencyPosDao =new CurrencyPosDaoimpl();
}

public static CurrencyPosServ newInstance(){
currencyPosServ =new CurrencyPosServ();
return currencyPosServ;
}


public static CurrencyPosServ n(){

    if(currencyPosServ==null){
        return new CurrencyPosServ();
    }else return currencyPosServ;

}

}
