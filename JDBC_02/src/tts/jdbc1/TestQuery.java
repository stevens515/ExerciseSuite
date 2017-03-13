package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ��ҳ��ѯ������
 */
public class TestQuery {
	private static final String sql = "select value from " +
			"(select value,rownum n from tts_foo " +
			"where rownum<?) where n>=?";
	//��order by �ķ�ҳ��ѯ
/*	select ename
	from(select ename rownum n from 
			(select ename,sal
					from emp order by ename) where rownum<20)
	where n>=10*/
	
	//MYSQL�ķ�ҳ��ѯ
	//��һ������Ϊ��ʼȡ�ļ�¼���(��0��ʼ)
	//�ڶ�������Ϊһ��ȡ�ļ�¼��
//	MySql���ݿⷽ��(a,b)���ӵ�a����ʼ��ȡ��b��
//	select ename from emp order by ename limit 10,10
	public static void main(String[] args) throws Exception{
		Connection con = ConnectionUtils.getConnection();
		//�ֲ���ѯ������
		PreparedStatement stmt = con.prepareStatement(sql);
		//��ȡ��90000��90000+10֮�����ʮ����¼
		stmt.setInt(1, 90000+10);
		stmt.setInt(2, 90000);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getInt(1));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
