package basic.day18.IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/*
 *  PrintWriter  extends Writer
 ���ı��������ӡ����ĸ�ʽ����ʾ��ʽ��
 */
public class ByteArrayIODemo {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,
				"utf-8"));
		writer.println("�ú�ѧϰ����������");
		writer.close();
		byte[] buf = out.toByteArray();
		String str = new String(buf, "utf-8");
		System.out.println(str);

	}
}
