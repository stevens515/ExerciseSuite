package basic.day09.packages;


/**
 *implementsʵ�֣��������Ǽ̳У���javaһ����ֻ�ܼ̳�һ������
 *������ʵ�ֶ���ӿڣ���Ｔ��Ҳ�ǵĹ�ϵ��
 *QQ����Car��Ҳ��Product,Ҳ��Object(����)
 *
 *������ʵ�ֽӿ�Ҫʵ��ȫ���ĳ��󷽷����ӿڷ�����
 */
public class QQ extends Object implements Car,Product {
	public String getType() {
		return TYPE_A;//TYPE_A�̳���Car
	}

	public void run() {
		System.out.println("����");
	}

	public void stop() {
		System.out.println("ͣ��");
	}

	public double getPrice() {
		return 29999;
	}

}
