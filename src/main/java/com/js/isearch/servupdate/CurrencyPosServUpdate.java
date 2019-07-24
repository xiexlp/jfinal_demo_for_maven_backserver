package com.js.isearch.servupdate;

/**
* last update time:"19-07-03 16:49:35"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.daoimpl.CurrencyPosDaoimpl;
import com.js.isearch.dao.CurrencyPosDao;
import com.js.isearch.servex.CurrencyPosServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPosServUpdate extends CurrencyPosServEx{

private CurrencyPosDao currencyPosDao;

private static CurrencyPosServUpdate currencyPosServUpdate= new CurrencyPosServUpdate();

public CurrencyPosServUpdate(){
this.currencyPosDao =new CurrencyPosDaoimpl();
}


public static CurrencyPosServUpdate n(){
if(currencyPosServUpdate!=null) return currencyPosServUpdate;
else {
currencyPosServUpdate = new CurrencyPosServUpdate();
}
return  currencyPosServUpdate;
}

public static CurrencyPosServUpdate newInstance(){
return new CurrencyPosServUpdate();
}


}
