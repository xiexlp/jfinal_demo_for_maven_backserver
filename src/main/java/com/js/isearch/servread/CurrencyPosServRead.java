package com.js.isearch.servread;

/**
* last update time:"19-06-21 15:55:54"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.daoimpl.CurrencyPosDaoimpl;
import com.js.isearch.dao.CurrencyPosDao;
import com.js.isearch.serv.CurrencyInfoServ;
import com.js.isearch.serv.CurrencyPosServ;
import com.js.isearch.servex.CurrencyPosServEx;
import java.util.List;
import com.js.common.util.PageList;

public class CurrencyPosServRead extends CurrencyPosServEx{

private CurrencyPosDao currencyPosDao;

private static CurrencyPosServRead currencyPosServRead= new CurrencyPosServRead();

public CurrencyPosServRead(){
this.currencyPosDao =new CurrencyPosDaoimpl();
}

public static CurrencyPosServRead n(){
    if(currencyPosServRead!=null) return currencyPosServRead;
    else {
    currencyPosServRead = new CurrencyPosServRead();
    }
    return currencyPosServRead;
}

public static CurrencyPosServRead newInstance(){
    return new CurrencyPosServRead();
}
//放在server里面
public PageList<CurrencyPos> find_OrderByCurrencyPosIdAsc_ByBatchTimeEqPage(long batchTime,int pageNo,int total){
return currencyPosDao.find_OrderByCurrencyPosIdAsc_ByBatchTimeEqPage(batchTime,pageNo,total);
}


    //放在server里面
    public PageList<CurrencyPos> find_OrderBy_ByBatchTimeEqPage(long batchTime,int pageNo,int total,String sortBy,int sort){
        return currencyPosDao.find_OrderBy_ByBatchTimeEqPage(batchTime,pageNo,total,sortBy,sort);
    }

    public static void main(String[] args) {
        List<CurrencyPos> currencyPosList = CurrencyPosServRead.n().findAll();
        int size = currencyPosList.size();

        for(CurrencyPos currencyPos:currencyPosList){
            System.out.println("currency name:"+currencyPos.getCurrencyName());
            int currencyId = currencyPos.getCurrencyId();
            CurrencyInfo currencyInfo = CurrencyInfoServ.n().get(currencyId);
            System.out.println("currency info:"+currencyInfo.getSymbol());
            currencyPos.setDetailLink(currencyInfo.getDetailLink());
            int result = CurrencyPosServ.n().update(currencyPos);
            if(result>0){
                System.out.println("更新链接成功");
            }
        }



    }


}