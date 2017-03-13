package container_sumarize_shiyong;

import java.util.TreeSet;

/*
 	Set�ӿ������ձ��ʵ���࣬HashSet��TreeSet.
 	���Ӽ�����������ķ�ʽ����ͳ�ȡԪ��ʱ��TreeSetʵ��������ô���
 	Ϊ���ܹ�˳˳�����в�������ӵ�TreeSet��Ԫ�ر����ǿ������
 */
public class TestTreeSetDemo {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(5);
		ts.add(9);
		ts.add(-1);
		ts.add(3);
		System.out.println(ts);//[-1, 3, 5, 9]�����Կ����Ѿ��Զ�������Ȼ˳������������
		System.out.println("��һ��Ԫ�أ�"+ts.first());
		System.out.println("���һ��Ԫ�أ�"+ts.last());
		//����С��4���Ӽ���ע��4���Ǽ���Ԫ��
		System.out.println(ts.headSet(4));//[-1, 3]
		//���ش���5���Ӽ�����������а���5�����Ӽ���Ҳ����5
		System.out.println(ts.tailSet(5));//[5, 9]
		//���ش��ڵ���3��С��5���Ӽ�
		System.out.println(ts.subSet(3, 5));//[3]
	}
}
