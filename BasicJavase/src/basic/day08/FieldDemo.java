package basic.day08;
/**
 	��̬�󶨣�java�������ñ������Ͳ�������
 	��̬�󶨣�java����ʵ�ʵĶ�����ҷ���
 	  �� Student �������� 2 ������ name��ϵͳΪ�˼������֣���Ϊͬ�����Լ�һ����ǩ�������Ա��
Ϊ��ջ�ڴ������������ñ��������ͣ����þ������ñ���.����ʱ�����ݱ�ǩȥ�ң����������Ϊ��̬��
ע�⣺��������ҵ����آ�����ڿ��������м��ٻ���������͸��ඨ��ͬ�����Ե���������Խ��飺��������ʹ�÷�������
�� Java �н����ֽ���Ĺ淶�ܽ��һ�ף����ǳ�֮Ϊ��JavaBean �淶����
  ���� JavaBean �淶��JavaBean آ���﷨�淶����ϰ���Ա�̹淶��������淶д����ʹ�÷��㡣
��ʱ�� JavaBean ����Ҳ��Ϊ:POJO �ࣨPlan Old Java Object��
  �򻯹淶��
  1)   �����а���package��
  2)   Java �࣬�����޲���������
  3)   ���� getXxx() �� setXxx() ������ Bean ����
            �磺getName() �� setName(String n) ������ Bean ����Ϊ��name, ���Ƿ���ʵ������name�޹�
            boolean ���͵� get ����������������ʽ��getMarried() ���� isMarried()
  4)   ����ʵ�����л��ӿڣ�ע����ѧϰ IO ��ʱ�����ѧϰ��
  JDK �ṩ���༸�������� JavaBean �淶���磺String ��, ������
  JavaBean ���ĺô�����ʹ�÷��㡱

 */
public class FieldDemo {

	public static void main(String[] args) {
		Student tom = new Student("Tom Wang");
		System.out.println(tom.name);
		Person5 p = tom;
		System.out.println(p.name);
	}

}
class Person5{
	String name;
}
class Student extends Person5{
	String name;
	public Student(String name){
		this.name=name;
		super.name="p"+name;
	}
}