package basic.day18.mldn.generics.guide;


//ʹ��С����ʾ����
public class GenericsDemo02 {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10.5f);//�����Զ�װ�������float->Integer->Object
		p.setY(20.6f);
		float x = (Float)p.getX();//ȡ������ʱ�ȱ��Float��֮���Զ�����
		float y = (Float)p.getY();
		System.out.println("������ʾ,X���꣺"+x);
		System.out.println("������ʾ��Y���꣺"+y);
	}
}
