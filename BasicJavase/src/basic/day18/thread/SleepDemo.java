package basic.day18.thread;

public class SleepDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();//��õ�ǰ�߳�
				System.out.println("ִ���̣߳�"+t.getName());
				try {
					Thread.sleep(1000);
					System.out.println("���߽�����"+t.getName());
				} catch (InterruptedException e) {
					//�ȷ������������ٷ�����׼����������Ϊ���ǲ����ģ������Ⱥ���򲻶���
					e.printStackTrace();//System.error�����������
					System.out.println("interrupt������𰡣�");//System.out��׼�������
				}
			}
		};
		//�����߳�ʱ����main���������ڣ�unning��
		t.start();//���̣߳�����run������ʵ�ֲ���
		Thread.sleep(500);
		t.interrupt();
		System.out.println("main ����");
	}
}
