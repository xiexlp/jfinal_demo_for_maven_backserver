package com.js.isearch.counter;

import com.js.common.db.DbUtils;

import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.ResultSet;
  import java.sql.Statement;

/**
 * 使用原生态的JDBC
 */
public class DbCounterUtil {

     //private static final String URL="jdbc:mysql://localhost:3306/ishop?useUnicode=true&amp;characterEncoding=utf8";
      private static final String URL="jdbc:mysql://localhost:3306/iforum?useUnicode=true&amp;characterEncoding=utf8";
     private static final String NAME="root";
     private static final String PASSWORD="";

   static Connection conn=null;
   static {
    init();
   }

     public static void  init(){
      try {
       //1.加载驱动程序
       Class.forName("com.mysql.jdbc.Driver");
       //2.获得数据库的连接
       conn = DriverManager.getConnection(URL, NAME, PASSWORD);
      }catch (Exception e){
        e.printStackTrace();
      }
     }

     public static Connection getConn(String dbName){
         Connection connection =null;
         try {
             //1.加载驱动程序
             Class.forName("com.mysql.jdbc.Driver");
             //2.获得数据库的连接
             connection = DriverManager.getConnection(URL, NAME, PASSWORD);
         }catch (Exception e){
             e.printStackTrace();
         }
         return connection;
     }

     public static int exeSql(String sql){
       int r=0;
         Statement stmt =null;
        try {
         //3.通过数据库的连接操作数据库，实现增删改查
          stmt = conn.createStatement();
         r = stmt.executeUpdate(sql);//选择import java.sql.ResultSet;
        }catch (Exception e){
         e.printStackTrace();
        }finally {
            DbUtils.closeConn(conn);
            DbUtils.close(stmt);
        }
        return r;
     }

    public static int query(String dbname,String sql){
        int r=0;
        Statement stmt =null;
        ResultSet rs=null;
        try {
            //3.通过数据库的连接操作数据库，实现增删改查
            stmt = getConn(dbname).createStatement();
            rs = stmt.executeQuery(sql);//选择import java.sql.ResultSet;
            while (rs.next()){
                int para = rs.getInt(1);
                r=para;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //DbUtils.closeConn(conn);
            DbUtils.close(stmt);
            DbUtils.close(rs);
        }
        return r;
    }

    public static int queryCount(String dbname,String sql){
        int r=0;
        Statement stmt =null;
        ResultSet rs=null;
        try {
            //3.通过数据库的连接操作数据库，实现增删改查
            stmt = getConn(dbname).createStatement();
            rs = stmt.executeQuery(sql);//选择import java.sql.ResultSet;
            while (rs.next()){
                int count = rs.getInt(1);
                r=count;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //DbUtils.closeConn(conn);
            DbUtils.close(stmt);
            DbUtils.close(rs);
        }
        return r;
    }

     public static void main(String[] args) throws Exception{


     }
 }