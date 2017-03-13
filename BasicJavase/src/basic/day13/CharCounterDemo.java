package basic.day13;

import java.util.HashMap;
import java.util.Map;

/**
 * ͳ������
 */
public class CharCounterDemo {
	public static void main(String[] args) {
		String str = "aabbccderfhhhh";
		Map<Character, Integer> map = countAll(str);
		System.out.println(map.toString());
	}

	public static Map<Character, Integer> countAll(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// ����ÿ���ַ�ch
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// ��map�м���Ƿ�����ַ�ch
			if (map.containsKey(ch)) {
				// ���������ȡ������ֵn��ȡ��n+1
				int n = map.get(ch);
				map.put(ch, n + 1);
			} else {// �����������д��map,1
				map.put(ch, 1);
			}
		}
		return map;

	}
}
