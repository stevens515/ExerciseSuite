package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.List;

/*
 	List����
 	ע������У��ж�λ�õ���䣬ʹ����new��������Ҳ����˵�жϵ�������һ�����ַ���
 	������һ������϶���������List�����У���ôΪʲô�᷵��2�أ�
 	������Ϊ��List���ж����������Ƿ���ȵı�׼Ϊequals����true
 */
public class TestListDemo1 {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("java");
		l.add("C++");
		l.add("VB");
		System.out.println(l);//[java, C++, VB]����˳�����
		
		l.add(1, "Delphi");
		System.out.println(l);//[java, Delphi, C++, VB]
		
		//��ʾ������Ԫ��
		System.out.println(l.get(2));//C++
		
		//ɾ���ڶ���Ԫ��
		l.remove(1);
		System.out.println(l);//[java, C++, VB]
		//�ж�ָ��Ԫ���ڼ����е�λ��
		System.out.println(l.indexOf(new String("VB")));//2,ע��˴�
		//���ڶ���Ԫ���滻�����¶���
		l.set(1, "VFP");
		System.out.println(l);//[java, VFP, VB]
		//��ʾ��һ��(����)��������Ԫ�أ���������
		System.out.println(l.subList(0, 2));//[java, VFP]
	}
}
