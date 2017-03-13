package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * ��������ϰ
 */
public class BatchDemo {
		public static void main(String[] args) {
			executeSql();
		}
		public static void executeSql(){
			String sql = "insert into mytemp_xxx(id) values(?)";
			Connection conn = ConnectionUtils.getConnection();
			PreparedStatement stmt = null;
			try{
				//�ر��Զ�Ĭ���ύ
				conn.setAutoCommit(false);
				stmt=conn.prepareStatement(sql);
				for(int i=1;i<=105;i++){
					stmt.setInt(1, i);
					//1.��sql������������
					stmt.addBatch();
					//2��ÿ10����¼����һ�α��⴦���е�sql���̫�� 
					if(i%10==0){
						//3��ִ��
						stmt.executeBatch();
						//4�����
						stmt.clearBatch();
					}
				}
				//ִ������5��sql
				stmt.executeBatch();
				conn.commit();
			}catch(SQLException e){
				try{
					conn.rollback();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}
}
