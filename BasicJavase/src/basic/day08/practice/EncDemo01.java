package basic.day08.practice;

public class EncDemo01 {

	public static void main(String[] args) {
		Person3 per = new Person3();//������ʵ��������
		per.setName("����");
//		per.name = "����";
		per.setAge(-30);
		per.tell();
	}

}
class Person3{
	private String name ;//������������
	private int age;//������������
	public Person3(){
		
	}
//	public Person3(String name,int age){
//		this.getName(name)=name;
//		this.getAge(Age)=;
//	}
	public void setName(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	public void setAge(int a){
		if(a>=0&&a<=150){
			age=a;
		}
	}
	public int getAge(){
		return age;
	}
	public void tell(){
		System.out.println("������"+name+",���䣺"+age);
	}
}