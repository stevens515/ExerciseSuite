package container_sumarize_shiyong;

import java.util.TreeSet;

/**
 	TreeSet�������Ԫ�صļ��������
 */
public class TestTreeSetDemo3 {
	
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		Z z = new Z("AAA");
		ts.add(z);
		ts.add(z);
		System.out.println(ts);//[AAA, AAA]
		((Z)ts.first()).name = "BBB";//�޸ĵ�һ��Ԫ�ص�name����
		System.out.println(ts);//[BBB, BBB],��������Ԫ�ص�name����ͬʱ�ı䣬��Ϊ���Ǳ������һ������
	}
}
class Z implements Comparable{
	String name;
	public Z(String name){
		this.name = name;
	}
	public boolean equals(Object o){
		return false;
	}
	public int compareTo(Object o){
		return 1;
	}
	public String toString(){
		return name;
	}
}