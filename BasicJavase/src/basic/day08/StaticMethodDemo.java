package basic.day08;

public class StaticMethodDemo {

	/**
	 	��̬������������ķ���������Ҫ�������ʵ��������ֱ�ӵ��õķ���
	 	�Ǿ�̬�����������ڶ���Ҫʹ�ö�����ã����ҷ����ڲ���this��
	 	�Ե��÷�����ǰ���������
	 */
	public static void main(String[] args) {
		//��̬����û��this��������this.���ñ���
		int x = Goo2.add(2,3);//6,2+3+1=6�����������þ�̬����
		Goo2 goo = new Goo2();//�ö�����÷Ǿ�̬����
		//���÷Ǿ�̬���������ǰ�add(goo,5),��goo��ֵ
		//��add(/*Goo2 this*/int a)��Goo2 this����5��ֵ��add(/*Goo2 this*/int a)��int a
		int y = goo.add(5);//6,1+5=6,add(goo,5);goo�����������ݸ�this!
	}

}
class Goo2{
	int a =1;
	static int b = 1;
	public static int add(int a,int b){//��̬��������ķ���
//		return add(1);//�����������this����̬��û��this.
//		return this.add(1,2);//���������Ϊ��̬��û��this
		return a+b+Goo2.b;
	}
	public int add(/*Goo2 this*/int a){//�Ǿ�̬����������ķ���
		return this.a+a;
	}
}