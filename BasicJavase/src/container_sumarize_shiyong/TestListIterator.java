package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//ListIterator������
public class TestListIterator {
public static void main(String[] args) {
	List l = new ArrayList();
	l.add("�����");
	l.add("��˽�");
	ListIterator li = l.listIterator();
	while(li.hasNext()){
		System.out.println(li.next());
		li.add("����������������");
	}
	System.out.println("��ʼ�������");
	System.out.println(li.previous());//���Ե�����ָ��ָ���λ��
	while(li.hasPrevious()){
		System.out.println(li.previous());
	}
}
}
