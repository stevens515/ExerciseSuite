package basic.day08.sub;

class Person{
	String name ;		// ������������
	int age ;			// ������������
	public void tell(){	// ȡ����Ϣ
		System.out.println("������" + name + "�����䣺" + age) ;
	}
};
public class ClassDemo02{
	public static void main(String args[]){
		Person per1 = null ;		// ��������
		Person per2=null;
		per1= new Person() ;	// ʵ��������
		per2 = per1;
		per1.name="����";
		per1.age=30;
		per2.age=33;
		System.out.println("per1��������ݣ�");
		per1.tell();
		System.out.println("per2��������ݣ�");
		per2.tell();
	}
};