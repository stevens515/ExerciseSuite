package basic.day18.mldn.generics;
/**
 *java������ͨ�������������ʾ���Խ��մ����͵����ⷺ�Ͷ���
 * ��Ȼ�����ˣ�������ʹ�����﷨ʱҲ��һ��ע��㣬
 * �����ʹ���ˡ�?�����շ��Ͷ����������ñ�����ָ�������ݣ����£�
 * ������������Ϊnull
 */
public class GenericsDemo09 {
	public static void main(String[] args) {
		Info<?> i = new Info<String>();//ʹ�á��������շ��Ͷ���
//		i.setVar("�ֶ���");//�����޷�����
		i.setVar(null);//���� ����
	}
}
