package basic.day03;

public class ArrayDemo {

	public static void main(String[] args) {
		//�����������������),�����������������
		String[] names;
		int[] ary;
		double[] ary1;
//		System.out.println(ary[0]);//�������aryû�г�ʼ��+6
		//null �գ�û��
		ary = null;//��ʼ��aryΪnull
//		System.out.println(ary[0]);//�����쳣��java.lang.NullPointerException
		//����(��ʼ����������󣬱���ָ�������С(Ԫ������)
		//��������С���ɱ�(�̶���)
		//�����±�(���)��0��1........length-1
		//�����Ԫ�����Զ���ʼ���ģ�ֵΪ"��ֵ"��0,0.0,\u0000,false,null
		ary = new int[3];
		System.out.println(ary[0]);//0
		
		//System.out.println(ary[3]
		//ѡ����������A����� B.�����쳣 C.0	D.null
//		ary5[1] = 8;//д����Ԫ��
//		System.out.println(ary5[0]);
//		System.out.println(ary5[1]);
//		System.out.println(ary5[2]);
//		int[] ary6 = ary5
		int ary5[];
		ary5 = new int[]{7,8,9,10};
		// 		-x ->{0,8,0}
		//	ary5-->{7,8,9,10}
		System.out.println(ary5[0]);
		System.out.println(ary5[1]);
		System.out.println(ary5[2]);
		System.out.println(ary5[3]);
		
		//������ʹ�õ��������������д��
		int ary8[];//�ȼ���int[] ary8,����Ϊ��C����ϰ�߼��ݡ�
		
		//��������ĳ���.length����
		System.out.println(ary5.length);//4
		//ary5.length  = 8;//������󣬲����޸����鳤��
		//���ڹؼ��֣�new , if ,int ��
		//�ؼ��ֲ�����������
		//50���ؼ���
		//������(�����ؼ��֣�java���µ�)(goto const)
		//���ǹؼ��֣�null,true ,false��������
	}

}
