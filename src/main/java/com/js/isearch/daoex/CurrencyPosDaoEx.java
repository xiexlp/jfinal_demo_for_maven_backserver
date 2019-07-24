package com.js.isearch.daoex;

/**
* last update time:"19-07-03 14:56:17"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPos;
import java.util.List;
import com.js.common.util.PageList;

public interface CurrencyPosDaoEx{

public int save(CurrencyPos currencyPos);
public int saveAutoId(CurrencyPos currencyPos);

public int saveAutoReturnId(CurrencyPos currencyPos);


public CurrencyPos get(int currencyPosId);



public int delete(int currencyPosId);

public int update(CurrencyPos currencyPos);

public int updateSet(String set,String where);

public int deleteWhere(String where);

public List<CurrencyPos> find(String hql);

public List<CurrencyPos> findNames(List<String> names,String wherehql);

    public PageList<CurrencyPos> findNamesPage(List<String> names,String wherehql,int pageNo,int total);
        public List<CurrencyPos> findNameArray(String[] names,String wherehql);

            public PageList<CurrencyPos> findNameArrayPage(String[] names,String wherehql,int pageNo,int total);


public List<CurrencyPos> findAll();

        public PageList<CurrencyPos> find_OrderBy_ByPage(int pageNo,int total,String sortBy,int sort,int pageSize);

public PageList<CurrencyPos> findByPage(int pageNo,int total);

public PageList<CurrencyPos> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
