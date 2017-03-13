package container_sumarize_shiyong;

import java.util.TreeSet;

/**���ַ�����������
 	��һ�֣�ʵ��Comparable�ӿ�
 */
public class TestTreeSetDemo4 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		Student s1 = new Student("�����",500,175);
		Student s2 = new Student("��˽�",200,180);
		Student s3 = new Student("ɳ����",150,185);
		Student s4 = new Student("��ɮ",40,176);
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		System.out.println(ts);//�Զ������������
	}
}
class Student implements Comparable{
	private String name;
	private int age;
	private double height;
	public Student(String name,int age,double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
	/*
	 * comparable�ӿڵ�compareTo(Object o)���Ƚϵ�ǰʵ�����������
	 * .���λ�ڶ���o֮ǰ���򷵻ظ�ֵ���������������������λ����ͬ������0��
	 * ���λ�ڶ���o���棬�򷵻���ֵ��
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o){//��дcompareTo����������height���Ƚ�
		Student s = (Student)o;
		if(this.height>s.height){
			return 1;
		}
		else if(this.height<s.height){
			return -1;
		}
		else {
			return 0;
		}
	}
	public boolean equals(Object o){
		Student s = (Student)o;
		if(this.name.equals(s.name)&& this.age == s.age && this.height ==s.height){
			return true;
		}
		return false;
	}
	public int hashCode(){
		return age;
	}
	public String toString(){
		return name;
	}
}