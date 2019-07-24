package com.js.isearch.servex;

/**
* last update time:"19-06-22 18:12:40"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.daoimplex.CurrencyPriceDaoimplEx;
import com.js.isearch.daoex.CurrencyPriceDaoEx;

import com.js.isearch.daoimpl.CurrencyPriceDaoimpl;
import com.js.isearch.dao.CurrencyPriceDao;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPriceServEx{

private CurrencyPriceDaoEx currencyPriceDaoEx;

public CurrencyPriceServEx(){
this.currencyPriceDaoEx =new CurrencyPriceDaoimplEx();
}

public static CurrencyPriceServEx n(){
return new CurrencyPriceServEx();
}

public int save(CurrencyPrice currencyPrice){
return this.currencyPriceDaoEx.save(currencyPrice);
}
public int saveAutoId(CurrencyPrice currencyPrice){
return this.currencyPriceDaoEx.saveAutoId(currencyPrice);
}

public int saveAutoReturnId(CurrencyPrice currencyPrice){
return this.currencyPriceDaoEx.saveAutoReturnId(currencyPrice);
}


public CurrencyPrice get(int currencyPriceId){
return this.currencyPriceDaoEx.get(currencyPriceId);
}

public int delete(int currencyPriceId){
return this.currencyPriceDaoEx.delete(currencyPriceId);
}

public int updateSet(String set,String where){
return this.currencyPriceDaoEx.updateSet(set,where);
}

public int deleteWhere(String where){
return this.currencyPriceDaoEx.deleteWhere(where);
}


public int update(CurrencyPrice currencyPrice){
return this.currencyPriceDaoEx.update(currencyPrice);
}

public List<CurrencyPrice> find(String hql){
return this.currencyPriceDaoEx.find(hql);
}

public List<CurrencyPrice> findNames(List<String> names,String wherehql){
    return this.currencyPriceDaoEx.findNames(names,wherehql);
    }


    public PageList<CurrencyPrice> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        return this.currencyPriceDaoEx.findNamesPage(names,wherehql,pageNo,total);
        }



public List<CurrencyPrice> findAll(){
return this.currencyPriceDaoEx.findAll();
}

public PageList<CurrencyPrice> findByPage(int pageNo,int total){
return this.currencyPriceDaoEx.findByPage(pageNo,total);
}

public PageList<CurrencyPrice> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.currencyPriceDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}
        public List<CurrencyPrice> findNameArray(String[] names,String wherehql){
        return this.currencyPriceDaoEx.findNameArray(names,wherehql);
        }

        public PageList<CurrencyPrice> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
        return this.currencyPriceDaoEx.findNameArrayPage(names,wherehql,pageNo,total);
        }



}
