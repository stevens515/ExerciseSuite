package basic.day13;

import java.util.Scanner;

/**��װ��*/
public class WorpClassDemo {
public static void main(String[] args) {
	//char[]	String
	//int 		Integer
	int i = 1;
	Integer x = new Integer(1);//��װ,boxing
	Object o = x;//���������Ͱ�װΪ����
	int j = x.intValue();//�����unboxing
	System.out.println(j);//1
	
	Integer y = 5;//java 5 �Զ���װ��java�ڵײ����new Integer(5����
	int z = y+6;//�ײ���㷽ʽ��y.intValue()+6;�Զ����
	Integer n = y + 6;//�Զ���װ������������������½�
	int m = i+6;//���ܸ�
	
	//�������͵Ĺ��߷������������������������
	//�������ͣ�����String
	Scanner in = new Scanner(System.in);
	int k = in.nextInt();//Integer.parseInt(str)
	String str = "65";
	k = Integer.parseInt(str);//"65"->65
	System.out.println(k);
	
	k = 0xffffffff;
	System.out.println(k);
	System.out.println(Integer.toString(k));//-1
	
	double d = -1;
	System.out.println(Double.toString(d));
	
	boolean b = true;
	System.out.println(Boolean.toString(b));//"true"
	}
}