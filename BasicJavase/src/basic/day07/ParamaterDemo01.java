package basic.day07;

public class ParamaterDemo01 {

	/**java������������ֻ��һ�ַ�ʽ������ֵ�Ĵ���
	 * 1.java������������ֻ��һ�ַ�ʽ������ֵ�Ĵ���,�Ǳ���ֵ�ĸ���
	 * 2.�������;�������ֵ�ĸ���
	 * 3.��������������ֵ����ַ���ĸ���
	 */
	/**����ִ�й���
	 * 	1,int a=1����ջ��
	 * 2,ֵ���ݣ���ʵ�ε�ֵ���ݸ��βΣ���������ʱ����add(int a )������ջ��
	 * 3.ִ�з����ڲ����룬a++,�ϱߵ���ʱ������a++,���2
	 * 4���������أ�������ʱ����a=2
	 * 5,����KooĬ���޲ι��������ڶ��ڴ��д������󡣵���class Koo���г�Ա�������ڶ���
	 * 6�������ڴ��ж���洢��ַ��ֵ��koo = basic.day07.practice.Koo@9304b1
	 * 7,ֵ���ݣ���ʵ�ε��׵�ַ���ݸ��βΣ�������ջ��
	 * 8������add(Koo koo)������Koo k = koo;����ջ��
	 * 9,k.a++;����a++,���2
	 * 10��add(Koo koo)�������أ�������ʱ����
	 * 11,���
	 */
	public static void main(String[] args) {
		int a = 1;
		add(a);
		Koo koo = new Koo();
		add(koo);
		System.out.println(a+" ,"+koo.a);//1,2
		System.out.println(koo);;//basic.day07.practice.Koo@9304b1
	}
	public static int add(int a){
		a++;
		return a;
	}
	public static int add(Koo koo){
		Koo k = koo;
		k.a++;
		return koo.a;
	}

}
class Koo{
	int a=1;
}