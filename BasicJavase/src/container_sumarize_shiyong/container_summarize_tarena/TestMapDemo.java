package container_sumarize_shiyong.container_summarize_tarena;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class TestMapDemo {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("c++", "chenglong");
		map.put("corejava", "huxz");
		map.put("java web", "qiaxf");
		map.put("ejb", "zhuzh");
		// System.out.println(map);//{ejb=zhuzh, c++=����, corejava=huxz, java
		// web=jiaxf}
		// ���ص�����һ�δ�KEY��Ӧ��ֵ��û�У�Ϊnull.
		// ���KEY��ͬ�����滻�����ؾ�ֵ
		System.out.println(map.put("c++", "wangfei"));//chenglong
		// System.out.println(map);//{ejb=zhuzh, c++=wangfei, corejava=huxz, java
		// web=jiaxf}
		System.out.println(map.get("c++"));// wangfei
		System.out.println("===============================");
		printValue(map);
		System.out.println("=================================");
		printKeyValuePairs(map);
		System.out.println("================================");
		printWithEntrySet(map);
	}

	// ������ʽһ key
	public static void printValue(Map m) {
		Collection c = m.values();// value���ش�ӳ���ֵ
		Iterator it = c.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			// ӳ��˳�� ����Ϊ��������ӳ��� collection ��ͼ�Ϸ�����Ԫ�ص�˳��
			System.out.println(s);
		}
	}
	//������ʽ�� key-value
	public static void printKeyValuePairs(Map m){
		Set s = m.keySet();//�õ�����Key��set����
		Iterator it = s.iterator();
		while(it.hasNext()){
			String key =(String)it.next();
			//get(Object key) ����ָ������ӳ���ֵ�������ӳ�䲻�����ü���ӳ���ϵ���򷵻� null��
			String value =(String)m.get(key);
			System.out.println(key+"-----"+value);
			
		}
	}
	//������ʽ����key-value
	public static void printWithEntrySet(Map m){
		Set s =m.entrySet();//�õ����ǣ���ֵ�Թ�ϵ��Entry����set����
		Iterator it = s.iterator();
		while(it.hasNext()){
			Entry element = (Entry)it.next();
			String key =(String)element.getKey();
			String value =(String)element.getValue();
			System.out.println(key+"<====>"+value);
		}
	}
}
