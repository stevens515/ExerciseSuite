package basic.day01;

public class FloatDemo {

	/**
	 * float
	 */
	public static void main(String[] args) {
		//floatû��int���ȸ�
		int max = 0x7fffffff;
		int i  = 0x7ffffff0;
		float f1 = max;
		float f2 = i;
		System.out.println(f1);//2.14748365E9
		System.out.println(f2);//2.14748365E9
		System.out.println(f2==f1);//true
		
		//double,β��52��ָ��11������λ1λ����64λ��
		double x = 0.5;
		//float y = 0.5;//�������
		float y = 0.5f;
		//1 1.0 1D 1L 1f
		//���������㲻��ȷ
		x = 3.6;
		double d = x -3D;
		System.out.println(d);//0.6000000000000001iannianjniannianniannian 
		
		System.out.println(Math.pow(2, 15));
	}

}
