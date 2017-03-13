package basic.day19.reflection;
/**ͨ���޲ι���ʵ��������
 * �������һ���޲ι��죡����
 *���Ҫͨ��Class����ʵ����������Ķ��������ʹ��newInstance()������������Ҫ��֤
 *��ʵ���������д���һ���޲ι��췽����
 *
 *ͨ��Class.forName()����ʵ����Class����֮��ֱ�ӵ���newInstance()�����Ϳ���
 *���ݴ������������.��"���Ƶķ�ʽ���ж����ʵ������������ȫȡ����֮ǰʹ�ùؼ���new�Ĳ�����ʽ
 */
class Person{//����Person��
	private String name;
	private int age;
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
	@Override
	public String toString() {
		return "������"+this.name+"�����䣺"+this.age;
	}
}
public class InstanceDemo01 {
	public static void main(String[] args) {
		Class<?> c = null;//ָ������
		try{
			c=Class.forName("basic.day19.reflection.Person");//����Ҫʵ�������������.������
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Person per =null;//����Person����
		try{
			per = (Person)c.newInstance();//ʵ����Person����
		}catch(Exception e){
			e.printStackTrace();
		}
		per.setName("�ֶ���");//��������
		per.setAge(20);
		System.out.println(per);//�������������toString()
	}
}
