package com.js.isearch.daoex;

/**
* last update time:"19-06-20 18:03:59"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyDex;
import java.util.List;
import com.js.common.util.PageList;

public interface CurrencyDexDaoEx{

public int save(CurrencyDex currencyDex);
public int saveAutoId(CurrencyDex currencyDex);

public int saveAutoReturnId(CurrencyDex currencyDex);


public CurrencyDex get(int dexId);



public int delete(int dexId);

public int update(CurrencyDex currencyDex);

public int updateSet(String set,String where);

public int deleteWhere(String where);

public List<CurrencyDex> find(String hql);

public List<CurrencyDex> findNames(List<String> names,String wherehql);

    public PageList<CurrencyDex> findNamesPage(List<String> names,String wherehql,int pageNo,int total);
        public List<CurrencyDex> findNameArray(String[] names,String wherehql);

            public PageList<CurrencyDex> findNameArrayPage(String[] names,String wherehql,int pageNo,int total);


public List<CurrencyDex> findAll();

public PageList<CurrencyDex> findByPage(int pageNo,int total);

public PageList<CurrencyDex> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
