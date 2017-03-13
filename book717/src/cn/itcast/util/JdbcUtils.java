package cn.itcast.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import cn.itcast.exception.DBException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource ds = null;
	static {
		ds = new ComboPooledDataSource();// ��ȡ����Ĭ�ϵ������ļ�c3p0��<default-config>
	}

	// ��ȡ����
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(Global.ERROR_CONNECTION_EXCEPTION);
		}
		return conn;
	}

	// ��
	public static void closeResource(Connection conn, Statement stmt,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException(Global.ERROR_CLOSERESULT_EXCEPTION);
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DBException(Global.ERROR_CLOSESTATEMENT_EXCEPTION);
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new DBException(Global.ERROR_CLOSECONNECTION_EXCEPTION);
					}
				}
			}
		}
	}
	/**
	 * 	��ʼ����
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
			try {
				if(conn != null){
					conn.setAutoCommit(false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException(Global.ERROR_BEGINTRANACTION_EXCEPTION);
			}
	}
	/**
	 * 	�ύ����
	 * @param conn
	 */
	public static void commitTransaction(Connection conn) {
		try {
			if(conn != null){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(Global.ERROR_COMMITBEGINTRANACTION_EXCEPTION);
		}
		
	}
	/**
	 * 	�ع�����
	 * @param conn
	 */
	public static void rollbackTransaction(Connection conn) {
		try {
			if(conn != null){
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(Global.ERROR_ROLLBACKTRANACTION_EXCEPTION);
		}
	}
}
