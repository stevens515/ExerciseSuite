package tarena.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory 
	implements InvocationHandler{
	private Object target;
	/**
	 * ����Ŀ���������һ���������
	 * @param target Ŀ�����
	 * @return �������
	 */
	public Object getProxy(Object target){
		this.target = target;
		//newProxyInstance������Ŀ�����������·������ǰ�ӿڣ�InvocationHandler��ʵ��
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				this);//this����InvocationHandler��ʵ��invode����
	}
	//����ص�����
	//��ͨ���������ִ��ҵ�񷽷�ʱ,���Զ����ø÷���
	public Object invoke(Object proxy, 
			Method method, Object[] args) throws Throwable {
		try{
			System.out.println("ǰ��֪ͨ����");
			//����Ŀ����󷽷�
			Object retVal = method.invoke(target, args);
			System.out.println("����֪ͨ����");
			return retVal;
		}catch(Exception ex){
			System.out.println("�쳣֪ͨ����");
			return null;
		}finally{
			System.out.println("����֪ͨ����");
		}
	}
}

//public class $prxoy1 implements Ŀ�����ӿ�{}


