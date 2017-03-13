package com.tarena.elts.util;

/**
 * 7. ϵͳ�����ļ��ļ���
 	1) Properties ��̳���Hashtable ��һ��ɢ�б�.
 	2) Properties �ṩ��load�������Խ� client.properties �ļ���ȡΪɢ�б����, ��෽��
 	3) Properties �ṩɢ�б���ҷ��� getProperty(key) ��ȡkey��Ӧ��valueֵ.
 	4) ����Config ���װProperties ���������ļ��Ķ�ȡ:
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Config��ȡϵͳ�������ļ�
public class Config {
	private Properties table = new Properties();

	public Config(String file) {
		try {
			//load�������Խ� client.properties �ļ���ȡΪɢ�б����, ��෽��
			table.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getInt(String key) {
		//ɢ�б���ҷ��� getProperty(key) ��ȡkey��Ӧ��valueֵ.
		return Integer.parseInt(table.getProperty(key));
	}

	public String getString(String key) {
		return table.getProperty(key);
	}

	public double getDouble(String key) {
		return Double.parseDouble(table.getProperty(key));
	}
}
