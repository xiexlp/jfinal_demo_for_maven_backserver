package com.js.isearch.servex;

/**
* last update time:"19-06-20 18:04:02"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyDex;
import com.js.isearch.daoimplex.CurrencyDexDaoimplEx;
import com.js.isearch.daoex.CurrencyDexDaoEx;

import com.js.isearch.daoimpl.CurrencyDexDaoimpl;
import com.js.isearch.dao.CurrencyDexDao;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyDexServEx{

private CurrencyDexDaoEx currencyDexDaoEx;

public CurrencyDexServEx(){
this.currencyDexDaoEx =new CurrencyDexDaoimplEx();
}

public static CurrencyDexServEx n(){
return new CurrencyDexServEx();
}

public int save(CurrencyDex currencyDex){
return this.currencyDexDaoEx.save(currencyDex);
}
public int saveAutoId(CurrencyDex currencyDex){
return this.currencyDexDaoEx.saveAutoId(currencyDex);
}

public int saveAutoReturnId(CurrencyDex currencyDex){
return this.currencyDexDaoEx.saveAutoReturnId(currencyDex);
}


public CurrencyDex get(int dexId){
return this.currencyDexDaoEx.get(dexId);
}

public int delete(int dexId){
return this.currencyDexDaoEx.delete(dexId);
}

public int updateSet(String set,String where){
return this.currencyDexDaoEx.updateSet(set,where);
}

public int deleteWhere(String where){
return this.currencyDexDaoEx.deleteWhere(where);
}


public int update(CurrencyDex currencyDex){
return this.currencyDexDaoEx.update(currencyDex);
}

public List<CurrencyDex> find(String hql){
return this.currencyDexDaoEx.find(hql);
}

public List<CurrencyDex> findNames(List<String> names,String wherehql){
    return this.currencyDexDaoEx.findNames(names,wherehql);
    }


    public PageList<CurrencyDex> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        return this.currencyDexDaoEx.findNamesPage(names,wherehql,pageNo,total);
        }



public List<CurrencyDex> findAll(){
return this.currencyDexDaoEx.findAll();
}

public PageList<CurrencyDex> findByPage(int pageNo,int total){
return this.currencyDexDaoEx.findByPage(pageNo,total);
}

public PageList<CurrencyDex> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.currencyDexDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}
        public List<CurrencyDex> findNameArray(String[] names,String wherehql){
        return this.currencyDexDaoEx.findNameArray(names,wherehql);
        }

        public PageList<CurrencyDex> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
        return this.currencyDexDaoEx.findNameArrayPage(names,wherehql,pageNo,total);
        }



}
