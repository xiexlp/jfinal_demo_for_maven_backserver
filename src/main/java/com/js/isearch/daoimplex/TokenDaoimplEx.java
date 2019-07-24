package com.js.isearch.daoimplex;

/**
* last update time:"18-05-14 15:20:14"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.Token;
import com.js.isearch.daoex.TokenDaoEx;
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


public class TokenDaoimplEx implements TokenDaoEx {

public String dbname= Globe.dbname;

public List find(String hql) {
return null;
}

public int save(Token token) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ejf_token(`token_id`,`token`,`token_size`,`doc_count`,`position_count`,`docs`) values(?,?,?,?,?,?)";
try {
//p = DbHotel.getIforumConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,token);
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



public int saveAutoReturnId(Token token) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ejf_token(`token`,`token_size`,`doc_count`,`position_count`,`docs`) values(?,?,?,?,?)";
try {
//p = DbHotel.getIforumConnection().prepareStatement("insert ejf_token(`token`,`token_size`,`doc_count`,`position_count`,`docs`) values(?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,token);
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

public int saveAutoId(Token token) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ejf_token(`token`,`token_size`,`doc_count`,`position_count`,`docs`) values(?,?,?,?,?)";
//p = DbHotel.getIforumConnection().prepareStatement("insert ejf_token(`token`,`token_size`,`doc_count`,`position_count`,`docs`) values(?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ejf_token(`token`,`token_size`,`doc_count`,`position_count`,`docs`) values(?,?,?,?,?)");
setStatementAutoId(p,token);
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

private void setStatement(PreparedStatement p,Token token) throws Exception{
p.setLong(1,token.getTokenId());
p.setString(2,token.getToken());
p.setObject(3,token.getTokenSize());
p.setObject(4,token.getDocCount());
p.setObject(5,token.getPositionCount());
p.setString(6,token.getDocs());

}

private void setStatementAutoId(PreparedStatement p,Token token) throws Exception{
    p.setString(1,token.getToken());
p.setObject(2,token.getTokenSize());
p.setObject(3,token.getDocCount());
p.setObject(4,token.getPositionCount());
p.setString(5,token.getDocs());

}

public List<Token> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Token token = null;
List<Token> list = new ArrayList();
try {
//p = DbHotel.getIforumConnection().prepareStatement("select a.token_id,a.token,a.token_size,a.doc_count,a.position_count,a.docs from ejf_token as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.token_id,a.token,a.token_size,a.doc_count,a.position_count,a.docs from ejf_token as a");
r = p.executeQuery();
while (r.next()) {
token = new Token();
setFindParamNo(r, token);
list.add(token);
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

public PageList<Token> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Token token = null;
PageList<Token> list = new PageList(pageNo,total);
String sql = "select a.token_id,a.token,a.token_size,a.doc_count,a.position_count,a.docs from ejf_token as a ORDER BY a.create_time DESC LIMIT ?,?";
try {
//p = DbHotel.getIforumConnection().prepareStatement("select a.token_id,a.token,a.token_size,a.doc_count,a.position_count,a.docs from ejf_token as a ORDER BY a.create_time DESC LIMIT ?,?");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
token = new Token();
setFindParamNo(r, token);
list.add(token);
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



public int update(Token token) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("update ejf_token set `token`=?,`token_size`=?,`doc_count`=?,`position_count`=?,`docs`=? where token_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ejf_token set `token`=?,`token_size`=?,`doc_count`=?,`position_count`=?,`docs`=? where token_id=? ");
p.setString(1,token.getToken());
p.setObject(2,token.getTokenSize());
p.setObject(3,token.getDocCount());
p.setObject(4,token.getPositionCount());
p.setString(5,token.getDocs());
p.setLong(6,token.getTokenId());

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

public int delete(long tokenId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("delete from ejf_token where token_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ejf_token where token_id=? ");
p.setLong(1,tokenId);

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

public Token get(long tokenId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Token token = null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("select `token_id`,`token`,`token_size`,`doc_count`,`position_count`,`docs` from ejf_token where token_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `token_id`,`token`,`token_size`,`doc_count`,`position_count`,`docs` from ejf_token where token_id=? ");
p.setLong(1,tokenId);

r=p.executeQuery();
while (r.next()) {
token =new Token();
setFindParamNo(r, token);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return token;
}




protected void setFindParam(ResultSet r,Token token) throws Exception{
token.setTokenId(r.getLong("token_id"));
token.setToken(r.getString("token"));
token.setTokenSize(r.getInt("token_size"));
token.setDocCount(r.getInt("doc_count"));
token.setPositionCount(r.getInt("position_count"));
token.setDocs(r.getString("docs"));
}

protected void setFindParamNo(ResultSet r,Token token) throws Exception{
token.setTokenId(r.getLong(1));
token.setToken(r.getString(2));
token.setTokenSize(r.getInt(3));
token.setDocCount(r.getInt(4));
token.setPositionCount(r.getInt(5));
token.setDocs(r.getString(6));
}

}
