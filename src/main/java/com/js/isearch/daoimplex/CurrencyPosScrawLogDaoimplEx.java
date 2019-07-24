package com.js.isearch.daoimplex;

/**
* last update time:"19-06-21 17:13:18"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.CurrencyPosScrawLog;
import com.js.isearch.daoex.CurrencyPosScrawLogDaoEx;
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


public class CurrencyPosScrawLogDaoimplEx implements CurrencyPosScrawLogDaoEx {

public String dbname= Globe.dbname;

public List<CurrencyPosScrawLog> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPosScrawLog currencyPosScrawLog = null;
List<CurrencyPosScrawLog> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
currencyPosScrawLog = new CurrencyPosScrawLog();
setFindParamNo(r, currencyPosScrawLog);
list.add(currencyPosScrawLog);
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


public List<CurrencyPosScrawLog> findNames(List<String> names,String wherehql){
    PreparedStatement p = null;
    ResultSet r = null;
    Connection conn=null;
    CurrencyPosScrawLog currencyPosScrawLog = null;
    List<CurrencyPosScrawLog> list = new ArrayList();

    StringBuffer sqlBuffer = new StringBuffer("select ");
    for(String fieldname:names){
    sqlBuffer.append(fieldname).append(",");
    }
    String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
    sqlBuffer.setLength(0);
    sqlBuffer.append(select).append(" from ").append(" ex_currency_pos_scraw_log ").append(wherehql);
    String sql = sqlBuffer.toString();
    try {
    //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
    conn =HikariDb.getConnection();
    p=conn.prepareStatement(sql);
    r = p.executeQuery();
    while (r.next()) {
    currencyPosScrawLog = new CurrencyPosScrawLog();
    setFindParamNo(r, currencyPosScrawLog);
//    for(String n:names){
//        currencyPosScrawLog.getMap().put(n,r.getString(n));
//    }
    list.add(currencyPosScrawLog);
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

    public PageList<CurrencyPosScrawLog> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyPosScrawLog currencyPosScrawLog = null;
        PageList<CurrencyPosScrawLog> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
        sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ").append(" ex_currency_pos_scraw_log ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
        //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        currencyPosScrawLog = new CurrencyPosScrawLog();
        setFindParamNo(r, currencyPosScrawLog);
        //for(String n:names){
        //currencyPosScrawLog.getMap().put(n,r.getString(n));
        //}
        list.add(currencyPosScrawLog);
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


        public List<CurrencyPosScrawLog> findNameArray(String[] names,String wherehql){
            PreparedStatement p = null;
            ResultSet r = null;
            Connection conn=null;
            CurrencyPosScrawLog currencyPosScrawLog = null;
            List<CurrencyPosScrawLog> list = new ArrayList();

            StringBuffer sqlBuffer = new StringBuffer("select ");
            for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
            }
            String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
            sqlBuffer.setLength(0);
            sqlBuffer.append(select).append(" from ").append(" ex_currency_pos_scraw_log ").append(wherehql);
            String sql = sqlBuffer.toString();
            try {
            //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
            currencyPosScrawLog = new CurrencyPosScrawLog();
            //for(String n:names){
            //currencyPosScrawLog.getMap().put(n,r.getString(n));
            //}
            setFindParamNo(r, currencyPosScrawLog);
            list.add(currencyPosScrawLog);
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


            public PageList<CurrencyPosScrawLog> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
                PreparedStatement p = null;
                ResultSet r = null;
                Connection conn=null;
                CurrencyPosScrawLog currencyPosScrawLog = null;
                PageList<CurrencyPosScrawLog> list = new PageList(pageNo,total);

                StringBuffer sqlBuffer = new StringBuffer("select ");
                for(String fieldname:names){
                sqlBuffer.append(fieldname).append(",");
                }
                String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
                sqlBuffer.setLength(0);
                sqlBuffer.append(select).append(" from ").append(" ex_currency_pos_scraw_log ").append(wherehql).append(" limit ?,?");
                String sql = sqlBuffer.toString();
                try {
                //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
                conn =HikariDb.getConnection();
                p=conn.prepareStatement(sql);
                p.setInt(1,list.getOffset());
                p.setInt(2,list.getPageSize());
                r = p.executeQuery();
                while (r.next()) {
                currencyPosScrawLog = new CurrencyPosScrawLog();
                setFindParamNo(r, currencyPosScrawLog);
                //for(String n:names){
                //currencyPosScrawLog.getMap().put(n,r.getString(n));
                //}
                list.add(currencyPosScrawLog);
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




public int save(CurrencyPosScrawLog currencyPosScrawLog) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ex_currency_pos_scraw_log(`currency_pos_scraw_log_id`,`pos_batch_time`,`pos_batch_num`) values(?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,currencyPosScrawLog);
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



public int saveAutoReturnId(CurrencyPosScrawLog currencyPosScrawLog) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ex_currency_pos_scraw_log(`pos_batch_time`,`pos_batch_num`) values(?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_pos_scraw_log(`pos_batch_time`,`pos_batch_num`) values(?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,currencyPosScrawLog);
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

public int saveAutoId(CurrencyPosScrawLog currencyPosScrawLog) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ex_currency_pos_scraw_log(`pos_batch_time`,`pos_batch_num`) values(?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_pos_scraw_log(`pos_batch_time`,`pos_batch_num`) values(?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ex_currency_pos_scraw_log(`pos_batch_time`,`pos_batch_num`) values(?,?)");
setStatementAutoId(p,currencyPosScrawLog);
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

private void setStatement(PreparedStatement p,CurrencyPosScrawLog currencyPosScrawLog) throws Exception{
p.setObject(1,currencyPosScrawLog.getCurrencyPosScrawLogId());
p.setLong(2,currencyPosScrawLog.getPosBatchTime());
p.setObject(3,currencyPosScrawLog.getPosBatchNum());

}

private void setStatementAutoId(PreparedStatement p,CurrencyPosScrawLog currencyPosScrawLog) throws Exception{
    p.setLong(1,currencyPosScrawLog.getPosBatchTime());
p.setObject(2,currencyPosScrawLog.getPosBatchNum());

}

public List<CurrencyPosScrawLog> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPosScrawLog currencyPosScrawLog = null;
List<CurrencyPosScrawLog> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_pos_scraw_log_id,a.pos_batch_time,a.pos_batch_num from ex_currency_pos_scraw_log as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.currency_pos_scraw_log_id,a.pos_batch_time,a.pos_batch_num from ex_currency_pos_scraw_log as a");
r = p.executeQuery();
while (r.next()) {
currencyPosScrawLog = new CurrencyPosScrawLog();
setFindParamNo(r, currencyPosScrawLog);
list.add(currencyPosScrawLog);
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

public PageList<CurrencyPosScrawLog> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPosScrawLog currencyPosScrawLog = null;
PageList<CurrencyPosScrawLog> list = new PageList(pageNo,total);
String sql = "select a.currency_pos_scraw_log_id,a.pos_batch_time,a.pos_batch_num from ex_currency_pos_scraw_log as a LIMIT ?,? ";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_pos_scraw_log_id,a.pos_batch_time,a.pos_batch_num from ex_currency_pos_scraw_log as a LIMIT ?,? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
currencyPosScrawLog = new CurrencyPosScrawLog();
setFindParamNo(r, currencyPosScrawLog);
list.add(currencyPosScrawLog);
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


public PageList<CurrencyPosScrawLog> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPosScrawLog currencyPosScrawLog = null;
PageList<CurrencyPosScrawLog> list = new PageList(pageNo,total);
String sql = "select a.currency_pos_scraw_log_id,a.pos_batch_time,a.pos_batch_num from ex_currency_pos_scraw_log as a";
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
currencyPosScrawLog = new CurrencyPosScrawLog();
setFindParamNo(r, currencyPosScrawLog);
list.add(currencyPosScrawLog);
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



public int update(CurrencyPosScrawLog currencyPosScrawLog) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ex_currency_pos_scraw_log set `pos_batch_time`=?,`pos_batch_num`=? where currency_pos_scraw_log_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ex_currency_pos_scraw_log set `pos_batch_time`=?,`pos_batch_num`=? where currency_pos_scraw_log_id=? ");
p.setLong(1,currencyPosScrawLog.getPosBatchTime());
p.setObject(2,currencyPosScrawLog.getPosBatchNum());
p.setInt(3,currencyPosScrawLog.getCurrencyPosScrawLogId());

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

public int delete(int currencyPosScrawLogId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ex_currency_pos_scraw_log where currency_pos_scraw_log_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ex_currency_pos_scraw_log where currency_pos_scraw_log_id=? ");
p.setInt(1,currencyPosScrawLogId);

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
        StringBuffer sqlBuffer = new StringBuffer("update ").append(" ex_currency_pos_scraw_log ").append(set).append(" ").append(where);
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
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ex_currency_pos_scraw_log ").append(where);
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



public CurrencyPosScrawLog get(int currencyPosScrawLogId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyPosScrawLog currencyPosScrawLog = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `currency_pos_scraw_log_id`,`pos_batch_time`,`pos_batch_num` from ex_currency_pos_scraw_log where currency_pos_scraw_log_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `currency_pos_scraw_log_id`,`pos_batch_time`,`pos_batch_num` from ex_currency_pos_scraw_log where currency_pos_scraw_log_id=? ");
p.setInt(1,currencyPosScrawLogId);

r=p.executeQuery();
while (r.next()) {
currencyPosScrawLog =new CurrencyPosScrawLog();
setFindParamNo(r, currencyPosScrawLog);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return currencyPosScrawLog;
}




protected void setFindParam(ResultSet r,CurrencyPosScrawLog currencyPosScrawLog) throws Exception{
currencyPosScrawLog.setCurrencyPosScrawLogId(r.getInt("currency_pos_scraw_log_id"));
currencyPosScrawLog.setPosBatchTime(r.getLong("pos_batch_time"));
currencyPosScrawLog.setPosBatchNum(r.getInt("pos_batch_num"));
}

protected void setFindParamNo(ResultSet r,CurrencyPosScrawLog currencyPosScrawLog) throws Exception{
currencyPosScrawLog.setCurrencyPosScrawLogId(r.getInt(1));
currencyPosScrawLog.setPosBatchTime(r.getLong(2));
currencyPosScrawLog.setPosBatchNum(r.getInt(3));
}

}
