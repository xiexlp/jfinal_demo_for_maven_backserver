package com.js.isearch.daoimplex;

/**
* last update time:"18-06-07 18:12:20"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.QueryLog;
import com.js.isearch.daoex.QueryLogDaoEx;
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


public class QueryLogDaoimplEx implements QueryLogDaoEx {

public String dbname= Globe.dbname;

public List<QueryLog> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
QueryLog queryLog = null;
List<QueryLog> list = new ArrayList();
try {
//p = DbHotel.getIforumConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
queryLog = new QueryLog();
setFindParam(r, queryLog);
list.add(queryLog);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return list;

}

public int save(QueryLog queryLog) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ejf_query_log(`log_id`,`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status`) values(?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforumConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,queryLog);
result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return result;
}



public int saveAutoReturnId(QueryLog queryLog) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ejf_query_log(`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status`) values(?,?,?,?,?,?)";
try {
//p = DbHotel.getIforumConnection().prepareStatement("insert ejf_query_log(`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status`) values(?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,queryLog);
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
//DbHotel.closeIforumConnection();
}
return returnID;
}

public int saveAutoId(QueryLog queryLog) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ejf_query_log(`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status`) values(?,?,?,?,?,?)";
//p = DbHotel.getIforumConnection().prepareStatement("insert ejf_query_log(`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status`) values(?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ejf_query_log(`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status`) values(?,?,?,?,?,?)");
setStatementAutoId(p,queryLog);
result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return result;
}

private void setStatement(PreparedStatement p,QueryLog queryLog) throws Exception{
p.setLong(1,queryLog.getLogId());
p.setString(2,queryLog.getQuery());
p.setString(3,queryLog.getIp());
p.setString(4,queryLog.getTerminal());
p.setString(5,queryLog.getWebUrl());
p.setLong(6,queryLog.getCreateTime());
p.setObject(7,queryLog.getIndexStatus());

}

private void setStatementAutoId(PreparedStatement p,QueryLog queryLog) throws Exception{
    p.setString(1,queryLog.getQuery());
p.setString(2,queryLog.getIp());
p.setString(3,queryLog.getTerminal());
p.setString(4,queryLog.getWebUrl());
p.setLong(5,queryLog.getCreateTime());
p.setObject(6,queryLog.getIndexStatus());

}

public List<QueryLog> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
QueryLog queryLog = null;
List<QueryLog> list = new ArrayList();
try {
//p = DbHotel.getIforumConnection().prepareStatement("select a.log_id,a.query,a.ip,a.terminal,a.web_url,a.create_time,a.index_status from ejf_query_log as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.log_id,a.query,a.ip,a.terminal,a.web_url,a.create_time,a.index_status from ejf_query_log as a");
r = p.executeQuery();
while (r.next()) {
queryLog = new QueryLog();
setFindParamNo(r, queryLog);
list.add(queryLog);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return list;
}

public PageList<QueryLog> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
QueryLog queryLog = null;
PageList<QueryLog> list = new PageList(pageNo,total);
String sql = "select a.log_id,a.query,a.ip,a.terminal,a.web_url,a.create_time,a.index_status from ejf_query_log as a ORDER BY a.create_time DESC LIMIT ?,?";
try {
//p = DbHotel.getIforumConnection().prepareStatement("select a.log_id,a.query,a.ip,a.terminal,a.web_url,a.create_time,a.index_status from ejf_query_log as a ORDER BY a.create_time DESC LIMIT ?,?");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
queryLog = new QueryLog();
setFindParamNo(r, queryLog);
list.add(queryLog);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return list;
}


public PageList<QueryLog> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
QueryLog queryLog = null;
PageList<QueryLog> list = new PageList(pageNo,total);
String sql = "select a.log_id,a.query,a.ip,a.terminal,a.web_url,a.create_time,a.index_status from ejf_query_log as a";
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
queryLog = new QueryLog();
setFindParamNo(r, queryLog);
list.add(queryLog);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return list;

}



public int update(QueryLog queryLog) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("update ejf_query_log set `query`=?,`ip`=?,`terminal`=?,`web_url`=?,`create_time`=?,`index_status`=? where log_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ejf_query_log set `query`=?,`ip`=?,`terminal`=?,`web_url`=?,`create_time`=?,`index_status`=? where log_id=? ");
p.setString(1,queryLog.getQuery());
p.setString(2,queryLog.getIp());
p.setString(3,queryLog.getTerminal());
p.setString(4,queryLog.getWebUrl());
p.setLong(5,queryLog.getCreateTime());
p.setObject(6,queryLog.getIndexStatus());
p.setLong(7,queryLog.getLogId());

result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return result;
}

public int delete(long logId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("delete from ejf_query_log where log_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ejf_query_log where log_id=? ");
p.setLong(1,logId);

result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return result;
}

public QueryLog get(long logId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
QueryLog queryLog = null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("select `log_id`,`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status` from ejf_query_log where log_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `log_id`,`query`,`ip`,`terminal`,`web_url`,`create_time`,`index_status` from ejf_query_log where log_id=? ");
p.setLong(1,logId);

r=p.executeQuery();
while (r.next()) {
queryLog =new QueryLog();
setFindParamNo(r, queryLog);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return queryLog;
}




protected void setFindParam(ResultSet r,QueryLog queryLog) throws Exception{
queryLog.setLogId(r.getLong("log_id"));
queryLog.setQuery(r.getString("query"));
queryLog.setIp(r.getString("ip"));
queryLog.setTerminal(r.getString("terminal"));
queryLog.setWebUrl(r.getString("web_url"));
queryLog.setCreateTime(r.getLong("create_time"));
queryLog.setIndexStatus(r.getInt("index_status"));
}

protected void setFindParamNo(ResultSet r,QueryLog queryLog) throws Exception{
queryLog.setLogId(r.getLong(1));
queryLog.setQuery(r.getString(2));
queryLog.setIp(r.getString(3));
queryLog.setTerminal(r.getString(4));
queryLog.setWebUrl(r.getString(5));
queryLog.setCreateTime(r.getLong(6));
queryLog.setIndexStatus(r.getInt(7));
}

}
