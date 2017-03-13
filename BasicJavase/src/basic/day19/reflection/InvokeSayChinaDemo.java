package basic.day19.reflection;

import java.lang.reflect.Method;

/**����߼�
 *����Person3���е�sayChina()����
 *ͨ������������еķ���
	�����������£�
		1�� ͨ��Class���getMethod(String name,Class...parameterTypes)����ȡ��һ��Method�Ķ���
			�����ô˷�������ʱ����Ҫ�Ĳ�������
		2�� ֮��ſ���ʹ��invoke���е��ã��������д���Ҫ���õĲ���
 */
public class InvokeSayChinaDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;//����Class����
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Method met = c1.getMethod("sayChina");//�ҵ��������˷���û�в���
			met.invoke(c1.newInstance());//���÷��������봫�ݶ���ʵ��
			/**
			 * ����ͨ��Class���getMethod()����ȡ��Method���󣬲�ͨ��invoke����ָ���ķ�����������ʹ��invoke()����ʱ
			 * ���봫��һ�����ʵ����������Ϊ��sayChina()������û���κεĲ��������Դ˴�û�����ò������ͺͲ�������
			 */
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
