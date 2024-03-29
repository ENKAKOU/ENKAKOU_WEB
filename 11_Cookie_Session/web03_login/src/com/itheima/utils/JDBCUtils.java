package com.itheima.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * JDBC的工具类
 * @author jt
 */
public class JDBCUtils {
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource(); 	// 创建一个连接池：但是这个连接池只需要创建一次即可。
	/**
	 * 获得连接的方法
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

	public static DataSource getDataSource(){    //获得连接池
		return dataSource;
	}
}
