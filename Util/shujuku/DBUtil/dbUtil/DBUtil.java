package dbUtil;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	//����Դ
	private static BasicDataSource dbs=null;
	//�����ļ�
	private static Configuration config=null;
	//ThreadLocal
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	//��ȡ�����ļ����ݣ���������Դ����
	static{
		config=Configuration.config("/dbUtil/db.xml");
		dbs=new BasicDataSource();
		dbs.setDriverClassName(config.getDriver());
		dbs.setUrl(config.getUrl());
		dbs.setUsername(config.getUsername());
		dbs.setPassword(config.getPassword());
		dbs.setInitialSize(config.getInitialSize());
		dbs.setMaxActive(config.getMaxActive());
		dbs.setMaxIdle(config.getMaxIdle());
		dbs.setMinIdle(config.getMinIdle());
	}
	//������ݿ�����
	public static Connection getConnection() throws SQLException{
		Connection conn=tl.get();
		if(conn==null){
			conn=dbs.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	//�ر����ݿ�����
	public static void close() throws SQLException{
		Connection conn=tl.get();
		if(conn!=null){
			conn.close();
		}
		tl.remove();
	}
}






