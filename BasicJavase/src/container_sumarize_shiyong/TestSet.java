package container_sumarize_shiyong;

import java.util.HashSet;
import java.util.Set;

/**
 	set�ӿڣ������ظ�
 	ע�⣺��ʵHashSet�������Ԫ�ص�ԭ���ǣ�ֻ��equals�����ж���ȣ�����true����
 	����hashCode�������ص�ֵ��ͬʱ�����޷��������ͬ�����Ԫ�أ����򣬶�������ӡ�
 */
public class TestSet {
	public static void main(String[] args) {
		//�����ظ�
		Set s1 = new HashSet();
		s1.add("�ϻ�");
		s1.add("ʨ��");
		s1.add("�ϻ�");
		System.out.println(s1);//[�ϻ�, ʨ��],����ֻ��һ���ϻ�
		
		//�ж��ظ���׼
		Set s = new HashSet();
		Fish f = new Fish("Nemo");
		Fish f1 = new Fish("Melo");
		s.add(f);
		s.add(f1);
		/*
		 	��Ȼf��f1��������ͬ���󣬵�����ΪFish���equals������hashCode������
		 	����ֵ����ȣ�����HashSet��Ϊ������ͬһ������
		 */
		System.out.println(s);//[Nemo]
		System.out.println(f.equals(f1));//true
		System.out.println(f.hashCode(f1));//true
		System.out.println(s.size());//1
	}
}
class Fish{
	private String name;
	public Fish(String name){
		this.name=name;
	}
	public boolean equals(Object o){
		return true;
	}
	public int hashCode(){
		return 1;
	}
	public String toString(){
		return name;
	}
	public boolean hashCode(Object o){
		return this.hashCode()==o.hashCode();
	}
}
