package com.tarena.elts.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 *public class Properties extends Hashtable<Object,Object>
 *Properties ���ʾ��һ���־õ����Լ���Properties �ɱ��������л�����м��ء������б���ÿ���������Ӧֵ����һ���ַ�����
 *һ�������б�ɰ�����һ�������б���Ϊ���ġ�Ĭ��ֵ�������δ����ԭ�е������б������������Լ����������ڶ��������б� 
 *String getProperty(String key) ��ָ���ļ��ڴ������б�����������
 *void load(InputStream inStream) ���������ж�ȡ�����б�����Ԫ�ضԣ���
 *void load(Reader reader) ���򵥵������еĸ�ʽ�������ַ����ж�ȡ�����б�����Ԫ�ضԣ�
 */
public class ConnectionUtils {
  // ��������
  private static String driver;
  private static String url;
  private static String username;
  private static String password;

  static {
    try {
      // �������ʱ��ʼ����������
      Properties props = new Properties();
      // ͨ���ļ����������ļ�����Ϣ
      // ���뵽Properties������
      InputStream is = ConnectionUtils.class
        .getClassLoader()
        .getResourceAsStream("db.properties");
        
        props.load(is);
      
      driver = props.getProperty("driver");
      url = props.getProperty("url");
      username = props.getProperty("username");
      password = props.getProperty("password");

      Class.forName(driver);

    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public static Connection getConnection() throws Exception {
    Connection con = DriverManager
      .getConnection(url, username, password);
    return con;
  }
}
