package basic.day16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//�ַ�
public class TestFileReader {
	public static void main(String[] args) {
		FileReader fr =null;
		int c =0;
		try{
			fr = new FileReader("/home/soft01/work/test/JSD1202_2/basic/day16/CPDemo.java");
			int in = 0;
			while((c=fr.read())!=-1){
				System.out.println((char)c);
			}
			fr.close();
		}catch(FileNotFoundException e){
			System.out.println("�Ҳ���ָ���ļ�");
		}catch(IOException e){
			System.out.println("�ļ���ȡ����");
		}
	}
}
