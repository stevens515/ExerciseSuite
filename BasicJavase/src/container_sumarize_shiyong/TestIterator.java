package container_sumarize_shiyong;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 	ʹ��Iterator�ӿڵ������޸ļ���
 */
public class TestIterator {
public static void main(String[] args) {
	Collection c = new HashSet();
	c.add("�����");
	c.add("��˽�");
	c.add("ɳ����");
	c.add("��ɮ");
	
	//��ȡc���϶�Ӧ�ĵ�����
	Iterator it = c.iterator();
	while(it.hasNext()){
		//it.next()�������ص���Object���ͣ���Ҫǿ������ת��
		String name = (String)it.next();
		System.out.print(name);//��ɮ��˽������ɳ����
		if(name.equals("��˽�")){
			//�Ӽ�����ɾ����һ��next�������ص�Ԫ��
			it.remove();//[��ɮ, �����, ɳ����]
		}
	}
	System.out.println("\n"+c);

  }
	
}
