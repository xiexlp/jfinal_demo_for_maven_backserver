package com.js.isearch.servex;

/**
* last update time:"19-06-21 17:13:19"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPosScrawLog;
import com.js.isearch.daoimplex.CurrencyPosScrawLogDaoimplEx;
import com.js.isearch.daoex.CurrencyPosScrawLogDaoEx;

import com.js.isearch.daoimpl.CurrencyPosScrawLogDaoimpl;
import com.js.isearch.dao.CurrencyPosScrawLogDao;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPosScrawLogServEx{

private CurrencyPosScrawLogDaoEx currencyPosScrawLogDaoEx;

public CurrencyPosScrawLogServEx(){
this.currencyPosScrawLogDaoEx =new CurrencyPosScrawLogDaoimplEx();
}

public static CurrencyPosScrawLogServEx n(){
return new CurrencyPosScrawLogServEx();
}

public int save(CurrencyPosScrawLog currencyPosScrawLog){
return this.currencyPosScrawLogDaoEx.save(currencyPosScrawLog);
}
public int saveAutoId(CurrencyPosScrawLog currencyPosScrawLog){
return this.currencyPosScrawLogDaoEx.saveAutoId(currencyPosScrawLog);
}

public int saveAutoReturnId(CurrencyPosScrawLog currencyPosScrawLog){
return this.currencyPosScrawLogDaoEx.saveAutoReturnId(currencyPosScrawLog);
}


public CurrencyPosScrawLog get(int currencyPosScrawLogId){
return this.currencyPosScrawLogDaoEx.get(currencyPosScrawLogId);
}

public int delete(int currencyPosScrawLogId){
return this.currencyPosScrawLogDaoEx.delete(currencyPosScrawLogId);
}

public int updateSet(String set,String where){
return this.currencyPosScrawLogDaoEx.updateSet(set,where);
}

public int deleteWhere(String where){
return this.currencyPosScrawLogDaoEx.deleteWhere(where);
}


public int update(CurrencyPosScrawLog currencyPosScrawLog){
return this.currencyPosScrawLogDaoEx.update(currencyPosScrawLog);
}

public List<CurrencyPosScrawLog> find(String hql){
return this.currencyPosScrawLogDaoEx.find(hql);
}

public List<CurrencyPosScrawLog> findNames(List<String> names,String wherehql){
    return this.currencyPosScrawLogDaoEx.findNames(names,wherehql);
    }


    public PageList<CurrencyPosScrawLog> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        return this.currencyPosScrawLogDaoEx.findNamesPage(names,wherehql,pageNo,total);
        }



public List<CurrencyPosScrawLog> findAll(){
return this.currencyPosScrawLogDaoEx.findAll();
}

public PageList<CurrencyPosScrawLog> findByPage(int pageNo,int total){
return this.currencyPosScrawLogDaoEx.findByPage(pageNo,total);
}

public PageList<CurrencyPosScrawLog> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.currencyPosScrawLogDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}
        public List<CurrencyPosScrawLog> findNameArray(String[] names,String wherehql){
        return this.currencyPosScrawLogDaoEx.findNameArray(names,wherehql);
        }

        public PageList<CurrencyPosScrawLog> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
        return this.currencyPosScrawLogDaoEx.findNameArrayPage(names,wherehql,pageNo,total);
        }



}
