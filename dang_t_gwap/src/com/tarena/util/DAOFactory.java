package com.tarena.util;

import java.io.Serializable;

/**
 * ������
 * 
 * @author soft01
 * 
 */
public class DAOFactory implements Serializable {
	private static final long serialVersionUID = -396116908068638655L;

	/**
	 * ���ݴ�����������Ϊ�˶��󴴽�ʵ��
	 * 
	 * @param type
	 *            ���������
	 * @return ���ص���һ��ʵ������
	 */
	public static Object getInstance(String type) {
		Object obj = null;
		// ���ݴ�������ʹ������ļ���ȡvalue
		String className = ConfigUtil.getValue(type);
		try {
			// Ϊ��valueҲ������������ʵ��
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return obj;
	}
}
