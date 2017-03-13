package basic.day18.thread;
/**
 * ����ͬ����
 * 	Ӧ��ԭ�򣺾����ܲ���������ͬ����Χ
 * 	
 * 	�ٽ���Դ���Ƕ���̹߳������(��д)����Դ(���󣯱���)
 * 		�������ٽ���Դ��ʵ������(���������)�;�̬����
 * 
 * 	�ٽ���Դ�ķ�����Ҫͬ���鱣����	
 * 
 * 		�ֲ����������ڷ����ڲ��������ʱ�����������ٽ���Դ��	
 * add()��add(b)��ͬ����
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Foo foo =new Foo();
		Thread t =new Thread(){
			public void run(){
				foo.add();
//				foo.add(5);
			}
		};
		t.start();
//		foo.add();
		foo.add(8);
	}
}
class Foo{
	int a = 1;
	/**
	 ��synchronized�����
	 			add start
				add over
				add start
				add over
	����synchronized�����
				add start
				add start
				add over
				add over
	*/
	public synchronized void add(){//������ִ����ͬ����
		a++;
		System.out.println("add start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("add over");
	}
	public synchronized void add(int b){
		a+=b;
		System.out.println("add b start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("add b over");
	}
	
}