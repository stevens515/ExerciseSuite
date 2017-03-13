package com.tarena.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * Ϊ�˶�ȡdao�����ļ�
 * 
 * @author soft01
 * 
 */
public class ConfigUtil implements Serializable {
	private static final long serialVersionUID = 2052132455163489640L;
	private static Properties table = new Properties();

	static {
		try {
			// ͨ����������ȡdao.properties�����ļ�
			table.load(ConfigUtil.class.getResourceAsStream("jdbcdao.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * ͨ��key�ҵ�value
	 * 
	 * @param key
	 *            �����ļ���key
	 * @return ����һ���ַ������͵�value
	 */
	public static String getValue(String key) {
		return table.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(getValue("UserDAO"));
	}
}
