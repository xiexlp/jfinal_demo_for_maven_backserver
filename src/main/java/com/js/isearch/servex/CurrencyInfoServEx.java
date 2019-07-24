package com.js.isearch.servex;

/**
* last update time:"19-07-03 14:07:41"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.daoimplex.CurrencyInfoDaoimplEx;
import com.js.isearch.daoex.CurrencyInfoDaoEx;

import com.js.isearch.daoimpl.CurrencyInfoDaoimpl;
import com.js.isearch.dao.CurrencyInfoDao;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyInfoServEx{

private CurrencyInfoDaoEx currencyInfoDaoEx;

public CurrencyInfoServEx(){
this.currencyInfoDaoEx =new CurrencyInfoDaoimplEx();
}

public static CurrencyInfoServEx n(){
return new CurrencyInfoServEx();
}

public int save(CurrencyInfo currencyInfo){
return this.currencyInfoDaoEx.save(currencyInfo);
}
public int saveAutoId(CurrencyInfo currencyInfo){
return this.currencyInfoDaoEx.saveAutoId(currencyInfo);
}

public int saveAutoReturnId(CurrencyInfo currencyInfo){
return this.currencyInfoDaoEx.saveAutoReturnId(currencyInfo);
}


public CurrencyInfo get(int currencyId){
return this.currencyInfoDaoEx.get(currencyId);
}

public int delete(int currencyId){
return this.currencyInfoDaoEx.delete(currencyId);
}

public int updateSet(String set,String where){
return this.currencyInfoDaoEx.updateSet(set,where);
}

public int deleteWhere(String where){
return this.currencyInfoDaoEx.deleteWhere(where);
}


public int update(CurrencyInfo currencyInfo){
return this.currencyInfoDaoEx.update(currencyInfo);
}

public List<CurrencyInfo> find(String hql){
return this.currencyInfoDaoEx.find(hql);
}

public List<CurrencyInfo> findNames(List<String> names,String wherehql){
    return this.currencyInfoDaoEx.findNames(names,wherehql);
    }


    public PageList<CurrencyInfo> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        return this.currencyInfoDaoEx.findNamesPage(names,wherehql,pageNo,total);
        }



public List<CurrencyInfo> findAll(){
return this.currencyInfoDaoEx.findAll();
}

public PageList<CurrencyInfo> findByPage(int pageNo,int total){
return this.currencyInfoDaoEx.findByPage(pageNo,total);
}

public PageList<CurrencyInfo> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.currencyInfoDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}
        public List<CurrencyInfo> findNameArray(String[] names,String wherehql){
        return this.currencyInfoDaoEx.findNameArray(names,wherehql);
        }

        public PageList<CurrencyInfo> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
        return this.currencyInfoDaoEx.findNameArrayPage(names,wherehql,pageNo,total);
        }



}
