package basic.day18.mldn.generics;
/**
 * �������෽ʽ2---ֱ���ڽӿ���ָ����������
 * ��GenericsDemo14.java�����
 */
interface Info5<T> {
	public T getVar();
}
class InfoImpl2 implements Info5<String>{
	private String var;
	public InfoImpl2(String var){
		this.setVar(var);
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
}