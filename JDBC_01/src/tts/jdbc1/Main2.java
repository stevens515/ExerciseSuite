package tts.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main2 {
	public static void main(String[] args) throws Exception {
		Connection con = null;// �ӿ�Connection,���ڷ�װ�����ݿ���������
		Statement stmt = null;// �ӿڣ�������װҪִ�е�SQL���
		ResultSet rs = null;// �ӿڣ����ڷ�װ����SQL���ִ��֮��Ĳ�ѯ���

		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println(con);// null
		con = DriverManager.getConnection("jdbc:oracle:thin:"
				+ "@192.168.0.26:1521:tarena", "openlab", "opne123");
		System.out.println(con);

		stmt = con.createStatement();
		System.out.println(stmt);// ����statement
		rs = stmt.executeQuery("select empno,ename,salary from emp_ning");

		while (rs.next()) {// ѭ��
			int empno = rs.getInt(1);// ��һ�еĵ�һ������
			String ename = rs.getString(2);// ��һ�еĵڶ�������
			double sal = rs.getDouble(3);// ��һ�еĵ���������
			System.out.println(empno + "," + ename + "," + sal);
		}
		rs.close();
		stmt.close();
		con.close();
	}

}
