package com.js.isearch.daoimplex;

/**
* last update time:"19-06-22 18:12:39"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.daoex.CurrencyPriceDaoEx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Connection;
import com.js.common.util.Globe;
import java.sql.Statement;
import com.js.common.util.PageList;


public class CurrencyPriceDaoimplEx implements CurrencyPriceDaoEx {

public String dbname= Globe.dbname;

public List<CurrencyPrice> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPrice currencyPrice = null;
List<CurrencyPrice> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
currencyPrice = new CurrencyPrice();
setFindParamNo(r, currencyPrice);
list.add(currencyPrice);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return list;

}


public List<CurrencyPrice> findNames(List<String> names,String wherehql){
    PreparedStatement p = null;
    ResultSet r = null;
    Connection conn=null;
    CurrencyPrice currencyPrice = null;
    List<CurrencyPrice> list = new ArrayList();

    StringBuffer sqlBuffer = new StringBuffer("select ");
    for(String fieldname:names){
    sqlBuffer.append(fieldname).append(",");
    }
    String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
    sqlBuffer.setLength(0);
    sqlBuffer.append(select).append(" from ").append(" ex_currency_price ").append(wherehql);
    String sql = sqlBuffer.toString();
    try {
    //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
    conn =HikariDb.getConnection();
    p=conn.prepareStatement(sql);
    r = p.executeQuery();
    while (r.next()) {
    currencyPrice = new CurrencyPrice();
    setFindParamNo(r, currencyPrice);
//    for(String n:names){
//        currencyPrice.getMap().put(n,r.getString(n));
//    }
    list.add(currencyPrice);
    }
    } catch (Exception e) {
    e.printStackTrace();
    throw new DatabaseException(e);
    } finally {
    DbUtils.close(r, p);
    DbUtils.closeConn(conn);
    //DbHotel.closeIforum_index_dbConnection();
    }
    return list;
    }

    public PageList<CurrencyPrice> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyPrice currencyPrice = null;
        PageList<CurrencyPrice> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
        sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ").append(" ex_currency_price ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
        //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        currencyPrice = new CurrencyPrice();
        setFindParamNo(r, currencyPrice);
        //for(String n:names){
        //currencyPrice.getMap().put(n,r.getString(n));
        //}
        list.add(currencyPrice);
        }
        } catch (Exception e) {
        e.printStackTrace();
        throw new DatabaseException(e);
        } finally {
        DbUtils.close(r, p);
        DbUtils.closeConn(conn);
        //DbHotel.closeIforum_index_dbConnection();
        }
        return list;
        }


        public List<CurrencyPrice> findNameArray(String[] names,String wherehql){
            PreparedStatement p = null;
            ResultSet r = null;
            Connection conn=null;
            CurrencyPrice currencyPrice = null;
            List<CurrencyPrice> list = new ArrayList();

            StringBuffer sqlBuffer = new StringBuffer("select ");
            for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
            }
            String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
            sqlBuffer.setLength(0);
            sqlBuffer.append(select).append(" from ").append(" ex_currency_price ").append(wherehql);
            String sql = sqlBuffer.toString();
            try {
            //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
            currencyPrice = new CurrencyPrice();
            //for(String n:names){
            //currencyPrice.getMap().put(n,r.getString(n));
            //}
            setFindParamNo(r, currencyPrice);
            list.add(currencyPrice);
            }
            } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
            } finally {
            DbUtils.close(r, p);
            DbUtils.closeConn(conn);
            //DbHotel.closeIforum_index_dbConnection();
            }
            return list;
            }


            public PageList<CurrencyPrice> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
                PreparedStatement p = null;
                ResultSet r = null;
                Connection conn=null;
                CurrencyPrice currencyPrice = null;
                PageList<CurrencyPrice> list = new PageList(pageNo,total);

                StringBuffer sqlBuffer = new StringBuffer("select ");
                for(String fieldname:names){
                sqlBuffer.append(fieldname).append(",");
                }
                String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
                sqlBuffer.setLength(0);
                sqlBuffer.append(select).append(" from ").append(" ex_currency_price ").append(wherehql).append(" limit ?,?");
                String sql = sqlBuffer.toString();
                try {
                //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
                conn =HikariDb.getConnection();
                p=conn.prepareStatement(sql);
                p.setInt(1,list.getOffset());
                p.setInt(2,list.getPageSize());
                r = p.executeQuery();
                while (r.next()) {
                currencyPrice = new CurrencyPrice();
                setFindParamNo(r, currencyPrice);
                //for(String n:names){
                //currencyPrice.getMap().put(n,r.getString(n));
                //}
                list.add(currencyPrice);
                }
                } catch (Exception e) {
                e.printStackTrace();
                throw new DatabaseException(e);
                } finally {
                DbUtils.close(r, p);
                DbUtils.closeConn(conn);
                //DbHotel.closeIforum_index_dbConnection();
                }
                return list;
                }




public int save(CurrencyPrice currencyPrice) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ex_currency_price(`currency_price_id`,`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,currencyPrice);
result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}



public int saveAutoReturnId(CurrencyPrice currencyPrice) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ex_currency_price(`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_price(`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,currencyPrice);
result=p.executeUpdate();
r = p.getGeneratedKeys();
if (r != null&&r.next()) {
returnID=r.getInt(1);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return returnID;
}

public int saveAutoId(CurrencyPrice currencyPrice) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ex_currency_price(`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_price(`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ex_currency_price(`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
setStatementAutoId(p,currencyPrice);
result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}

private void setStatement(PreparedStatement p,CurrencyPrice currencyPrice) throws Exception{
p.setObject(1,currencyPrice.getCurrencyPriceId());
p.setObject(2,currencyPrice.getCurrencyId());
p.setString(3,currencyPrice.getName());
p.setString(4,currencyPrice.getSymbol());
p.setObject(5,currencyPrice.getCurrentPrice());
p.setObject(6,currencyPrice.getPriceChange());
p.setObject(7,currencyPrice.getDexId());
p.setString(8,currencyPrice.getDexName());
p.setLong(9,currencyPrice.getCreateTime());
p.setLong(10,currencyPrice.getUpdateTime());
p.setLong(11,currencyPrice.getVolume());
p.setLong(12,currencyPrice.getCirculatingVolume());
p.setObject(13,currencyPrice.getMarketCap());
p.setObject(14,currencyPrice.getRankMarketCap());
p.setLong(15,currencyPrice.getBatchTime());
p.setString(16,currencyPrice.getInfoUrl());

}

private void setStatementAutoId(PreparedStatement p,CurrencyPrice currencyPrice) throws Exception{
    p.setObject(1,currencyPrice.getCurrencyId());
p.setString(2,currencyPrice.getName());
p.setString(3,currencyPrice.getSymbol());
p.setObject(4,currencyPrice.getCurrentPrice());
p.setObject(5,currencyPrice.getPriceChange());
p.setObject(6,currencyPrice.getDexId());
p.setString(7,currencyPrice.getDexName());
p.setLong(8,currencyPrice.getCreateTime());
p.setLong(9,currencyPrice.getUpdateTime());
p.setLong(10,currencyPrice.getVolume());
p.setLong(11,currencyPrice.getCirculatingVolume());
p.setObject(12,currencyPrice.getMarketCap());
p.setObject(13,currencyPrice.getRankMarketCap());
p.setLong(14,currencyPrice.getBatchTime());
p.setString(15,currencyPrice.getInfoUrl());

}

public List<CurrencyPrice> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPrice currencyPrice = null;
List<CurrencyPrice> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_price_id,a.currency_id,a.name,a.symbol,a.current_price,a.price_change,a.dex_id,a.dex_name,a.create_time,a.update_time,a.volume,a.circulating_volume,a.market_cap,a.rank_market_cap,a.batch_time,a.info_url from ex_currency_price as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.currency_price_id,a.currency_id,a.name,a.symbol,a.current_price,a.price_change,a.dex_id,a.dex_name,a.create_time,a.update_time,a.volume,a.circulating_volume,a.market_cap,a.rank_market_cap,a.batch_time,a.info_url from ex_currency_price as a");
r = p.executeQuery();
while (r.next()) {
currencyPrice = new CurrencyPrice();
setFindParamNo(r, currencyPrice);
list.add(currencyPrice);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return list;
}

public PageList<CurrencyPrice> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPrice currencyPrice = null;
PageList<CurrencyPrice> list = new PageList(pageNo,total);
String sql = "select a.currency_price_id,a.currency_id,a.name,a.symbol,a.current_price,a.price_change,a.dex_id,a.dex_name,a.create_time,a.update_time,a.volume,a.circulating_volume,a.market_cap,a.rank_market_cap,a.batch_time,a.info_url from ex_currency_price as a ORDER BY a.create_time DESC  LIMIT ?,? ";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_price_id,a.currency_id,a.name,a.symbol,a.current_price,a.price_change,a.dex_id,a.dex_name,a.create_time,a.update_time,a.volume,a.circulating_volume,a.market_cap,a.rank_market_cap,a.batch_time,a.info_url from ex_currency_price as a ORDER BY a.create_time DESC  LIMIT ?,? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
currencyPrice = new CurrencyPrice();
setFindParamNo(r, currencyPrice);
list.add(currencyPrice);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return list;
}


public PageList<CurrencyPrice> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPrice currencyPrice = null;
PageList<CurrencyPrice> list = new PageList(pageNo,total);
String sql = "select a.currency_price_id,a.currency_id,a.name,a.symbol,a.current_price,a.price_change,a.dex_id,a.dex_name,a.create_time,a.update_time,a.volume,a.circulating_volume,a.market_cap,a.rank_market_cap,a.batch_time,a.info_url from ex_currency_price as a";
StringBuffer sb = new StringBuffer(sql);
sb.append(" order by ").append("a.").append(fieldname);
if(asc) sb.append(" asc ");
else sb.append(" desc ");
sb.append(" limit ?,?");

try {
conn =HikariDb.getConnection();
p=conn.prepareStatement(sb.toString());
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
currencyPrice = new CurrencyPrice();
setFindParamNo(r, currencyPrice);
list.add(currencyPrice);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return list;

}



public int update(CurrencyPrice currencyPrice) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ex_currency_price set `currency_id`=?,`name`=?,`symbol`=?,`current_price`=?,`price_change`=?,`dex_id`=?,`dex_name`=?,`create_time`=?,`update_time`=?,`volume`=?,`circulating_volume`=?,`market_cap`=?,`rank_market_cap`=?,`batch_time`=?,`info_url`=? where currency_price_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ex_currency_price set `currency_id`=?,`name`=?,`symbol`=?,`current_price`=?,`price_change`=?,`dex_id`=?,`dex_name`=?,`create_time`=?,`update_time`=?,`volume`=?,`circulating_volume`=?,`market_cap`=?,`rank_market_cap`=?,`batch_time`=?,`info_url`=? where currency_price_id=? ");
p.setObject(1,currencyPrice.getCurrencyId());
p.setString(2,currencyPrice.getName());
p.setString(3,currencyPrice.getSymbol());
p.setObject(4,currencyPrice.getCurrentPrice());
p.setObject(5,currencyPrice.getPriceChange());
p.setObject(6,currencyPrice.getDexId());
p.setString(7,currencyPrice.getDexName());
p.setLong(8,currencyPrice.getCreateTime());
p.setLong(9,currencyPrice.getUpdateTime());
p.setLong(10,currencyPrice.getVolume());
p.setLong(11,currencyPrice.getCirculatingVolume());
p.setObject(12,currencyPrice.getMarketCap());
p.setObject(13,currencyPrice.getRankMarketCap());
p.setLong(14,currencyPrice.getBatchTime());
p.setString(15,currencyPrice.getInfoUrl());
p.setInt(16,currencyPrice.getCurrencyPriceId());

result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}

public int delete(int currencyPriceId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ex_currency_price where currency_price_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ex_currency_price where currency_price_id=? ");
p.setInt(1,currencyPriceId);

result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}

        public int updateSet(String set,String where){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        StringBuffer sqlBuffer = new StringBuffer("update ").append(" ex_currency_price ").append(set).append(" ").append(where);
        String sql = sqlBuffer.toString();
        System.out.println("update sql:"+sql);
        try {
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        result=p.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace();
        throw new DatabaseException(e);
        } finally {
        DbUtils.close(p);
        DbUtils.closeConn(conn);
        }
        return result;
        }

        public int deleteWhere(String where){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ex_currency_price ").append(where);
        String sql = sqlBuffer.toString();
        System.out.println("delete sql:"+sql);
        try {
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        result=p.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace();
        throw new DatabaseException(e);
        } finally {
        DbUtils.close(p);
        DbUtils.closeConn(conn);
        }
        return result;
        }



public CurrencyPrice get(int currencyPriceId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPrice currencyPrice = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `currency_price_id`,`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url` from ex_currency_price where currency_price_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `currency_price_id`,`currency_id`,`name`,`symbol`,`current_price`,`price_change`,`dex_id`,`dex_name`,`create_time`,`update_time`,`volume`,`circulating_volume`,`market_cap`,`rank_market_cap`,`batch_time`,`info_url` from ex_currency_price where currency_price_id=? ");
p.setInt(1,currencyPriceId);

r=p.executeQuery();
while (r.next()) {
currencyPrice =new CurrencyPrice();
setFindParamNo(r, currencyPrice);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return currencyPrice;
}




protected void setFindParam(ResultSet r,CurrencyPrice currencyPrice) throws Exception{
currencyPrice.setCurrencyPriceId(r.getInt("currency_price_id"));
currencyPrice.setCurrencyId(r.getInt("currency_id"));
currencyPrice.setName(r.getString("name"));
currencyPrice.setSymbol(r.getString("symbol"));
currencyPrice.setCurrentPrice(r.getDouble("current_price"));
currencyPrice.setPriceChange(r.getDouble("price_change"));
currencyPrice.setDexId(r.getInt("dex_id"));
currencyPrice.setDexName(r.getString("dex_name"));
currencyPrice.setCreateTime(r.getLong("create_time"));
currencyPrice.setUpdateTime(r.getLong("update_time"));
currencyPrice.setVolume(r.getLong("volume"));
currencyPrice.setCirculatingVolume(r.getLong("circulating_volume"));
currencyPrice.setMarketCap(r.getDouble("market_cap"));
currencyPrice.setRankMarketCap(r.getInt("rank_market_cap"));
currencyPrice.setBatchTime(r.getLong("batch_time"));
currencyPrice.setInfoUrl(r.getString("info_url"));
}

protected void setFindParamNo(ResultSet r,CurrencyPrice currencyPrice) throws Exception{
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
}

}
