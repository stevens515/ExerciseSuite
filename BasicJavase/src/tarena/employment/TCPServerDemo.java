package tarena.employment;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
  public static void main(String[] args) throws IOException {
    TCPServerDemo server = new TCPServerDemo();
    server.start();
  }
  public void start() throws IOException {
    //ServerSocket ��������󶨵�ǰ�������Ķ˿�8000
    //һ���˿�ֻ�ܱ���һ��, ����ظ���, �ᷢ��ǰ�쳣!
	//������Ҫ������������ȥ����
	// new Socket()���췽�������ӷ�����(��accept()���������)��
	// ���ӳɹ�����Socketʵ��s, ����ʧ���׳��쳣��s����ͻ��˵�������������
    ServerSocket ss = new ServerSocket(8000);
    while(true){
      //accept() ��������IO Block(IO����), �ȵ�IO��ɲż���ִ��
      //Ŀ��: �ڶ˿�8000�ϵȴ��ͻ��˵�����, ����ͻ����ӳɹ�
      // �ͽ���Block����ִ��, ���ҷ���Socket(�׽���)ʵ�� s
      // s ����ͻ�������, ��������а��������� in��out
      // in ����ͻ�������˵�����
      // out ������������ͻ��˵����
      Socket s = ss.accept();
      // һ��ᴴ���ͻ��˷����߳�Ϊ�ͻ��ṩҵ�����
      new Service(s).start();
    }
  }
  /** �ͻ������߳�, Ϊÿ���ͻ�����һ���߳�ʵ�� */
  private class Service extends Thread{
    Socket s;
    public Service(Socket s) {
      this.s = s;
    }
    /** run������Ҫ��ɶԿͻ��ķ����� */
    public void run(){
      try{
        //����˵�in����ͻ��˵ĵ�����������Ϣ����
        //����˵�out������������ͻ�����Ϣ����
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        //Լ���ͻ��˷����������ı�, �ı���Ϣʹ�û�����Ϊ���
        //Scanner s = new Scanner(in);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(in));
        out.write("����, ����ɶ?\n".getBytes());
        out.flush();
        while(true){
          String str = reader.readLine();
          if(str.equals("����")){
            out.write("û�д���\n".getBytes());
            out.flush();
          }if(str.equals("ls")){
            File dir=new File(".");
            File[] files = dir.listFiles();
            for (File file : files) {
              out.write((file.getName()+"\n").getBytes());
            }
            out.flush();
          }else if(str.equals("����")){
            out.write("�������\n".getBytes());
            out.flush();
          }else if(str.equals("bye")){
            out.write("�ټ�, ��ӭ�´�����!\n".getBytes());
            out.flush();
            this.s.close();
            break;
          }
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
}