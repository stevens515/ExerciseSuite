package basic.day18.mldn.generics;

/**
 * ͨ��� �ڷ��� ��Ĳ����У��ڽ������ô���ʱ�������ͱ���ƥ��ſ��Դ��ݣ��������޷����ݵġ�
 * ��Ȼû���﷨���󣬵���fun()������Info�в�û��ָ���κεķ������ͣ����������׵�������Ϊ�˽��������⣬
 * java������ͨ�������������ʾ���Խ��մ����͵����ⷺ�Ͷ���
 * ��Ȼ�����ˣ�������ʹ�����﷨ʱҲ��һ��ע��㣬�����ʹ���ˡ�?�����շ��Ͷ����������ñ�����ָ�������ݣ����£�
 */
public class GenericsDemo08 {
	public static void main(String[] args) {
		Info<String> i = new Info<String>();// ָ��StringΪ���ͷ�������
		i.setVar("�ֶ���");

		// �������ȷִ�У����Խ�fun()�����ж����Info<Object>�޸�ΪInfo������ָ������
		fun(i);// 1.Info<Object>ʱ���������
	}

	// 1.Info<Object>ʱ���������
	// ����String��Object������࣬�����ڽ������ô���ʱҲͬ���޷����в�����
	// public static void fun(Info<Object> temp){//�˴����Խ���Object����
	// System.out.println("���ݣ�"+temp);
	// }
	// 2.Infoʱ����������
	// public static void fun(Info temp) {// �˴����Խ���Object����
	// System.out.println("���ݣ�" + temp);
	// }
	// 3.Info<?>����������
	public static void fun(Info<?> temp) {// �˴����Խ���Object����
		System.out.println("���ݣ�" + temp);
	}
}
