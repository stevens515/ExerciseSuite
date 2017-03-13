package tts.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPreparedStatement {
  public static void main(String[] args) throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection(
        "jdbc:oracle:thin:@192.168.0.26:1521:tarena", "openlab", "open123");
    String username = "a";
    String password = "c' or 'b'='b";
    // Statement stmt = con.createStatement();
    // ResultSet rs = stmt
    // .executeQuery("select count(*) from tts_user where username='"
    // + username + "'");

    // PreparedStatement��װ�˺���Ԥ���������SQL���
    // �������Ԥ���������,�ſ�������
    PreparedStatement stmt = con
        .prepareStatement("select count(*) from tts_user "
            + "where username=? and password =?");
    // ��������Ԥ�������
    // ��һ������ʾ���õڼ���Ԥ�������(�ʺ�)
    // �ڶ�������ʾ���õ�ֵ
    // ʹ�õ����ͱ����Ҫ���õĲ�����Ӧ���е�����ƥ��
    stmt.setString(1, username);
    stmt.setString(2, password);
    		//ResultSet executeQuery()throws SQLException
    		// �ڴ� PreparedStatement ������ִ�� SQL ��ѯ�������ظò�ѯ���ɵ� ResultSet ���� 
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      System.out.println(rs.getInt(1));
    }

    rs.close();
    stmt.close();
    con.close();

  }
}


