package basic.day07;

public class FieldDemo {

	public static void main(String[] args) {
		Tricker tricker = new Tricker("Jerry");
		Person person = tricker;
		//�����ǰ󶨵����������ϵģ���̬�󶨣����ݱ������ͷ�������
		//Tricker���͵ı���tricker.name����Tricker��name
		//Person���͵ı���Person.name ����Person��name
		System.out.println(tricker.name+","+person.name);
		//�����Ƕ�̬�󶨵������ɾ���������;��������ĸ�����
		//������tricker����person����Tricker��������ã�getName()
		//���õĶ���Tricker���͵ķ����������ͷ����������ˣ�
		System.out.println(tricker.getName()+","+person.getname());
		//���ۣ�
		//�����ǰ󶨵����������ϵģ���̬�󶨣����ݱ������ͷ�������
		////�����Ƕ�̬�󶨵������ɾ���������;��������ĸ�����
		//��̽��飺
		//	A ���಻���鶨���븸��ͬ��������
		//  B ����ʹ��getXXX()�����������Ե�ֵ�����������ȶ���
	}

}
class Person{
	String name;
	public Person(String name){
		this.name=name;
	}
	/**��������*/
	public String getname(){
		return name;
	}
}
/**ƭ��*/
class Tricker extends Person{
	String name;
	public Tricker(String name){
		super("Tom");
		this.name=name;
	}
	public String getName(){
		return name;
	}
}	
//�߼�������
//class Student extends Person{
//	String name;
//}