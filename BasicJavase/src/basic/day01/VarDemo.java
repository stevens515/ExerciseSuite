package basic.day01;

public class VarDemo {

	public static void main(String[] args) {
//		System.out.println(age);//���������û��������age cannot be resolved
		int age;//����������
//		System.out.println(age);//���������û�г�ʼ����The local variable age may not have been initialized!
		age  = 15;//�����ĳ�ʼ������һ�θ�ֵ
		System.out.println(age);//���15
		age = 16;//��ֵ�����ı��� ��ֵ
		System.out.println(age);//16
		int times = 10;//����ͬʱ��ʼ��
		System.out.println(times);
//		int age;//������󣬱����ظ�������Duplicate local variable age!
		if(age<20){
			int score = 10;
//			System.out.println(socre);//��д��ʱ��score cannot be resolved!
			System.out.println(score);//10
		}
//		System.out.println(score);�������û��������score cannot be resolved!
		int score = 5;//
		System.out.println(score);//5
		
		
		System.out.println(Math.pow(2, 3));//��һ������ƽ��
	}

}
