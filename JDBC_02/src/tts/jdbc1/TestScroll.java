package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestScroll {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		//��ҳ��ѯ������
//		preparedStatement stmt = con.prepareStatement("select * from tts_foo");
		
		//�����ɹ����Ľ����
		//CallableStatement prepareCall(String sql):����һ�� CallableStatement �������������ݿ�洢���̡�
		PreparedStatement stmt = con.prepareCall("select* from tts_foo",
				//	TYPE_SCROLL_INSENSITIVE
		        //  �ó���ָʾ�ɹ�����ͨ������ ResultSet �ײ����ݸ���Ӱ��� ResultSet ��������͡�
				//CONCUR_READ_ONLY:�ó���ָʾ�����Ը��µ� ResultSet ����Ĳ���ģʽ��
				ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//����Ĭ�������õĽ����
		//ֻ��next!!!
		ResultSet rs = stmt.executeQuery();
		//rs.next();//�α����
		//rs.previous();//�α���ǰ
		rs.absolute(100);//�α���Զ�λ
		System.out.println(rs.getInt(1));
		
		rs.close();
		stmt.close();
		con.close();
	}
}
