package basic.day09;

public class FinalMethodDemo {
	public static void main(String[] args) {
		
	}
}
class Foo{
	public final int add(int a,int b){
		return a+b;
	}
	private final int add(int a,int b,int c){//˽�з������ܼ̳У�ֻ���ڱ����пɼ����������в��ɼ�
		return a+b+c;
	}
	
	public int add(int b){
		return b+b;
	}
}
class Koo extends Foo{
	//����ֻ�ܼ̳и���ɼ�������˽�з������ܱ��̳У�˽�з���û�и���
	public int add(int a,int b,int c){//���·��������Ǹ��� 
		return a+b+c+1;
	}
//	public int add(int a,int b){//�������final�ķ������ɱ����ǡ�
//		return a+b+1;
//	}
	public int add(int b){//��������
		return b+1;
	}
}