package basic.day18.mldn.generics.guide;


//�쳣
public class GenericsDemo04 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);//�����Զ�װ�������int->Integer->Object
		p.setY("��γ210��");//String->object
		int x = (Integer)p.getX();//ȡ������ʱ
		int y = (Integer)p.getY();//ȡ������ʱ->�˴���������ת������
		System.out.println("������ʾ,X���꣺"+x);
		System.out.println("������ʾ��Y���꣺"+y);
	}
}
