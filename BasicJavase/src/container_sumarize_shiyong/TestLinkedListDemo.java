package container_sumarize_shiyong;

import java.util.LinkedList;

/**Queue�ӿ�
 	LinkedListʵ����
 */
public class TestLinkedListDemo {
public static void main(String[] args) {
	LinkedList ll = new LinkedList();
	//����Ԫ�ؼ������β��
	ll.offer("java");// ��ָ��Ԫ����ӵ����б��ĩβ�����һ��Ԫ�أ�
	//��һ���ַ�����ջ
	ll.push("C++");// ��Ԫ��������б�����ʾ�Ķ�ջ��
	System.out.println(ll);//[C++, java]
	
	//��һ���ַ�����ӵ�����ͷ��
	ll.offerFirst("VB");// �ڴ��б�Ŀ�ͷ����ָ����Ԫ�ء�
	System.out.println(ll);//[VB, C++, java]
	//���ʲ���ɾ����һ��Ԫ��
//	��ȡ�����Ƴ����б�ĵ�һ��Ԫ�أ�������б�Ϊ�գ��򷵻� null��
	System.out.println(ll.peekFirst());//VB
	//��һ��Ԫ�س�ջ
	System.out.println(ll.pop());//VB,�Ӵ��б�����ʾ�Ķ�ջ������һ��Ԫ��
	System.out.println(ll);//[C++, java]
}
}
