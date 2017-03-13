package tts.jdbc1;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestMeta {
	//���ԭ����
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement stmt = 
			con.prepareStatement("select * from emp");
		ResultSet rs = stmt.executeQuery();//    �ڴ� PreparedStatement ������ִ�� SQL ��ѯ�������ظò�ѯ���ɵ� ResultSet ����
		
		//��ȡԪ����(�����е���Ϣ)
		//ResultSetMetaData getMetaData() throws SQLException
        //��ȡ�� ResultSet ������еı�š����ͺ����ԡ�
		ResultSetMetaData rsmd = rs.getMetaData();
			
		//���ش� ResultSet �����е�������
		for(int i=1;i<rsmd.getColumnCount();i++){
			//����ָ���е�����
			System.out.println(rsmd.getColumnName(i)+"");
			//����ָ���е����͵�����
			System.out.println(rsmd.getColumnTypeName(i));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
