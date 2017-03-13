package basic.day19.high_level;

/**
 * �������ģʽ ������Ӧ�õ�����ģʽ�� ʹ������������ʱ���Բ������κε��޸ģ��Ϳ��Դﵽ���ܵ����䡣
 */
interface Fruit { // ˮ���ӿ�
	public void eat();// ��ˮ��
}

class Apple implements Fruit {// ����ƻ��
	public void eat() {// ��д���󷽷�
		System.out.println("**��ƻ����");
	}
}

class Orange implements Fruit {// ��������
	public void eat() {
		System.out.println("**������");
	}
}

class Factory {
	public static Fruit getInstance(String className) {// ȡ�ýӿ�ʵ��
		Fruit fruit = null;// ����ӿڶ���
		try {
			fruit = (Fruit) Class.forName(className).newInstance();// ʵ��������
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fruit;
	}
}

public class FactoryDemo01 {

	public static void main(String[] args) {
		// ͨ��������ȡ�ýӿ�ʵ�������������İ�.������
		Fruit f = Factory.getInstance("basic.day19.high_level.Apple");
		if (f != null) {// �ж��Ƿ�ȡ�ýӿ�ʵ��
			f.eat();// ���÷���
		}
	}
}
