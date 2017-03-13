package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * ������
 */
public class TestBatch {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		//�����Զ��ύfalse(Ĭ����true)
		con.setAutoCommit(false);
		
		PreparedStatement stmt = con
				.prepareStatement("insert into tts_foo(value"+"values(?)");
		long time = System.currentTimeMillis();
		
		try{
			
			for(int i=90000;i<90000+1000000;i++){
				stmt.setInt(1, i);
				stmt.addBatch();//��һ�������ӵ��� PreparedStatement ����������������С� 
				if(i%100000==0){
					stmt.executeBatch();//��һ�������ύ�����ݿ���ִ�У����ȫ������ִ�гɹ����򷵻ظ��¼�����ɵ����顣
				}
				//ִ�и����� SQL ��䣬��֪ͨ���������ڸ���������ָʾ���Զ����ɵļ�Ӧ�ÿ����ڻ�ȡ��
				//���������Ŀ����е��е���������Ŀ������Ӧ�ÿɻ�ȡ���Զ����ɵļ���
				//stmt.executeUpdate();
			}
			stmt.executeBatch();//���ִ�й�������ݲ���100000�͵����������ִ��
			
			con.commit();
			
			System.out.println(System.currentTimeMillis()-time);
		}catch(Exception e){
			e.printStackTrace();
			con.rollback();
		}
	}
}
