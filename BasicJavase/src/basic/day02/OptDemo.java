package basic.day02;

/**��ѧ�������ʾ*/
public class OptDemo {
	public static void main(String[] args){
		
		//��̬���󣬴�ӡ
		char c = 'A';
		int i =c+1;
		System.out.println(i);//66,char+char ����ѧ�ӷ�
		System.out.println(c+'\n');//75
		System.out.println(c+"\n"+"���ԣ�������");//A���κ��������ַ�����+��,"+"������������
		
		int a = 5;
		byte b = 6;
		int x = a+b;//���byteת��int,��ת����
		
		b = 1;
//		b = b+b;//�������b+b�ǰ�int�����
		b = (byte)(b+b);
//		b = b+1;//�����b+1��int
		b = (byte)(b+1);
		
		//�߽�����
		b = 2+1;//�������������ڱ����ڼ��Ż�Ϊ��������
		
		//Σ�����
		int max = 0x7fffffff;
		int y  = max + max +2;
		long l = max + max +2;
		l = (long)max + max +2;//�Ȱ�ǰ�ߵ�max��long�㣬Ȼ�����ߵ�max��ӣ���long��λ
		l = max + max + 2L;
		
		//�������������������� /
		a = 5;
		x = a/2;
		System.out.println(x);//2
		double d = (double)a/2;
		System.out.println(d);//2.5
		System.out.println(0/5);//0
		System.out.println(1/5);//0
		
		//ȡ�� %
		a = 5;
		x = a%3;//2
		a = -5;//�����������Ǹ���
		x = a%3;//-2
		System.out.println(0%3);//0
		System.out.println(1%3);//1
		System.out.println(2%3);//2
		System.out.println(3%3);//0
		System.out.println(4%3);//1
		System.out.println(5%3);//2
		System.out.println(6%3);//0
		System.out.println(7%3);//1
		//...
		
	}
}
