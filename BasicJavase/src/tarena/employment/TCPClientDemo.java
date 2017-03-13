package tarena.employment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/** rfc tcp */
public class TCPClientDemo {
  public static void main(String[] args) {
    TCPClientDemo clent = new TCPClientDemo();
    clent.open();
  }
  public void open(){
    try{
      //������Ҫ������, ����ȥ����
      //new Socket() ���췽�������ӷ�����, ���ӳɹ�����Socket
      //ʵ�� s, ����ʧ���׳��쳣, s����ͻ��˵�������������
      Socket s = new Socket("localhost", 8000);
      InputStream in = s.getInputStream();
      OutputStream out = s.getOutputStream();
      new Writer(in, s).start();
      new Reader(out, s).start();      
    }catch(IOException e){
      e.printStackTrace();
      System.out.println("����������ʧ��!"); 
    }
  }
  /** ���𽫷���������������Ϣд�Ŀ���̨�� */
  class Writer extends Thread{
    InputStream in;
    Socket s;
    public Writer(InputStream in, Socket s) {
      this.in = in;
      this.s = s;
      setDaemon(true);
    }
    public void run(){
      //���𽫷���������������Ϣд�Ŀ���̨��
      Scanner sc = new Scanner(in);
      while(true){
        String str = sc.nextLine();
        System.out.println(str);
      }
    }
  }
  /** ������̨�ϵ���Ϣ���͵��������� */
  class Reader extends Thread{
    OutputStream out;
    Socket s;
    public Reader(OutputStream out, Socket s) {
      this.out = out;
      this.s = s;
    }
    public void run() {
      Scanner sc = new Scanner(System.in);
      try{
        while(true){
          String str = sc.nextLine();
          out.write((str+"\n").getBytes());
          out.flush();
          if(str.equals("bye")){
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










