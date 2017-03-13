package basic.day18.mldn.generics;
/**���� �� ��ȫ����
 *�ڷ���Ӧ������������������ʱָ�����ڲ����������ͣ��磺Info<String>,
 *�����ָ�����ͣ������û���ʹ����������ʱ���ͻ���ֲ���ȫ�ľ�����Ϣ
 */
/*
 * ����ʱ���־��棬���ǲ���Ӱ���������С�û��ָ��ʱ�����е�����ͳһʹ��Object���н��ա�
 * �±ߵ�var����ʵ������Object���͵�
 * Info<Object> i = new Info<Object>();//���棬û��ָ����������
		i.setVar("�ֶ���");
		System.out.println("���ݣ�"+i.getVar());
 */
class Info<T>{//�˴�����������ı�ʶ���ţ�T��type�ļ��
	private T var ;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	@Override
	public String toString() {
		return this.var.toString();
	}
}
public class GenericsDemo07 {
	public static void main(String[] args) {
		Info i = new Info();//���棬û��ָ����������
		i.setVar("�ֶ���");
		System.out.println("���ݣ�"+i.getVar());
	}
}
