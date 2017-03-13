package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties props = 
		new Properties();
	static{
		//��.properites�ļ������ҽ��ļ������ݼ��ص�
		//props�����
		//ClassLoader:�������,����.class�ļ����ص�
		//��������ת���һ��class����
		ClassLoader loader = 
			ConfigUtil.class.getClassLoader();
		System.out.println("loader:" + loader);
		InputStream ips = 
			loader.getResourceAsStream("util/dao.properties");
		try {
			props.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return props.getProperty(key);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getValue("EmployeeDAO"));
	}

}
