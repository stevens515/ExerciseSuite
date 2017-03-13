package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarena.util.file.Env;

public class DBConnection {

	// һ����������ļ���ע������ʹ��static
	// һ���Լ���
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	static {
		try {
			Class.forName(Env.getString("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �������ݿ�
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn=tl.get();
		if(conn==null){
			conn=DriverManager.getConnection(Env.getString("url"), Env
					.getString("user"), Env.getString("password"));
			tl.set(conn);
		}
		return conn;
	}

	/**
	 * 
	 * �н�����ر�(��ѯ)
	 * 
	 * @param rs
	 *            �����
	 * @param ps
	 *            PreparedStatement
	 * @param conn
	 *            ����
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			tl.remove();
		}
	}

	/**
	 * 
	 * �н�����ر�(��ѯ)
	 * 
	 * @param rs
	 *            �����
	 * @param stat
	 *            Statement
	 * @param conn
	 *            ����
	 */

	static public void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * �޽�����ر�(ɾ�����޸ġ�����)
	 * 
	 * @param ps
	 *            PreparedStatement
	 * @param conn
	 *            ����
	 */
	static public void close(PreparedStatement ps, Connection conn) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * �޽�����ر�(ɾ�����޸ġ�����)
	 * 
	 * @param stat
	 *            Statement
	 * @param conn
	 *            ����
	 */

	static public void close(Statement stat, Connection conn) {
		try {
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ������
	// �ύ����
	public static void commitTran(Connection conn) {
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �ع�����
	public static void rollbackTran(Connection conn) {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
