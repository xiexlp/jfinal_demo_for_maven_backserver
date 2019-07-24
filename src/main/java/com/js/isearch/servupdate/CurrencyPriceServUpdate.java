package com.js.isearch.servupdate;

/**
* last update time:"19-06-22 17:26:09"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.daoimpl.CurrencyPriceDaoimpl;
import com.js.isearch.dao.CurrencyPriceDao;
import com.js.isearch.servex.CurrencyPriceServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPriceServUpdate extends CurrencyPriceServEx{

private CurrencyPriceDao currencyPriceDao;

private static CurrencyPriceServUpdate currencyPriceServUpdate= new CurrencyPriceServUpdate();

public CurrencyPriceServUpdate(){
this.currencyPriceDao =new CurrencyPriceDaoimpl();
}


public static CurrencyPriceServUpdate n(){
if(currencyPriceServUpdate!=null) return currencyPriceServUpdate;
else {
currencyPriceServUpdate = new CurrencyPriceServUpdate();
}
return  currencyPriceServUpdate;
}

public static CurrencyPriceServUpdate newInstance(){
return new CurrencyPriceServUpdate();
}


}
