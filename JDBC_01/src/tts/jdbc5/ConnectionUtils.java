package tts.jdbc5;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtils {
	//��������
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//�����ʱ�ͼ��غ���Щ����
	static{
		try{
		//�������ʱ��ʼ����������
		Properties props = new Properties();
		//ͨ���ļ��������Ե���Ϣ���뵽Properties������
		//����·���¼��������ļ�
		//getClassLoader()���װ�����װ������Ҳ���Դ���·����װ���ļ�
		//װ������getResourceAsStream()���ð����װ��·���µ�һ���ļ�
		InputStream is =ConnectionUtils.class
				.getClassLoader()
				.getResourceAsStream("db.properties");
		props.load(is);
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		
		Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//ÿ��һ��getConnection()���Ͳ���һ���µ����ӡ�
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
}
