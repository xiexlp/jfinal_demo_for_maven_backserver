package com.js.isearch.daoimplex;

/**
* last update time:"19-06-21 14:44:42"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.daoex.CurrencyStatusDaoEx;
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


public class CurrencyStatusDaoimplEx implements CurrencyStatusDaoEx {

public String dbname= Globe.dbname;

public List<CurrencyStatus> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyStatus currencyStatus = null;
List<CurrencyStatus> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
currencyStatus = new CurrencyStatus();
setFindParamNo(r, currencyStatus);
list.add(currencyStatus);
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


public List<CurrencyStatus> findNames(List<String> names,String wherehql){
    PreparedStatement p = null;
    ResultSet r = null;
    Connection conn=null;
    CurrencyStatus currencyStatus = null;
    List<CurrencyStatus> list = new ArrayList();

    StringBuffer sqlBuffer = new StringBuffer("select ");
    for(String fieldname:names){
    sqlBuffer.append(fieldname).append(",");
    }
    String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
    sqlBuffer.setLength(0);
    sqlBuffer.append(select).append(" from ").append(" ex_currency_status ").append(wherehql);
    String sql = sqlBuffer.toString();
    try {
    //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
    conn =HikariDb.getConnection();
    p=conn.prepareStatement(sql);
    r = p.executeQuery();
    while (r.next()) {
    currencyStatus = new CurrencyStatus();
    setFindParamNo(r, currencyStatus);
//    for(String n:names){
//        currencyStatus.getMap().put(n,r.getString(n));
//    }
    list.add(currencyStatus);
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

    public PageList<CurrencyStatus> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        CurrencyStatus currencyStatus = null;
        PageList<CurrencyStatus> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
        sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ").append(" ex_currency_status ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
        //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        currencyStatus = new CurrencyStatus();
        setFindParamNo(r, currencyStatus);
        //for(String n:names){
        //currencyStatus.getMap().put(n,r.getString(n));
        //}
        list.add(currencyStatus);
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


        public List<CurrencyStatus> findNameArray(String[] names,String wherehql){
            PreparedStatement p = null;
            ResultSet r = null;
            Connection conn=null;
            CurrencyStatus currencyStatus = null;
            List<CurrencyStatus> list = new ArrayList();

            StringBuffer sqlBuffer = new StringBuffer("select ");
            for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
            }
            String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
            sqlBuffer.setLength(0);
            sqlBuffer.append(select).append(" from ").append(" ex_currency_status ").append(wherehql);
            String sql = sqlBuffer.toString();
            try {
            //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
            currencyStatus = new CurrencyStatus();
            //for(String n:names){
            //currencyStatus.getMap().put(n,r.getString(n));
            //}
            setFindParamNo(r, currencyStatus);
            list.add(currencyStatus);
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


            public PageList<CurrencyStatus> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
                PreparedStatement p = null;
                ResultSet r = null;
                Connection conn=null;
                CurrencyStatus currencyStatus = null;
                PageList<CurrencyStatus> list = new PageList(pageNo,total);

                StringBuffer sqlBuffer = new StringBuffer("select ");
                for(String fieldname:names){
                sqlBuffer.append(fieldname).append(",");
                }
                String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
                sqlBuffer.setLength(0);
                sqlBuffer.append(select).append(" from ").append(" ex_currency_status ").append(wherehql).append(" limit ?,?");
                String sql = sqlBuffer.toString();
                try {
                //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
                conn =HikariDb.getConnection();
                p=conn.prepareStatement(sql);
                p.setInt(1,list.getOffset());
                p.setInt(2,list.getPageSize());
                r = p.executeQuery();
                while (r.next()) {
                currencyStatus = new CurrencyStatus();
                setFindParamNo(r, currencyStatus);
                //for(String n:names){
                //currencyStatus.getMap().put(n,r.getString(n));
                //}
                list.add(currencyStatus);
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




public int save(CurrencyStatus currencyStatus) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ex_currency_status(`currency_status_id`,`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time`) values(?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,currencyStatus);
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



public int saveAutoReturnId(CurrencyStatus currencyStatus) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ex_currency_status(`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time`) values(?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_status(`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time`) values(?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,currencyStatus);
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

public int saveAutoId(CurrencyStatus currencyStatus) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ex_currency_status(`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time`) values(?,?,?,?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ex_currency_status(`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time`) values(?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ex_currency_status(`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time`) values(?,?,?,?,?,?)");
setStatementAutoId(p,currencyStatus);
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

private void setStatement(PreparedStatement p,CurrencyStatus currencyStatus) throws Exception{
p.setObject(1,currencyStatus.getCurrencyStatusId());
p.setObject(2,currencyStatus.getPosPanelNum());
p.setObject(3,currencyStatus.getPricePanelNum());
p.setLong(4,currencyStatus.getPosLastBatchTime());
p.setLong(5,currencyStatus.getPriceLastBatchTime());
p.setLong(6,currencyStatus.getCreateTime());
p.setLong(7,currencyStatus.getUpdateTime());

}

private void setStatementAutoId(PreparedStatement p,CurrencyStatus currencyStatus) throws Exception{
    p.setObject(1,currencyStatus.getPosPanelNum());
p.setObject(2,currencyStatus.getPricePanelNum());
p.setLong(3,currencyStatus.getPosLastBatchTime());
p.setLong(4,currencyStatus.getPriceLastBatchTime());
p.setLong(5,currencyStatus.getCreateTime());
p.setLong(6,currencyStatus.getUpdateTime());

}

public List<CurrencyStatus> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyStatus currencyStatus = null;
List<CurrencyStatus> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_status_id,a.pos_panel_num,a.price_panel_num,a.pos_last_batch_time,a.price_last_batch_time,a.create_time,a.update_time from ex_currency_status as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.currency_status_id,a.pos_panel_num,a.price_panel_num,a.pos_last_batch_time,a.price_last_batch_time,a.create_time,a.update_time from ex_currency_status as a");
r = p.executeQuery();
while (r.next()) {
currencyStatus = new CurrencyStatus();
setFindParamNo(r, currencyStatus);
list.add(currencyStatus);
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

public PageList<CurrencyStatus> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyStatus currencyStatus = null;
PageList<CurrencyStatus> list = new PageList(pageNo,total);
String sql = "select a.currency_status_id,a.pos_panel_num,a.price_panel_num,a.pos_last_batch_time,a.price_last_batch_time,a.create_time,a.update_time from ex_currency_status as a ORDER BY a.create_time DESC  LIMIT ?,? ";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.currency_status_id,a.pos_panel_num,a.price_panel_num,a.pos_last_batch_time,a.price_last_batch_time,a.create_time,a.update_time from ex_currency_status as a ORDER BY a.create_time DESC  LIMIT ?,? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
currencyStatus = new CurrencyStatus();
setFindParamNo(r, currencyStatus);
list.add(currencyStatus);
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


public PageList<CurrencyStatus> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyStatus currencyStatus = null;
PageList<CurrencyStatus> list = new PageList(pageNo,total);
String sql = "select a.currency_status_id,a.pos_panel_num,a.price_panel_num,a.pos_last_batch_time,a.price_last_batch_time,a.create_time,a.update_time from ex_currency_status as a";
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
currencyStatus = new CurrencyStatus();
setFindParamNo(r, currencyStatus);
list.add(currencyStatus);
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



public int update(CurrencyStatus currencyStatus) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ex_currency_status set `pos_panel_num`=?,`price_panel_num`=?,`pos_last_batch_time`=?,`price_last_batch_time`=?,`create_time`=?,`update_time`=? where currency_status_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ex_currency_status set `pos_panel_num`=?,`price_panel_num`=?,`pos_last_batch_time`=?,`price_last_batch_time`=?,`create_time`=?,`update_time`=? where currency_status_id=? ");
p.setObject(1,currencyStatus.getPosPanelNum());
p.setObject(2,currencyStatus.getPricePanelNum());
p.setLong(3,currencyStatus.getPosLastBatchTime());
p.setLong(4,currencyStatus.getPriceLastBatchTime());
p.setLong(5,currencyStatus.getCreateTime());
p.setLong(6,currencyStatus.getUpdateTime());
p.setInt(7,currencyStatus.getCurrencyStatusId());

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

public int delete(int currencyStatusId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ex_currency_status where currency_status_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ex_currency_status where currency_status_id=? ");
p.setInt(1,currencyStatusId);

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
        StringBuffer sqlBuffer = new StringBuffer("update ").append(" ex_currency_status ").append(set).append(" ").append(where);
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
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ex_currency_status ").append(where);
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



public CurrencyStatus get(int currencyStatusId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
CurrencyStatus currencyStatus = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `currency_status_id`,`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time` from ex_currency_status where currency_status_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `currency_status_id`,`pos_panel_num`,`price_panel_num`,`pos_last_batch_time`,`price_last_batch_time`,`create_time`,`update_time` from ex_currency_status where currency_status_id=? ");
p.setInt(1,currencyStatusId);

r=p.executeQuery();
while (r.next()) {
currencyStatus =new CurrencyStatus();
setFindParamNo(r, currencyStatus);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return currencyStatus;
}




protected void setFindParam(ResultSet r,CurrencyStatus currencyStatus) throws Exception{
currencyStatus.setCurrencyStatusId(r.getInt("currency_status_id"));
currencyStatus.setPosPanelNum(r.getInt("pos_panel_num"));
currencyStatus.setPricePanelNum(r.getInt("price_panel_num"));
currencyStatus.setPosLastBatchTime(r.getLong("pos_last_batch_time"));
currencyStatus.setPriceLastBatchTime(r.getLong("price_last_batch_time"));
currencyStatus.setCreateTime(r.getLong("create_time"));
currencyStatus.setUpdateTime(r.getLong("update_time"));
}

protected void setFindParamNo(ResultSet r,CurrencyStatus currencyStatus) throws Exception{
currencyStatus.setCurrencyStatusId(r.getInt(1));
currencyStatus.setPosPanelNum(r.getInt(2));
currencyStatus.setPricePanelNum(r.getInt(3));
currencyStatus.setPosLastBatchTime(r.getLong(4));
currencyStatus.setPriceLastBatchTime(r.getLong(5));
currencyStatus.setCreateTime(r.getLong(6));
currencyStatus.setUpdateTime(r.getLong(7));
}

}
