package com.js.isearch.daoimpl;

/**
* last update time:"18-05-08 14:47:49"
* last update user:pku
*/

import com.js.isearch.daoimplex.TokenDaoimplEx;
import com.js.common.db.*;
import com.js.isearch.orm.Token;
import com.js.isearch.dao.TokenDao;
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
public class TokenDaoimpl extends TokenDaoimplEx implements TokenDao{

    //放在daoimpl里面
    public List<Long> findTokenIdByToken(String token) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        List<Long> list = new ArrayList();
        Long result = null;
        String sql = "select token_id from ejf_token where token=? and  1=1  ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,token);

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
    public int incDocCount(long tokenId,int num){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_token set `doc_count`=`doc_count`+? where token_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,num);
            p.setObject(2,tokenId);


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
    //放在daoimpl里面
    public PageList<Token> findByAllPage(int pageNo,int total) {
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Token> list = new PageList(pageNo,total);
        PageList<Token> list = new PageList(pageNo,total);
        Token token = null;
        String sql = "select token_id,token,token_size,doc_count,position_count,docs from ejf_token where  1=1   limit ?,?";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,list.getOffset());
            p.setInt(2,list.getPageSize());
            r = p.executeQuery();
            while (r.next()) {
                token = new Token();
                token.setTokenId(r.getLong(1));
                token.setToken(r.getString(2));
                token.setTokenSize(r.getInt(3));
                token.setDocCount(r.getInt(4));
                token.setPositionCount(r.getInt(5));
                token.setDocs(r.getString(6));
                list.add(token);
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


    public PageList<Token> findByAllPage(int pageNo,int total,String fieldname,boolean asc){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
//PageList<Token> list = new PageList(pageNo,total);
        PageList<Token> list = new PageList(pageNo,total);
        Token token = null;

        StringBuffer sb = new StringBuffer();
        sb.append(" order by ").append(fieldname);
        if(asc) sb.append(" asc ");
        else sb.append(" desc ");

        String sql = "select token_id,token,token_size,doc_count,position_count,docs from ejf_token where  1=1 "+ sb.toString()+"  limit ?,?";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,list.getOffset());
            p.setInt(2,list.getPageSize());
            r = p.executeQuery();
            while (r.next()) {
                token = new Token();
                token.setTokenId(r.getLong(1));
                token.setToken(r.getString(2));
                token.setTokenSize(r.getInt(3));
                token.setDocCount(r.getInt(4));
                token.setPositionCount(r.getInt(5));
                token.setDocs(r.getString(6));
                list.add(token);
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
    public int updateDocs(String docs,long tokenId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_token set `docs`=? where token_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setString(1,docs);
            p.setObject(2,tokenId);
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
    public int updateDocCountDocs(int docCount,String docs,long tokenId){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        String sql = "update ejf_token set `doc_count`=?,`docs`=? where token_id=? ";
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setObject(1,docCount);
            p.setString(2,docs);
            p.setObject(3,tokenId);

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



}
