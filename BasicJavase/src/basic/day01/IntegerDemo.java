package basic.day01;

public class IntegerDemo {

	/**
	 * byte int 
	 */
	public static void main(String[] args) {
		//Ĭ�ϵġ���������������int����
		//�����������ڲ�����byte��Χʱ����Ը�byte������ֵ
		int i = 5;//i�Ǳ�����5����������ֱ������
		byte b = 127;
//		b = 128;//������󣬳�����Χ
		b = -128;
		//b = -129;//�������
		b = 0x7f;
//		b = 0x00000080;//cannot convert from int to byte
		System.out.println(0xffffff80);//-128
		b = 0xffffff80;
		b = 0xfffffff6;//-10
//		b = i;//������󣬡��������������ܸ�byte������ֵ��
		
		long l = 0x7fffffffffffffffL;
		//��l/L��׺����������long���� 
		System.out.println(l);
		
		long x = 0xf;
		x = -1;//�Զ��ķ�������λ��չ����
		System.out.println(x);//-1
		b = -1;
		x = b;//�Զ��ķ�������λ��չ����
		System.out.println(b);//-1
		
		short s = 5;
		//byte short ����int����
		short k = (short)(s + s);
		
		int max = 0x7fffffff;
		long y = max +1;
		System.out.println(y);//-2147483648
		y = max +  1L;
		System.out.println(y);//2147483648
		
		
		
//		System.out.println(Integer.toHexString(y));//�����
		System.out.println(Long.toHexString(y));//80000000
		System.out.println(Long.toHexString(-1));//16��f
		System.out.println(Integer.toHexString(-1));//8��f
//		System.out.println(Byte.toHexString(-1));//�������û�з���Byte.toHexString();
		/*
		 * ����
		 */
		byte min  =-128;
		System.out.println(Integer.toHexString(min));//ffffff80
		System.out.println(Integer.toHexString(min &  0xff));//80
		//10000000 byte -128
		//11111111 11111111 11111111 10000000 -128
		//00000000 00000000 00000000 11111111 0xff	mask
		//&---------------------------------------
		//00000000 00000000 00000000 10000000 0x80
		
		short n = -32768;
		System.out.println(Integer.toHexString(n));//ffff8000
		System.out.println(Integer.toHexString(n & 0xffff));//8000
		
		/*
		 * ǿ������ת�����ǰ��շ����򣬽���ת�����������������ʧ���ȡ�
		 */
		int z = 128+256;// 00000000 00000000 00000001 10000000 
		 byte z2 = (byte)z;
		 System.out.println(z2);//-128
		 long z3=0xf80000000L;
		 int z4 = (int)z3;
		 System.out.println(z4);//����,-2147483648
		 z3 = 8;
		 int d = (int)z3;
		 System.out.println(d);//8
		 float pi = (float)3.1415926535;//��ʧ����
		 System.out.println(pi);//3.1415927
		 char c = '0';
		 char z5 = (char)(c+2);
		 System.out.println(z5);//2
		

	}
}
