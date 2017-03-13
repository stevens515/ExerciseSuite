package basic.day19.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP���ģ���������"rfc tcp" �ͻ��˳��򣬲��ܵ�����
 */
public class TCPClientDemo {
	public static void main(String[] args) {
		TCPClientDemo clent = new TCPClientDemo();
		clent.open();
	}

	public void open() {
		try {
			// ������Ҫ������������ȥ����
			// new Socket()���췽�������ӷ�����(��accept()���������)��
			// ���ӳɹ�����Socketʵ��s, ����ʧ���׳��쳣��s����ͻ��˵�������������
			Socket s = new Socket("localhost", 8000);
			InputStream in = s.getInputStream();// in����write����
			OutputStream out = s.getOutputStream();// out����Reader����
			new Writer(in, s).start();
			new Reader(out, s).start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ�ܣ�");
		}
	}

	/** ���𽫷���������������Ϣд������̨�� */
	class Writer extends Thread {
		InputStream in;

		Socket s;

		public Writer(InputStream in, Socket s) {
			this.in = in;
			this.s = s;
			setDaemon(true);// ��̨�߳�
		}

		public void run() {
			// ���𽫷���������������Ϣд������̨��
			Scanner sc = new Scanner(in);// ����������Socket��õ�in
			while (true) {
				String str = sc.nextLine();// IO Block�ģ���in������س��Ž�����
				System.out.println(str);
			}
		}
	}

	/** ���𽫿���̨�ϵ���Ϣ���͵��������� */
	class Reader extends Thread {
		OutputStream out;

		Socket s;

		public Reader(OutputStream out, Socket s) {
			this.out = out;
			this.s = s;
		}

		public void run() {// ����̨�ϵ���Ϣ����������
			Scanner sc = new Scanner(System.in);// ����̨
			while (true) {// �к��У����������Ϸ�
				try {
					String str = sc.nextLine();
					out.write((str + "\n").getBytes());
					out.flush();
//					if (str.startsWith("bye")) {
//						break;
//					}
					 if(str.equals("bye")){
							out.write("�ټ�����ӭ�´�������\n".getBytes());
							out.flush();
							this.s.close();//in��out����Socket������ֻҪ����Socket������
							break;
					 }
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
}
