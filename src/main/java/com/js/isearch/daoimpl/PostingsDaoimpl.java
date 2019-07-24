package com.js.isearch.daoimpl;

/**
* last update time:"18-05-08 14:47:30"
* last update user:pku
*/

import com.js.isearch.daoimplex.PostingsDaoimplEx;
import com.js.common.db.*;
import com.js.isearch.orm.Postings;
import com.js.isearch.dao.PostingsDao;
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
public class PostingsDaoimpl extends PostingsDaoimplEx implements PostingsDao{

    //放在daoimpl里面
    public List<Long> findPostingIdByTokenIdDocId(long tokenId,long docId) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Postings> list = new PageList(pageNo,total);
        List<Long> list = new ArrayList();
        Long result = null;
        String sql = "select posting_id from ejf_postings where token_id=? and doc_id=? and  1=1  ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,tokenId);
            p.setObject(2,docId);

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


    //daoimpl no bean
    public int incPositionsUpdateTimeByPostingId(String positions,long updateTime,long postingId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_postings set positions=positions+?,update_time=? where posting_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setString(1,positions);
            p.setLong(2,updateTime);
            p.setLong(3,postingId);

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
    public int incFrequencyPositionsUpdateTimeByPostingId(int frequency,String positions,long updateTime,long postingId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_postings set frequency=frequency+?,positions=positions+?,update_time=? where posting_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,frequency);
            p.setString(2,positions);
            p.setLong(3,updateTime);
            p.setLong(4,postingId);

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


    //放在daoimpl里面
    public List<Postings> findByDocId(long docId) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Postings> list = new PageList(pageNo,total);
        List<Postings> list = new ArrayList();
        Postings postings = null;
        String sql = "select posting_id,token_id,token,doc_id,tablename,dbname,frequency,positions,create_time,update_time,token_size from ejf_postings where doc_id=? and  1=1  order by create_time desc";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,docId);

            r = p.executeQuery();
            while (r.next()) {
                postings = new Postings();
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

                list.add(postings);
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
    public PageList<Postings> findByAllPage(int pageNo,int total) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        PageList<Postings> list = new PageList(pageNo,total);
        Postings postings = null;
        String sql = "select posting_id,token_id,token,doc_id,tablename,dbname,frequency,positions,create_time,update_time,token_size,fieldname from ejf_postings where  1=1  order by create_time asc limit ?,?";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,list.getOffset());
            p.setInt(2,list.getPageSize());
            r = p.executeQuery();
            while (r.next()) {
                postings = new Postings();
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
                list.add(postings);
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
    public PageList<Postings> findByDocIdPage(long docId,int pageNo,int total) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        PageList<Postings> list = new PageList(pageNo,total);
        Postings postings = null;
        String sql = "select posting_id,token_id,token,doc_id,tablename,dbname,frequency,positions,create_time,update_time,token_size,fieldname from ejf_postings where doc_id=? and  1=1   limit ?,?";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,docId);
            p.setInt(2,list.getOffset());
            p.setInt(3,list.getPageSize());
            r = p.executeQuery();
            while (r.next()) {
                postings = new Postings();
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
                list.add(postings);
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
    public int updatePositionsUpdateTimeByPostingId(String positions,long updateTime,long postingId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_postings set positions=?,update_time=? where posting_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setString(1,positions);
            p.setLong(2,updateTime);
            p.setLong(3,postingId);
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
    public int incFrequencyUpdateTimeByPostingId(int frequencyInc,long updateTime,long postingId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_postings set frequency=frequency+?,update_time=? where posting_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,frequencyInc);
            p.setLong(2,updateTime);
            p.setLong(3,postingId);


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
    public int deleteByPostingId(long postingId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "delete from ejf_postings where posting_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setLong(1,postingId);
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
    public int deleteByDocId(long docId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "delete from ejf_postings where doc_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setLong(1,docId);

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
    public List<Postings> findDocIdPositionsByToken(String token) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Postings> list = new PageList(pageNo,total);
        List<Postings> list = new ArrayList();
        Postings postings = null;
        String sql = "select doc_id,positions from ejf_postings where token=? and  1=1  ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,token);
            r = p.executeQuery();
            while (r.next()) {
                postings = new Postings();
                postings.setDocId(r.getLong(1));
                postings.setPositions(r.getString(2));
                list.add(postings);
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
    public List<Long> findPostingIdByTokenIdDocIdFieldname(long tokenId,long docId,String fieldname) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Postings> list = new PageList(pageNo,total);
        List<Long> list = new ArrayList();
        Long result = null;
        String sql = "select posting_id from ejf_postings where token_id=? and doc_id=? and fieldname=? and  1=1  order by create_time asc";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,tokenId);
            p.setObject(2,docId);
            p.setObject(3,fieldname);

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
    public List<Postings> findDocIdPositionsFieldnameByToken(String token) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Postings> list = new PageList(pageNo,total);
        List<Postings> list = new ArrayList();
        Postings postings = null;
        String sql = "select doc_id,positions,fieldname from ejf_postings where token=? and  1=1  order by create_time asc";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,token);

            r = p.executeQuery();
            while (r.next()) {
                postings = new Postings();
                postings.setDocId(r.getLong(1));
                postings.setPositions(r.getString(2));
                postings.setFieldname(r.getString(3));

                list.add(postings);
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


















}
