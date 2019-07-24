package com.js.isearch.dao;

/**
* last update time:"19-06-20 22:08:43"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPos;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.daoex.CurrencyPosDaoEx;

public interface CurrencyPosDao extends CurrencyPosDaoEx{




//放在dao里面
public PageList<CurrencyPos> find_OrderByCurrencyPosIdAsc_ByBatchTimeEqPage(long batchTime,int pageNo,int total);

    public PageList<CurrencyPos> find_OrderBy_ByBatchTimeEqPage(long batchTime,int pageNo,int total,String sortBy,int sort);

}