package com.js.isearch.daoimpl;

/**
* last update time:"19-06-20 18:07:03"
* last update user:pku
*/

import com.js.common.util.StringTool;
import com.js.isearch.daoimplex.CurrencyPriceDaoimplEx;
import com.js.common.db.*;
import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.dao.CurrencyPriceDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.js.common.util.PageList;

/**
* Created by Administrator on 2015-7-16.
*/
public class CurrencyPriceDaoimpl extends CurrencyPriceDaoimplEx implements CurrencyPriceDao{




//放在daoimpl里面
public PageList<CurrencyPrice> find_OrderByMarketCapDesc_ByBatchTimeEqPage(long batchTime,int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
//PageList<CurrencyPrice> list = new PageList(pageNo,total);
PageList<CurrencyPrice> list = new PageList(pageNo,total);
    CurrencyPrice currencyPrice = null;
String sql = "select a.currency_price_id,a.currency_id,a.name,a.symbol,a.current_price,a.price_change,a.dex_id,a.dex_name,a.create_time,a.update_time,a.volume,a.circulating_volume,a.market_cap,a.rank_market_cap,a.batch_time,a.info_url from ex_currency_price as a where a.batch_time=? and  1=1  order by a.market_cap desc limit ?,?";
try {
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setObject(1,batchTime);
p.setInt(2,list.getOffset());
p.setInt(3,list.getPageSize());

//p.setObject(1,userID);
//p.setInt(2,list.getOffset());
//p.setInt(3,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
    currencyPrice = new CurrencyPrice();
    currencyPrice.setCurrencyPriceId(r.getInt(1));
currencyPrice.setCurrencyId(r.getInt(2));
currencyPrice.setName(r.getString(3));
currencyPrice.setSymbol(r.getString(4));
currencyPrice.setCurrentPrice(r.getDouble(5));
currencyPrice.setPriceChange(r.getDouble(6));
currencyPrice.setDexId(r.getInt(7));
currencyPrice.setDexName(r.getString(8));
currencyPrice.setCreateTime(r.getLong(9));
currencyPrice.setUpdateTime(r.getLong(10));
currencyPrice.setVolume(r.getLong(11));
currencyPrice.setCirculatingVolume(r.getLong(12));
currencyPrice.setMarketCap(r.getDouble(13));
currencyPrice.setRankMarketCap(r.getInt(14));
currencyPrice.setBatchTime(r.getLong(15));
currencyPrice.setInfoUrl(r.getString(16));

    list.add(currencyPrice);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
}
return list;
}

    public PageList<CurrencyPrice> find_OrderBy_ByBatchTimeEqPage(long batchTime,int pageNo,int total,String sortBy,int sort,int pageSize) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        //PageList<CurrencyPrice> list = new PageList(pageNo,total);
        PageList<CurrencyPrice> list = new PageList(pageNo,total,pageSize);
        CurrencyPrice currencyPrice = null;
        String sql = "select a.currency_price_id,a.currency_id,a.name,a.symbol,a.current_price,a.price_change,a.dex_id,a.dex_name,a.create_time,a.update_time,a.volume,a.circulating_volume,a.market_cap,a.rank_market_cap,a.batch_time,a.info_url from ex_currency_price as a where a.batch_time=? and  1=1  order by ";
        StringBuffer sb = new StringBuffer(sql);
        if(!sortBy.equalsIgnoreCase("")) {
            sb.append(" a.").append(StringTool.humpToUnderLine(sortBy)).append(" ");
        }else sb.append(" a.market_cap ");
        if(sort==0) sb.append(" desc ");
        else if(sort==1) sb.append(" asc ");
        sb.append(" limit ?,?");
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sb.toString());
            p.setObject(1,batchTime);
            p.setInt(2,list.getOffset());
            p.setInt(3,list.getPageSize());
            r = p.executeQuery();
            while (r.next()) {
                currencyPrice = new CurrencyPrice();
                currencyPrice.setCurrencyPriceId(r.getInt(1));
                currencyPrice.setCurrencyId(r.getInt(2));
                currencyPrice.setName(r.getString(3));
                currencyPrice.setSymbol(r.getString(4));
                currencyPrice.setCurrentPrice(r.getDouble(5));
                currencyPrice.setPriceChange(r.getDouble(6));
                currencyPrice.setDexId(r.getInt(7));
                currencyPrice.setDexName(r.getString(8));
                currencyPrice.setCreateTime(r.getLong(9));
                currencyPrice.setUpdateTime(r.getLong(10));
                currencyPrice.setVolume(r.getLong(11));
                currencyPrice.setCirculatingVolume(r.getLong(12));
                currencyPrice.setMarketCap(r.getDouble(13));
                currencyPrice.setRankMarketCap(r.getInt(14));
                currencyPrice.setBatchTime(r.getLong(15));
                currencyPrice.setInfoUrl(r.getString(16));

                list.add(currencyPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
        } finally {
            DbUtils.close(r, p);
            DbUtils.closeConn(conn);
        }
        return list;
    }


}