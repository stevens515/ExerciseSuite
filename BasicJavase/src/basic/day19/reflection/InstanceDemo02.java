package basic.day19.reflection;
import java.lang.reflect.Constructor;
/**
 * newInstance()�������ʵ������������
 * �����в�������ʵ��������
	ֻ���ڲ���ʱ��Ҫ��ȷ�ص������еĹ��췽���������������ݽ�ȥ֮��ſ��Խ���ʵ����������
	���裺(1)ͨ��Class���е�getConstructors()ȡ�ñ����е�ȫ�����췽��
		(2)���췽���д���һ�����������ȥ����������˹��췽��������ĸ�������
		(3)֮��ͨ��Constructorʵ��������
 */
class Person2{
	private String name;
	private int age;
	public Person2(String name, int age) {
		this.setName(name);
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
	@Override
	public String toString() {
		return "������"+this.name+",���䣺"+this.age;
	}
}
public class InstanceDemo02 {
	public static void main(String[] args) {
		Class<?> c = null;
		try{
			c = Class.forName("basic.day19.reflection.Person2");//����Class����
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Person2 per = null;
		Constructor<?> cons[] = null;//����һ����ʾ���췽��������
		cons = c.getConstructors();//ͨ������ȡ��ȫ������
		try{
			//���췽���д��ݲ������˷���ʹ�ÿɱ�������գ���ʵ��������
			per = (Person2)cons[0].newInstance("�ֶ���",20);//��Ϊֻ��һ�����죬���������±�Ϊ0
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(per);//�������
		
	}
}
