package basic.day17.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils_02 {
	/**
	 * ��ȡ�ļ����Ұ���16�����������10byteΪһ��
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException{
		//1.�����ļ�����������
		FileInputStream in = new FileInputStream(fileName);
		int b ;
		//2.ѭ����ȡbyte
		while((b=in.read())!=-1){
			if(b<=0xf){
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b)+" ");
		}
		in.close();
	}
	//printHex��String fileName)�����ط���
	public static void printHex(File file) throws IOException{
//		1�����ļ�����������
		FileInputStream in= new FileInputStream(file);
		int b;
		//2ѭ����ȡbyte
		while((b=in.read())!=-1){
			if(b<=0xf){
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b)+" ");
		}
		in.close();
	}
	//printHex(String fileName)�����ط���
	public static void printHex(InputStream in) throws IOException{
		int b;
		while((b=in.read())!=-1){
				if(b<=0xf){
					System.out.println("0");
				}
				System.out.println(Integer.toHexString(b)+" ");
		}
		in.close();
	}
}
