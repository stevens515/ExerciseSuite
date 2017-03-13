package com.tarena.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * �������ӳع�����
 * @author soft01
 *
 */
public class DbPoolUtil implements Serializable {
	private static final long serialVersionUID = 220071241737991341L;
	private static DataSource dataSource;
	private static ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();

	static {
		try {
			Properties props = new Properties();
			props.load(DbPoolUtil.class.getResourceAsStream("dbcp.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ݿ����ӷ���
	 * 
	 * @return ���ص���һ�����ݿ�����
	 * @throws SQLException
	 */
	public synchronized static Connection getConnection() throws SQLException {
		Connection conn = connLocal.get();
		if (conn == null) {
			conn = dataSource.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}

	/**
	 * ���ݿ�رյĲ���
	 * 
	 * @throws SQLException
	 */
	public synchronized static void close() throws SQLException {
		Connection conn = connLocal.get();
		connLocal.set(null);
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
