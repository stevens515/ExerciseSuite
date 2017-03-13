package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestNull {
	public static void main(String[] args) throws Exception {
		//�������ֵ���ͣ�������NULL��JDBC���ص���0
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement stmt = con
			.prepareStatement("select ename,bonus from emp_ning");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			//�������ֵ���ͣ�������NULL,JDBC����0
			System.out.println(rs.getString(1)+" ");
			System.out.println(rs.getDouble(2)+" ");
			//�ո�ȡ�����Ƿ�Ϊ��
			System.out.println(rs.wasNull());
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
