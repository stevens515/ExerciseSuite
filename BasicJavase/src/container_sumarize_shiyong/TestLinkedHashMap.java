package container_sumarize_shiyong;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
public static void main(String[] args) {
	LinkedHashMap lhm = new LinkedHashMap();
	lhm.put("����", 80);
	lhm.put("��ѧ", 70);
	lhm.put("Ӣ��", 90);
	//����֮���ռ���˳�����
	for(Object key:lhm.keySet()){
		System.out.println(key+"---->");
		System.out.println(lhm.get(key));
	}
}
}
