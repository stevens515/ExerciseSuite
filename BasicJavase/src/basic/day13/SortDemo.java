package basic.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 	comparable��comparator
 	����Ƚϴ�С
 */
public class SortDemo {
public static void main(String[] args) {
	//�����ǰ���ǣ����ŵ�Ԫ���ǿ��ԱȽϴ�С�ģ�
	List<String> names = new ArrayList<String>();
	names.add("Tom");
	names.add("Andy");
	names.add("Nimo");
	names.add("Jerry");
	names.add("John");
	names.add("Jack");
	System.out.println(names);//[Tom, Andy, Nimo, Jerry, John, Jack]
	Collections.sort(names);
	System.out.println("����"+names);//����[Andy, Jack, Jerry, John, Nimo, Tom]
	//�ַ����ǿ��ԱȽϴ�С�ģ����Բ�������
	String s1 = "Tom";
	String s2 = "Jerry";
	//compareTo()���ַ����������ķ������Ƚϵ�ǰ�ַ���������һ���ַ���
	//�ַ�����С�ķ��������أ�0������ʾ��ǰ�ַ�����Լ����һ���ַ�������0��ʾ��ȣ���0��ʾ��������ַ�С
	//compareTo()�ײ�һ��ʹ�ü���������ʵ��
	System.out.println(s1.compareTo(s2));//10
	System.out.println(s2.compareTo(s1));//-10
	System.out.println(s2.compareTo(s2));//0
	//java.lang.Comparable�ӿ���������compareTo()����
	//Comparable�����ԱȽϵ�
	//String ʵ���˽ӿ�Comparable:����ˣ�String�ǿ��ԱȽϴ�С��
	//Stringʵ����Comparable�еķ���compareTo()
	//java�н�ʵ��Comparable�ӿڵ��࣬��Ϊ��������Ȼ����ġ�
	//compareTo()������ʵ����equals()������һ�µ�
	
	//�Զ�������java.util.Comparator �ӿ������涨�Զ��������
	//Comparator:�Ƚ��ߣ��ȽϹ��������Ƚ���
	//Comparator������ʱ���Զ�����������磺�������������
	ByLength byLength = new ByLength();
	Collections.sort(names,byLength);//���ճ����Զ�������
	System.out.println("ByLength:"+names);//ByLength:[Tom, Nimo, John, Jack, Andy, Jerry]
	
}
}
/**�Զ���ȽϹ��򣺰��ճ��ȱȽ�*/
class ByLength implements Comparator<String>{
	//�ص������� �Ǳ�����API���õķ���
	public int compare(String o1,String o2){
		System.out.println("o1:"+",o2:"+o2);
		int val= o1.length()-o2.length();
		if(val==0){//�������һ�������ַ�����С����������
			return -o1.compareTo(o2);
		}
		return val;
	}
	

	
}
