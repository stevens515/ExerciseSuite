package basic.day17;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import basic.day16.IOUtils;

/**
 * OutputStreamWriterҲ��һ����������չ��������OutputStream 
 * OutputStreamWriter�ṩ��write(int)�����������ĵ�16λ���� (char ����)���б��룬����Ϊbyte���У�д�뵽OutputStream
 * OutputStream��write(byte)д��һbyte����int�ĵͰ�λ
 * OutputStreamWriter��write(char)����charΪbyteд�����ײ���
 */
public class OutputStreamWriterDemo {

	public static void main(String[] args) throws IOException {
		String file = "writer.txt";
		OutputStreamWriter out = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(file)), "utf-8");
		out.write('��');
		out.write('��');
		out.close();
		IOUtils.print(file);//e4 b8 ad e5 9b bd 
	}
}
