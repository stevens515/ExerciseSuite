package basic.day02;

public class CastDemo {

	/**
	 * char
	 */
	public static void main(String[] args) {
		int a = 128;
//		byte b = a;//int���������Զ����Ƹ�byte����
		byte b = (byte)a;
		System.out.println(b);//-128
		
		a = 128 +1024;
		b=(byte)a;//Ĩ��int�����ĸ�24λ��������8λ
		System.out.println(b);//-128
		
		a = 128 +1024+2048+65536+0x10000000;
		b=(byte)a;//Ĩ��int�����ĸ�24λ��������8λ
		System.out.println(b);//-128
		
		a = 127 +1024;
		b=(byte)a;//Ĩ��int�����ĸ�24λ��������8λ
		System.out.println(b);//127
		
		a = -100;
		b = (byte)a;//ǿ������ת����������Χ��û������
		System.out.println(b);//-100
		
		//һ����ȷ�е�˵����int���ܸ�byte��ֵ
		//int�������ڲ�����byte ��Χʱ�����Ը�byte������ֵ
		
//		b = 0xffffff80;//-128
		b = (byte)0x80;//128
//		b = 0x00000080;//128
		System.out.println(b);//-128
		
		char c = 'A'+1;//('A'+1)��һ�����������൱��int 66
		int i = 1;
//		c = 'A'+i;//�������A����i��int����,���ܸ�char������ֵ��
		c = (char)('A'+i);
//		c = 'A'+65535;//�����������������Χ!

	}

}
