package basic.day18.mldn.generics;
/**
 *[����Ȩ��] <���ͱ�ʶ> ���ͱ�ʶ ��������(���ͱ�ʶ ��������)
 */
class Demo{
	public <T> T fun(T t){//���Խ����������͵�����
		return t;
	}
}
public class GenericsDemo15 {
	public static void main(String[] args) {
		Demo d = new Demo();
		String str = d.fun("�ֶ���");//�����ַ���
		int i=d.fun(30);//�������֣��Զ�װ��
		System.out.println(str);//�������
		System.out.println(i);//�������
	}
}
