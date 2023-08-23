package datasource.demo1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;
import com.itheima.jdbc.utils.JDBCUtils;

public class MyDataSource implements DataSource {
	private List<Connection> connList = new ArrayList<Connection>();	// 将一些连接存入到内存中，可以定义一个集合，用于存储连接对象。
	
	public MyDataSource() {	// 在初始化的时候提供一些连接
		// 初始化连接：
		for(int i = 1;i<=3;i++){
			connList.add(JDBCUtils.getConnection());    // 向集合中存入连接:
		}
	}
	
	// 从连接池中获得连接的方法
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = connList.remove(0);
		// 增强连接：
		MyConnectionWrapper connWrapper = new MyConnectionWrapper(conn, connList);
		return connWrapper;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
