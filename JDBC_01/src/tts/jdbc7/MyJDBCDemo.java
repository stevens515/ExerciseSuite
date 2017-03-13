package tts.jdbc7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyJDBCDemo {
	private static String url;
	private static String dbUser;
	private static String dbPassword;
	
	public static void getParam(String filename){
		Properties propes=new Properties();
		File file = new File(filename);
		try{
			FileInputStream fis = new FileInputStream(file);
			//����������ָ�����ļ�
			propes.load(fis);
			//��ȡ�ļ���url��key����Ӧ��value,����ֵ��ȫ�ֱ���
			url = propes.getProperty("url");
			dbUser = propes.getProperty("dbUser");
			dbPassword=propes.getProperty("dbPassword");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//�������ݿ⣬��ȡemp������ݲ����������̨
	public static void getEmpData(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//sql��䣬ע��û�зֺ�
		String sql = "select * from emp";
		try{
			//����DriverManager�����Ӷ���ֵ
			//��Ҫ���������������ַ��������ݵ��û���������
			conn=DriverManager.getConnection(url,dbUser,dbPassword);
			stmt = conn.createStatement();
			//����sql��䵽���ݿ��У������ؽ����
			rs = stmt.executeQuery(sql);
			
			//next()������ָ��һ�У�������booleanֵ
			while(rs.next()){
				//id,name,age��������oracle���ݿ���number���͵�������getInt()ȡֵ
				//varchar2/char���͵�������getString()ȡֵ
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println(id+","+name+","+age);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getParam("src/db_oracle.properties");
		getEmpData();
	}
}	
