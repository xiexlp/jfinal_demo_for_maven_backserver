package com.js.isearch.dao;

/**
* last update time:"19-06-20 18:07:01"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPrice;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.daoex.CurrencyPriceDaoEx;

public interface CurrencyPriceDao extends CurrencyPriceDaoEx{




//放在dao里面
public PageList<CurrencyPrice> find_OrderByMarketCapDesc_ByBatchTimeEqPage(long batchTime,int pageNo,int total);


public PageList<CurrencyPrice> find_OrderBy_ByBatchTimeEqPage(long batchTime,int pageNo,int total,String sortBy,int sort,int pageSize);

}