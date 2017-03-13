package tts.jdbc7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
  ���ڻ���ķ�ҳ����
 		1��һ���԰�����ȫ��ȡ�������ڻ����У������û�Ҫ����ҳ��(page)��ÿҳ��¼��(pageSize),
 					�������Щ���������ʾ��
 		2������ÿҳ10��(pageSize=10)
 				��1ҳ��1��10
 				�ڶ�ҳ��11��20
 				������
 				��nҳ��������(n-1)*pageSize+1------>[�յ�]���+pageSize-1
 		3)�ص㣺
 			ֻ�������ݿ�һ�Σ���һ��ȡ���Ƚ������Ժ�ÿҳ���ӻ�����ȡ���ȽϿ�
 			�Ƚ��ʺ�С������������������󣬶��ڴ�ѹ���Ƚϴ�
 			һ���Խ����ݿ����ݶ���������ÿ�β鿴ָ����ҳʱ��Ҫ��������ָ���ܹ�
 		����ָ�����У���ָ���ܹ������������������һλ�á�
 */
public class BufferPageDemo {
		public static void main(String[] args) {
			//�ӵ�3ҳ��ʼ����ӡ10����¼
			getPage(10,"3");
//			getPage(10,3);//21��30
		}
		/**
		 * ��ӡָ��ҳ�����ݣ���mytemp_xxx��������
		 * begin:�ڽ�����е�pageҳ�ļ�¼���
		 * 	begin=(page-1)pageSize+1;
		 * @param pageSize	ÿҳ���ټ�¼
		 * @param page		�ڼ�ҳ
		 */
		public static void getPage(int pageSize,String strPage){
			int page=1;
			
			//��ֹ�û����벻�Ϸ��ַ���Ϊҳ����ǿ��ת����һҳ
			try{
				page= Integer.parseInt(strPage);
			}catch(NumberFormatException e){
				page=1;
			}
			//��ֹ�û�����ҳ���������ֵ
			int totalPage=getTotalPage(pageSize);//��ȡ��ҳ��
			if(page>totalPage){
				//���û����볬�����ҳ������ӡ���һҳ
				page = totalPage;
			}
			//��ֹ�û����븺��,ת����һҳ
			if(page<1){
				page=1;
			}
			//�ڽ�����У���pageҳ�ļ�¼���
			int begin = (page-1)*pageSize+1;
			
			String sql = "select * from mytemp_xxx";
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			
			try{
				//Լ������������ͺͲ�����
				stmt = conn.createStatement(
						//1)��������Ϊ�ɹ����Ľ����(��������	)
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						//2)���ò�����Ϊ�����û�ֻ��
						ResultSet.CONCUR_READ_ONLY
				);
				//�����Ϊ�ɹ����ģ��ɽ��з�ҳ����
				rs = stmt.executeQuery(sql);
				
				//ָ������������е����begin
				rs.absolute(begin);
				//ѭ��pageSize�Σ�ȡ���ݲ���ӡ
				for(int i=0;i<pageSize;i++){
					System.out.println(rs.getInt("id"));
					if(!rs.next()){
						break;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(rs);
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}
		/**
		 * ��ñ�õ���ҳ��TotalPage
		 * ����ÿҳ�ļ�¼�������㹲����ҳ
		 * @param pageSize ÿҳ������
		 * @return			��ҳ��
		 */
		private static int getTotalPage(int pageSize){
			int totalTableCount=0;//�ܼ�¼����105��
			totalTableCount = getTotalTableCount();
			int totalPage = 0;
			int mode = totalTableCount%pageSize;
			if(mode==0){//�պó�����
				totalPage=totalTableCount/pageSize;
			}else{//û�г�������1ҳ
				totalPage = totalTableCount/pageSize+1;
			}
			return totalPage;
		}
		/**
		 * 	��ñ���ܼ�¼��TotalTableCount
		 * @return		����ܼ�¼��
		 */
		private static int getTotalTableCount(){
			int count = 0;
			String sql = "select count(*) num from mytemp_xxx";
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt  = null;
			ResultSet rs = null;
			try{
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next();
				count = rs.getInt("num");//ȡ�ý�����ĵ�1 ��
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
			return count;
		}
		
}
/*		public static void getPage(int pageSize,int page){

			//�ڽ�����У���pageҳ�ļ�¼���
			int begin=(page-1)*pageSize+1;
			String sql = "select* from mytemp_xxx";
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			try{
				//Լ������������ͺͲ�����
				stmt = conn.createStatement(
						//1����������Ϊ�ɹ����Ľ�������������ģ�
				ResultSet.TYPE_SCROLL_INSENSITIVE,
						//2)���ò�����Ϊ�����û�ֻ��
				ResultSet.CONCUR_READ_ONLY
				);
				//�����Ϊ�ɹ����ģ��ɽ��з�ҳ����
				rs = stmt.executeQuery(sql);
				*//**ע����ʾ1 ֻ�ǲ��Խ������ָ���λ�ã��������ڷ�ҳ��Ч����ʾ2������*//*
				��ʾ1
				//1)��λ������λ�� 
				rs.absolute(85);//85
				System.out.println(rs.getInt("id"));
				//2)��λ������λ��
				rs.relative(5);//90
				System.out.println(rs.getInt("id"));
				//3)��һ��
				rs.next();//91
				System.out.println(rs.getInt("id"));
				//4)ǰһ��
				rs.previous();//90
				System.out.println(rs.getInt("id"));
				//5) �쳣��������ľ�
				rs.absolute(106);//��105������
//				System.out.println(rs.getInt("id"));
				System.out.println("#########################");
				
				��ʾ 2
				//ָ������������е����begin
				rs.absolute(begin);
				//ѭ��pageSize�Σ�ȡ���ݲ���ӡ
				for(int i=0;i<pageSize;i++){
					System.out.println(rs.getInt("id"));
					if(!rs.next()){
						break;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(rs);
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}*/

