package basic.day18.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * ��java�У����ǿ�Խ������ķ�Χ��һ��Ҫ�Լ������ͷš�
 * �ֽ���ʵ���ļ� �Ŀ������£�
 */
public class TestCopy {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("Դ�ļ���");
		FileInputStream fis = new FileInputStream("demo.txt");
		BufferedInputStream bis =new BufferedInputStream(fis);
		
//		FileOutputStream fos = new FileOutputStream("Ŀ���ļ���");
		FileOutputStream fos = new FileOutputStream("utf16be.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] b = new byte[1024];//��Ϊ����������СΪ1K
		int len;//���������ʵ���ֽڽ���
		while((len=bis.read(b))!=-1){
			bos.write(b,0,len);//д��SOCKET��
			bos.flush();//��ջ��������ǵ�ҪдŶ������һ��Ҫд
		}
	}
}
