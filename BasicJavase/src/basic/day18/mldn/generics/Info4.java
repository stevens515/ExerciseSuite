package basic.day18.mldn.generics;
/**
 * �������෽ʽ1����������Ķ�����������������
 * ��GenericsDemo13.java�����
 */
interface Info4<T> {//�ڽӿ��϶��巺�� 
	public T getVar();
}
class InfoImpl<T> implements Info4<T>{//���巺�ͽӿڵ�����
	private T var;
	
	public InfoImpl(T var){
		this.setVar(var);
	}
	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
}