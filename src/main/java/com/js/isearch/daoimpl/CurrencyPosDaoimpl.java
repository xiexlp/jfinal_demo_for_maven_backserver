package com.js.isearch.daoimpl;

/**
* last update time:"19-06-20 22:08:46"
* last update user:pku
*/

import com.js.isearch.daoimplex.CurrencyPosDaoimplEx;
import com.js.common.db.*;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.dao.CurrencyPosDao;
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
public class CurrencyPosDaoimpl extends CurrencyPosDaoimplEx implements CurrencyPosDao{




//放在daoimpl里面
public PageList<CurrencyPos> find_OrderByCurrencyPosIdAsc_ByBatchTimeEqPage(long batchTime,int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
//PageList<CurrencyPos> list = new PageList(pageNo,total);
PageList<CurrencyPos> list = new PageList(pageNo,total);
    CurrencyPos currencyPos = null;
String sql = "select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time from ex_currency_pos as a where a.batch_time=? and  1=1  order by a.currency_pos_id asc limit ?,?";
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
    currencyPos = new CurrencyPos();
    currencyPos.setCurrencyPosId(r.getInt(1));
currencyPos.setCurrencyName(r.getString(2));
currencyPos.setSymbol(r.getString(3));
currencyPos.setLogoUrl(r.getString(4));
currencyPos.setCurrentPrice(r.getDouble(5));
currencyPos.setPriceChange(r.getDouble(6));
currencyPos.setVolume(r.getLong(7));
currencyPos.setMarketCap(r.getDouble(8));
currencyPos.setRoi(r.getDouble(9));
currencyPos.setNodeNum(r.getInt(10));
currencyPos.setRequiredNum(r.getInt(11));
currencyPos.setMnWorth(r.getDouble(12));
currencyPos.setCreateTime(r.getLong(13));
currencyPos.setUpdateTime(r.getLong(14));
currencyPos.setInfoUrl(r.getString(15));
currencyPos.setCurrencyId(r.getInt(16));
currencyPos.setBatchTime(r.getLong(17));

    list.add(currencyPos);
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

    public PageList<CurrencyPos> find_OrderBy_ByBatchTimeEqPage(long batchTime,int pageNo,int total,String sortBy,int sort){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        //PageList<CurrencyPos> list = new PageList(pageNo,total);
        PageList<CurrencyPos> list = new PageList(pageNo,total);
        CurrencyPos currencyPos = null;
        String sql = "select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time,a.detail_link from ex_currency_pos as a where a.batch_time=? and  1=1  order by ";
        StringBuffer sb = new StringBuffer(sql);
        if(sortBy.equalsIgnoreCase("")) sb.append(" a.currency_pos_id ");
        else { sb.append(" a.");sb.append(sortBy);}
        if(sort==0) sb.append(" asc ");
        if(sort==1) sb.append(" desc  ");
        sb.append(" limit ?,?");
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sb.toString());
            p.setObject(1,batchTime);
            p.setInt(2,list.getOffset());
            p.setInt(3,list.getPageSize());

            r = p.executeQuery();
            while (r.next()) {
                currencyPos = new CurrencyPos();
                currencyPos.setCurrencyPosId(r.getInt(1));
                currencyPos.setCurrencyName(r.getString(2));
                currencyPos.setSymbol(r.getString(3));
                currencyPos.setLogoUrl(r.getString(4));
                currencyPos.setCurrentPrice(r.getDouble(5));
                currencyPos.setPriceChange(r.getDouble(6));
                currencyPos.setVolume(r.getLong(7));
                currencyPos.setMarketCap(r.getDouble(8));
                currencyPos.setRoi(r.getDouble(9));
                currencyPos.setNodeNum(r.getInt(10));
                currencyPos.setRequiredNum(r.getInt(11));
                currencyPos.setMnWorth(r.getDouble(12));
                currencyPos.setCreateTime(r.getLong(13));
                currencyPos.setUpdateTime(r.getLong(14));
                currencyPos.setInfoUrl(r.getString(15));
                currencyPos.setCurrencyId(r.getInt(16));
                currencyPos.setBatchTime(r.getLong(17));
                currencyPos.setDetailLink(r.getString(18));
                list.add(currencyPos);
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