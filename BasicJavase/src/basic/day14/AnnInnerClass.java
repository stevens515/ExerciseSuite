package basic.day14;
/**�����ڲ���
 *new Koo()���������Ͷ���
 *new Koo(){}���������������ڲ��� 
 */
public class AnnInnerClass {
public static void main(String[] args) {
	//new Koo()����Koo��ʵ������
	//new Koo(){}���������ڲ��࣬�Ƕ�Koo��ļ̳У���������
	//ʵ����Ϊһ���������������Koo�������ͣ�����������)ʵ����
	//�����ڲ��෵�ص��Ƕ������У��������壬�����������
	//����������п���ʵ���κ������͵��﷨�����巽�������ԣ�����...), 
	Koo koo = new Koo(){};
	Koo k1 = new Koo(){
		public String toString(){//���Ǹ����͵�toString()����
			return "Object k1";
		}
	};
	System.out.println(k1);//Object k1
	//֤����k1���õ�ʵ���е�toString()�����������ˣ�k1���õ���
	//������ʵ����
	
	//��������Լ̳�(��ʵ��)���࣬�������ӿ�
	//�ڼ̳�(��ʵ��)�������ӿ�ʱ��Ҫ���ؼ̳е��﷨
	//����ʵ�����еĳ��󷽷���
	//Moo moo = new Moo(){};�����������Ϊû��û��ʵ�ֳ��󷽷�
	//"new Moo();"�����á�"new Moo(){}"�������ڲ��࣬�ǿ��Ե�
	//"new Moo(){}"���ԣ��ⲻ��ʵ���������Ǽ̳У�ʵ��������
	//Moo moo = new Moo();//������󣬲���ʵ�����ӿڣ�������
	final int x = 5;
	Moo moo = new Moo(){
		public int add(int b){//���������뷽����
			return b+1;
//			return b+1+x;�ӱ���ҲҪ��final���͵�
		}
	};
	System.out.println(moo.add(5));
	}
}
interface Moo{
	int add(int a);
}
class Koo{
	
}