package basic.day08;

import basic.day08.sub.Koo;

/**
  	�������Σ�
 		A ���е�����/����/��ȣ�������ط����ɼ�
 		B ˽�е���Դ������/����/�ֻࣩ���������ڲ��ɷ���
 		C ��������Դ�������࣬��ͬһ����(package)���Է���
 		D Ĭ�ϵģ����ӹؼ��ֵģ���Դ����ͬһpackage�п��Է���
 		E �κη�����Ȩ��ͬһ�����ڲ����Է���
 		
 	��̽��飺
 		A �����ܷ�װ�������ܼ�С��Դ�ķ��ʷ�Χ
 			����private,���protected, ���public.
 		B ����ʹ��Ĭ�Ϸ�����Ȩ������ʹ��package��Ϊ���ʷ�Χ
 		C ������������"��װ"����.
 		D ������˽������,�������Եķ��ʷ���
 		
 	��װ�����󾡿��ܼ��ٶ��Ⱪ¶������
 	
 	javaԴ�ļ��淶:
 		A һ��.java�ļ��п������������
 		B һ��Դ�ļ�ֻ����һ��������,�����ļ���Ҫ�빫��������һ��
 			��:Hello.java �� public class Helloһ��
 		C ���û�й�����,�ļ�������������һ��
 		D һ�����ǹ��е�,�������һ����Ĭ�����ε�!������:
 			��������ֻ���ڵ�ǰ���з���!��������!
 		��̽���:�඼�ǹ��е�,һ���ļ�һ��������!
 */
public class AccessDemo {

	public static void main(String[] args) {
		Foo foo = new Foo();
		System.out.println(foo.a);
		System.out.println(foo.b);
		System.out.println(foo.c);
		/*
		 No enclosing instance of type AccessDemo is accessible.Must qualify the allocation with
		 an enclosing instance of type AccessDemo(e.g.x.new A() where x is an instance of AccessDemo
		 */
//		System.out.println(foo.d);//������󣬷�װ��������d���ǲ��ɼ���
		System.out.println(foo.getD());//4,˵������id����
		
		Koo koo  = new Koo();
		System.out.println(koo.a);//1
//		System.out.println(koo.b);//�����b���ɼ���The field Koo.b not visible.
//		System.out.println(koo.c);//��������ɼ�The field Koo.c not visible.
//		System.out.println(koo.d);//��������ɼ�The field Koo.d not visible.
		System.out.println(koo.getD());//���з���
		Goo goo = new Goo();
		goo.test();
	}
}
class Goo extends Koo{
	public void test(){
		System.out.println(this.a);//���У����Ķ��ɼ�
		System.out.println(this.b);//����������ɿ���
//		System.out.println(this.c);//Ĭ�ϣ����಻�ɼ�
//		System.out.println(this.d);//˽�У����಻�ɼ�
		System.out.println(this.getD());//4
	}
}
class Foo{
	public int a = 1;//���е�
	protected int b = 2;//������
	int c = 3;//Ĭ�ϵ�
	private int d = 4;//˽�е�
	public int getD(){
		return d;
	}
}

