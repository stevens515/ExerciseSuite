package basic.day09;

/**final �ı��������Գ�ʼ���������޸�*/
public class FinalVarDemo {

	public static /*final*/ void main(/*final*/String[] args) {//�Ӳ���fianl������
		final int a = 1;//�ֲ������������������ı���
		//a=a++;//A�������Σ�������final���ܸ���
		//a++;//�������final���ܸ���
		System.out.println("a="+a);//a=1
		
		int b = add(a,a);
		System.out.println("b="+b);//3
		
		final int[] ary = {3,4,5};
//		ary = null ;//������󣬲����޸�fianl������ֵ��
		ary[1] = 8;//�����޸Ķ��������
		//˵����ȷ�У�final�������ǲ����޸ĵ�
		final String[] names = {"Tom","Jerry"};
	}
	public static /*final*/ int add(final int a,int b ){
		//��������Ҳ�Ǿֲ�������
		//���������ڵ��÷��������ݲ���ʱ���ʼ��
//		a++;//�����a�����޸�
		b++;//û�������޸�
		return a+1;
	}
}
