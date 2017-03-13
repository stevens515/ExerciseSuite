package tts.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * JDBC��һ�죬����γ�
 */
public class Main {
	public static void main(String[] args) throws Exception{
		// ��JDBC��API������Oracle
		// 192.168.0.26 openlab/open123
		//�����ؼ�API
		Connection con = null;// �ӿ�Connection,���ڷ�װ�����ݿ���������
		Statement stmt = null;// �ӿڣ�������װҪִ�е�SQL���
		ResultSet rs = null;// �ӿڣ����ڷ�װ����SQL���ִ��֮��Ĳ�ѯ���
		
		//װ��Oracle��JDBC API��ʵ��
		
		//Class.forName():�����������װ���ڴ����
		//��oracle.jdbc.OracleDriverװ���ڴ�
		//Class.forName("tts.jdbc.Foo");//����о�̬�飬����װ��ʱִ��
		//static���еĴ������DriverManagerע��Oracle������(��OracleDriver)����
		//����JDBC��ͨ�����������ҵ�JDBC API����Ӧʵ��
		//OracleDriver�������������ʵ����ķ������Զ��� 
		Class.forName("oracle.jdbc.OracleDriver");
		//MySql:com.mysql.jdbc.Driver
		
		//���Oracle��ӦConnection�ӿڵ�ʵ��
		//����ֵ�Ƕ�Connecction�ӿڵ�ʵ��
		//tarena:oracle��ʵ����,װOracleʱ��SID
		//jdbc:oracle:thin:IP��ַ���˿ںţ�ʵ������user,password
		System.out.println(con);//null
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","opne123");
		//jdbc:mysql://ip:port/databaseName
		System.out.println(con);
		
		stmt = con.createStatement();
		System.out.println(stmt);//����statement
		//ִ��һ����ѯ���,����ֵ��Resultset
		rs = stmt.executeQuery("select empno,ename,salary from emp_ning");
		
		//������rs�ķ�����ȡ��ѯ�Ľ����rs�ڲ��и��αָ꣬����һ�оͿ���ȡ��һ�е����ݣ�Ĭ���ڵ�һ�е�ǰ����һ����
		//rs.next();//���α��ƶ�����һ�У�����һ��boolean����
	/*	if(rs.next()){
			//�����һ�У��ĵ�columnIndex�е����ݡ�getInt,getDate,�ȡ���ȡ��������ת����XXX����
			//rs.getXXX(columnIndex)
			int empno = rs.getInt(1);//��һ�еĵ�һ������
			String ename = rs.getString(2);//��һ�еĵڶ�������
			double sal = rs.getDouble(3);//��һ�еĵ���������
			System.out.println(empno+","+ename+","+sal);
		}*/
		while(rs.next()){//ѭ��
			//�����һ�У��ĵ�columnIndex�е����ݡ�getInt,getDate,�ȡ���ȡ��������ת����XXX����
			//rs.getXXX(columnIndex)
			int empno = rs.getInt(1);//��һ�еĵ�һ������
			String ename = rs.getString(2);//��һ�еĵڶ�������
			double sal = rs.getDouble(3);//��һ�еĵ���������
			System.out.println(empno+","+ename+","+sal);
		}
		
		//�ͷ���Դ
		rs.close();
		stmt.close();
		con.close();
	}

}
