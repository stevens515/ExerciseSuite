package basic.day14;

import basic.day14.Goo.Koo;

public class InnerClassDemo {
	public static void main(String[] args) {
		Goo g1 = new Goo();
		// Koo koo = new Koo();//������󣬱��봴��Gooʵ��������ʵ������
		Koo koo1 = g1.new Koo();
		Koo koo2 = g1.new Koo();
		koo1.test();
		koo2.test();
		// �����Ա�ڲ��๲��ͬһ���ⲿ��ʵ�������ԣ�
		// �磺koo1��koo2����ͬһ��g1���������
		Goo g2 = new Goo();
		g2.a = 8;
		Koo k1 = g2.new Koo();
		Koo k2 = g2.new Koo();
		k1.test();
		k2.test();
	}
}

class Goo {
	int a = 1;

	class Koo {// ��Ա�ڲ��࣬����staticΪ��Ա�ڲ��࣬��static�Ǿ�̬�ڲ���
		public void test() {
			System.out.println(a);
		}
	}
}