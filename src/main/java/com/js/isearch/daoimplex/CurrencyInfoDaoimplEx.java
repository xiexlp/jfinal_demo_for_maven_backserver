package com.js.isearch.daoimplex;

/**
* last update time:"19-07-03 14:07:40"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.common.util.StringTool;
import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.daoex.CurrencyInfoDaoEx;
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


public class CurrencyInfoDaoimplEx implements CurrencyInfoDaoEx {

public String dbname= Globe.dbname;

public List<CurrencyInfo> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyInfo currencyInfo = null;
List<CurrencyInfo> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
currencyInfo = new CurrencyInfo();
setFindParamNo(r, currencyInfo);
list.add(currencyInfo);
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






public List<CurrencyInfo> findNames(List<String> names,String wherehql){
    PreparedStatement p = null;
    ResultSet r = null;
    Connection conn=null;
    CurrencyInfo currencyInfo = null;
    List<CurrencyInfo> list = new ArrayList();

    StringBuffer sqlBuffer = new StringBuffer("select ");
    for(String fieldname:names){
    sqlBuffer.append(fieldname).append(",");
    }
    String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
    sqlBuffer.setLength(0);
    sqlBuffer.append(select).append(" from ").append(" ex_currency_info ").append(wherehql);
    String sql = sqlBuffer.toString();
    try {
    //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
    conn =HikariDb.getConnection();
    p=conn.prepareStatement(sql);
    r = p.executeQuery();
    while (r.next()) {
    currencyInfo = new CurrencyInfo();
    setFindParamNo(r, currencyInfo);
//    for(String n:names){
//        currencyInfo.getMap().put(n,r.getString(n));
//    }
    list.add(currencyInfo);
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

    public PageList<CurrencyInfo> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyInfo currencyInfo = null;
        PageList<CurrencyInfo> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
        sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ").append(" ex_currency_info ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
        //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        currencyInfo = new CurrencyInfo();
        setFindParamNo(r, currencyInfo);
        //for(String n:names){
        //currencyInfo.getMap().put(n,r.getString(n));
        //}
        list.add(currencyInfo);
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


        public List<CurrencyInfo> findNameArray(String[] names,String wherehql){
            PreparedStatement p = null;
            ResultSet r = null;
            Connection conn=null;
            CurrencyInfo currencyInfo = null;
            List<CurrencyInfo> list = new ArrayList();

            StringBuffer sqlBuffer = new StringBuffer("select ");
            for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
            }
            String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
            sqlBuffer.setLength(0);
            sqlBuffer.append(select).append(" from ").append(" ex_currency_info ").append(wherehql);
            String sql = sqlBuffer.toString();
            try {
            //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
            currencyInfo = new CurrencyInfo();
            //for(String n:names){
            //currencyInfo.getMap().put(n,r.getString(n));
            //}
            setFindParamNo(r, currencyInfo);
            list.add(currencyInfo);
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


            public PageList<CurrencyInfo> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
                PreparedStatement p = null;
                ResultSet r = null;
                Connection conn=null;
                CurrencyInfo currencyInfo = null;
                PageList<CurrencyInfo> list = new PageList(pageNo,total);

                StringBuffer sqlBuffer = new StringBuffer("select ");
                for(String fieldname:names){
                sqlBuffer.append(fieldname).append(",");
                }
                String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
                sqlBuffer.setLength(0);
                sqlBuffer.append(select).append(" from ").append(" ex_currency_info ").append(wherehql).append(" limit ?,?");
                String sql = sqlBuffer.toString();
                try {
                //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
                conn =HikariDb.getConnection();
                p=conn.prepareStatement(sql);
                p.setInt(1,list.getOffset());
                p.setInt(2,list.getPageSize());
                r = p.executeQuery();
                while (r.next()) {
                currencyInfo = new CurrencyInfo();
                setFindParamNo(r, currencyInfo);
                //for(String n:names){
                //currencyInfo.getMap().put(n,r.getString(n));
                //}
                list.add(currencyInfo);
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




public int save(CurrencyInfo currencyInfo) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ex_currency_info(`currency_id`,`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,currencyInfo);
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



public int saveAutoReturnId(CurrencyInfo currencyInfo) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ex_currency_info(`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_info(`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,currencyInfo);
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

public int saveAutoId(CurrencyInfo currencyInfo) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ex_currency_info(`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_info(`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ex_currency_info(`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
setStatementAutoId(p,currencyInfo);
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

private void setStatement(PreparedStatement p,CurrencyInfo currencyInfo) throws Exception{
p.setObject(1,currencyInfo.getCurrencyId());
p.setString(2,currencyInfo.getName());
p.setString(3,currencyInfo.getSymbol());
p.setLong(4,currencyInfo.getVolume());
p.setLong(5,currencyInfo.getCirculatingVolume());
p.setObject(6,currencyInfo.getInitPrice());
p.setLong(7,currencyInfo.getInitDate());
p.setString(8,currencyInfo.getUrl());
p.setString(9,currencyInfo.getCurrencyDesc());
p.setObject(10,currencyInfo.getSrcWebId());
p.setString(11,currencyInfo.getCurrencyIdName());
p.setString(12,currencyInfo.getDetailLink());
p.setString(13,currencyInfo.getMasterLink());

}

private void setStatementAutoId(PreparedStatement p,CurrencyInfo currencyInfo) throws Exception{
    p.setString(1,currencyInfo.getName());
p.setString(2,currencyInfo.getSymbol());
p.setLong(3,currencyInfo.getVolume());
p.setLong(4,currencyInfo.getCirculatingVolume());
p.setObject(5,currencyInfo.getInitPrice());
p.setLong(6,currencyInfo.getInitDate());
p.setString(7,currencyInfo.getUrl());
p.setString(8,currencyInfo.getCurrencyDesc());
p.setObject(9,currencyInfo.getSrcWebId());
p.setString(10,currencyInfo.getCurrencyIdName());
p.setString(11,currencyInfo.getDetailLink());
p.setString(12,currencyInfo.getMasterLink());

}

public List<CurrencyInfo> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyInfo currencyInfo = null;
List<CurrencyInfo> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_id,a.name,a.symbol,a.volume,a.circulating_volume,a.init_price,a.init_date,a.url,a.currency_desc,a.src_web_id,a.currency_id_name,a.detail_link,a.master_link from ex_currency_info as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.currency_id,a.name,a.symbol,a.volume,a.circulating_volume,a.init_price,a.init_date,a.url,a.currency_desc,a.src_web_id,a.currency_id_name,a.detail_link,a.master_link from ex_currency_info as a");
r = p.executeQuery();
while (r.next()) {
currencyInfo = new CurrencyInfo();
setFindParamNo(r, currencyInfo);
list.add(currencyInfo);
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

public PageList<CurrencyInfo> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyInfo currencyInfo = null;
PageList<CurrencyInfo> list = new PageList(pageNo,total);
String sql = "select a.currency_id,a.name,a.symbol,a.volume,a.circulating_volume,a.init_price,a.init_date,a.url,a.currency_desc,a.src_web_id,a.currency_id_name,a.detail_link,a.master_link from ex_currency_info as a LIMIT ?,? ";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_id,a.name,a.symbol,a.volume,a.circulating_volume,a.init_price,a.init_date,a.url,a.currency_desc,a.src_web_id,a.currency_id_name,a.detail_link,a.master_link from ex_currency_info as a LIMIT ?,? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
currencyInfo = new CurrencyInfo();
setFindParamNo(r, currencyInfo);
list.add(currencyInfo);
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


public PageList<CurrencyInfo> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyInfo currencyInfo = null;
PageList<CurrencyInfo> list = new PageList(pageNo,total);
String sql = "select a.currency_id,a.name,a.symbol,a.volume,a.circulating_volume,a.init_price,a.init_date,a.url,a.currency_desc,a.src_web_id,a.currency_id_name,a.detail_link,a.master_link from ex_currency_info as a";
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
currencyInfo = new CurrencyInfo();
setFindParamNo(r, currencyInfo);
list.add(currencyInfo);
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

        public PageList<CurrencyInfo> find_OrderBy_ByPage(int pageNo,int total,String sortBy,int sort,int pageSize){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyInfo currencyInfo = null;
        PageList<CurrencyInfo> list = new PageList(pageNo,total,pageSize);
        String sql = "select a.currency_id,a.name,a.symbol,a.volume,a.circulating_volume,a.init_price,a.init_date,a.url,a.currency_desc,a.src_web_id,a.currency_id_name,a.detail_link,a.master_link from ex_currency_info as a";
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
        currencyInfo = new CurrencyInfo();
        setFindParamNo(r, currencyInfo);
        list.add(currencyInfo);
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




public int update(CurrencyInfo currencyInfo) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ex_currency_info set `name`=?,`symbol`=?,`volume`=?,`circulating_volume`=?,`init_price`=?,`init_date`=?,`url`=?,`currency_desc`=?,`src_web_id`=?,`currency_id_name`=?,`detail_link`=?,`master_link`=? where currency_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ex_currency_info set `name`=?,`symbol`=?,`volume`=?,`circulating_volume`=?,`init_price`=?,`init_date`=?,`url`=?,`currency_desc`=?,`src_web_id`=?,`currency_id_name`=?,`detail_link`=?,`master_link`=? where currency_id=? ");
p.setString(1,currencyInfo.getName());
p.setString(2,currencyInfo.getSymbol());
p.setLong(3,currencyInfo.getVolume());
p.setLong(4,currencyInfo.getCirculatingVolume());
p.setObject(5,currencyInfo.getInitPrice());
p.setLong(6,currencyInfo.getInitDate());
p.setString(7,currencyInfo.getUrl());
p.setString(8,currencyInfo.getCurrencyDesc());
p.setObject(9,currencyInfo.getSrcWebId());
p.setString(10,currencyInfo.getCurrencyIdName());
p.setString(11,currencyInfo.getDetailLink());
p.setString(12,currencyInfo.getMasterLink());
p.setInt(13,currencyInfo.getCurrencyId());

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

public int delete(int currencyId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ex_currency_info where currency_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ex_currency_info where currency_id=? ");
p.setInt(1,currencyId);

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
        StringBuffer sqlBuffer = new StringBuffer("update ").append(" ex_currency_info ").append(set).append(" ").append(where);
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
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ex_currency_info ").append(where);
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



public CurrencyInfo get(int currencyId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyInfo currencyInfo = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `currency_id`,`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link` from ex_currency_info where currency_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `currency_id`,`name`,`symbol`,`volume`,`circulating_volume`,`init_price`,`init_date`,`url`,`currency_desc`,`src_web_id`,`currency_id_name`,`detail_link`,`master_link` from ex_currency_info where currency_id=? ");
p.setInt(1,currencyId);

r=p.executeQuery();
while (r.next()) {
currencyInfo =new CurrencyInfo();
setFindParamNo(r, currencyInfo);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return currencyInfo;
}




protected void setFindParam(ResultSet r,CurrencyInfo currencyInfo) throws Exception{
currencyInfo.setCurrencyId(r.getInt("currency_id"));
currencyInfo.setName(r.getString("name"));
currencyInfo.setSymbol(r.getString("symbol"));
currencyInfo.setVolume(r.getLong("volume"));
currencyInfo.setCirculatingVolume(r.getLong("circulating_volume"));
currencyInfo.setInitPrice(r.getDouble("init_price"));
currencyInfo.setInitDate(r.getLong("init_date"));
currencyInfo.setUrl(r.getString("url"));
currencyInfo.setCurrencyDesc(r.getString("currency_desc"));
currencyInfo.setSrcWebId(r.getInt("src_web_id"));
currencyInfo.setCurrencyIdName(r.getString("currency_id_name"));
currencyInfo.setDetailLink(r.getString("detail_link"));
currencyInfo.setMasterLink(r.getString("master_link"));
}

protected void setFindParamNo(ResultSet r,CurrencyInfo currencyInfo) throws Exception{
currencyInfo.setCurrencyId(r.getInt(1));
currencyInfo.setName(r.getString(2));
currencyInfo.setSymbol(r.getString(3));
currencyInfo.setVolume(r.getLong(4));
currencyInfo.setCirculatingVolume(r.getLong(5));
currencyInfo.setInitPrice(r.getDouble(6));
currencyInfo.setInitDate(r.getLong(7));
currencyInfo.setUrl(r.getString(8));
currencyInfo.setCurrencyDesc(r.getString(9));
currencyInfo.setSrcWebId(r.getInt(10));
currencyInfo.setCurrencyIdName(r.getString(11));
currencyInfo.setDetailLink(r.getString(12));
currencyInfo.setMasterLink(r.getString(13));
}

}
