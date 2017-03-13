package basic.day19.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * ���Ҫ��ɶ�̬�������ȶ���һ��InvocationHandler�ӿڵ����࣬����ɴ���ľ������
 * ��MyInvocationHandler���bind()�����н��ܱ�����������ʵ����ʵ�֣�֮��дInvocationHandler�ӿ��е�
 * invoke()��������ɾ���ķ������� 
 */
public class MyInvocationHandler implements InvocationHandler {
	private Object obj;//��ʵ����
	public Object bind(Object obj){//����ʵ��������
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().
				getClassLoader(),obj.getClass().getInterfaces(),this);//ȡ�ô������
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {//��̬���÷���
		Object temp = method.invoke(this.obj, args);//���÷�����������ʵ����Ͳ���
		return temp;//���ط����ķ�����Ϣ
	}
	
}
