package container_sumarize_shiyong;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 	treeMap
 */
public class TreeMapDemo {
public static void main(String[] args) {
	//key��������String,Value��int��ʹ�ð�װ��
	//TreeMap ����key�Ĵ�С��������������ṹ��
	Map<String,Integer> map = new TreeMap<String,Integer>();
	map.put("Tom", 5);
	map.put("Jerry", 2);
	map.put("Andy", 4);
	map.put("Robin", 5);
	map.put("Wang", 5);
	System.out.println(map);
	System.out.println(map.get("Tom"));//5
	
	//TreeSet �ײ����TreeMap,�൱�ڱ���key���ֵ�treeMap
	TreeSet<String> set = new TreeSet<String>();
	set.add("Tom");
	set.add("Andy");
	set.add("Jerry");
	System.out.println(set);
}
}
