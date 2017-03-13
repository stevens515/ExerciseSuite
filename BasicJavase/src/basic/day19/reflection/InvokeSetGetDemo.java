package basic.day19.reflection;

import java.lang.reflect.Method;

/**�ص�
 * ����߼� ͨ��setter��getter���÷�������
 * ������ʵ��˼·��
 * 	1�����÷������ƣ������÷�������ʱ��������ֱ��ʹ�õ����������ƣ�����name��age������ʵ���Ϸ���������setName(),
 * 			getName(),setAge(),getAge(),�����������Ƶ�����ĸ��Ҫ��д������Ϊ�˽�����������⣬��������һ������
 * 			initStr()��ͨ���˷������ַ����е�����ĸ��д������ĸ��д֮��������set��get�ַ������ҵ���Ӧ�ķ�����
 *  2������setter()����ʱ��������ʵ��������Ҫ�������������ƣ��ڷ����лὫ������ĸ��д����Ҫ���õĲ��������Լ������
 * 			 �������ͣ���������Ϊ������getMethod()��invoke()������ʹ��Ҫ��
 * 	3�� �ڵ���getter()����ʱ��Ҳͬ��������ͬһ��ʵ����������Ϊ�䱾����Ҫ�κεĽ��ղ���������ֻ�������������ƣ���
 * 		�����лὫ������ĸ��д�������ڴ˷����н����ݴ�ӡ�����
 * ���ϳ����Ƿ�����÷���ʱ����ҪӦ�ã�����������ԭ��
 */
public class InvokeSetGetDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		Object obj = null;// ��������
		try {
			c1 = Class.forName("basic.day19.reflection.Person3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			obj = c1.newInstance();// ʵ������������
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		setter(obj, "name", "�ֶ���", String.class);// ����setter����
		setter(obj, "age", 30, int.class);// ����setter����
		System.out.print("������");
		getter(obj, "name");
		System.out.print("���䣺");
		getter(obj, "age");
	}

	/**
	 * @param obj�����Ķ���
	 * @param att����������
	 * @param value���õ�ֵ
	 * @param type����������
	 */
	public static void setter(Object obj, String att, Object value,
			Class<?> type) {
		try {
			Method met = obj.getClass().getMethod("set" + initStr(att), type);// ���÷�����������
			met.invoke(obj, value);// ���÷���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getter(Object obj, String att) {// ����getter����
		try {
			Method met = obj.getClass().getMethod("get" + initStr(att));// �˷�������Ҫ����
			System.out.println(met.invoke(obj));// ���շ����ķ���ֵ
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String initStr(String old) {// ��������ĸ��д
		String str = old.substring(0, 1).toUpperCase() + old.substring(1);
		return str;
	}
}
