package com.tarena.elts.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		// Properties�̳���Hashtable
		// PropertiesҲ��ɢ�б�key:value ����Stringɢ�б�
		Properties cfg = new Properties();
		// ��roperties��ʽ���ı��ļ�����ȡΪɢ�б�
		// load���Խ�һ���ļ��򿪣���һ���ļ���
		cfg.load(new FileInputStream("client.properties"));// ��ȡ�����ļ�
		System.out.println(cfg);
		// getProperty��ɢ�б�����key����value.����ֵ���ַ�������
		String filename = cfg.getProperty("UserFile");
		System.out.println(filename);// user.txt
	}
}
