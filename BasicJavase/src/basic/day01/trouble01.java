package basic.day01;

public class trouble01 {

	/**
	 * ���������
	 */
	public static void main(String[] args) {
		//Ϊʲô10�ʹ��ˣ�9���ǿ��Ե�
//		System.out.println((int)'10');//Invalid character constant����Ч���ַ�����
		
		/*
		 * ǿ������ת��(��ʾ����ת����������ȷ�����ǰ��շ����򣬽��е�ת����
		 * ����ת���������������ʧ���ȡ�Ҫע�����ݵķ�Χ
		 */
	/*	int z = 128+256;// 00000000 00000000 00000001 10000000 
		 byte z2 = (byte)z;
		 System.out.println(z2);//-128
		 long z3=0xf80000000L;
		 int z4 = (int)z3;
		 System.out.println(z4);//����,-2147483648
		 z3 = 8;
		 int d = (int)z3;
		 System.out.println(d);//8
*/		 float pi = (float)3.1415926535;//��ʧ����
		 System.out.println(pi);//3.1415927
		 char c = '0';
		 char z5 = (char)(c+2);
		 System.out.println(z5);//2

		 
		 //long����ô�����±���ô���������
			int max = 0x7fffffff;
			System.out.println(max);//2147483647
			long y = max +1;
			System.out.println(y);//-2147483648
			y = max +  1L;
			System.out.println(y);//2147483648
			
			
			//System.out.println(Integer.toHexString(y));//�����
			System.out.println(Long.toHexString(y));//80000000
			System.out.println(Long.toHexString(-1));//16��f
			System.out.println(Integer.toHexString(-1));//8��f
//			System.out.println(Byte.toHexString(-1));//�������û�з���Byte.toHexString();
	}

}
