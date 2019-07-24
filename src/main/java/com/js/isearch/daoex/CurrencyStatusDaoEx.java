package com.js.isearch.daoex;

/**
* last update time:"19-06-21 14:44:40"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyStatus;
import java.util.List;
import com.js.common.util.PageList;

public interface CurrencyStatusDaoEx{

public int save(CurrencyStatus currencyStatus);
public int saveAutoId(CurrencyStatus currencyStatus);

public int saveAutoReturnId(CurrencyStatus currencyStatus);


public CurrencyStatus get(int currencyStatusId);



public int delete(int currencyStatusId);

public int update(CurrencyStatus currencyStatus);

public int updateSet(String set,String where);

public int deleteWhere(String where);

public List<CurrencyStatus> find(String hql);

public List<CurrencyStatus> findNames(List<String> names,String wherehql);

    public PageList<CurrencyStatus> findNamesPage(List<String> names,String wherehql,int pageNo,int total);
        public List<CurrencyStatus> findNameArray(String[] names,String wherehql);

            public PageList<CurrencyStatus> findNameArrayPage(String[] names,String wherehql,int pageNo,int total);


public List<CurrencyStatus> findAll();

public PageList<CurrencyStatus> findByPage(int pageNo,int total);

public PageList<CurrencyStatus> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
