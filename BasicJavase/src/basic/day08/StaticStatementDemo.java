package basic.day08;

/**
 	��̬����飬����ļ����ڼ�ִ�У���ֻ����һ�Σ�����ִֻ��һ��
 	�Ǿ�̬����飬�ڴ���ʱ��ִ�У�ÿ����һ�������ִ��һ��
 */
public class StaticStatementDemo {

	public static void main(String[] args) {
		Xoo x1 = new Xoo();
		Xoo x2 = new Xoo();
	}

}
class Xoo{
//	System.out.println("HI");//���������������С�
	{
//		System.out.println("HI");//û���ˣ���������Ŀ����С�
		System.out.println("�Ǿ�̬�����");
	}
	static {
		System.out.println("��̬�����");
	}
	public Xoo(){
		System.out.println("ִ�й�������");
	}
}
/**������£�
 	��̬�����
	�Ǿ�̬�����	
	ִ�й�������
	�Ǿ�̬�����
	ִ�й�������
 */