package basic.day06;

public class MethodDemo {

	/**
	 * �漰���������ص�����
	 * ������ʾ��ӡ����ͬ�Ľ��������Ϊ���ݲ�����ͬ�������� 
	 * System.out.println()��ͬ�����ط�����
	 */
	public static void main(String[] args) {
		char[] chs = {'A','B','C'};
		int [] ary = {'A','B','C'};
		//char�����ӡ�����ַ���
		System.out.println(chs);//ABC,println(char[])
		//int�����ӡ���ǵ�ַ
		System.out.println(ary);//[I@42e816,println(Object)
		//��ӡint����toString()�����ķ���ֵ
		System.out.println(ary.toString());//[I@42e816
		//��ӡ�ַ�
		System.out.println('A');//A,println(char)
		//��ӡ����
		System.out.println(65);//65,println(int)
	}

}
