package basic.day10;

public class StringDemo {

	public static void main(String[] args) {
		String str1 = "ABC";
		String str2 = new String("ABC");
		System.out.println(str1.equals(str2));//true
		
		//�ַ���ת�����ַ�����
		char[] chs = str1.toCharArray();
		System.out.println(chs);//ABC
		System.out.println(str1);//ABC
		
		chs[1]='D';
		System.out.println(chs);//ADC
		System.out.println(str1);//ABC
		
		//�ַ�����ת��Ϊ�ַ���
		String s = new String(chs);
		System.out.println(s);//ADC
	}

}
