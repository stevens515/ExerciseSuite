package basic.day11;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo {
public static void main(String[] args) {
	//List �ӿڴ����������Ա����������Ա�Ĳ����������磺add()
	//add() remove() size() isEmpty() contains() ....
	//ArrayList ����Object[] ʵ���˾�������Ա�(list)��������
	//add() ��Object[]������ʵ������ӷ���
	//ArrayList�����ñ䳤�����㷨ʵ�ֵ�List(���Ա�)
	List list = null;//��
	list = new ArrayList();//�ռ�
	System.out.println(list.isEmpty());//��������û��Ԫ��
	list.add("����");//�����ڽӿ�����������ArrayListʵ�ֵķ���
	list.add("������");
	System.out.println(list.isEmpty());//false
	System.out.println(list);//toString();
	
	//LinkedList ��ʹ�á�˫��ѭ������ʵ�ֵ����Ա�list)
	//ʵ����ȫ���ķ�����add()	remove() ��
	//��Щ�����ĵײ�������ǡ�˫��ѭ������
	list = new LinkedList();
	list.add("����");
	list.add("������");
	System.out.println(list);//[����, ������]

}
}
