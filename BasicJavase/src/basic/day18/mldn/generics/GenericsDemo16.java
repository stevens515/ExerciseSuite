package basic.day18.mldn.generics;
/**ͨ�����ͷ������ط���ʵ��
 *	�������ͨ�����ͷ�������һ���������ʵ��������
 *	������ڷ����ķ���������������ȷ��ָ�����ͱ�ʶ  
 */
class Info6<T extends Number>{	//�˴�����ֻ������������
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
public class GenericsDemo16 {
	public static void main(String[] args) {
		Info6<Integer> i = fun(30);
		System.out.println(i.getVar());
	}
	//<T extends Number>ָ�������д���򷵻صķ��������ɵ��÷���ʱ�����õĲ������;��� 
	public static <T extends Number> Info6<T> fun(T param){
		Info6<T> temp = new Info6<T>();//���ݴ������������ʵ����Info6����
		temp.setVar(param);//�����ݵ��������õ�Info6���е�var����֮��
		return temp;//����ʵ��������
	}
}
