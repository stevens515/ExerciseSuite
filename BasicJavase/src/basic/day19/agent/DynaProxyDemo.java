package basic.day19.agent;
/**
 *���Զ�̬����
 *�ӳ������н�����Է��֣���ɵĹ����뾲̬�������ûʲô��ͬ��������һ��Ŀ����к���ʹ�õ����ֶ�̬������ƣ������ڱ�д
 *һЩ�ײ�����ʹ��һЩ���(��Spring Framework)ʱ�����ֶ�̬����ģʽ�ͱȽϳ����ˡ�
 */
public class DynaProxyDemo {
	public static void main(String[] args) {
		MyInvocationHandler handler = new MyInvocationHandler();//ʵ�������������
		Subject sub = (Subject)handler.bind(new RealSubject());//�󶨶���
		String info = sub.say("�ֶ���", 21);//ͨ����̬������÷���
		System.out.println(info);//��Ϣ���
	}
}
