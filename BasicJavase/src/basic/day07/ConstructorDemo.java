package basic.day07;

/**
	A ��һ���й�����
	B ���಻�ܼ̳и��๹����
	C ����һ�����ø��๹����
		Ĭ�ϵ��ø������޲���������
		��ʹ��super()���ø��๹����
	D �����⣺
		����Ĭ�ϵ��ø��๹���������������Call Xoo(),�����Call Yoo()
		���ø�����޲�������������javacĬ���Զ���ӵ�
	F ��̽��飺�����඼�ṩ�޲���������!����̳�������Ĭ�ϵ���!
*/
public class ConstructorDemo {

	public static void main(String[] args) {
//		Goo goo = new Goo(1);//������󣬹��������ܼ̳С�
		Goo goo = new Goo();//���Ǽ̳еģ�new Goo()���õ�������Ĭ�Ϲ�����
		Yoo yoo = new Yoo();//���๹����Ĭ�ϵ��ø��๹������
		new B();//ѡD
		//ѡ����������A ����� B �����쳣 C �� D.A
		/**�����
	 	A
		basic.day07.B@1fb8ee3
		 */
	System.out.println(new B());
	}

}
class A{
	public A(){
		System.out.println("A");
	}
}
class B extends A{
	
}
class Noo{
	public Noo(int a){}//�������
}
class Moo extends Noo{//�������û�а취Ĭ�ϵ��ø����޲���������
	public Moo(){
		super(5);//ʹ��super(int),���ø����в���������
	}
	public Moo(int x){
		this();//�����this()��javac�Ͳ����super()
		//ͨ��this()����Moo()��Moo()������Ҳ���õĸ��๹����
	}
}
class Xoo{
	public Xoo(){
		System.out.println("Call Xoo()");
	}
}
class Yoo extends Xoo{
	public Yoo(){
		//super()��������ڴ���ĵ�һ�У�
		super();//���ø�����޲�������������javacĬ���Զ���ӵ�
		System.out.println("Call Yoo()");
		}
}
class Foo{
	int a;
	public Foo(){
	}
	public Foo(int a){
		this.a = a;
	}
}
class Goo extends Foo{
	
}
