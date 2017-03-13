package basic.day13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
public class CharCounterDemo3 {//ͳ������
	public static void main(String[] args) {
		String str = "aabbccderfhhhh";
		Map<Character, Integer> map = countAll(str);
		System.out.println(map);
		//����Map:����
		//����Map:�������е�key,�������е�Value,����Entry<key:value>
		//���õ������е�value��ʵ��ͳ�����е��ַ�����
		Collection<Integer> values = map.values();
		int total = 0;
		Iterator<Integer> ite = values.iterator();
		while(ite.hasNext()){
			Integer n = ite.next();
			total+=n;
		}
		System.out.println("�ַ�����"+total);
		//�������е�key�����õ��������ַ�ʵ�����ͳ�Ʊ��
		Set<Character> keys = map.keySet();//�������е�key
		ArrayList<Character> list = new ArrayList<Character>(keys);
		Collections.sort(list);//��Ȼ����Ĭ������
		for(Iterator<Character> i = list.iterator();i.hasNext();){
			Character ch = i.next();
			int n  = map.get(ch);
			System.out.println(ch+":");
			System.out.println(n+","+(((double)n/total))*100);
		}
		//����Entry<key:Value>ʵ�ְ����ַ����ֵ������������
		Set<Entry<Character,Integer>> entries = map.entrySet();
		List<Entry<Character,Integer>> entList= new ArrayList<Entry<Character,Integer>>(entries);
		Collections.sort(entList,new ByValue());
		for(Iterator<Entry<Character,Integer>>i=entries.iterator();i.hasNext();){
			Entry<Character,Integer> entry = i.next();
			Character ch = entry.getKey();
			Integer n = entry.getValue();
			System.out.println(ch+":");
			System.out.println(n+","+(((double)n/total))*100);
		}
		System.out.println("�����ַ��������");
	}

	public static Map<Character, Integer> countAll(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// ����ÿ���ַ�ch
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			Integer n = map.get(ch);
			map.put(ch, n==null?1:n+1);
//			char ch = str.charAt(i);
//			// ��map�м���Ƿ�����ַ�ch
//			if (map.containsKey(ch)) {
//				// ���������ȡ������ֵn��ȡ��n+1
//				int n = map.get(ch);
//				map.put(ch, n + 1);
//			} else {// �����������д��map,1
//				map.put(ch, 1);
//			}
		}
		return map;

	}
}
class ByValue implements Comparator<Entry<Character,Integer>>{
	public int compare(Entry<Character,Integer>o1,Entry<Character,Integer>o2){
		return -(o1.getValue()-o2.getValue());
	}
}
