package basic.day19.agent;
/**
 *�ӽ���п��� ���֣�Ĭ�ϵ�ClassLoader����AppClassLoader���ڿ������û�Ҳ����ͨ���̳�ClassLoader����ʵ��
 *�Լ���������������������������岻��
 */
class Person{}
public class ClassLoaderDemo {
	public static void main(String[] args) {
		Person stu = new Person();//ʵ�����������
		System.out.println("���������"+stu.getClass().getClassLoader().getClass().getName());
	}
}
