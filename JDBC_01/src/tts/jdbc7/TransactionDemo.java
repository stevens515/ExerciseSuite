package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �޸�Ա��1001��нˮΪ20000
 * ��������
 */
public class TransactionDemo {
	public static void main(String[] args) {
		try{
			updateSalary(1001,20000);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//�޸�Ա������ĳ��Ա����нˮΪָ��ֵ��ͬʱ��¼��־
	public static void updateSalary(int empno,double salary) 
																									throws SQLException {
			//String sql1 = "update emp_xxx set salary = "+salary+"where empno="+empno;
//			String sql2 = "insert into logs_xxx"+"values(" +
//																"	mysql_log_xxx.nextval"+"user,sysdate,'update salay')";
			Connection conn = ConnectionUtils.getConnection();
			String na = "lu";
			String sql2 = "insert into t_student(name) values(?)";
			PreparedStatement stmt =null;
			try{
				//1.��JDBC���Զ��ύ�ر�
				conn.setAutoCommit(false);
				stmt  = conn.prepareStatement(sql2);
				//2.ִ��sql
				stmt.setString(1, na);
				int n1 = stmt.executeUpdate();
				System.out.println("n1="+n1);
				na ="jia";
				stmt.setString(1, na);
				int n2 = stmt.executeUpdate();
				System.out.println("n2="+n2);
				//3�����ִ�гɹ��ˣ��ύ���������
				if(n1==1&&n2==3){//n1=1:нˮ���ɹ��޸ģ�n2=1���ɹ�����һ����־��¼
					conn.commit();
				}else{
					conn.rollback();
				}
				//4�ָ�Ĭ��ֵ
				conn.setAutoCommit(true);
			}catch(Exception e){
				System.out.println("SQL���������쳣��");
				conn.rollback();
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
	}
}
