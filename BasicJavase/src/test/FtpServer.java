package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/** 
 * ģ��FTP������, ֧������pwd,ls,get file
 * 
 * Э��:  type,length,value  TLV��ʽ
 * 
 *   �ı�: text,5\nline1\nline2\nline3\nline4\nline5\n
 *   �ļ�: file,4,filename\n 41 42 43 44 
 *   
 *   text,5\nline1\nline2\nline3\nline4\nline5\nfile,4,filename\n 41 42 43 44
 */

public class FtpServer {
  public static void main(String[] args)
    throws IOException{
    FtpServer server = new FtpServer();
    server.start();
  }
  
  public void start() throws IOException{
    ServerSocket ss = new ServerSocket(6666);
    while(true){
      Socket s = ss.accept();
      new Agent(s).start();
    }
  }
  class Agent extends Thread{
    Socket s;
    public Agent(Socket s) {
      this.s = s;
    }
    public void run() {
      try{
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        //��ͻ��˷���, �ȷ�Э��ͷ,�ٷ����ı���
        out.write("text,1\n".getBytes());//Э��ͷ
        //������Ϣ����, һ���ı���Ϣ
        out.write("��ӭʹ��FTP��ʾ������!\n".getBytes());
        out.flush();
        while(true){
          //��ȡ�ͻ��˷��͵�����
          String cmd = IOUtils.readLine(in).trim();
          if("pwd".equals(cmd)){//��ʾ��ǰĿ¼
            pwd(out);
          }else if("ls".equals(cmd)){
            ls(out);
          }else if(cmd.startsWith("get ")){
            get(cmd, out);
          }else if("bye".equalsIgnoreCase(cmd)){
            IOUtils.println(out, "text,1");
            IOUtils.println(out, "Bye, Bye!");
            s.close();
          }else{
            out.write("text,1\n".getBytes());//Э��ͷ
            out.write("ֻ֧��pwd,ls,get,bye!\n".getBytes());
            out.flush();
          }
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
  public void pwd(OutputStream out) 
    throws IOException{
    File dir = new File(".");
    IOUtils.println(out, "text,1");
    IOUtils.println(out, dir.getCanonicalPath());
  }
  public void ls(OutputStream out)
    throws IOException{
    File dir = new File(".");
    File[] files = dir.listFiles();
    IOUtils.println(out, "text,"+files.length);
    for (File f : files) {
      if(f.isDirectory()){
        IOUtils.println(out, "["+f.getName()+"]");
      }else{
        IOUtils.println(out, f.getName());
      }
    }
  }

  public void get(String cmd, OutputStream out)
    throws IOException{
    //cmd="get filename"
    String name = cmd.split("\\s+")[1];
    File file = new File(name);
    if(! file.exists()){
      IOUtils.println(out, "text,1");
      IOUtils.println(out, "û���ļ�ѽ!"+name);
      return;
    }
    //�ļ�Э��ͷ: 
    IOUtils.println(out, 
        "file,"+file.length()+","+name);
    FileInputStream in = 
      new FileInputStream(file);
    IOUtils.cp(in, out);
    out.flush();
    in.close();
    IOUtils.println(out, "text,1");
    IOUtils.println(out, "���ͳɹ�:"+name);
  }
}





