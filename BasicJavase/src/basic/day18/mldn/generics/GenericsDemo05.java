package basic.day18.mldn.generics;
/**ʹ��Point�ཫvar���������ó�����
 * Point5.java�е�setter��getter�����ͱ�� �ˣ�
 * �˳���Point���е�var�������ó�Integer���ͣ�������������ʵ��������ʱʹ��Point<Integer>������ʵ����
 * 	private T var;//�˱������������ⲿ����
 * 
	public Integer getVar(){//����ֵ���������ⲿָ��
		return var;
	}
	public void setVar(Integer var){//���õ��������ⲿָ��
		this.var=var;
	}
 */
public class GenericsDemo05 {
	public static void main(String[] args) {
		// ���Ͷ����壺������<������> �������� �� new ������<������>();
		Point5<Integer> p = new Point5<Integer>();//�����var����ΪInteger����
		
		p.setVar(30);//�������֣��Զ� װ��
		System.out.println(p.getVar()*2);//��������������ȡ��
	}
}
