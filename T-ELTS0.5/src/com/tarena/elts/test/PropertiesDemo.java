package com.tarena.elts.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
  public static void main(String[] args) 
    throws IOException {
    //Properties �̳���Hashtable
    //Properties Ҳ��ɢ�б�, key:value ����Stringɢ�б�
    Properties cfg = new Properties();
    //�� properties ��ʽ���ı��ļ�, ��ȡΪɢ�б�
    cfg.load(new FileInputStream("client.properties"));
    System.out.println(cfg); 
    String filename = cfg.getProperty("UserFile");
    System.out.println(filename);//user.txt
  }

}
