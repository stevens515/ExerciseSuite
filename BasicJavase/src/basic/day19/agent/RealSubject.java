package basic.day19.agent;
/**
 * ������ʵ����ʵ����
 * ���ඨ���˽ӿڼ���ʵ�����࣬�����ڲ���ʱֱ�ӽ���ʵ������Ķ����뵽
 * MyInvocationHandler���bind()�����м���
 */
public class RealSubject implements Subject {//��ʵʵ����

	public String say(String name, int age) {//��дsay()����
		return "����:"+name+",���䣺"+age;  //������Ϣ
	}

}
