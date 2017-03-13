package basic.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionCopyDemo {
	/**
	 	javaֻ���Ƶ�һ�㲻���Ƶڶ��㡣��ԭ��
	 	ǳ���ƣ���ֻ���Ƽ��϶��󣬲����Ƽ���Ԫ�ض���
	 	�����඼�ṩ�˸��ƹ����������Ը��Ƽ������ݣ�ǳ���ƣ�
	 */
public static void main(String[] args) {
	ArrayList<String> list1 = new ArrayList<String>();
	list1.add("Tom");
	list1.add("Jerry");
	list1.add("Tom");
	
	//clone()���Դ��������͵Ķ��󸱱�
	ArrayList<String> list2 = (ArrayList<String>)list1.clone();
	//�ǡ�ǳ���ơ������
	//ǳ���ƣ���ֻ���Ƽ��϶��󣬲����Ƽ���Ԫ�ض���
	System.out.println("������ͬ��"+(list1==list2));//false
	System.out.println("Ԫ����ͬ��"+(list1.get(0)==list2.get(0)));//true
	
	String[] ary = {"Tom","Jerry"};
	String[] ary1 =Arrays.copyOf(ary, ary.length);
	System.out.println("������ͬ��"+(ary==ary1));//false
	System.out.println("Ԫ����ͬ��"+(ary[0]==ary1[0]));//true
	
	//�����඼�ṩ�˸��ƹ����������Ը��Ƽ������ݣ�ǳ���ƣ�
	//new LinkedList<String>(list1) ����������list1�ĸ���
	List<String> linked = new LinkedList<String>(list1);
	System.out.println("���ϲ�ͬ��"+(list1==linked));//false
	System.out.println("Ԫ����ͬ��"+(list1.get(0)==linked.get(0)));//true
	
	//�����͸���list ->set
	Set<String> set = new HashSet<String>(list1);
	System.out.println(set);//[Jerry, Tom]
	System.out.println(list1);//[Tom, Jerry, Tom]
}
}
