package basic.day18.mldn.generics;

public class GenericsDemo21 {
	public static void main(String[] args) {
		Person<Introduction> per = null;//����Person����ͬʱָ��Introduction����
		//ʵ����Person����ͬʱ����info����Ϣ
		per = new Person<Introduction>(new Introduction("�ֶ���","��",30));
		System.out.println(per);
	}
}
