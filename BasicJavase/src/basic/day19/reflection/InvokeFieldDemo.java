package basic.day19.reflection;

import java.lang.reflect.Field;

/**
 *ֱ�Ӳ������е�����
 *ͨ���˳�����Է��֣����Ա�֮ǰ��ʹ��setter��getter�����������Դ�����Ӽ򵥣����㡣
 *ע�⣺��������������������Եķ���Ȩ�޺�ֱ�Ӳ������ԣ�������Person���в�����Ҫ��дsetter��getter������
 *�����ڿ����е�������ʱ�� Ҫʹ��setter��getter�����������ڿ���ʱһ��ע�⣬��Ҫֱ�Ӳ������ԣ�
 *����Ҫͨ��setter��getter��������
 */
public class InvokeFieldDemo {
	public static void main(String[] args) throws Exception {
		Class<?>  c1 = null;
		Object obj = null;
		c1 = Class.forName("basic.day19.reflection.Person3");
		obj =  c1.newInstance();//ʵ��������
		Field nameField = null;//��ʾname����
		Field ageField = null;//��ʾage����
		nameField = c1.getDeclaredField("name");//ȡ��name����
		ageField = c1.getDeclaredField("age");
		nameField.setAccessible(true);//��name�������óɿɱ��ⲿ����
		
		nameField.set(obj, "�ֶ���");//����name��������
		ageField.setAccessible(true);//��age�������óɿɱ� �ⲿ����
		
		ageField.set(obj, 21);//����age��������
		System.out.println("����:"+nameField.get(obj));//ͨ��getȡ����������
		System.out.println("���䣺"+ageField.get(obj));
	}
}
