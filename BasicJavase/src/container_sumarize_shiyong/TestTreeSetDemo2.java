package container_sumarize_shiyong;

import java.util.TreeSet;

/**
 	TreeSet����Ȼ����
 	ע�⣺�����TreeSet����ӵ����û��Զ��������ô�Ϳ��Խ���ͬ���͵Ķ������TreeSet���ϣ�
 	ǰ���Ǹö����compareTo(Object o)������û�о���ǿ������ת���������ǣ���Ȼ������ӽ�ȥ������
 	����ͼ������������ʱ����ͬ���͵�Ԫ����Ȼ�ᷢ������ת���쳣���������ǵĳ����г��Ǽ�������£�����
 	������������ͬ���͵Ķ������TreeSet������
 */
public class TestTreeSetDemo2 {
	public static void main(String[] args) {
		//����һ��Ԫ�ض���������û��ʵ��Comparable�ӿ�
		TreeSet ts = new TreeSet();
		ts.add(new A());//A��û��ʵ��Comparable�ӿڣ����ǵ�һ��Ԫ�ؿ����������
		System.out.println(ts);
//		ts.add(new A());//�׳��쳣ClassCastException����ͼ������ǿ��ת��Ϊ����ʵ��������ʱ���׳����쳣
		
		//�������û�����ͬ�����
		TreeSet ts1 = new TreeSet();
		ts1.add("abcde");
		//��ȻString��Date�඼ʵ����Comparable�ӿڣ������������ǲ���ͬ�����
		//�����޷����빲ͬ��TreeSet����
//		ts1.add(new Date());
	}
}
