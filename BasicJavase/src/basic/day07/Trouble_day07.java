package basic.day07;

/**�����Ƕ�̬�󶨵�������ķ����ϣ������ڼ䰴�����ͼ�飡���������а��������ķ���*/
public class Trouble_day07{
	public static void main(String[] args) {
//		Goo1 g=new Goo1();
//		Hoo h=(Hoo)g;//���д��������ڼ䰴����ķ�����顣g�Ǹ����ͣ�����������ת��java.lang.ClassCastException
		Hoo h = new Hoo();	
		Goo1 g=h;
		System.out.println(h.age);//20
		System.out.println(g.age);//10
		h.f();//20
		g.f();//20
//		System.out.println(h.f());
//		System.out.println(g.f());
		//Hoo h=g;//������󣬱����ڼ䰴�����ͼ�飡eclipse�����Զ������������ʱ�͸���ʾ��
		
		//Hoo h = new Hoo();
		//Goo1 g = h;
		//System.out.println(g.age);//10, С���Ϳ�����������ת
	}
}
class Goo1{
	int age=10;
	public void f(){
		System.out.println(this.age);
		
	}
}
class Hoo extends Goo1{
	int age=20;
	public void f(){
		System.out.println(this.age);
	}
}
