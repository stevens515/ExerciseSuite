package basic.day18.thread;

public class SleepDemo2 {
	public static void main(String[] args) {
		//˯���������ѵ��߳�
		 final Thread she = new Thread(){
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println("˯��");
					try{
						Thread.sleep(1000);
						System.out.println("�����ˡ�������");
					}catch(InterruptedException e){
						System.out.println("�����ģ������أ���0_��");
						break;
					}
				}
			}
		};
		//��ǽ�̣߳��ҿ��Ժ���she
		Thread he =new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("�٣���ǽ��");
					try{
						Thread.sleep(200);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("�ƿ��ˣ�����");
				she.interrupt();
			}
		};
		she.start();
		he.start();
	}
}
