package basic.day08;

/**
 	��̬���� ��̬����
 		A ��̬��������������ڼ���䣬ֻ��һ�ݣ�������ı���
 		B һ��ʹ���������ʾ�̬���Գ�Ա
 	�뾲̬�����෴��ʵ���������Ǿ�̬�����������ڶ���ʵ���ı���ÿ������һ��
 */
public class StaticFieldDemo {

	public static void main(String[] args) {
		Foo2 f1 = new Foo2();
		Foo2 f2 = new Foo2();
		//��̬����������.��̬���������磺Foo2.index
		System.out.println(f1.id+","+f2.id+","+Foo2.index);//1,2,3
		Foo2 f3 = new Foo2();//1,2,4,3,4
		System.out.println(f1.id+","+f2.id+","+Foo2.index+","+f3.id+","+Foo2.index);
	}

}
class Foo2{
	static int index=1;//��̬���ԣ���̬����
	int id;//ʵ������
	public Foo2(){
		this.id = index++;
	}
}
