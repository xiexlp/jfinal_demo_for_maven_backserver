package com.js.isearch.daoimpl;

/**
* last update time:"18-06-07 18:13:53"
* last update user:pku
*/

import com.js.isearch.daoimplex.QueryLogDaoimplEx;
import com.js.common.db.*;
import com.js.isearch.orm.QueryLog;
import com.js.isearch.dao.QueryLogDao;
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
public class QueryLogDaoimpl extends QueryLogDaoimplEx implements QueryLogDao{

    public List<QueryLog> findNames(List<String> names,String wherehql){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        QueryLog queryLog = null;
        List<QueryLog> list = new ArrayList();

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ejf_query_log ").append(wherehql);
        String sql = sqlBuffer.toString();
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                queryLog = new QueryLog();
                for(String n:names){
                    queryLog.getMap().put(n,r.getString(n));
                }
                //setFindParam(r, queryLog);
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

    public PageList<QueryLog> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        PreparedStatement p = null;
        ResultSet r = null;
        Connection conn=null;
        QueryLog queryLog = null;
        //List<QueryLog> list = new ArrayList();
        PageList<QueryLog> list = new PageList(pageNo,total);

        StringBuffer sqlBuffer = new StringBuffer("select ");
        for(String fieldname:names){
            sqlBuffer.append(fieldname).append(",");
        }
        String select = sqlBuffer.substring(0,sqlBuffer.length()-1);
        sqlBuffer.setLength(0);
        sqlBuffer.append(select).append(" from ejf_query_log ").append(wherehql).append(" limit ?,?");
        String sql = sqlBuffer.toString();
        try {
            conn =HikariDb.getConnection();
            p=conn.prepareStatement(sql);
            p.setInt(1,list.getOffset());
            p.setInt(2,list.getPageSize());
            r = p.executeQuery();
            while (r.next()) {
                queryLog = new QueryLog();
                for(String n:names){
                    queryLog.getMap().put(n,r.getString(n));
                }
                //setFindParam(r, queryLog);
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

    public int updateSet(String set,String where){
        PreparedStatement p = null;
        int result=-1;
        Connection conn=null;
        StringBuffer sqlBuffer = new StringBuffer("update ").append("ejf_query_log").append(set).append(" ").append(where);
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
        StringBuffer sqlBuffer = new StringBuffer("delete from ").append(" ejf_query_log ").append(where);
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


}
