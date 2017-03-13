package basic.day19.reflection;
/**
 * Class�౾��û�ж��幹�췽�����������Ҫʹ�������ȱ���ͨ��forName()
 * ����ʵ��������Ҳ����ʹ�á���.class���򡰶���.getClass()������ʵ����
 */
public class GetClassDemo01 {
	public static void main(String[] args) {
		Class <?> c1 = null;//ָ������
		Class <?> c2 = null;
		Class <?> c3 = null;
		try{
			c1 = Class.forName("basic.day19.reflection.X");//��õ���ʽ
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		c2 = new X().getClass();//ͨ��Object���еķ���ʵ��
		c3 = X.class;//ͨ����.classʵ����
		System.out.println("�����ƣ�"+c1.getName());//�õ��������
		System.out.println("�����ƣ�"+c2.getName());
		System.out.println("�����ƣ�"+c3.getName());
	}
}	
class X{}