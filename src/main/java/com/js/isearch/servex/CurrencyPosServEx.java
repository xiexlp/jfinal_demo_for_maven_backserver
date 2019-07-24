package com.js.isearch.servex;

/**
* last update time:"19-07-03 14:56:20"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.daoimplex.CurrencyPosDaoimplEx;
import com.js.isearch.daoex.CurrencyPosDaoEx;

import com.js.isearch.daoimpl.CurrencyPosDaoimpl;
import com.js.isearch.dao.CurrencyPosDao;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPosServEx{

private CurrencyPosDaoEx currencyPosDaoEx;

public CurrencyPosServEx(){
this.currencyPosDaoEx =new CurrencyPosDaoimplEx();
}

public static CurrencyPosServEx n(){
return new CurrencyPosServEx();
}

public int save(CurrencyPos currencyPos){
return this.currencyPosDaoEx.save(currencyPos);
}
public int saveAutoId(CurrencyPos currencyPos){
return this.currencyPosDaoEx.saveAutoId(currencyPos);
}

public int saveAutoReturnId(CurrencyPos currencyPos){
return this.currencyPosDaoEx.saveAutoReturnId(currencyPos);
}


public CurrencyPos get(int currencyPosId){
return this.currencyPosDaoEx.get(currencyPosId);
}

public int delete(int currencyPosId){
return this.currencyPosDaoEx.delete(currencyPosId);
}

public int updateSet(String set,String where){
return this.currencyPosDaoEx.updateSet(set,where);
}

public int deleteWhere(String where){
return this.currencyPosDaoEx.deleteWhere(where);
}


public int update(CurrencyPos currencyPos){
return this.currencyPosDaoEx.update(currencyPos);
}

public List<CurrencyPos> find(String hql){
return this.currencyPosDaoEx.find(hql);
}

public List<CurrencyPos> findNames(List<String> names,String wherehql){
    return this.currencyPosDaoEx.findNames(names,wherehql);
    }


    public PageList<CurrencyPos> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        return this.currencyPosDaoEx.findNamesPage(names,wherehql,pageNo,total);
        }



public List<CurrencyPos> findAll(){
return this.currencyPosDaoEx.findAll();
}

public PageList<CurrencyPos> findByPage(int pageNo,int total){
return this.currencyPosDaoEx.findByPage(pageNo,total);
}

public PageList<CurrencyPos> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.currencyPosDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}
        public List<CurrencyPos> findNameArray(String[] names,String wherehql){
        return this.currencyPosDaoEx.findNameArray(names,wherehql);
        }

        public PageList<CurrencyPos> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
        return this.currencyPosDaoEx.findNameArrayPage(names,wherehql,pageNo,total);
        }



}
