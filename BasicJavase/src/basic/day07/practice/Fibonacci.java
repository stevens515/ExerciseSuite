package basic.day07.practice;

public class Fibonacci {

	/**
	 	12������һ������n������쳲���������(Fibonacci)�ĵ�n��ֵ
  			1  1  2  3  5  8  13  21  34
 			���ɣ�һ��������ǰ������֮��
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int n1 = 1;//��һ����
		int n2 = 1;//�ڶ�����
		int sum = 0;//��
		if(n<=0){
			System.out.println("��������");
			return;
		}
		if(n<=2){
				sum = 1;
		}else{
			for(int i=3;i<=n;i++){
				sum = n1 + n2;
				n1 = n2;
				n2 = sum;
			}
		}
		System.out.println(sum);
	}
}
