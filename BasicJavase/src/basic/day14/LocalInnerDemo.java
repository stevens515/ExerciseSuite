package basic.day14;

import java.util.Comparator;
import java.util.Arrays;

/**�ֲ��ڲ���*/
public class LocalInnerDemo {
	public static void main(String[] args) {
		int a=5;
		final int b = 8;
		class Koo{//�ֲ��ڲ��࣬�ڷ����ж���,�ڷ����ڲ��ɼ�
			public void test(){
//				System.out.println(a);//�������a��������final��
				System.out.println(b);//�ֲ��ڲ���ֻ�ܷ���fianl�ֲ�����
			}
		}
		Koo koo = new Koo();
		koo.test();//8
		
		//�ֲ��ڲ����Ӧ��
		final int dir = -1;//������С����1�������ɴ�С
		class ByLength implements Comparator<String>{
			public int compare(String o1,String o2){
//				return o1.length()-o2.length();
				return dir*(o1.length()-o2.length());
			}
		}
		String[] names = {"Andy","Tom","Jerry"};
		Arrays.sort(names,new ByLength());
		System.out.println(Arrays.toString(names));
	}
}
