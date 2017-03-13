package basic.day13;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



/**
 * ͳ������
 */
public class CharCounterDemo2 {
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
