package basic.day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {
		int b = 0;
		FileInputStream in =null;
		FileOutputStream out = null;
		try{
			in = new FileInputStream("/home/soft01/work/test/JSD1202_2/basic/day16/CPDemo.java");
			out = new FileOutputStream("/home/soft01/Desktop/test.java");
			while((b=in.read())!=-1){
				out.write(b);
			}
			in.close();
			out.close();
		}catch(FileNotFoundException e2){
			System.out.println("�Ҳ���ָ���ļ�");
			System.exit(-1);
		}catch(IOException e1){
			System.out.println("�ļ����ƴ���");
			System.exit(-1);
		}
		System.out.println("�ļ��Ѹ���");
	}
}
