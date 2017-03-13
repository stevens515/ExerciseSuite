package basic.day18.mldn.generics;
/**
 * ʹ�÷��� ͳһ����Ĳ�������
 * add()������info����ķ������ͱ���һ�¡�
 */
class Info7<T>{	//�˴�����ֻ������������
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	@Override
	public String toString() {
		return this.var.toString();
	}
}
public class GenericsDemo17 {
	public static void main(String[] args) {
		Info7<String> i1 = new Info7<String>();//����StringΪ��������
		Info7<String> i2 = new Info7<String>();
		i1.setVar("HELLO");//��������
		i2.setVar("�ֶ���");
		add(i1,i2);
	}
	public static <T> void add(Info7<T> i1,Info7<T> i2){
		System.out.println(i1.getVar()+" "+i2.getVar());
	}
}
