package basic.day09;

/**final �ؼ��� 
		1)  final ���ε��࣬�����ٱ��̳�
		         Java �� String ���� final �࣬���ܱ��̳У�����������ܿ�����
		         Math �� final �࣬���ܱ��̳У�
		         Integer ��Long��Character �Ȱ�װ���� final �࣬���ܱ��̳У�
		         ��ʵ����Ŀ�����У�ԭ���ϲ�����ʹ�� final �࣡
		         Spring, Hibernate,Struts 2, ��Щ���ʹ����"��̬�̳д���"������ʹ�� final �����Ӱ
		          ��"��̬������" ��ʵ��.
		2)  final ���εķ����������ٱ�����
		         ��ʵ����Ŀ�����У�ԭ���ϲ�����ʹ�� final ������ ԭ��Ҳ����Ϊ: ��̬������
		3)  final ���εı�������ʼ���Ժ��������޸���
		         final �ֲ�����
		         final ��������
		         final �ĳ�Ա����
		4) final static -- Java ʹ�� final static ���εı�����Ϊ����
		        һ��Ҫ���������д�д��ĸ
		        Java �������� const��c��c++�����γ��������η���
		 
 */
public class FinalFieldDemo {

	public static void main(String[] args) {
		Goo g1 = new Goo();
		Goo g2 = new Goo();
		System.out.println(g1.id+","+g2.id+","+Goo.index);//1,2,3
//		g1.id = 8;//�������id���Գ�ʼ�����������޸�
	}

}
class Goo{
	static int index =1;
	final int id;
	public Goo(){
		this.id = index++;
	}
}
