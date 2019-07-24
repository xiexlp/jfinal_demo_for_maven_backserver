package com.js.isearch.daoimplex;

/**
* last update time:"18-05-25 16:03:59"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.Doc;
import com.js.isearch.daoex.DocDaoEx;
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


public class DocDaoimplEx implements DocDaoEx {

public String dbname= Globe.dbname;

public List find(String hql) {
return null;
}

public int save(Doc doc) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ejf_doc(`doc_id`,`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforumConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,doc);
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



public int saveAutoReturnId(Doc doc) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ejf_doc(`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforumConnection().prepareStatement("insert ejf_doc(`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,doc);
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

public int saveAutoId(Doc doc) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ejf_doc(`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//p = DbHotel.getIforumConnection().prepareStatement("insert ejf_doc(`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ejf_doc(`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
setStatementAutoId(p,doc);
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

private void setStatement(PreparedStatement p,Doc doc) throws Exception{
p.setLong(1,doc.getDocId());
p.setString(2,doc.getTitle());
p.setObject(3,doc.getTitleSize());
p.setString(4,doc.getBody());
p.setObject(5,doc.getBodySize());
p.setString(6,doc.getTablename());
p.setString(7,doc.getDbname());
p.setString(8,doc.getFieldname());
p.setLong(9,doc.getFieldId());
p.setString(10,doc.getUrl());
p.setString(11,doc.getHost());
p.setLong(12,doc.getCreateTime());
p.setLong(13,doc.getUpdateTime());
p.setString(14,doc.getIndexStatus());
p.setObject(15,doc.getIndexStage());

}

private void setStatementAutoId(PreparedStatement p,Doc doc) throws Exception{
    p.setString(1,doc.getTitle());
p.setObject(2,doc.getTitleSize());
p.setString(3,doc.getBody());
p.setObject(4,doc.getBodySize());
p.setString(5,doc.getTablename());
p.setString(6,doc.getDbname());
p.setString(7,doc.getFieldname());
p.setLong(8,doc.getFieldId());
p.setString(9,doc.getUrl());
p.setString(10,doc.getHost());
p.setLong(11,doc.getCreateTime());
p.setLong(12,doc.getUpdateTime());
p.setString(13,doc.getIndexStatus());
p.setObject(14,doc.getIndexStage());

}

public List<Doc> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Doc doc = null;
List<Doc> list = new ArrayList();
try {
//p = DbHotel.getIforumConnection().prepareStatement("select a.doc_id,a.title,a.title_size,a.body,a.body_size,a.tablename,a.dbname,a.fieldname,a.field_id,a.url,a.host,a.create_time,a.update_time,a.index_status,a.index_stage from ejf_doc as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.doc_id,a.title,a.title_size,a.body,a.body_size,a.tablename,a.dbname,a.fieldname,a.field_id,a.url,a.host,a.create_time,a.update_time,a.index_status,a.index_stage from ejf_doc as a");
r = p.executeQuery();
while (r.next()) {
doc = new Doc();
setFindParamNo(r, doc);
list.add(doc);
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

public PageList<Doc> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Doc doc = null;
PageList<Doc> list = new PageList(pageNo,total);
String sql = "select a.doc_id,a.title,a.title_size,a.body,a.body_size,a.tablename,a.dbname,a.fieldname,a.field_id,a.url,a.host,a.create_time,a.update_time,a.index_status,a.index_stage from ejf_doc as a ORDER BY a.create_time DESC LIMIT ?,?";
try {
//p = DbHotel.getIforumConnection().prepareStatement("select a.doc_id,a.title,a.title_size,a.body,a.body_size,a.tablename,a.dbname,a.fieldname,a.field_id,a.url,a.host,a.create_time,a.update_time,a.index_status,a.index_stage from ejf_doc as a ORDER BY a.create_time DESC LIMIT ?,?");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
doc = new Doc();
setFindParamNo(r, doc);
list.add(doc);
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



public int update(Doc doc) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("update ejf_doc set `title`=?,`title_size`=?,`body`=?,`body_size`=?,`tablename`=?,`dbname`=?,`fieldname`=?,`field_id`=?,`url`=?,`host`=?,`create_time`=?,`update_time`=?,`index_status`=?,`index_stage`=? where doc_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ejf_doc set `title`=?,`title_size`=?,`body`=?,`body_size`=?,`tablename`=?,`dbname`=?,`fieldname`=?,`field_id`=?,`url`=?,`host`=?,`create_time`=?,`update_time`=?,`index_status`=?,`index_stage`=? where doc_id=? ");
p.setString(1,doc.getTitle());
p.setObject(2,doc.getTitleSize());
p.setString(3,doc.getBody());
p.setObject(4,doc.getBodySize());
p.setString(5,doc.getTablename());
p.setString(6,doc.getDbname());
p.setString(7,doc.getFieldname());
p.setLong(8,doc.getFieldId());
p.setString(9,doc.getUrl());
p.setString(10,doc.getHost());
p.setLong(11,doc.getCreateTime());
p.setLong(12,doc.getUpdateTime());
p.setString(13,doc.getIndexStatus());
p.setObject(14,doc.getIndexStage());
p.setLong(15,doc.getDocId());

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

public int delete(long docId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("delete from ejf_doc where doc_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ejf_doc where doc_id=? ");
p.setLong(1,docId);

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

public Doc get(long docId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Doc doc = null;
try {
//p = DbHotel.getIforumConnection().prepareStatement("select `doc_id`,`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage` from ejf_doc where doc_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `doc_id`,`title`,`title_size`,`body`,`body_size`,`tablename`,`dbname`,`fieldname`,`field_id`,`url`,`host`,`create_time`,`update_time`,`index_status`,`index_stage` from ejf_doc where doc_id=? ");
p.setLong(1,docId);

r=p.executeQuery();
while (r.next()) {
doc =new Doc();
setFindParamNo(r, doc);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforumConnection();
}
return doc;
}




protected void setFindParam(ResultSet r,Doc doc) throws Exception{
doc.setDocId(r.getLong("doc_id"));
doc.setTitle(r.getString("title"));
doc.setTitleSize(r.getInt("title_size"));
doc.setBody(r.getString("body"));
doc.setBodySize(r.getInt("body_size"));
doc.setTablename(r.getString("tablename"));
doc.setDbname(r.getString("dbname"));
doc.setFieldname(r.getString("fieldname"));
doc.setFieldId(r.getLong("field_id"));
doc.setUrl(r.getString("url"));
doc.setHost(r.getString("host"));
doc.setCreateTime(r.getLong("create_time"));
doc.setUpdateTime(r.getLong("update_time"));
doc.setIndexStatus(r.getString("index_status"));
doc.setIndexStage(r.getInt("index_stage"));
}

protected void setFindParamNo(ResultSet r,Doc doc) throws Exception{
doc.setDocId(r.getLong(1));
doc.setTitle(r.getString(2));
doc.setTitleSize(r.getInt(3));
doc.setBody(r.getString(4));
doc.setBodySize(r.getInt(5));
doc.setTablename(r.getString(6));
doc.setDbname(r.getString(7));
doc.setFieldname(r.getString(8));
doc.setFieldId(r.getLong(9));
doc.setUrl(r.getString(10));
doc.setHost(r.getString(11));
doc.setCreateTime(r.getLong(12));
doc.setUpdateTime(r.getLong(13));
doc.setIndexStatus(r.getString(14));
doc.setIndexStage(r.getInt(15));
}

}
