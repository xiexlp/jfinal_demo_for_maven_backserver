package com.js.isearch.daoimplex;

/**
* last update time:"18-09-27 16:21:57"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.Postings;
import com.js.isearch.daoex.PostingsDaoEx;
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


public class PostingsDaoimplEx implements PostingsDaoEx {

public String dbname= Globe.dbname;

public List<Postings> find(String hql) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Postings postings = null;
List<Postings> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement(hql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(hql);
r = p.executeQuery();
while (r.next()) {
postings = new Postings();
setFindParamNo(r, postings);
list.add(postings);
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


public List<Postings> findNames(List<String> names,String wherehql){
    PreparedStatement p = null;
    ResultSet r = null;
    Connection conn=null;
    Postings postings = null;
    List<Postings> list = new ArrayList();

    StringBuffer sqlBuffer = new StringBuffer("select ");
    for(String fieldname:names){
    sqlBuffer.append(fieldname).append(",");
    }
    String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
    sqlBuffer.setLength(0);
    sqlBuffer.append(select).append(" from ").append(" ejf_postings ").append(wherehql);
    String sql = sqlBuffer.toString();
    try {
    //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
    conn =HikariDb.getConnection();
    p=conn.prepareStatement(sql);
    r = p.executeQuery();
    while (r.next()) {
    postings = new Postings();
    for(String n:names){
        postings.getMap().put(n,r.getString(n));
    }
    list.add(postings);
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

    public PageList<Postings> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        Postings postings = null;
        PageList<Postings> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
        sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ").append(" ejf_postings ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
        //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
        conn =HikariDb.getConnection();
        p=conn.prepareStatement(sql);
        p.setInt(1,list.getOffset());
        p.setInt(2,list.getPageSize());
        r = p.executeQuery();
        while (r.next()) {
        postings = new Postings();
        for(String n:names){
        postings.getMap().put(n,r.getString(n));
        }
        list.add(postings);
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


        public List<Postings> findNameArray(String[] names,String wherehql){
            PreparedStatement p = null;
            ResultSet r = null;
            Connection conn=null;
            Postings postings = null;
            List<Postings> list = new ArrayList();

            StringBuffer sqlBuffer = new StringBuffer("select ");
            for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
            }
            String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
            sqlBuffer.setLength(0);
            sqlBuffer.append(select).append(" from ").append(" ejf_postings ").append(wherehql);
            String sql = sqlBuffer.toString();
            try {
            //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
            postings = new Postings();
            for(String n:names){
            postings.getMap().put(n,r.getString(n));
            }
            list.add(postings);
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


            public PageList<Postings> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
                PreparedStatement p = null;
                ResultSet r = null;
                Connection conn=null;
                Postings postings = null;
                PageList<Postings> list = new PageList(pageNo,total);

                StringBuffer sqlBuffer = new StringBuffer("select ");
                for(String fieldname:names){
                sqlBuffer.append(fieldname).append(",");
                }
                String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
                sqlBuffer.setLength(0);
                sqlBuffer.append(select).append(" from ").append(" ejf_postings ").append(wherehql).append(" limit ?,?");
                String sql = sqlBuffer.toString();
                try {
                //p = DbHotel.getIforum_index_dbConnection().prepareStatement(sql);
                conn =HikariDb.getConnection();
                p=conn.prepareStatement(sql);
                p.setInt(1,list.getOffset());
                p.setInt(2,list.getPageSize());
                r = p.executeQuery();
                while (r.next()) {
                postings = new Postings();
                for(String n:names){
                postings.getMap().put(n,r.getString(n));
                }
                list.add(postings);
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




public int save(Postings postings) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ejf_postings(`posting_id`,`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,postings);
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



public int saveAutoReturnId(Postings postings) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ejf_postings(`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ejf_postings(`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,postings);
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

public int saveAutoId(Postings postings) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ejf_postings(`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ejf_postings(`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ejf_postings(`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
setStatementAutoId(p,postings);
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

private void setStatement(PreparedStatement p,Postings postings) throws Exception{
p.setLong(1,postings.getPostingId());
p.setLong(2,postings.getTokenId());
p.setString(3,postings.getToken());
p.setLong(4,postings.getDocId());
p.setString(5,postings.getTablename());
p.setString(6,postings.getDbname());
p.setObject(7,postings.getFrequency());
p.setString(8,postings.getPositions());
p.setLong(9,postings.getCreateTime());
p.setLong(10,postings.getUpdateTime());
p.setObject(11,postings.getTokenSize());
p.setString(12,postings.getFieldname());
p.setObject(13,postings.getFieldnameType());

}

private void setStatementAutoId(PreparedStatement p,Postings postings) throws Exception{
    p.setLong(1,postings.getTokenId());
p.setString(2,postings.getToken());
p.setLong(3,postings.getDocId());
p.setString(4,postings.getTablename());
p.setString(5,postings.getDbname());
p.setObject(6,postings.getFrequency());
p.setString(7,postings.getPositions());
p.setLong(8,postings.getCreateTime());
p.setLong(9,postings.getUpdateTime());
p.setObject(10,postings.getTokenSize());
p.setString(11,postings.getFieldname());
p.setObject(12,postings.getFieldnameType());

}

public List<Postings> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Postings postings = null;
List<Postings> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.posting_id,a.token_id,a.token,a.doc_id,a.tablename,a.dbname,a.frequency,a.positions,a.create_time,a.update_time,a.token_size,a.fieldname,a.fieldname_type from ejf_postings as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.posting_id,a.token_id,a.token,a.doc_id,a.tablename,a.dbname,a.frequency,a.positions,a.create_time,a.update_time,a.token_size,a.fieldname,a.fieldname_type from ejf_postings as a");
r = p.executeQuery();
while (r.next()) {
postings = new Postings();
setFindParamNo(r, postings);
list.add(postings);
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

public PageList<Postings> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Postings postings = null;
PageList<Postings> list = new PageList(pageNo,total);
String sql = "select a.posting_id,a.token_id,a.token,a.doc_id,a.tablename,a.dbname,a.frequency,a.positions,a.create_time,a.update_time,a.token_size,a.fieldname,a.fieldname_type from ejf_postings as a ORDER BY a.create_time DESC  LIMIT ?,? ";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.posting_id,a.token_id,a.token,a.doc_id,a.tablename,a.dbname,a.frequency,a.positions,a.create_time,a.update_time,a.token_size,a.fieldname,a.fieldname_type from ejf_postings as a ORDER BY a.create_time DESC  LIMIT ?,? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
postings = new Postings();
setFindParamNo(r, postings);
list.add(postings);
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


public PageList<Postings> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Postings postings = null;
PageList<Postings> list = new PageList(pageNo,total);
String sql = "select a.posting_id,a.token_id,a.token,a.doc_id,a.tablename,a.dbname,a.frequency,a.positions,a.create_time,a.update_time,a.token_size,a.fieldname,a.fieldname_type from ejf_postings as a";
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
postings = new Postings();
setFindParamNo(r, postings);
list.add(postings);
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



public int update(Postings postings) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ejf_postings set `token_id`=?,`token`=?,`doc_id`=?,`tablename`=?,`dbname`=?,`frequency`=?,`positions`=?,`create_time`=?,`update_time`=?,`token_size`=?,`fieldname`=?,`fieldname_type`=? where posting_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ejf_postings set `token_id`=?,`token`=?,`doc_id`=?,`tablename`=?,`dbname`=?,`frequency`=?,`positions`=?,`create_time`=?,`update_time`=?,`token_size`=?,`fieldname`=?,`fieldname_type`=? where posting_id=? ");
p.setLong(1,postings.getTokenId());
p.setString(2,postings.getToken());
p.setLong(3,postings.getDocId());
p.setString(4,postings.getTablename());
p.setString(5,postings.getDbname());
p.setObject(6,postings.getFrequency());
p.setString(7,postings.getPositions());
p.setLong(8,postings.getCreateTime());
p.setLong(9,postings.getUpdateTime());
p.setObject(10,postings.getTokenSize());
p.setString(11,postings.getFieldname());
p.setObject(12,postings.getFieldnameType());
p.setLong(13,postings.getPostingId());

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

public int delete(long postingId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ejf_postings where posting_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ejf_postings where posting_id=? ");
p.setLong(1,postingId);

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
        StringBuffer sqlBuffer = new StringBuffer("update ").append(" ejf_postings ").append(set).append(" ").append(where);
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
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ejf_postings ").append(where);
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



public Postings get(long postingId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Postings postings = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `posting_id`,`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type` from ejf_postings where posting_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `posting_id`,`token_id`,`token`,`doc_id`,`tablename`,`dbname`,`frequency`,`positions`,`create_time`,`update_time`,`token_size`,`fieldname`,`fieldname_type` from ejf_postings where posting_id=? ");
p.setLong(1,postingId);

r=p.executeQuery();
while (r.next()) {
postings =new Postings();
setFindParamNo(r, postings);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return postings;
}




protected void setFindParam(ResultSet r,Postings postings) throws Exception{
postings.setPostingId(r.getLong("posting_id"));
postings.setTokenId(r.getLong("token_id"));
postings.setToken(r.getString("token"));
postings.setDocId(r.getLong("doc_id"));
postings.setTablename(r.getString("tablename"));
postings.setDbname(r.getString("dbname"));
postings.setFrequency(r.getInt("frequency"));
postings.setPositions(r.getString("positions"));
postings.setCreateTime(r.getLong("create_time"));
postings.setUpdateTime(r.getLong("update_time"));
postings.setTokenSize(r.getInt("token_size"));
postings.setFieldname(r.getString("fieldname"));
postings.setFieldnameType(r.getInt("fieldname_type"));
}

protected void setFindParamNo(ResultSet r,Postings postings) throws Exception{
postings.setPostingId(r.getLong(1));
postings.setTokenId(r.getLong(2));
postings.setToken(r.getString(3));
postings.setDocId(r.getLong(4));
postings.setTablename(r.getString(5));
postings.setDbname(r.getString(6));
postings.setFrequency(r.getInt(7));
postings.setPositions(r.getString(8));
postings.setCreateTime(r.getLong(9));
postings.setUpdateTime(r.getLong(10));
postings.setTokenSize(r.getInt(11));
postings.setFieldname(r.getString(12));
postings.setFieldnameType(r.getInt(13));
}

}
