package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 	�ܽ᣺���ò��ɱ伯����ͬ������
 */
public class TestCollectionEnd {
	public static void main(String[] args) {
		//����һ���յĲ��ɱ伯
		List list = Collections.emptyList();
		//����һ��ֻ��һ��Ԫ���Ҳ��ɱ��Set����
		Set set = Collections.singleton("java");
		//����һ����ͨMap����
		Map map = new HashMap();
		map.put("����", 80);
		map.put("Java", 82);
		//������ͨMap����Ĳ��ɱ�汾
		Map uMap = Collections.unmodifiableMap(map);
		//��������һ�д��붼�������쳣��
//		list.add("C++");
//		set.add("C++");
//		uMap.put("��ѧ", 90);
		
		
		//ͬ������
		Collection c = Collections.synchronizedCollection(new ArrayList());
		List l = Collections.synchronizedList(new ArrayList());
		Set s = Collections.synchronizedSet(new TreeSet());
		Map m = Collections.synchronizedMap(new HashMap());
	}
}
