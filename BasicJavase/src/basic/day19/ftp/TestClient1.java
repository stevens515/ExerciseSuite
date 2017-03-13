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
public class TestClient1 {
	public static void main(String[] args) {
		try{
			Socket s1 = new Socket("127.0.0.1",6000);
			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dis.close();
			s1.close();
		}catch(ConnectException connExe){
			connExe.printStackTrace();
			System.out.println("����������ʧ�ܣ�");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
