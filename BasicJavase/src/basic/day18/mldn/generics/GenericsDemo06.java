package basic.day18.mldn.generics;

public class GenericsDemo06 {
	public static void main(String[] args) {
		Point5<String> p = new Point5<String>();
		p.setVar("�ֶ���");//�����ַ���
		System.out.println(p.getVar().length());//ȡ���ַ�����
	}
}
