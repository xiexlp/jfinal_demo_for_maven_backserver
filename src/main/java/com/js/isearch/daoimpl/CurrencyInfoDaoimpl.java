package com.js.isearch.daoimpl;

/**
* last update time:"19-06-20 18:05:55"
* last update user:pku
*/

import com.js.isearch.daoimplex.CurrencyInfoDaoimplEx;
import com.js.common.db.*;
import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.dao.CurrencyInfoDao;
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
public class CurrencyInfoDaoimpl extends CurrencyInfoDaoimplEx implements CurrencyInfoDao{




//放在daoimpl里面
public List<CurrencyInfo> find_OrderBy_BySymbolEq(String symbol) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
//PageList<CurrencyInfo> list = new PageList(pageNo,total);
List<CurrencyInfo> list = new ArrayList();
    CurrencyInfo currencyInfo = null;
String sql = "select a.currency_id,a.name,a.symbol,a.volume,a.circulating_volume,a.init_price,a.init_date,a.url,a.currency_desc from ex_currency_info as a where a.symbol=? and  1=1  ";
try {
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setObject(1,symbol);

r = p.executeQuery();
while (r.next()) {
    currencyInfo = new CurrencyInfo();
    currencyInfo.setCurrencyId(r.getInt(1));
currencyInfo.setName(r.getString(2));
currencyInfo.setSymbol(r.getString(3));
currencyInfo.setVolume(r.getLong(4));
currencyInfo.setCirculatingVolume(r.getLong(5));
currencyInfo.setInitPrice(r.getDouble(6));
currencyInfo.setInitDate(r.getLong(7));
currencyInfo.setUrl(r.getString(8));
currencyInfo.setCurrencyDesc(r.getString(9));

list.add(currencyInfo);
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