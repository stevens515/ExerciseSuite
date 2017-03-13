package basic.day12;

import java.util.Collection;
import java.util.Set;
import java.util.List;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
/*
 * set:û��˳�򣬲����ظ�������ѧ�ļ���
	list:��˳�򣬲������ظ�
	��������ĵ�ַһ����һ�����������ж��Ƿ��ظ��أ�
	�жϿ��ظ�ԭ����������������equals�;Ϳ���˵�����ظ���
	���������ָ���������
 */
public class CollectionDemo {

	public static void main(String[] args) {
		//���ϣ�Ԫ�طŵ�һ��Ϳ����ˣ�û�ж������(index)
		Collection<String> col = new LinkedList<String>();
		col.add("Tom");
		col.add("Andy");
		col.add("Jerry");
//		String str = col.get(1);//�������,col��û�з���get(index)
		System.out.println(col);//[Tom, Andy, Jerry]
		
		//Set����ѧ���ϣ�Ԫ�ز����ظ���Ԫ������
		//HashSetʹ��HashMapʵ�ֵ�set,ֻ������key����
		Set<String> set = new HashSet<String>();
		set.add("Tom");
		set.add("Jerry");
		set.add("Andy");
//		System.out.println(set.get(1));//�������,setû�з���get(index),��Ϊset������������
		System.out.println(set);//��������˳���޹ء�[Jerry, Tom, Andy]
		
		//List��������˳��Ԫ�ؿ����ظ�����Index��صķ���
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Tom");
		System.out.println(list.get(1));//Jerry
		System.out.println(list);//[Tom, Jerry, Andy, Tom]
	}

}
