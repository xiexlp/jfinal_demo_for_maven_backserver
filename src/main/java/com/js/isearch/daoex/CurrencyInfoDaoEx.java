package com.js.isearch.daoex;

/**
* last update time:"19-07-03 14:07:38"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyInfo;
import java.util.List;
import com.js.common.util.PageList;

public interface CurrencyInfoDaoEx{

public int save(CurrencyInfo currencyInfo);
public int saveAutoId(CurrencyInfo currencyInfo);

public int saveAutoReturnId(CurrencyInfo currencyInfo);


public CurrencyInfo get(int currencyId);



public int delete(int currencyId);

public int update(CurrencyInfo currencyInfo);

public int updateSet(String set,String where);

public int deleteWhere(String where);

public List<CurrencyInfo> find(String hql);

public List<CurrencyInfo> findNames(List<String> names,String wherehql);

    public PageList<CurrencyInfo> findNamesPage(List<String> names,String wherehql,int pageNo,int total);
        public List<CurrencyInfo> findNameArray(String[] names,String wherehql);

            public PageList<CurrencyInfo> findNameArrayPage(String[] names,String wherehql,int pageNo,int total);


public List<CurrencyInfo> findAll();

        public PageList<CurrencyInfo> find_OrderBy_ByPage(int pageNo,int total,String sortBy,int sort,int pageSize);

public PageList<CurrencyInfo> findByPage(int pageNo,int total);

public PageList<CurrencyInfo> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
