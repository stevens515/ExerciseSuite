package tarena.interview;

import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		System.out.println("���������ֲ��ԣ�");
		Scanner console = new Scanner(System.in);
		int temp = console.nextInt();
		System.out.println(isOdd(temp));
	}
	public static boolean isOdd(int i){
		//����������
//		return i%2==1;//���κθ����������ϵ��ø÷������᷵��false,��������ż
		//�������1
//		return i%2 !=0;
		//���������2
		/**
		   �߼������㣬һ����ǰ�true���Ϊ1,false���Ϊ0.
			5��3ʱ,��1��   1 0 1
						��0 1 1
					....................
		  				0	0 1
		 */
		return (i & 1)!=0;
	}

}
