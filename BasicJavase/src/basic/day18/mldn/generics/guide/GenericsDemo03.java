package basic.day18.mldn.generics.guide;


//ʹ���ַ�����ʾ����
public class GenericsDemo03 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX("����180��");//String->Object
		p.setY("��γ210��");
		String x = (String)p.getX();//ȡ������
		String y = (String)p.getY();
		System.out.println("������ʾ,X���꣺"+x);
		System.out.println("������ʾ��Y���꣺"+y);
	}
}
