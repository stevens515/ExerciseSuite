package container_sumarize_shiyong;

import java.util.Vector;
/**
 	ִ�����������Է��֣���ʼVector��capacityΪ10����Ԫ������
 	С��capacityʱ��capacity���ᷢ���仯������һ�����������³�
 	��һ����capacity�ͻ�ɱ�������
 */
//����ArrayList��Vector���capacity����
public class TestArrayListDemo1 {
public static void main(String[] args) {
	Vector al = new Vector();
	System.out.println(al.size());//0��ʵ��Ԫ����
	System.out.println(al.capacity());//10��������ע��ArrayList���������η���
	
	String[] a = new String[11];
	for(int i=0;i<a.length;i++){
		al.add(a[i]);
	}
	System.out.println(al.size());//11��ʵ��Ԫ����
	System.out.println(al.capacity());//20��������ע��ArrayList���������η���
	}
}
