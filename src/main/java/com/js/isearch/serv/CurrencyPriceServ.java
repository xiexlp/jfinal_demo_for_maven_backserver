package com.js.isearch.serv;

/**
* last update time:"19-06-20 18:07:04"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.daoimpl.CurrencyPriceDaoimpl;
import com.js.isearch.dao.CurrencyPriceDao;
import com.js.isearch.servex.CurrencyPriceServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPriceServ extends CurrencyPriceServEx{

private CurrencyPriceDao currencyPriceDao;
private static CurrencyPriceServ currencyPriceServ;

public CurrencyPriceServ(){
this.currencyPriceDao =new CurrencyPriceDaoimpl();
}

public static CurrencyPriceServ newInstance(){
currencyPriceServ =new CurrencyPriceServ();
return currencyPriceServ;
}


public static CurrencyPriceServ n(){

    if(currencyPriceServ==null){
        return new CurrencyPriceServ();
    }else return currencyPriceServ;

}

}
