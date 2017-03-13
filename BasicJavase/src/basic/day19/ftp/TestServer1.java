package basic.day19.ftp;

import java.io.*;
import java.net.*;

/*�������ƣ��򵥵�client/server����
 * Դ�ļ����ƣ�TestClient1.java/TestServer1.java
 * Ҫ�㣺
 * 	1.Java Socket��̲���
 *	2.Socket/ServerSocket���÷�
 *	3.ͨ��Socket������Ի�ȡͨ�ŶԷ�Socket����Ϣ
 */
public class TestServer1 {
	public static void main(String[] args) {
		try{
			ServerSocket s = new ServerSocket(6000);
			while(true){
				Socket s1 = s.accept();
				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				//getInetAddress()�ǳ�IP��ַ��getPort()��ʵ��ʹ�õĶ˿ں�
				dos.writeUTF("Hello"+s1.getInetAddress()
						+"port#"+s1.getPort()+"bye-bye!");
				dos.close();
				s1.close();
			}
		}catch(IOException e){
			e.printStackTrace();
			System.err.println("�������г���"+e);
		}
	}
}
