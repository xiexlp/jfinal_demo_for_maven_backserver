package com.js.isearch.daoimplex;

/**
* last update time:"19-06-20 18:04:01"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.CurrencyDex;
import com.js.isearch.daoex.CurrencyDexDaoEx;
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


public class CurrencyDexDaoimplEx implements CurrencyDexDaoEx {

public String dbname= Globe.dbname;

public List<CurrencyDex> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyDex currencyDex = null;
List<CurrencyDex> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
currencyDex = new CurrencyDex();
setFindParamNo(r, currencyDex);
list.add(currencyDex);
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


public List<CurrencyDex> findNames(List<String> names,String wherehql){
    PreparedStatement p = null;
    ResultSet r = null;
    Connection conn=null;
    CurrencyDex currencyDex = null;
    List<CurrencyDex> list = new ArrayList();

    StringBuffer sqlBuffer = new StringBuffer("select ");
    for(String fieldname:names){
    sqlBuffer.append(fieldname).append(",");
    }
    String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
    sqlBuffer.setLength(0);
    sqlBuffer.append(select).append(" from ").append(" ex_currency_dex ").append(wherehql);
    String sql = sqlBuffer.toString();
    try {
    //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
    conn =HikariDb.getConnection();
    p=conn.prepareStatement(sql);
    r = p.executeQuery();
    while (r.next()) {
    currencyDex = new CurrencyDex();
    setFindParamNo(r, currencyDex);
//    for(String n:names){
//        currencyDex.getMap().put(n,r.getString(n));
//    }
    list.add(currencyDex);
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

    public PageList<CurrencyDex> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyDex currencyDex = null;
        PageList<CurrencyDex> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
        sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ").append(" ex_currency_dex ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
        //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        currencyDex = new CurrencyDex();
        setFindParamNo(r, currencyDex);
        //for(String n:names){
        //currencyDex.getMap().put(n,r.getString(n));
        //}
        list.add(currencyDex);
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


        public List<CurrencyDex> findNameArray(String[] names,String wherehql){
            PreparedStatement p = null;
            ResultSet r = null;
            Connection conn=null;
            CurrencyDex currencyDex = null;
            List<CurrencyDex> list = new ArrayList();

            StringBuffer sqlBuffer = new StringBuffer("select ");
            for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
            }
            String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
            sqlBuffer.setLength(0);
            sqlBuffer.append(select).append(" from ").append(" ex_currency_dex ").append(wherehql);
            String sql = sqlBuffer.toString();
            try {
            //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
            currencyDex = new CurrencyDex();
            //for(String n:names){
            //currencyDex.getMap().put(n,r.getString(n));
            //}
            setFindParamNo(r, currencyDex);
            list.add(currencyDex);
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


            public PageList<CurrencyDex> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
                PreparedStatement p = null;
                ResultSet r = null;
                Connection conn=null;
                CurrencyDex currencyDex = null;
                PageList<CurrencyDex> list = new PageList(pageNo,total);

                StringBuffer sqlBuffer = new StringBuffer("select ");
                for(String fieldname:names){
                sqlBuffer.append(fieldname).append(",");
                }
                String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
                sqlBuffer.setLength(0);
                sqlBuffer.append(select).append(" from ").append(" ex_currency_dex ").append(wherehql).append(" limit ?,?");
                String sql = sqlBuffer.toString();
                try {
                //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
                conn =HikariDb.getConnection();
                p=conn.prepareStatement(sql);
                p.setInt(1,list.getOffset());
                p.setInt(2,list.getPageSize());
                r = p.executeQuery();
                while (r.next()) {
                currencyDex = new CurrencyDex();
                setFindParamNo(r, currencyDex);
                //for(String n:names){
                //currencyDex.getMap().put(n,r.getString(n));
                //}
                list.add(currencyDex);
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




public int save(CurrencyDex currencyDex) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ex_currency_dex(`dex_id`,`name`,`url`,`logo_url`) values(?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,currencyDex);
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



public int saveAutoReturnId(CurrencyDex currencyDex) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ex_currency_dex(`name`,`url`,`logo_url`) values(?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_dex(`name`,`url`,`logo_url`) values(?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,currencyDex);
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

public int saveAutoId(CurrencyDex currencyDex) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ex_currency_dex(`name`,`url`,`logo_url`) values(?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_dex(`name`,`url`,`logo_url`) values(?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ex_currency_dex(`name`,`url`,`logo_url`) values(?,?,?)");
setStatementAutoId(p,currencyDex);
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

private void setStatement(PreparedStatement p,CurrencyDex currencyDex) throws Exception{
p.setObject(1,currencyDex.getDexId());
p.setString(2,currencyDex.getName());
p.setString(3,currencyDex.getUrl());
p.setString(4,currencyDex.getLogoUrl());

}

private void setStatementAutoId(PreparedStatement p,CurrencyDex currencyDex) throws Exception{
    p.setString(1,currencyDex.getName());
p.setString(2,currencyDex.getUrl());
p.setString(3,currencyDex.getLogoUrl());

}

public List<CurrencyDex> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyDex currencyDex = null;
List<CurrencyDex> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.dex_id,a.name,a.url,a.logo_url from ex_currency_dex as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.dex_id,a.name,a.url,a.logo_url from ex_currency_dex as a");
r = p.executeQuery();
while (r.next()) {
currencyDex = new CurrencyDex();
setFindParamNo(r, currencyDex);
list.add(currencyDex);
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

public PageList<CurrencyDex> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyDex currencyDex = null;
PageList<CurrencyDex> list = new PageList(pageNo,total);
String sql = "select a.dex_id,a.name,a.url,a.logo_url from ex_currency_dex as a LIMIT ?,? ";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.dex_id,a.name,a.url,a.logo_url from ex_currency_dex as a LIMIT ?,? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
currencyDex = new CurrencyDex();
setFindParamNo(r, currencyDex);
list.add(currencyDex);
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


public PageList<CurrencyDex> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyDex currencyDex = null;
PageList<CurrencyDex> list = new PageList(pageNo,total);
String sql = "select a.dex_id,a.name,a.url,a.logo_url from ex_currency_dex as a";
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
currencyDex = new CurrencyDex();
setFindParamNo(r, currencyDex);
list.add(currencyDex);
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



public int update(CurrencyDex currencyDex) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ex_currency_dex set `name`=?,`url`=?,`logo_url`=? where dex_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ex_currency_dex set `name`=?,`url`=?,`logo_url`=? where dex_id=? ");
p.setString(1,currencyDex.getName());
p.setString(2,currencyDex.getUrl());
p.setString(3,currencyDex.getLogoUrl());
p.setInt(4,currencyDex.getDexId());

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

public int delete(int dexId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ex_currency_dex where dex_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ex_currency_dex where dex_id=? ");
p.setInt(1,dexId);

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
        StringBuffer sqlBuffer = new StringBuffer("update ").append(" ex_currency_dex ").append(set).append(" ").append(where);
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
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ex_currency_dex ").append(where);
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



public CurrencyDex get(int dexId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyDex currencyDex = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `dex_id`,`name`,`url`,`logo_url` from ex_currency_dex where dex_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `dex_id`,`name`,`url`,`logo_url` from ex_currency_dex where dex_id=? ");
p.setInt(1,dexId);

r=p.executeQuery();
while (r.next()) {
currencyDex =new CurrencyDex();
setFindParamNo(r, currencyDex);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return currencyDex;
}




protected void setFindParam(ResultSet r,CurrencyDex currencyDex) throws Exception{
currencyDex.setDexId(r.getInt("dex_id"));
currencyDex.setName(r.getString("name"));
currencyDex.setUrl(r.getString("url"));
currencyDex.setLogoUrl(r.getString("logo_url"));
}

protected void setFindParamNo(ResultSet r,CurrencyDex currencyDex) throws Exception{
currencyDex.setDexId(r.getInt(1));
currencyDex.setName(r.getString(2));
currencyDex.setUrl(r.getString(3));
currencyDex.setLogoUrl(r.getString(4));
}

}
