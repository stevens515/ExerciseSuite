package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.Collections;

/*
 	���ң��滻
 */
public class TestCollections1 {
public static void main(String[] args) {
	ArrayList al = new ArrayList();
	al.add(2);
	al.add(-5);
	al.add(3);
	al.add(0);
	System.out.println(al);//[2, -5, 3, 0]
	//������Ԫ��
	System.out.println("���Ԫ��Ϊ��"+Collections.max(al));//���Ԫ��Ϊ��3
	//�����СԪ��
	System.out.println("��СԪ��Ϊ��"+Collections.min(al));//��СԪ��Ϊ��-5
	Collections.replaceAll(al, 0, 1);
	System.out.println("�滻�Ժ�"+al);//�滻�Ժ�[2, -5, 3, 1]
	//�жϣ�5���ִ���
	System.out.println(Collections.frequency(al, -5));//1
	//����
	Collections.sort(al);
	System.out.println(al);//[-5, 1, 2, 3]
	//���ַ�����
	System.out.println(Collections.binarySearch(al, 3));//3
}
}
