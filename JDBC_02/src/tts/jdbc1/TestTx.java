package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestTx {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		//�����Զ��ύfalse(Ĭ����true)
		con.setAutoCommit(false);
		PreparedStatement stmt = con
			.prepareStatement("insert into tts_foo (value) "+"values(?)");
		
		try{
			stmt.setInt(1, 5000);
			stmt.executeUpdate();
			
			if(true){
				throw new Exception();
			}
			
			stmt.setInt(1, 6000);
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			con.rollback();
		}
		//�ύ����
		con.commit();
		stmt.close();
		con.close();
	}
}
