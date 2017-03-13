package tts.jdbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloWorld {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {
    // ��JDBC��API������Oracle
    // 192.168.0.26 openlab/open123
    // �����ؼ�API
    Connection con = null; // ���ڷ�װ�����ݿ���������
    Statement stmt = null; // ���ڷ�װ����ִ�е�SQL���
    ResultSet rs = null; // ���ڷ�װSQLִ�����Ĳ�ѯ���
    // װ��Oracle��JDBC API��ʵ��

    // ��oracle.jdbc.OracleDriverװ���ڴ�
    // OracleDriver��static���漴����
    // static���еĴ������DriverManagerע��Oracle������(��OracleDriver)����
    // ����JDBC��ͨ�����������ҵ�JDBC API����Ӧʵ��
    Class.forName("oracle.jdbc.OracleDriver");
    // MySQL: com.mysql.jdbc.Driver
    // ���Oracle��ӦConnection�ӿڵ�ʵ��
    System.out.println(con);
    con = DriverManager.getConnection(
        "jdbc:oracle:thin:@192.168.0.26:1521:tarena", "openlab", "open123");
    // jdbc:mysql://ip:port/databaseName
    System.out.println(con);

    stmt = con.createStatement();
    System.out.println(stmt);
    // ִ��һ����ѯ���,����ֵ��ReslutSet
    rs = stmt.executeQuery("select empno, ename, salary from emp_ning");

    // ������rs�ķ�����ȡ��ѯ�Ľ��
    while (rs.next()) {
      int empno = rs.getInt(1);
      String ename = rs.getString(2);
      double sal = rs.getDouble(3);
      System.out.println(empno + "," + ename + "," + sal);
    }

    // �ͷ���Դ
    rs.close();
    stmt.close();
    con.close();

  }

}
