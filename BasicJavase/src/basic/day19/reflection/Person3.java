package basic.day19.reflection;
/**
 *�������
 */
interface China{				//����ӿ�
	public static final String NATIONAL = "China";//����ȫ�ֳ���
	public static final String AUTHOR = "�ֶ���";
	public void sayChina();//�����޲εĳ��󷽷�
	public String sayHello(String name,int age);//�����вεĳ��󷽷�
}
public class Person3 implements China {
	private String name;
	private int age;
	public Person3(){			//�����޲�������
	}
	public Person3(String name){	//������һ�������Ĺ��췽��
		this.name=name;
	}
	public Person3(String name,int age){	//���������������Ĺ��췽��
		this(name);
		this.setAge(age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void sayChina() {	//��д���������Ϣ
		System.out.println("���ߣ�"+AUTHOR+",������"+NATIONAL);
	}
	public String sayHello(String name, int age) {//��д������������Ϣ
		return name+",��ã��ҽ���"+age+"���ˣ�";
	}
}
