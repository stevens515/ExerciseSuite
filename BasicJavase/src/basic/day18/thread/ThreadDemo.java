package basic.day18.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		Thread t = new Thread(){
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println(t.getId()+","+t.getName());
			}
		};
		//��Ӧ�õ���t.run()���������Ὺ�����̣߳����Ὺ�������߳�
		//û���������Լ������̵߳ģ�����������
		t.run();//�����߳���ִ��run()�������߳���˳��ִ�У�û��ʵ�ֲ���
		//���ţ����Լ�����run(),�Լ��ܣ����̵߳ģ�������
//		t.start();//�������̣߳������߳���ִ��run(),�ǲ���ִ��
	}
}
