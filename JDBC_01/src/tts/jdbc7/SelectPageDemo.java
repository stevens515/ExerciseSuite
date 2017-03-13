package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*���ڲ�ѯ�ķ�ҳ����
	1��ÿ��ֻ�����ݿ�Ҫ��һҳ����������
2������ÿҳ10��(pageSize=10)
	��1ҳ��1��10
	�ڶ�ҳ��11��20
	������
	��nҳ��������(n-1)*pageSize+1------>[�յ�]���+pageSize-1
3���ص㣺Ƶ�������ݿ���ʡ��ڴ�ȡ���ݵ�ʱ����
					�Ƚ��ʺϴ�������
					���ڴ�ѹ��С
 */
/**
  		�����Է�����������ͼ�����У�
 				SQL>select * from (select id,rownum rn from mytemp_xxx)
 										where rn between 21 and 30;
 				----�����ϵȼ���
 				SQL>create view myview
 							as
 							select id,rownum rn from mytemp_xxx;
 				SQL>select * from myview;
 */
public class SelectPageDemo {
		public static void main(String[] args) {
			getPage(10,8);//71--80
		}
		/**
		 * ����ÿҳ��¼����Ҫ�鿴��ҳ������ʾ����
		 * @param pageSize		ÿҳ������
		 * @param page		Ҫ�����ǵڼ�ҳ
		 */
		public static void getPage(int pageSize,int page){
			int begin = (page-1)*pageSize+1;
			int end = begin+pageSize-1;
			String sql ="select id from (" +
					"select id,rownum rn from mytemp_xxx) " +
					"where rn between ? and ?";
	
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectionUtils.close(rs);
			ConnectionUtils.close(stmt);
			ConnectionUtils.close(conn);
		}
	}
}
