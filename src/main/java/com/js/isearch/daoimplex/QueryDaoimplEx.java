package com.js.isearch.daoimplex;

/**
* last update time:"18-06-06 22:10:52"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.Query;
import com.js.isearch.daoex.QueryDaoEx;
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


public class QueryDaoimplEx implements QueryDaoEx {

public String dbname= Globe.dbname;

public List find(String hql) {
return null;
}

public int save(Query query) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ejf_query(`query_id`,`query`,`create_time`,`update_time`,`query_num`,`token`) values(?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,query);
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



public int saveAutoReturnId(Query query) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ejf_query(`query`,`create_time`,`update_time`,`query_num`,`token`) values(?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ejf_query(`query`,`create_time`,`update_time`,`query_num`,`token`) values(?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,query);
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

public int saveAutoId(Query query) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ejf_query(`query`,`create_time`,`update_time`,`query_num`,`token`) values(?,?,?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ejf_query(`query`,`create_time`,`update_time`,`query_num`,`token`) values(?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ejf_query(`query`,`create_time`,`update_time`,`query_num`,`token`) values(?,?,?,?,?)");
setStatementAutoId(p,query);
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

private void setStatement(PreparedStatement p,Query query) throws Exception{
p.setLong(1,query.getQueryId());
p.setString(2,query.getQuery());
p.setLong(3,query.getCreateTime());
p.setLong(4,query.getUpdateTime());
p.setLong(5,query.getQueryNum());
p.setString(6,query.getToken());

}

private void setStatementAutoId(PreparedStatement p,Query query) throws Exception{
    p.setString(1,query.getQuery());
p.setLong(2,query.getCreateTime());
p.setLong(3,query.getUpdateTime());
p.setLong(4,query.getQueryNum());
p.setString(5,query.getToken());

}

public List<Query> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Query query = null;
List<Query> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.query_id,a.query,a.create_time,a.update_time,a.query_num,a.token from ejf_query as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.query_id,a.query,a.create_time,a.update_time,a.query_num,a.token from ejf_query as a");
r = p.executeQuery();
while (r.next()) {
query = new Query();
setFindParamNo(r, query);
list.add(query);
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

public PageList<Query> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Query query = null;
PageList<Query> list = new PageList(pageNo,total);
String sql = "select a.query_id,a.query,a.create_time,a.update_time,a.query_num,a.token from ejf_query as a ORDER BY a.create_time DESC LIMIT ?,?";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.query_id,a.query,a.create_time,a.update_time,a.query_num,a.token from ejf_query as a ORDER BY a.create_time DESC LIMIT ?,?");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
query = new Query();
setFindParamNo(r, query);
list.add(query);
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


public PageList<Query> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Query query = null;
PageList<Query> list = new PageList(pageNo,total);
String sql = "select a.query_id,a.query,a.create_time,a.update_time,a.query_num,a.token from ejf_query as a";
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
query = new Query();
setFindParamNo(r, query);
list.add(query);
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



public int update(Query query) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ejf_query set `query`=?,`create_time`=?,`update_time`=?,`query_num`=?,`token`=? where query_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ejf_query set `query`=?,`create_time`=?,`update_time`=?,`query_num`=?,`token`=? where query_id=? ");
p.setString(1,query.getQuery());
p.setLong(2,query.getCreateTime());
p.setLong(3,query.getUpdateTime());
p.setLong(4,query.getQueryNum());
p.setString(5,query.getToken());
p.setLong(6,query.getQueryId());

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

public int delete(long queryId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ejf_query where query_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ejf_query where query_id=? ");
p.setLong(1,queryId);

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

public Query get(long queryId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Query query = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `query_id`,`query`,`create_time`,`update_time`,`query_num`,`token` from ejf_query where query_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `query_id`,`query`,`create_time`,`update_time`,`query_num`,`token` from ejf_query where query_id=? ");
p.setLong(1,queryId);

r=p.executeQuery();
while (r.next()) {
query =new Query();
setFindParamNo(r, query);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return query;
}




protected void setFindParam(ResultSet r,Query query) throws Exception{
query.setQueryId(r.getLong("query_id"));
query.setQuery(r.getString("query"));
query.setCreateTime(r.getLong("create_time"));
query.setUpdateTime(r.getLong("update_time"));
query.setQueryNum(r.getLong("query_num"));
query.setToken(r.getString("token"));
}

protected void setFindParamNo(ResultSet r,Query query) throws Exception{
query.setQueryId(r.getLong(1));
query.setQuery(r.getString(2));
query.setCreateTime(r.getLong(3));
query.setUpdateTime(r.getLong(4));
query.setQueryNum(r.getLong(5));
query.setToken(r.getString(6));
}

}
