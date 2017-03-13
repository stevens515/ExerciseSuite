package basic.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/** �����뼯�ϵ�����ת��*/
public class ArrayCollectionDemo {
public static void main(String[] args) {
	//���鵽���ϵ�ת��
	String[] names = {"Tom","Jerry","Tom"};
	//asList()�������Խ�����ת��ΪList���϶������list��ֻ����
	List<String> list = Arrays.asList(names);
	System.out.println(list.get(1));//Jerry
//	list.add("Andy");//�����쳣
//	list = (ArrayList<String>)list;//�����쳣��������ǿ��ת��
	//תlist
	list = new ArrayList<String>(list);//�½�һ�������Ե�
	System.out.println(list);//[Tom, Jerry, Tom]
	//ת��set
	Set<String> set = new HashSet<String>(list);
	System.out.println(set);//[Jerry, Tom]
	
	//����ת��Ϊ����
	//toArray()��ת��ΪObject[]��������
	Object[] ary = set.toArray();
	System.out.println(Arrays.toString(ary));//[Jerry, Tom]
	//toArray(ary)��ת��Ϊ�ض����͵����飬�磺String[]����
	String[] ary1 = new String[4];
	/**
	 set.toArray(ary1)�����ܽ�set�е�Ԫ����䵽ary1��
	 	�����ary1 �������ã�����䲢�ҷ���ary1����
	 	�����ary1 ���������ã��ʹ�����������䲢�ҷ���������
	 */
	ary1 = set.toArray(ary1);
	String[] ary2 = new String[1];
	ary2 = set.toArray(ary2);
	System.out.println(Arrays.toString(ary1));//[Jerry, Tom, null, null]
	System.out.println(Arrays.toString(ary2));//[Jerry, Tom]

	//�ֹ�ת
	String[] ary3 =new String[set.size()];
	int j =0;
	for(Iterator<String> i =set.iterator();i.hasNext();){
		ary3[j++]=i.next();
	}
	System.out.println(Arrays.toString(ary3));//[Jerry, Tom]
}
}
