package tts.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPreparedStatement {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("" +
				"jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","open123");
		String username = "abc";//SQLע������
		String password = "123";
//		String password = "a' or 'c'='c ";
//		Statement stmt = con.createStatement();//���ӽӿ�PreparedStatement����
//		ResultSet rs = stmt.executeQuery("select count(*) form tts_user where username'"+username +"'");
		//PreparedStatement׼������ ��SQL��䣬ֻҪ����ֵ���Ϳ���������
		//PreparedStatement��װ�˺���Ԥ���������SQL���
		//�������Ԥ��������󣬲ſ�������
		PreparedStatement stmt =con
			.prepareStatement("select count(*) from tts_user "
				+"where username=? and  password =?");

		//��������Ԥ�������
		//setInt,setDouble�ȴ���������ֵ�����ͣ������Oracle���ص�����һ�µġ�
		//��һ������ʾ���õڼ���Ԥ����������ʺţ�
		//�ڶ���������ʾ���õ�ֵ
		//ʹ�õ����ͱ����Ҫ���õĲ�����Ӧ���е�����ƥ�� ��
//		stmt.setXXX(1,XXX);
		//JDBC���Ǵ�1��ʼ����������
//		���û����(?)����ֱ��stmt.executeQuery()������в���(?)�ͱ���stmt.setString(1,XXX);
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			System.out.println(rs.getInt(1));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
/**
�ܽ᣺
Select��DML(insert/update/delete)������
	1��sql��䲻һ��
	2��Selectͨ��Statement�����executeQuery()������ý������
			ResultSet rs = stmt.executeQuery()
	3) DML���ͨ��Statement�����executeUpdate()������ò�������
			int n = stmt.executeUpdate();
Select��DML(insert/update/delete)����ͬ�㣺
	1)   �������(Connection)��ʽ��ͬ��
	2�����ݿ����Ӷ���(Statemetn/PreparedStatement)
			���ֶ�������Ҫ���ִ�е�sql��䣬ʹ��PreparedStatement���ܸ��á�
	3�����ʹ��PreparedStatement,sql����������������ʱ�򴫵ݣ�����ռλ��(�ʺ�)�����ݵĹ�ϵ
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,password);
			stmt.setString(1,id);
			stmt.setInt(2,id);
			stmt.executeQuery()��executeUpdate();//������дsql
	4) 	���ʹ��Statement,sql�����ִ��ʱ����
			stmt = conn.createStatement();
			stmt.executeQuery(sql)��executeUpdate(sql)
	5)	PreparedStatement��Statement����sql���Ĵ���ʱ����ͬ��
*/