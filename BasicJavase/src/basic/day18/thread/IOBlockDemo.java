package basic.day18.thread;

import java.util.Random;
import java.util.Scanner;

public class IOBlockDemo {
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("�߳�" + t.getName() + "����");
				Scanner in = new Scanner(System.in);
				// System.out.println("�����߳�IO BIOCK��");
				// IO Block �����̣߳�ֱ��IO����̼߳���ִ��
				// String str = in.nextLine();//IO Block ֱ��IO����̼߳���ִ��
				// System.out.println("IO ��� �� str:"+str);
				// ��IO Block
				int n = in.nextInt();
				System.out.println("IO ��� �� str:" + n);
				Random random = new Random();
				n = random.nextInt();// ����Block��������������������
				System.out.println(n);
			}
		};
		t.start();
	}
}
