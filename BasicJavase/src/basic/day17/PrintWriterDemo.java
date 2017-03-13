package basic.day17;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import basic.day16.IOUtils;

/**
 * ������ı��ļ�д������println() 
 * PrintWriter����println()����������һ��д��һ���ı����ļ��У�
 * �Զ���ӻس����߻���(win/linux/mac��ͬ)
 *  PrintWriter���ǹ�����չ������ֱ�ӷ����ļ��������ײ���
 */

public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		String file = "demo.txt";
		PrintWriter out = new PrintWriter(//���ж�д 
				new OutputStreamWriter(//ת�������ַ�ת�ֽڵ�
						new BufferedOutputStream(//���ˣ����壬��ȥ��
								new FileOutputStream(file)),"gbk"));
		out.println("HI,");
		out.println("���Ǽֶ��£�");
		out.println("�Ǳ������ڹ�˾ѧԱ��");
		out.close();
		IOUtils.print(file);
	}
}
