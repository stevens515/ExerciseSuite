package basic.day08.practice;

class Person{
	private String name ;
	private int age ;
	public Person(){}					// ����һ���޲εĹ��췽��
	public Person(String n){			// ������һ�������Ĺ��췽��
		this.setName(n) ;
	}
	public Person(String n,int a){		// �������췽����Ϊ���е����Գ�ʼ��
		this.setName(n) ;
		this.setAge(a) ;
	}
	public void setName(String n){
		name = n ;
	}
	public void setAge(int a){
		if(a>0&&a<150){
			age = a ;
		}
	}
	public String getName(){
		return name ;
	}
	public int getAge(){
		return age ;
	}
	public void tell(){
		System.out.println("������" + this.getName() + "�����䣺" + this.getAge()) ;
	}
};
public class ConsDemo{
	public static void main(String args[]){
		System.out.println("��������Person per = null ;") ;
		Person per = null ;	// ��������ʱ����ȥ���ù��췽��
		System.out.println("ʵ��������per = new Person() ;") ;
		per = new Person("����",30) ;//ʵ��������
		per.tell() ;
	}
};