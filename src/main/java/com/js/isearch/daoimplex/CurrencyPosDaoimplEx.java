package com.js.isearch.daoimplex;

/**
* last update time:"19-07-03 14:56:18"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.common.util.StringTool;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.daoex.CurrencyPosDaoEx;
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


public class CurrencyPosDaoimplEx implements CurrencyPosDaoEx {

public String dbname= Globe.dbname;

public List<CurrencyPos> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPos currencyPos = null;
List<CurrencyPos> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
currencyPos = new CurrencyPos();
setFindParamNo(r, currencyPos);
list.add(currencyPos);
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






public List<CurrencyPos> findNames(List<String> names,String wherehql){
    PreparedStatement p = null;
    ResultSet r = null;
    Connection conn=null;
    CurrencyPos currencyPos = null;
    List<CurrencyPos> list = new ArrayList();

    StringBuffer sqlBuffer = new StringBuffer("select ");
    for(String fieldname:names){
    sqlBuffer.append(fieldname).append(",");
    }
    String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
    sqlBuffer.setLength(0);
    sqlBuffer.append(select).append(" from ").append(" ex_currency_pos ").append(wherehql);
    String sql = sqlBuffer.toString();
    try {
    //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
    conn =HikariDb.getConnection();
    p=conn.prepareStatement(sql);
    r = p.executeQuery();
    while (r.next()) {
    currencyPos = new CurrencyPos();
    setFindParamNo(r, currencyPos);
//    for(String n:names){
//        currencyPos.getMap().put(n,r.getString(n));
//    }
    list.add(currencyPos);
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

    public PageList<CurrencyPos> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyPos currencyPos = null;
        PageList<CurrencyPos> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
        sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ").append(" ex_currency_pos ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
        //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        currencyPos = new CurrencyPos();
        setFindParamNo(r, currencyPos);
        //for(String n:names){
        //currencyPos.getMap().put(n,r.getString(n));
        //}
        list.add(currencyPos);
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


        public List<CurrencyPos> findNameArray(String[] names,String wherehql){
            PreparedStatement p = null;
            ResultSet r = null;
            Connection conn=null;
            CurrencyPos currencyPos = null;
            List<CurrencyPos> list = new ArrayList();

            StringBuffer sqlBuffer = new StringBuffer("select ");
            for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
            }
            String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
            sqlBuffer.setLength(0);
            sqlBuffer.append(select).append(" from ").append(" ex_currency_pos ").append(wherehql);
            String sql = sqlBuffer.toString();
            try {
            //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
            currencyPos = new CurrencyPos();
            //for(String n:names){
            //currencyPos.getMap().put(n,r.getString(n));
            //}
            setFindParamNo(r, currencyPos);
            list.add(currencyPos);
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


            public PageList<CurrencyPos> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
                PreparedStatement p = null;
                ResultSet r = null;
                Connection conn=null;
                CurrencyPos currencyPos = null;
                PageList<CurrencyPos> list = new PageList(pageNo,total);

                StringBuffer sqlBuffer = new StringBuffer("select ");
                for(String fieldname:names){
                sqlBuffer.append(fieldname).append(",");
                }
                String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
                sqlBuffer.setLength(0);
                sqlBuffer.append(select).append(" from ").append(" ex_currency_pos ").append(wherehql).append(" limit ?,?");
                String sql = sqlBuffer.toString();
                try {
                //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
                conn =HikariDb.getConnection();
                p=conn.prepareStatement(sql);
                p.setInt(1,list.getOffset());
                p.setInt(2,list.getPageSize());
                r = p.executeQuery();
                while (r.next()) {
                currencyPos = new CurrencyPos();
                setFindParamNo(r, currencyPos);
                //for(String n:names){
                //currencyPos.getMap().put(n,r.getString(n));
                //}
                list.add(currencyPos);
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




public int save(CurrencyPos currencyPos) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ex_currency_pos(`currency_pos_id`,`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,currencyPos);
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



public int saveAutoReturnId(CurrencyPos currencyPos) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ex_currency_pos(`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_pos(`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,currencyPos);
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

public int saveAutoId(CurrencyPos currencyPos) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ex_currency_pos(`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_pos(`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ex_currency_pos(`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
setStatementAutoId(p,currencyPos);
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

private void setStatement(PreparedStatement p,CurrencyPos currencyPos) throws Exception{
p.setObject(1,currencyPos.getCurrencyPosId());
p.setString(2,currencyPos.getCurrencyName());
p.setString(3,currencyPos.getSymbol());
p.setString(4,currencyPos.getLogoUrl());
p.setObject(5,currencyPos.getCurrentPrice());
p.setObject(6,currencyPos.getPriceChange());
p.setLong(7,currencyPos.getVolume());
p.setObject(8,currencyPos.getMarketCap());
p.setObject(9,currencyPos.getRoi());
p.setObject(10,currencyPos.getNodeNum());
p.setObject(11,currencyPos.getRequiredNum());
p.setObject(12,currencyPos.getMnWorth());
p.setLong(13,currencyPos.getCreateTime());
p.setLong(14,currencyPos.getUpdateTime());
p.setString(15,currencyPos.getInfoUrl());
p.setObject(16,currencyPos.getCurrencyId());
p.setLong(17,currencyPos.getBatchTime());
p.setString(18,currencyPos.getDetailLink());

}

private void setStatementAutoId(PreparedStatement p,CurrencyPos currencyPos) throws Exception{
    p.setString(1,currencyPos.getCurrencyName());
p.setString(2,currencyPos.getSymbol());
p.setString(3,currencyPos.getLogoUrl());
p.setObject(4,currencyPos.getCurrentPrice());
p.setObject(5,currencyPos.getPriceChange());
p.setLong(6,currencyPos.getVolume());
p.setObject(7,currencyPos.getMarketCap());
p.setObject(8,currencyPos.getRoi());
p.setObject(9,currencyPos.getNodeNum());
p.setObject(10,currencyPos.getRequiredNum());
p.setObject(11,currencyPos.getMnWorth());
p.setLong(12,currencyPos.getCreateTime());
p.setLong(13,currencyPos.getUpdateTime());
p.setString(14,currencyPos.getInfoUrl());
p.setObject(15,currencyPos.getCurrencyId());
p.setLong(16,currencyPos.getBatchTime());
p.setString(17,currencyPos.getDetailLink());

}

public List<CurrencyPos> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPos currencyPos = null;
List<CurrencyPos> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time,a.detail_link from ex_currency_pos as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time,a.detail_link from ex_currency_pos as a");
r = p.executeQuery();
while (r.next()) {
currencyPos = new CurrencyPos();
setFindParamNo(r, currencyPos);
list.add(currencyPos);
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

public PageList<CurrencyPos> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPos currencyPos = null;
PageList<CurrencyPos> list = new PageList(pageNo,total);
String sql = "select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time,a.detail_link from ex_currency_pos as a ORDER BY a.create_time DESC  LIMIT ?,? ";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time,a.detail_link from ex_currency_pos as a ORDER BY a.create_time DESC  LIMIT ?,? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
currencyPos = new CurrencyPos();
setFindParamNo(r, currencyPos);
list.add(currencyPos);
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


public PageList<CurrencyPos> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPos currencyPos = null;
PageList<CurrencyPos> list = new PageList(pageNo,total);
String sql = "select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time,a.detail_link from ex_currency_pos as a";
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
currencyPos = new CurrencyPos();
setFindParamNo(r, currencyPos);
list.add(currencyPos);
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

        public PageList<CurrencyPos> find_OrderBy_ByPage(int pageNo,int total,String sortBy,int sort,int pageSize){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyPos currencyPos = null;
        PageList<CurrencyPos> list = new PageList(pageNo,total,pageSize);
        String sql = "select a.currency_pos_id,a.currency_name,a.symbol,a.logo_url,a.current_price,a.price_change,a.volume,a.market_cap,a.roi,a.node_num,a.required_num,a.mn_worth,a.create_time,a.update_time,a.info_url,a.currency_id,a.batch_time,a.detail_link from ex_currency_pos as a";
        StringBuffer sb = new StringBuffer(sql);
        sb.append(" where 1=1 ");
        if(!sortBy.equalsIgnoreCase("")) {
        sb.append(" a.").append(StringTool.humpToUnderLine(sortBy)).append(" ");
        }else sb.append(" a.createTime ");
        if(sort==0) sb.append(" desc ");
        else if(sort==1) sb.append(" asc ");
        sb.append(" limit ?,? ");
        try {
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sb.toString());
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        currencyPos = new CurrencyPos();
        setFindParamNo(r, currencyPos);
        list.add(currencyPos);
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




public int update(CurrencyPos currencyPos) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ex_currency_pos set `currency_name`=?,`symbol`=?,`logo_url`=?,`current_price`=?,`price_change`=?,`volume`=?,`market_cap`=?,`roi`=?,`node_num`=?,`required_num`=?,`mn_worth`=?,`create_time`=?,`update_time`=?,`info_url`=?,`currency_id`=?,`batch_time`=?,`detail_link`=? where currency_pos_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ex_currency_pos set `currency_name`=?,`symbol`=?,`logo_url`=?,`current_price`=?,`price_change`=?,`volume`=?,`market_cap`=?,`roi`=?,`node_num`=?,`required_num`=?,`mn_worth`=?,`create_time`=?,`update_time`=?,`info_url`=?,`currency_id`=?,`batch_time`=?,`detail_link`=? where currency_pos_id=? ");
p.setString(1,currencyPos.getCurrencyName());
p.setString(2,currencyPos.getSymbol());
p.setString(3,currencyPos.getLogoUrl());
p.setObject(4,currencyPos.getCurrentPrice());
p.setObject(5,currencyPos.getPriceChange());
p.setLong(6,currencyPos.getVolume());
p.setObject(7,currencyPos.getMarketCap());
p.setObject(8,currencyPos.getRoi());
p.setObject(9,currencyPos.getNodeNum());
p.setObject(10,currencyPos.getRequiredNum());
p.setObject(11,currencyPos.getMnWorth());
p.setLong(12,currencyPos.getCreateTime());
p.setLong(13,currencyPos.getUpdateTime());
p.setString(14,currencyPos.getInfoUrl());
p.setObject(15,currencyPos.getCurrencyId());
p.setLong(16,currencyPos.getBatchTime());
p.setString(17,currencyPos.getDetailLink());
p.setInt(18,currencyPos.getCurrencyPosId());

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

public int delete(int currencyPosId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ex_currency_pos where currency_pos_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ex_currency_pos where currency_pos_id=? ");
p.setInt(1,currencyPosId);

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
        StringBuffer sqlBuffer = new StringBuffer("update ").append(" ex_currency_pos ").append(set).append(" ").append(where);
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
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ex_currency_pos ").append(where);
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



public CurrencyPos get(int currencyPosId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPos currencyPos = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `currency_pos_id`,`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link` from ex_currency_pos where currency_pos_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `currency_pos_id`,`currency_name`,`symbol`,`logo_url`,`current_price`,`price_change`,`volume`,`market_cap`,`roi`,`node_num`,`required_num`,`mn_worth`,`create_time`,`update_time`,`info_url`,`currency_id`,`batch_time`,`detail_link` from ex_currency_pos where currency_pos_id=? ");
p.setInt(1,currencyPosId);

r=p.executeQuery();
while (r.next()) {
currencyPos =new CurrencyPos();
setFindParamNo(r, currencyPos);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return currencyPos;
}




protected void setFindParam(ResultSet r,CurrencyPos currencyPos) throws Exception{
currencyPos.setCurrencyPosId(r.getInt("currency_pos_id"));
currencyPos.setCurrencyName(r.getString("currency_name"));
currencyPos.setSymbol(r.getString("symbol"));
currencyPos.setLogoUrl(r.getString("logo_url"));
currencyPos.setCurrentPrice(r.getDouble("current_price"));
currencyPos.setPriceChange(r.getDouble("price_change"));
currencyPos.setVolume(r.getLong("volume"));
currencyPos.setMarketCap(r.getDouble("market_cap"));
currencyPos.setRoi(r.getDouble("roi"));
currencyPos.setNodeNum(r.getInt("node_num"));
currencyPos.setRequiredNum(r.getInt("required_num"));
currencyPos.setMnWorth(r.getDouble("mn_worth"));
currencyPos.setCreateTime(r.getLong("create_time"));
currencyPos.setUpdateTime(r.getLong("update_time"));
currencyPos.setInfoUrl(r.getString("info_url"));
currencyPos.setCurrencyId(r.getInt("currency_id"));
currencyPos.setBatchTime(r.getLong("batch_time"));
currencyPos.setDetailLink(r.getString("detail_link"));
}

protected void setFindParamNo(ResultSet r,CurrencyPos currencyPos) throws Exception{
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
}

}
