package basic.day18.mldn.generics;
/**
 *���͵�Ƕ������ 
 */
public class GenericsDemo19 {
	public static void main(String[] args) {
		Demo2<Info8<String,Integer>> d = null;//��Info8��ΪDemo2�ķ�������
		Info8<String,Integer> i = null;//InfoҪָ��������������
		i = new Info8<String,Integer>("�ֶ���",20);
		d = new Demo2<Info8<String,Integer>>(i);//��Demo��������Info�����
		System.out.println("����һ��"+d.getInfo().getVar());
		System.out.println("���ݶ���"+d.getInfo().getValue());
	}
}
class Info8<T,V>{//ָ��������������
	private T var;//��һ����������
	private V value;//��һ����������
	
	public Info8(T var,V value) {//ͨ�����췽������
		this.setVar(var);
		this.setValue(value);
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public T getVar() {
		return var;
	}
	public void setVar(T var) {
		this.var = var;
	}
}
class Demo2<S>{
	private S info;

	public Demo2(S info) {
		this.setInfo(info);
	}

	public S getInfo() {
		return info;
	}

	public void setInfo(S info) {
		this.info = info;
	}
	
}