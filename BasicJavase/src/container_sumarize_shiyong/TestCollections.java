package container_sumarize_shiyong;

import java.util.Collections;
import java.util.ArrayList;

/*
 	Collections������
 */
public class TestCollections {
public static void main(String[] args) {
	ArrayList al = new ArrayList();
	al.add(2);
	al.add(-5);
	al.add(3);
	al.add(0);
	System.out.println(al);//[2, -5, 3, 0]
	//��ת
	Collections.reverse(al);
	System.out.println("��ת�Ժ�");
	System.out.println(al);//0, 3, -5, 2]
	//����
	Collections.sort(al);
	System.out.println("�����Ժ�");
	System.out.println(al);//[-5, 0, 2, 3]
	//ϴ��
	Collections.shuffle(al);
	System.out.println(al);//�仯������
}
}
