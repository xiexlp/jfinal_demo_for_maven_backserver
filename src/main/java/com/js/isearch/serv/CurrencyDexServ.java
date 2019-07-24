package com.js.isearch.serv;

/**
* last update time:"19-06-20 18:03:55"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyDex;
import com.js.isearch.daoimpl.CurrencyDexDaoimpl;
import com.js.isearch.dao.CurrencyDexDao;
import com.js.isearch.servex.CurrencyDexServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyDexServ extends CurrencyDexServEx{

private CurrencyDexDao currencyDexDao;
private static CurrencyDexServ currencyDexServ;

public CurrencyDexServ(){
this.currencyDexDao =new CurrencyDexDaoimpl();
}

public static CurrencyDexServ newInstance(){
currencyDexServ =new CurrencyDexServ();
return currencyDexServ;
}


public static CurrencyDexServ n(){

    if(currencyDexServ==null){
        return new CurrencyDexServ();
    }else return currencyDexServ;

}

}
