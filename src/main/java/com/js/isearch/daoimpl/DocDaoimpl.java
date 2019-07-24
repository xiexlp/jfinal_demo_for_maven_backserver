package com.js.isearch.daoimpl;

/**
* last update time:"18-05-08 14:47:08"
* last update user:pku
*/

import com.js.isearch.daoimplex.DocDaoimplEx;
import com.js.common.db.*;
import com.js.isearch.orm.Doc;
import com.js.isearch.dao.DocDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.js.common.util.PageList;

/**
* Created by Administrator on 2015-7-16.
*/
public class DocDaoimpl extends DocDaoimplEx implements DocDao{

    //daoimpl no bean
    public int updateBodyUpdateTimeByDocId(String body,long updateTime,long docId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_doc set body=?,update_time=? where doc_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setString(1,body);
            p.setLong(2,updateTime);
            p.setLong(3,docId);
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

    //daoimpl no bean
    public int updateUpdateTimeIndexStatusByDocId(long updateTime,String indexStatus,long docId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_doc set update_time=?,index_status=? where doc_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setLong(1,updateTime);
            p.setString(2,indexStatus);
            p.setLong(3,docId);
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

    //放在daoimpl里面
    public PageList<Doc> findByAllPage(int pageNo,int total) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Doc> list = new PageList(pageNo,total);
        PageList<Doc> list = new PageList(pageNo,total);
        Doc doc = null;
        String sql = "select doc_id,title,title_size,body,body_size,tablename,dbname,fieldname,field_id,url,host,create_time,update_time,index_status,index_stage from ejf_doc where  1=1  order by create_time asc limit ?,?";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,list.getOffset());
            p.setInt(2,list.getPageSize());

            r = p.executeQuery();
            while (r.next()) {
                doc = new Doc();
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

                list.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
        } finally {
            DbUtils.close(r, p);
            DbUtils.closeConn(conn);
        }
        return list;
    }


    public PageList<Doc> findByAllPageOrder(int pageNo,int total,String fieldname,boolean asc){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Doc> list = new PageList(pageNo,total);
        PageList<Doc> list = new PageList(pageNo,total);
        Doc doc = null;

        StringBuffer sb = new StringBuffer();
        sb.append(fieldname);
        if(asc) sb.append(" asc ");
        else sb.append(" desc ");

        String sql = "select doc_id,title,title_size,body,body_size,tablename,dbname,fieldname,field_id,url,host,create_time,update_time,index_status,index_stage from ejf_doc where  1=1  order by "+ sb.toString()+ " limit ?,?";

        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,list.getOffset());
            p.setInt(2,list.getPageSize());

            r = p.executeQuery();
            while (r.next()) {
                doc = new Doc();
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

                list.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
        } finally {
            DbUtils.close(r, p);
            DbUtils.closeConn(conn);
        }
        return list;
    }

    //daoimpl no bean
    public int updateIndexStageByDocId(int indexStage,long docId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_doc set index_stage=? where doc_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,indexStage);
            p.setLong(2,docId);

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


    //放在daoimpl里面
    public List<Long> findDocIdByFieldnameFieldIdTablenameDbname(String fieldname,long fieldId,String tablename,String dbname) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        List<Long> list = new ArrayList();
        Long result = null;
        String sql = "select doc_id from ejf_doc where fieldname=? and field_id=? and tablename=? and dbname=? and  1=1  order by create_time desc";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,fieldname);
            p.setObject(2,fieldId);
            p.setObject(3,tablename);
            p.setObject(4,dbname);

            r = p.executeQuery();
            while (r.next()) {
                result = new Long(0);
                result=r.getLong(1);

                list.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
        } finally {
            DbUtils.close(r, p);
            DbUtils.closeConn(conn);
        }
        return list;
    }


    //放在daoimpl里面
    public List<Doc> findByIndexStage(int indexStage) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        List<Doc> list = new ArrayList();
        Doc doc = null;
        String sql = "select doc_id,title,title_size,body,body_size,tablename,dbname,fieldname,field_id,url,host,create_time,update_time,index_status,index_stage from ejf_doc where index_stage=? and  1=1  order by create_time desc";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,indexStage);

            r = p.executeQuery();
            while (r.next()) {
                doc = new Doc();
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

                list.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
        } finally {
            DbUtils.close(r, p);
            DbUtils.closeConn(conn);
        }
        return list;
    }









//daoimpl no bean
public int updateUrlByDocId(String url,long docId){
PreparedStatement p = null;
int result=-1;
Connection conn=null;
String sql = "update ejf_doc set `url`=? where `doc_id`=? ";
try {
// p = DbHotel.getJshopConnection().prepareStatement(sql);
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setString(1,url);
p.setLong(2,docId);

//p.setString(1,spec.getSpecName());
//p.setObject(2,spec.getSpecTypeID());
//p.setString(3,spec.getTypeName());
//p.setString(4,spec.getBrief());
//p.setInt(5,spec.getSpecID());

result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeJshopConnection();
//DbHotel.closeConnectionByName(dbname);
}
return result;
}


}