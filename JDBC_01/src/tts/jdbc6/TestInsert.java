package tts.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {
  public static void main(String[] args) throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager
            .getConnection("jdbc:oracle:thin:@192.168.0.26:1521:tarena",
             "openlab", "open123");
    PreparedStatement stmt = 
        con.prepareStatement("insert into " +
        		" tts_user(username, password) " +
        		"values (?,?)");
    stmt.setString(1,"name_1");
    stmt.setString(2, "pwd_1");
    // ����ֵ��ʾִ�е������Ӱ�������
    int rows = stmt.executeUpdate();
    System.out.println("rows="+rows);
    
    stmt.close();
    con.close();
  }
}


