package tts.jdbc7;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTableData {
		public static void main(String[] args) {
//			getData("emp");
			getData("users_ning");
		}
		public static void getData(String tablename){
			String sql = "select * from "+tablename	;
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			try{
				//���ݿ��Ԫ����
				DatabaseMetaData dmd = conn.getMetaData();
				//���ݿ���
				System.out.println(dmd.getDatabaseProductName());
				//���ݿ�汾��
				System.out.println(dmd.getDatabaseMajorVersion());
				//�����ַ���
				System.out.println(dmd.getURL());
				//�û���
				System.out.println(dmd.getUserName());
				
				//��ʾ2�������Ԫ����
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();//��ȡ�������Ԫ����
				int columnCount = rsmd.getColumnCount();//��ȡ����
				
				for(int i=1;i<=columnCount;i++){
					System.out.println(rsmd.getColumnName(i)+" ");
				}
				System.out.println();
				System.out.println("-------------------------");
				while(rs.next()){
					//ע��:JDBC�ļ�����1��ʼ 
					for(int i=1;i<=columnCount;i++){
						String value = rs.getString(rsmd.getColumnName(i));
						System.out.println(value+"\t");
					}
					System.out.println();
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(rs);
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}
}
