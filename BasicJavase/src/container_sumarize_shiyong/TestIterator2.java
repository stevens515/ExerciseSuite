package container_sumarize_shiyong;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
 	HashSet
 */
public class TestIterator2 {
public static void main(String[] args) {
	Collection c = new HashSet();
	c.add("�����");
	c.add("��˽�");
	c.add("ɳ����");
	c.add("��ɮ");
	
	//��ȡc���϶�Ӧ�ĵ�����
	Iterator it = c.iterator();
	
	/**
 	��ȷʹ��Iterator�ӿڣ������������ڣ�����Ԫ�ز��ܸı䡣
 */
	while(it.hasNext()){
		String name = (String)it.next();
		System.out.print(name);//��ɮ��˽������ɳ����
		if(name.equals("��˽�")){
			//ֱ�ӴӼ�����ɾ��Ԫ�أ�����������ʱ�쳣��java.util.ConcurrentModificatrionException
			c.remove(name);
		}
		
		}
	System.out.println(c);
	}
}
