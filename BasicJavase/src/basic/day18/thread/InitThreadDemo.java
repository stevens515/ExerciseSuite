package basic.day18.thread;

public class InitThreadDemo {
	public static void main(String[] args) {
//		Runnable r = new Runnable(){};
		class Tester implements Runnable{//�ֲ��ڲ���
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			}
		}
		Thread t1 = new Thread(new Tester());
		t1.start();
		//�ڲ���
		Runnable r = new Runnable(){//
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			}
		};
		Thread t2 =new Thread(r);
		Thread t3 = new Thread(r);
		t2.start();
		t3.start();
		//�����ڲ���
		Thread t4 =new Thread(new Runnable(){
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			}
		});
		t4.start();
		//�ڲ���
		new Thread(){		
			public void run() {
			Thread t = Thread.currentThread();
			System.out.println(t.getName());
		}}.start();
		//�ڲ���
		new Thread(new Runnable(){

			public void run() {
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
			
			}}).start();
	}
}
