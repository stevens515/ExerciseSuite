package basic.day07;

public class ParamaterDemo02 {

	/**����2 ��ʾ��java�е�ֵ���ݹ���
	 	1.�������͵�ֵ���䱾��
	 	2.���ñ�����ֵ��һ����ֵַ���Ǳ����ö�����׵�ַ
	 	3.Ϊ�˱������ò������ݵĸ����ã�����һ�н��ʹ�÷���ֵ����
	 */
	public static void main(String[] args) {
		int a = 1;
		int c = add(a);
		KKoo koo = new KKoo();
		int d =  add(koo);
		System.out.println(a+","+koo.a);
		System.out.println(c+","+d);
	}
	public static int add(int a){
		a++;
		return a;
	}
	public static int add(KKoo koo){
		KKoo k = koo;
		k.a++;
		return koo.a;
	}
}
class KKoo{
	int a = 1;
}