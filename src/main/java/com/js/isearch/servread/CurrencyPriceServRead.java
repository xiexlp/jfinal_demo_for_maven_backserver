package com.js.isearch.servread;

/**
* last update time:"19-06-22 17:25:59"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.daoimpl.CurrencyPriceDaoimpl;
import com.js.isearch.dao.CurrencyPriceDao;
import com.js.isearch.servex.CurrencyPriceServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPriceServRead extends CurrencyPriceServEx{

private CurrencyPriceDao currencyPriceDao;

private static CurrencyPriceServRead currencyPriceServRead= new CurrencyPriceServRead();

public CurrencyPriceServRead(){
this.currencyPriceDao =new CurrencyPriceDaoimpl();
}

public static CurrencyPriceServRead n(){
    if(currencyPriceServRead!=null) return currencyPriceServRead;
    else {
    currencyPriceServRead = new CurrencyPriceServRead();
    }
    return currencyPriceServRead;
}

public static CurrencyPriceServRead newInstance(){
    return new CurrencyPriceServRead();
}
//放在server里面
public PageList<CurrencyPrice> find_OrderByMarketCapDesc_ByBatchTimeEqPage(long batchTime,int pageNo,int total){
return currencyPriceDao.find_OrderByMarketCapDesc_ByBatchTimeEqPage(batchTime,pageNo,total);
}

    public PageList<CurrencyPrice> find_OrderBy_ByBatchTimeEqPage(long batchTime,int pageNo,int total,String sortBy,int sort,int pageSize){
        return currencyPriceDao.find_OrderBy_ByBatchTimeEqPage(batchTime,pageNo,total,sortBy,sort,pageSize);
    }

}