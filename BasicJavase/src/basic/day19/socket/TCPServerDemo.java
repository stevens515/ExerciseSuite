package basic.day19.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/*
 * ֻ�е�ʳ�ÿ��ţ����ǲ���ȥ�������൱�ڿͻ��ˣ�ʳ���൱�ڷ���ˣ�����Ҫ�ȿ�������˲���
 * ��ѧʱȥʳ��2�����򷹣�ѡһ������ȥ��
 * ���telnet localhost �˿ں�   ָ��������˿ڵķ�����
	telnet 127.0.0.1 8000		 ���ϱ�һ��
	Server�ˣ�
	ServerSocket�󶨶˿ںţ�new��ɺ󣬷������˾������ �ˣ��˿�Ϊ�ͻ��ṩ����
	.acceput()�����ͻ��˼���
	Socketʵ�������ͻ������̴߳���Service��
	Client�ˣ�
		new Socket����ʵ��
		����������ӳɹ��󣬴���Socketʵ��
		�������߳�write,reader����
		
		����֧����ˣ��������ͻ���
 */
public class TCPServerDemo {
	public static void main(String[] args) throws IOException {
		TCPServerDemo server = new TCPServerDemo();
		server.start();
	}
	private void start() throws IOException {
		//�˿ڷ�Χ��0��65535��Լ�������ò�����10000�ģ�10000������ϵͳ��
		//ServerSocket��������󶨵�ǰ�������Ķ˿�8000
		//һ���˿�ֻ�Ա���һ�Σ�����ظ��󶨣��ᷢ��ǰ�쳣
		ServerSocket ss = new ServerSocket(8000);//ռ��������
		while(true){
		//accept()��������IO Block(IO����),�ȵ�IO��ɲż���ִ��
		//Ŀ�ģ��ڶ˿�8000�ϵȴ��ͻ��˵����ӣ�����ͻ����ӳɹ���
		//�ͽ���Block����ִ�У����ҷ���Socket(�׽���)ʵ��s
		//s����ͻ������ӣ���������а���������in��out
		//in����ͻ�������˵�����
		//out������������ͻ��˵����
		Socket s = ss.accept();//��ʼ���ܷ���������
		//һ��ᴴ���ͻ��˷����߳�Ϊ�ͻ��ṩҵ�����
		new Service(s).start();//һ���������ڿ�����n������Ա�����������Աͬʱ���������߳�
		}
	}
	/**�ͻ������̣߳�Ϊÿ���ͻ�����һ���߳�ʵ��*/
	private class Service extends Thread{
		Socket s;//s����ͻ�
		public Service(Socket s){
			this.s = s ;
		}
		/**��run������Ҫ�ṩΪ�ͻ��ķ�����*/
		public void run(){//run���쳣�������׵�,��Ȼrun
			try{
			//����˵�in����ͻ��˵ĵ�����������Ϣ����
			//�ͻ�˵ʲô����in �л��
			//����˵�out������������ͻ�����Ϣ����
			//����Ա�Կͻ��ķ�����out��
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			//Լ���ͻ��˷����������ı����ı���Ϣʹ�û�����Ϊ���
			//��Ϊ���п��Դ��κζ�������ҪԼ��
//			Scanner s = new Scanner(in);//����������һ�����ӿͻ��˶�
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			out.write("hello,what do you want?\n".getBytes());//��ʾ�ڻ�ȡ�ͻ�˵��ǰ�����ͻ�����к���
			out.flush();
			while(true){
			//readLine()ʱ������IOBlock���ȴ���ֻ����������Ϣʱ���У�������Ϣ���ǿͻ��˷�������Ϣ
			String str = reader.readLine();//���ֻس��Ž�����һ����
			if(str.equals("apple")){
				out.write("����û��ƻ������\n".getBytes());//����\n(����)�Ž�����һ��
				out.flush();//д����Ŀ���ǿͻ��ˣ���д�����ͻ��˿��ܿ�����
			}if(str.equals("ls")){
				File dir = new File(".");
				File[] files = dir.listFiles();
				for(File file:files){
					out.write((file.getName()+"\n").getBytes());
				}
				out.flush();
			}else if (str.equals("fish")){
				out.write("���Եĺ���û��ԣ�\n".getBytes());
				out.flush();
			}else if(str.equals("dumpling")){
				out.write("���㣬����Խ��ˣ�\n".getBytes());
				out.flush();
			}else if(str.equals("bye")){
				out.write("�ټ�����ӭ�´�������\n".getBytes());
				out.flush();
				this.s.close();//in��out����Socket������ֻҪ����Socket������
				break;
			}
			}
			
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
