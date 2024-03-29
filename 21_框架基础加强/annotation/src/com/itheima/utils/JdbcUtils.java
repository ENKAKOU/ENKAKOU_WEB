package com.itheima.utils;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {

	@JdbcProperty(driverClass = "com.mysql.jdbc.Driver", url = "jdbc:mysql:///exam", user = "root", password = "abc")
	public static Connection getConnection()
			throws ClassNotFoundException, SQLException, NoSuchMethodException, SecurityException {
				
		// 如何得到方法上的注解的属性值---结合反射来完成
		Class clazz = JdbcUtils.class;		// 1.得到当前类的Class

		Method method = clazz.getDeclaredMethod("getConnection");		// 2.得到getConnection方法的Method对象

		JdbcProperty jp = (JdbcProperty) method.getAnnotation(JdbcProperty.class);		// 3.得到方法上的Annotation

		String driverClass = jp.driverClass();
		String url = jp.url();
		String user = jp.user();
		String password = jp.password();

		Class.forName(driverClass);		// 1.加载驱动

		Connection con = DriverManager.getConnection(url, user, password);		// 2.获取Connection

		return con;
	}

	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, SQLException {
		Connection connection = getConnection();

		ResultSet rs = connection.createStatement().executeQuery("select * from user");
		if (rs.next()) {
			System.out.println(rs.getString("username"));
		}
	}
}
