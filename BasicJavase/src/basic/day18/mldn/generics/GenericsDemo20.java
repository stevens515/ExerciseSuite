package basic.day18.mldn.generics;

public class GenericsDemo20 {
	public static void main(String[] args) {
		Person<Contact> per = null;//����Person����ͬʱָ��Contact����
		//ʵ����Person����ͬʱ����info����Ϣ
		per = new Person<Contact>(new Contact("������","01051283346","100088"));
		System.out.println(per);
	}
}
