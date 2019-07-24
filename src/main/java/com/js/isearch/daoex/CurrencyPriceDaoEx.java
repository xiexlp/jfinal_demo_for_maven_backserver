package com.js.isearch.daoex;

/**
* last update time:"19-06-22 18:12:38"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPrice;
import java.util.List;
import com.js.common.util.PageList;

public interface CurrencyPriceDaoEx{

public int save(CurrencyPrice currencyPrice);
public int saveAutoId(CurrencyPrice currencyPrice);

public int saveAutoReturnId(CurrencyPrice currencyPrice);


public CurrencyPrice get(int currencyPriceId);



public int delete(int currencyPriceId);

public int update(CurrencyPrice currencyPrice);

public int updateSet(String set,String where);

public int deleteWhere(String where);

public List<CurrencyPrice> find(String hql);

public List<CurrencyPrice> findNames(List<String> names,String wherehql);

    public PageList<CurrencyPrice> findNamesPage(List<String> names,String wherehql,int pageNo,int total);
        public List<CurrencyPrice> findNameArray(String[] names,String wherehql);

            public PageList<CurrencyPrice> findNameArrayPage(String[] names,String wherehql,int pageNo,int total);


public List<CurrencyPrice> findAll();

public PageList<CurrencyPrice> findByPage(int pageNo,int total);

public PageList<CurrencyPrice> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
