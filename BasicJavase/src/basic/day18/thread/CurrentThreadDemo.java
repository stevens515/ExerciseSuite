package basic.day18.thread;

/**
 * ��ǰ�̣߳����߳���
 */
public class CurrentThreadDemo {
	public static void main(String[] args) {
		// main�����Ǳ����̵߳��õ�
		// ���߳���Threadʵ��
		// ����ʹ��Thread.currentThread()������ڵ��õ�ǰ�������߳�
		Thread main = Thread.currentThread();
		// ����main�������̵߳�����
		// �߳���ID��������
		System.out.println(main.getId() + "," + main.getName());
		test();
		Thread t = new Thread() {
			@Override
			public void run() {
				// this����ǰ�࣬��Thread������
				System.out.println("run:" + this.getId() + "," + this.getName());
				test();
			}
		};
		t.start();
	}

	public static void test() {
		Thread t = Thread.currentThread();
		// t���õ������ڵ���test()�������߳�
		System.out.println("test:" + t.getId() + "," + t.getName());
	}
}
