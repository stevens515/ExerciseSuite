package tts.jdbc4;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		System.out.println(con);
		PreparedStatement stmt = con.prepareStatement("delect from tts_user where username=?");
		stmt.setString(1, "name1");
		//����ֵ��ʾִ�е������Ӱ�������
		int rows = stmt.executeUpdate();
		System.out.println("rows="+rows);
		stmt.close();
		con.close();
	}
}
