package tarena.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyFactory implements MethodInterceptor{
	private Object target;
	/**
	 * ����Ŀ��������ɴ������
	 * @param target
	 * @return
	 */
	public Object getProxy(Object target){
		this.target = target;
		Enhancer hancer = new Enhancer();
		hancer.setSuperclass(target.getClass());
		hancer.setCallback(this);
		return hancer.create();//�����������
	}
	//��ͨ������������ҵ�񷽷�ʱ,�Զ�ִ�и÷���
	public Object intercept(
			Object proxy, 
			Method method, Object[] params, 
			MethodProxy arg3) throws Throwable {
		System.out.println("ǰ��֪ͨ����");
		//����Ŀ����󷽷�
		Object retVal = method.invoke(target, params);
		System.out.println("����֪ͨ����");
		return retVal;
	}
}
