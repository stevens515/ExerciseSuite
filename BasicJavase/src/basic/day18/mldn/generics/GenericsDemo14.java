package basic.day18.mldn.generics;
/**
 * ʹ�÷��ͽӿڵ�����
 *��Info5.java�����
 */
public class GenericsDemo14 {
	public static void main(String[] args) {
		Info5<String> i = null;//����ӿڶ���ָ������
		i=new InfoImpl2("���˻�");//ͨ������ʵ�����˶��󣬲���ָ������
		System.out.println("����"+i.getVar());
	}
}
