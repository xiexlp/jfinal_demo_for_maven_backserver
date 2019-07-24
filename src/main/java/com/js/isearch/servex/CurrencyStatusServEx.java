package com.js.isearch.servex;

/**
* last update time:"19-06-21 14:44:43"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.daoimplex.CurrencyStatusDaoimplEx;
import com.js.isearch.daoex.CurrencyStatusDaoEx;

import com.js.isearch.daoimpl.CurrencyStatusDaoimpl;
import com.js.isearch.dao.CurrencyStatusDao;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyStatusServEx{

private CurrencyStatusDaoEx currencyStatusDaoEx;

public CurrencyStatusServEx(){
this.currencyStatusDaoEx =new CurrencyStatusDaoimplEx();
}

public static CurrencyStatusServEx n(){
return new CurrencyStatusServEx();
}

public int save(CurrencyStatus currencyStatus){
return this.currencyStatusDaoEx.save(currencyStatus);
}
public int saveAutoId(CurrencyStatus currencyStatus){
return this.currencyStatusDaoEx.saveAutoId(currencyStatus);
}

public int saveAutoReturnId(CurrencyStatus currencyStatus){
return this.currencyStatusDaoEx.saveAutoReturnId(currencyStatus);
}


public CurrencyStatus get(int currencyStatusId){
return this.currencyStatusDaoEx.get(currencyStatusId);
}

public int delete(int currencyStatusId){
return this.currencyStatusDaoEx.delete(currencyStatusId);
}

public int updateSet(String set,String where){
return this.currencyStatusDaoEx.updateSet(set,where);
}

public int deleteWhere(String where){
return this.currencyStatusDaoEx.deleteWhere(where);
}


public int update(CurrencyStatus currencyStatus){
return this.currencyStatusDaoEx.update(currencyStatus);
}

public List<CurrencyStatus> find(String hql){
return this.currencyStatusDaoEx.find(hql);
}

public List<CurrencyStatus> findNames(List<String> names,String wherehql){
    return this.currencyStatusDaoEx.findNames(names,wherehql);
    }


    public PageList<CurrencyStatus> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        return this.currencyStatusDaoEx.findNamesPage(names,wherehql,pageNo,total);
        }



public List<CurrencyStatus> findAll(){
return this.currencyStatusDaoEx.findAll();
}

public PageList<CurrencyStatus> findByPage(int pageNo,int total){
return this.currencyStatusDaoEx.findByPage(pageNo,total);
}

public PageList<CurrencyStatus> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.currencyStatusDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}
        public List<CurrencyStatus> findNameArray(String[] names,String wherehql){
        return this.currencyStatusDaoEx.findNameArray(names,wherehql);
        }

        public PageList<CurrencyStatus> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
        return this.currencyStatusDaoEx.findNameArrayPage(names,wherehql,pageNo,total);
        }



}
