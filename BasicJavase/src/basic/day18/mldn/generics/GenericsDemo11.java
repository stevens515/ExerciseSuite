package basic.day18.mldn.generics;
/**Ҳ���������������ָ�����͵����޷�Χ��
 * [��ʽ10-4 ��������]
	��������������<? extends ��> ��������
	�����ࣺ[����Ȩ��] ������<���ͱ�ʶ extends ��>{}
 */
public class GenericsDemo11 {
	public static void main(String[] args) {
		Info2<Integer> i1 = new Info2<Integer>();//
		System.out.println("���ݣ�"+i1);
		
		//��������
		//Info<String> i2 = new Info(String)();
		//System.out.println("���ݣ�"+i2);
	}
}
class Info2<T extends Number>{
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