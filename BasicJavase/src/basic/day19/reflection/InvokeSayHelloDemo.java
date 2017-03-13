package basic.day19.reflection;

import java.lang.reflect.Method;

/**����߼�
 * ��ʾһ���򷽷��д��ݲ�����ʵ�����Ե���Person3���sayHello(String naem,int age)����Ϊ�����˷�����Ҫ��������
 */
public class InvokeSayHelloDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Method met = c1.getMethod("sayHello", String.class,int.class);//�˷�����Ҫ��������
			String rv =null;//���շ����ķ���ֵ
			//���÷��������봫�ݶ���ʵ����ͬʱ������������ֵ
			rv = (String) met.invoke(c1.newInstance(), "�ֶ���",21);
			System.out.println(rv);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
