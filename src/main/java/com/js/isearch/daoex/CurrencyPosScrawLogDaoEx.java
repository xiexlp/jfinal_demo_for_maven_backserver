package com.js.isearch.daoex;

/**
* last update time:"19-06-21 17:13:17"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPosScrawLog;
import java.util.List;
import com.js.common.util.PageList;

public interface CurrencyPosScrawLogDaoEx{

public int save(CurrencyPosScrawLog currencyPosScrawLog);
public int saveAutoId(CurrencyPosScrawLog currencyPosScrawLog);

public int saveAutoReturnId(CurrencyPosScrawLog currencyPosScrawLog);


public CurrencyPosScrawLog get(int currencyPosScrawLogId);



public int delete(int currencyPosScrawLogId);

public int update(CurrencyPosScrawLog currencyPosScrawLog);

public int updateSet(String set,String where);

public int deleteWhere(String where);

public List<CurrencyPosScrawLog> find(String hql);

public List<CurrencyPosScrawLog> findNames(List<String> names,String wherehql);

    public PageList<CurrencyPosScrawLog> findNamesPage(List<String> names,String wherehql,int pageNo,int total);
        public List<CurrencyPosScrawLog> findNameArray(String[] names,String wherehql);

            public PageList<CurrencyPosScrawLog> findNameArrayPage(String[] names,String wherehql,int pageNo,int total);


public List<CurrencyPosScrawLog> findAll();

public PageList<CurrencyPosScrawLog> findByPage(int pageNo,int total);

public PageList<CurrencyPosScrawLog> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
