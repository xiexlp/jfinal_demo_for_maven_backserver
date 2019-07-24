package com.js.isearch.dao;

/**
* last update time:"19-06-20 18:05:54"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyInfo;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.daoex.CurrencyInfoDaoEx;

public interface CurrencyInfoDao extends CurrencyInfoDaoEx{




//放在dao里面
public List<CurrencyInfo> find_OrderBy_BySymbolEq(String symbol);

}