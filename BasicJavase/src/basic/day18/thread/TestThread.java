package basic.day18.thread;

public class TestThread {
	public static void main(String[] args) {
		Person1 p1 = new Person1();// ������һ���̶߳����߳�ʵ��
		Person2 p2 = new Person2();
		Person3 p3 = new Person3();
		p1.setPriority(Thread.MIN_PRIORITY);// ����Ϊ��͵����ȼ�����1��10֮��
		p1.setDaemon(true);// ����Ϊ��̨�߳�
		p3.setPriority(Thread.MAX_PRIORITY);// ���10
		p1.start();// ��������������߳��е�run()����
		p2.start();// Ĭ�����ȼ�5
		p3.start();
		System.out.println("main over!���߳̽�����");
	}

}

class Person2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("����˭?");
			Thread.yield();// ��ǰ�߳��ó�����������Running���ص�ʱRunnable
		}
		System.out.println("����˭? OVER!");
	}
}

class Person1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("����������Ҳ�����");
			Thread.yield();
		}
		System.out.println("�����ӣ�OVER!");
	}
}

class Person3 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("��ˮ��ģ�");
			Thread.yield();
		}
		System.out.println("��ˮ��OVER!");
	}
}
/**
 * ��̨�߳�(�ػ��߳�, �����߳�) 
 * t1.setDaemon(true); Java���̵Ľ���: 
 * ��ǰ����ǰ̨�̶߳�����ʱ, Java���̽��� ��̨�߳�,
 * �����Ƿ����, ����ͣ��! ��Ϊ����������, ��̨�߳� ������������!
 */
