package basic.day06;

public class ConstructorDemo {

	/**
	 * A ��һ���й�����
	 * B ���û���ṩ��������javacĬ�����Ĭ�Ϲ�����
	 * C ��������˹�������javac�Ͳ�������κι�����
	 */
	public static void main(String[] args) {
		Foo foo = new Foo();//���ú�ҹ������
//		Koo koo = new Koo();//�������û�й�����Koo();
		Koo k2 = new Koo(1);//�й�������Koo��int)
//		System.out.println(koo.a);//�������
	}
}
class Foo{
	//public Foo(){}
}
class Koo{
	int a ;
	public Koo(int a){
		this.a = a;
	}
}
