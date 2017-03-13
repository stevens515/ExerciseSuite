package basic.day18.thread;

import basic.day18.thread.Table.Person;

/**
 * �ٽ���Դ����, ͬ����������ͬ����
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		Table table = new Table();
		Person p1 = table.new Person();
		Person p2 = table.new Person();
		p1.start();
		p2.start();
	}
}

class Table {
	int beans = 20;

	Object monitor = new Object();// ͬ����������ͬ����,��ʡ�ԣ�����дthis

	// boolean monitor lock=false;//Ĭ��Ϊfalse
	// �õ���ʱΪtrue

	// ������ ,����������䣬��
	// Object monitor = new Object();// ͬ����������ͬ����,��ʡ�ԣ�����дthis
	// public int getBean() {
	// synchronized (monitor) {
	// int a = 5;
	// if (beans == 0)
	// throw new RuntimeException("û��");
	// Thread.yield();
	// return beans--;
	// }
	// }

	// // ������ ,��д��ȥ��������䣬 synchronized (monitor)�е�monitor�ĳ�this
	// // Object monitor = new Object();// ͬ����������ͬ����,��ʡ�ԣ�����дthis
	// public int getBean() {
	// synchronized (this) {
	// int a = 5;
	// if (beans == 0)
	// throw new RuntimeException("û��");
	// Thread.yield();
	// return beans--;
	// }
	// }

	// // ����������������ʱдsynchronized
	// public synchronized int getBean() {
	// int a = 5;
	// // synchronized (monitor) {
	// if (beans == 0)
	// throw new RuntimeException("û��");
	// Thread.yield();
	// return beans--;
	// }

	// �����ģ������������������룬�ٽ��������
	public int getBean() {
		if (beans == 0)
			throw new RuntimeException("û��");
		// Thread.yield(); //�Ķ�����һ������ ������
		try {
			Thread.sleep(100); // �Ķ�����������������Խ������Խ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return beans--;
	}

	class Person extends Thread {
		public void run() {
			while (true) {
				int bean = getBean();
				System.out.println(getName() + "�õ���" + bean);
				Thread.yield();
			}
		}
	}
}