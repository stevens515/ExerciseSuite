package basic.day14;

import basic.day14.Foo.Koo;

public class StaticInnerClassDemo {

	public static void main(String[] args) {
		Koo koo = new Koo();
		System.out.println(koo.add());
	}
}
class Foo{
	int a = 1 ;
	static int b = 5;
	//��̬�ڲ�����Է����ⲿ��ľ�̬��Ա
	static class Koo{//��̬�ڲ���
		//��̬�ڲ��಻���Է����ڲ��Ǿ�̬��Ա
		int b = 1;
		public int add(){
			//return a+b;//�������û��a.Cannot make a static reference to the non-static field a 
			return Foo.b+b;
		}
	}
}