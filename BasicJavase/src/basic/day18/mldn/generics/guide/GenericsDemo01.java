package basic.day18.mldn.generics.guide;


//��������ʾ����
public class GenericsDemo01 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);//�����Զ�װ�������int->Integer->Object
		p.setY(20);//�����Զ�װ�������int ->Integer->object
		int x = (Integer)p.getX();//ȡ������ʱ�ȱ��Integer��֮���Զ�����
		int y = (Integer)p.getY();
		System.out.println("������ʾ,X���꣺"+x);
		System.out.println("������ʾ��Y���꣺"+y);
	}
}
