package basic.day11;

import java.util.ArrayList;

public class ArrayListDemo {
public static void main(String[] args) {
	StringBuilder buf = new StringBuilder();//��Ϊchar[]�ַ�
	buf.append('��');
	buf.append('��');
	buf.insert(0, '��');
	buf.insert(2,'��');
	System.out.println(buf.toString());//���ﾩ��
	ArrayList list = new ArrayList();//object���ַ�������
	list.add("��");
	list.add("��");
	list.add(0,"��");
	list.add(1,'��');
	System.out.println(list);//[��, ��, ��, ��]
}
}
