package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.List;

//�����������ʾList�ж϶�����ȱ�׼��
public class TestListDemo2 {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("java");
		l.add("C++");
		l.add("VB");
		System.out.println(l);//[java, C++, VB]
		l.remove(new Aa());
		System.out.println(l);//[C++, VB],��ɾ����һ��Ԫ��
		l.remove(new Aa());//����ɾ����һ��
		System.out.println(l);//[VB]
		
	}
}
class Aa{
	public boolean equals(Object o){
		return true;
	}
}