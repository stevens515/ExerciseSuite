package basic.day09.packages;

/**
 * java�ڱ����ڼ䰴�ա����������͡���鷽��������
 */
public class QQDemo {
	public static void main(String[] args) {
		QQ qq = new QQ();
		// Car car = new Car();//���ܴ����ӿ�ʵ��Cannot instantiate the type Car
		Car car = qq;// �ӿڿ��Զ�����������þ���ʵ�����ʵ��������
		car.run();
		car.stop();

		// �����ڼ䰴���ͼ��
		Product p = qq;
		// System.out.println(car.getPrice());//�������Car������û��getPrice()����
		System.out.println(p.getPrice());

	}
}
