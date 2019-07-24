package com.js.common.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HikariDb {
	
	static HikariConfig config = new HikariConfig();
	static HikariDataSource ds ;
	
	
	static {
		init();
	}
	
	static void init() {
		//在此修改数据库配置信息
		config.setJdbcUrl("jdbc:mysql://localhost:3306/iforum_index_db?characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&useSSL=false");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds=new HikariDataSource(config);
	}
	
	
	
	public static Connection getConnection() {
		//Connection connection=null;
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/nshop?characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;useSSL=false");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);
		try {
			
			Connection con=ds.getConnection();
			PreparedStatement ps =con.prepareStatement("desc js_user");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				String name=rs.getString(1);
				System.out.println(name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	

}
