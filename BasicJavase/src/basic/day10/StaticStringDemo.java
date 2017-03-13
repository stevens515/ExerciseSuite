package basic.day10;

public class StaticStringDemo {

	/**
	 	����̬�ַ������ַ��������� String���������ʱ����õ�����
	 	���ͣ�String����������Ӱ��java������
	 java�����̬���Ż���String
	 	1.java���������ͳ���(�������ͣ�String��)�����㣬�ڱ����ڼ�ִ��
	 	2.java���ַ����������ͳ��������ھ�̬���У�������ʹ��ͬһ�����󣬾�̬�����Ҳ���ڶ��С�
	 	3.��̬�������ַ���ʵ�������پ�̬���з��䡣���¶���
	 		�磺new String()  s1+s2 �Ľ��
	 */
	public static final String S ="123ABC";
	public static final int N = 123;
	public static void main(String[] args) {
		String s = "123";
		String s1 = "123ABC";
		String s2 = "123ABC";
		System.out.println(s2==s1);
		
		String s3 = N+"ABC";//"123ABC"
		System.out.println(s2==s3);//true
		System.out.println(s3==s1);//true
		String s4 = 123 +"ABC";//"123ABC
		System.out.println(s3==s4);//true
		
		String s5 = 1+2+3+"ABC";//6ABC
		System.out.println(s4==s5);//false
		String s6 = '1'+'2'+'3'+"ABC";//,49+50+51"150ABC"
		System.out.println(s6==s5);//false
		String s7 = "1"+"2"+"3"+"ABC";
		System.out.println(s7==s1);//true
		
		String s8 = s+"ABC";//123ABC,�����ڲ�����
		System.out.println(s8==s1);//false
		String s9 = new String("123ABC");//123ABC
		System.out.println(s9==s1);//false
		System.out.println(s9==s8);//false
		String s10 = new String("123"+"ABC");//123ABC,new string("123	aBC zx 
		System.out.println(s10==s9);//false
	}

}
