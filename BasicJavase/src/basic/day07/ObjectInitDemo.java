package basic.day07;

public class ObjectInitDemo {

	/**����ʵ��������
	 	1 ��������ࣨKoo.class)�Լ����еĸ����ͣ�ֻ����һ�Σ�
	 	2 �ݹ�������и��๹����������ߵĸ���ִ��A��B��C��
	 		������
	 		A ���丸�����Կռ䣬�Զ���ʼ��ΪĬ��ֵ
	 		B ִ�����Եĳ�ʼ����ֵ
	 		C ִ�и��๹��������
	 	   ������
	 		D �����������Կռ䣬�Զ���ʼ��Ĭ��ֵ
	 		E ִ���������Գ�ʼ����ֵ
	 		F ִ�����๹��������
	 	3 ��󴴽��Ķ�������ʵ�������������и��������������Կռ�
	 	
	 	this �ؼ��֣�
	 		A this() �ڹ������ĵ�һ�У����ñ���Ĺ���������this()�Ͳ���Ĭ���Զ����super()
	 		B this ����ǰ��������ã��������ʵ�ǰ��������ԣ��ͷ���
	 			�磺this.a �Ƿ�������
	 			   this.a()�ǵ��÷�����
	 				����ܹ�����ֲ����������ԣ�ʵ��������������ʡ�Ե�this.
	 	
	 	super �ؼ���:
	 		A super()�ŵ��������ĵ�һ�У����ø��๹������Ĭ���Զ����
	 		B super�������д������Ͷ�������ã������������ʸ����͵�����
	 			�磺super.a ���ʸ�����a����
	 				super.a()���ʸ����͵ķ���
	 				����ܹ�����ǰ�����븸������ԣ��Ϳ���ʡ�Ե�super
	 */
	public static void main(String[] args) {
			
		//�ٿ���û�и����ͣ����м��أ��ݹ���أ�������أ�ֻ����һ��
		K4oo k4oo = new K4oo(10);//����K4oo.class,ͨ��classpath����û�з����쳣
		System.out.println(k4oo.a);//
	}
}
class F4oo{
	int a =1;
	public F4oo(int a){
		super();
		//����ռ�a����ʼ������
		System.out.println("��ʼ������a ="+this.a);//1
		this.a = a;
		System.out.println("ִ��Foo����������a = "+this.a);//8
	}
}
class K4oo extends F4oo{
	int b = 3;
	public K4oo(int b){
		super(8);
		//����ռ�b����ʼ������
		System.out.println("Koo(): a="+this.a);//8,super.aҲ��
		System.out.println("Koo(): b="+this.b);//3
		this.a = b;;
		this.b=b;
		System.out.println("������Koo()���ִ�У�b = "+b);//10
	}
}
