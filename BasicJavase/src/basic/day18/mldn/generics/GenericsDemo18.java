package basic.day18.mldn.generics;
/**
 * ��������
 *ʹ�÷��ͷ���ʱ��Ҳ���Դ��ݻ򷵻�һ����������
 */
public class GenericsDemo18 {
	public static void main(String[] args) {
		Integer i[] = fun1(1,2,3,4,5,6);//���ط�������
		fun2(i);						//�����������
	}
	public static <T> T[] fun1(T...arg){//���տɱ���������ط�������
		return arg;
	}
	public static <T> void fun2(T param[]){//���շ�������
		System.out.print("���շ������飺");
		for(T t: param){
			System.out.print(t+",");
		}
		System.out.println();
	}
}
