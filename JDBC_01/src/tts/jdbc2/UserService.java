package tts.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	/**
	 * ʵ�ֵ�¼�������ɹ�����true,���򷵻�false
	 */
	public boolean login(String username,String password) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena","openlab","open123");
		Statement stmt = con.createStatement();
		String sql = "select count(*) from tts_user"+ " where username='" +
				username +"'and password ='"+ password+"'";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		boolean b =false;
		if(rs.next()){
			int n = rs.getInt(1);
			if(n>0){
				b=true;
			}
		}
		con.close();
		stmt.close();
		rs.close();
		return b;
	}
}
/**
 * 		�ܽ᣺
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