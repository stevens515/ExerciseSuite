package basic.day18.mldn.generics;
/**���͵�����
	��ʹ�õķ���ֻ���ڱ��༰�丸��������Ӧ��ʱ���ͱ���ʹ�÷��� �ķ�Χ���޽�������
	[��ʽ10-5 ��������]
	��������������<? super ��> ��������
	�����ࣺ[����Ȩ��] ������<���ͱ�ʶ extends ��>{}
 */
class Info3<T>{
	private T var;

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
public class GenericsDemo12 {
	public static void main(String[] args) {
		Info<Object> i1 = new Info<Object>();//�������޷�Χ
		Info<String> i2 = new Info<String>();
		i1.setVar(new Object());//����Object����
		i2.setVar("���˻�");//�����ַ���
		fun(i1);
		fun(i2);
	}
	public static void fun(Info<? super String> temp){//ֻ�ܽ���String��Object���͵ķ���
		System.out.println("���ݣ�"+temp);
	}
}
