package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**ʵ�������������ļ��еõ�����
 *		���Ҫ���ļ���ȡ�����ݣ���ֱ�ӽ�File���ʵ�����뵽Scanner�Ĺ���
 *�����м��ɡ�
 */
public class ScannerDemo04 {
	public static void main(String[] args) {
		//File.separator���ļ��ָ������Կ�ƽ̨
		File f = new File("test"+File.separator+"xiya.txt");//ָ�������ļ�
		Scanner scan = null;
		try {
			scan = new Scanner(f);	//���ļ���������
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuffer str = new StringBuffer();//���ڽ�������
		while(scan.hasNext()){	//�ж��Ƿ�������
			str.append(scan.next()).append("\n");//ȡ������
		}
		System.out.println(str);
	}
}
