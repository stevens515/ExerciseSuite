package basic.day18.mldn.generics;
/**
 * �������෽ʽ1����ʹ�÷��ͽӿڵ�����
 * ��Info4.java�����
 */
public class GenericsDemo13 {
	public static void main(String[] args) {
		Info4<String> i  = null; //����ӿڶ���
		i  = new InfoImpl<String>("�ֶ���");//ͨ������ʵ�����˶���
		System.out.println("���ݣ�"+i.getVar());
	}
}
