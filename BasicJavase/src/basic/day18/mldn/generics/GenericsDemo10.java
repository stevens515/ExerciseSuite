package basic.day18.mldn.generics;
/**��������
 *	���ڼ���һ���������ܽ��յķ��Ͷ���ֻ��������(Byte,Short,Long,Integer,Float,Double)���ͣ�
 *��ʱ�ڶ��巽���������ն���ʱ���ͱ���ָ�����͵����ޡ���Ϊ���е����ְ�װ�඼��Number���͵����࣬���Դ������£� 
 *
 *���÷���ֻ�ܽ��շ���ΪNumber��Number���͵�����
 */
public class GenericsDemo10 {
	public static void main(String[] args) {
		Info<Integer> i1 = new Info<Integer>();//����Integer�ķ��Ͷ���
		Info<Float> i2 = new Info<Float>();
		i1.setVar(30);//�����������Զ�װ��
		i2.setVar(30.1f);//����С�����Զ�װ��
		fun(i1);//�����ֿ��Դ���
		fun(i2);//��С�����Դ���
		//��������ܴ����ַ���
//		Info<String> i3 = new Info<String>();//����String�ķ��Ͷ���
//		i3.setVar("hello");
//		fun(i3);
	}
	//����Info���󣬷�Χ��������ΪNumber,����ֻ�ܽ�����������
	public static void fun(Info<? extends Number> temp){
		System.out.println(temp+",");
	}
}
