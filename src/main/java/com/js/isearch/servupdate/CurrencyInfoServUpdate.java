package com.js.isearch.servupdate;

/**
* last update time:"19-07-02 18:00:14"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.daoimpl.CurrencyInfoDaoimpl;
import com.js.isearch.dao.CurrencyInfoDao;
import com.js.isearch.servex.CurrencyInfoServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyInfoServUpdate extends CurrencyInfoServEx{

private CurrencyInfoDao currencyInfoDao;

private static CurrencyInfoServUpdate currencyInfoServUpdate= new CurrencyInfoServUpdate();

public CurrencyInfoServUpdate(){
this.currencyInfoDao =new CurrencyInfoDaoimpl();
}


public static CurrencyInfoServUpdate n(){
if(currencyInfoServUpdate!=null) return currencyInfoServUpdate;
else {
currencyInfoServUpdate = new CurrencyInfoServUpdate();
}
return  currencyInfoServUpdate;
}

public static CurrencyInfoServUpdate newInstance(){
return new CurrencyInfoServUpdate();
}


}
