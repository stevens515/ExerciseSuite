package basic.day04.practice;

/**
 	���ڶ�·����룬��·��ͻ�����
 	1��.�����������˵�����һ������Ϊ�٣�������������������Ǽ٣����ս�����Ǽ١�
 	2��.���ڻ������˵�����һ������Ϊ�棬������������������Ǽ٣����ս�������档
 	3).��������˵��Ҫ�����е��������жϣ������ʹ�ö�·�룬��һ��������Ϊfalse����
 		����������������жϡ�
 	4��.���ڻ���˵��Ҫ�����е��������жϣ������ʹ�ö�·�򣬵�һ��������Ϊtrue����
 		����������������ж�
 */

public class OperatorDemo01 {
	public static void main(String[] args){
		int x = 10/0;
		System.out.println("x="+x);//java.lang.ArithmeticException: / by zero
	}
}

/**�Ա���
 	public class OperatorDemo02 {
	public static void main(String[] args){
		if(10 != 10&10/0==0){		//�Ƕ�·��
		//java.lang.ArithmeticException: / by zero
		System.out.println("��������");
		}
	}
}

/**�Ա���
 	public class OperatorDemo03 {
	public static void main(String[] args){
		if(10 != 10&&10/0==0){			//��·��
		System.out.println("��������");//��������հ�
		}
	}
}
 */

/**�ԱȻ�
 	public class OperatorDemo04 {
	public static void main(String[] args){
		if(10 == 10 | 10/0==0){		//�Ƕ�·��
		//java.lang.ArithmeticException: / by zero
		System.out.println("��������");
		}
	}
}
*/

/**
 	public class OperatorDemo05 {
	public static void main(String[] args){
		if(10 == 10 || 10/0==0){		//��·��
		System.out.println("��������");//��������

		}
	}
}
*/
