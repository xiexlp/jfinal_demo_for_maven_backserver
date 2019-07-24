package com.js.isearch.servread;

/**
* last update time:"19-06-21 10:34:46"
* last update user:pku
*/

import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.daoimpl.CurrencyInfoDaoimpl;
import com.js.isearch.dao.CurrencyInfoDao;
import com.js.isearch.serv.CurrencyInfoServ;
import com.js.isearch.servex.CurrencyInfoServEx;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.servupdate.CurrencyInfoServUpdate;

public class CurrencyInfoServRead extends CurrencyInfoServEx{

private CurrencyInfoDao currencyInfoDao;

private static CurrencyInfoServRead currencyInfoServRead= new CurrencyInfoServRead();

public CurrencyInfoServRead(){
this.currencyInfoDao =new CurrencyInfoDaoimpl();
}

public static CurrencyInfoServRead n(){
    if(currencyInfoServRead!=null) return currencyInfoServRead;
    else {
    currencyInfoServRead = new CurrencyInfoServRead();
    }
    return currencyInfoServRead;
}

public static CurrencyInfoServRead newInstance(){
    return new CurrencyInfoServRead();
}
//放在server里面
public List<CurrencyInfo> find_OrderBy_BySymbolEq(String symbol){
return currencyInfoDao.find_OrderBy_BySymbolEq(symbol);
}


    public static void main1(String[] args) {
        CurrencyInfoServRead currencyInfoServRead= CurrencyInfoServRead.n();
        List<CurrencyInfo> currencyInfoList=currencyInfoServRead.find_OrderBy_BySymbolEq("DASH");
        System.out.println(currencyInfoList.size());
    }

    public static void main(String[] args) {
        CurrencyInfoServRead currencyInfoServRead= CurrencyInfoServRead.n();
        List<CurrencyInfo> currencyInfos = currencyInfoServRead.findAll();
        for(CurrencyInfo currencyInfo:currencyInfos){

            if(currencyInfo.getUrl().equalsIgnoreCase("")){
                System.out.println("来源于masternodes");
                //currencyInfo.setUrl("https://masternodes.online");
                //int result=CurrencyInfoServUpdate.n().update(currencyInfo);
                //if(result>0){
                 //   System.out.println("更新成功");
                //}
            }else if(currencyInfo.getUrl().equalsIgnoreCase("https://coinmarketcap.com")){
                System.out.println("来源于coinmarketcap");

                String name = currencyInfo.getName();
                System.out.println("名称:"+name);
                int index = name.indexOf(" ");
                String nextName = name.substring(index,name.length());
                System.out.println("next name:"+nextName);
                String underline = nextName.trim().replace(" ","-").replace(".","-");
                System.out.println("under line:"+underline.toLowerCase());
                //得到唯一的名称标识
                currencyInfo.setCurrencyIdName(underline.toLowerCase());

                int result =CurrencyInfoServ.n().update(currencyInfo);
                if(result>0){
                    System.out.println("更新currency id name成功:"+underline.toLowerCase());
                }

            }

        }


    }

}