package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//�����뼯���໥ת��
public class ArrayCollectionDemo {
	public static void main(String[] args) {
		//���鵽����
		String[] names = {"Tom","Jerry","Tom"};
		List<String> list = Arrays.asList(names);
		System.out.println(list.get(1));
		//תlist
		list = new ArrayList<String>(list);
		System.out.println(list);
		//תset
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		//����ת��Ϊ����
		Object[] ary = set.toArray();
		System.out.println(Arrays.toString(ary));
		String[] ary1 = new String[4];
		
		ary1 = set.toArray(ary1);
		String[] ary2 = new String[1];
		ary2 = set.toArray(ary2);
		System.out.println(Arrays.toString(ary1));
		System.out.println(Arrays.toString(ary2));
	}
}
