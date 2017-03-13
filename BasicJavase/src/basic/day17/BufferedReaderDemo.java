package basic.day17;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** �ı��ļ� �Ķ�ȡ */
public class BufferedReaderDemo {
	/**
	 * BufferedReader����õ��ļ��ļ���ȡAPI ��������ṩ�˷ǳ�����ķ���readLine()
	 * readLine()����ÿ�ο��Դ��ļ��ж�ȡһ���ı����ַ��� ����ļ��Ǿ������룬���н�����λ�ã��������н�������
	 * readLine()����null��ʱ���ʾ��ȡ���ļ�ĩβ �� �н������ţ��س�(\r)���߻���(\n)
	 * bufferedReader�ǹ������������Ĺ�����չ��������byte��
	 */
	public static void main(String[] args) throws IOException {
		String file = "test/liyi.txt";
		//��һ��д��
		// InputStream is = new FileInputStream(file);
		// InputStreamReader reader = new InputStreamReader(is,"gbk");
		// BufferedReader in = new BufferedReader(reader);
		//�ڶ���д������˾��д��
		BufferedReader in = new BufferedReader(
		//���ַ��������ж�ȡ�ı�����������ַ����Ӷ�ʵ���ַ���������еĸ�Ч��ȡ��  String 	readLine() 
				new InputStreamReader(// ���ֽ���ͨ���ַ�������������ʹ��ָ���� charset
						/**��ȡ�ֽڲ��������Ϊ�ַ�
						 * ÿ�ε��� InputStreamReader �е�һ�� read()
						 * �������ᵼ�´ӵײ���������ȡһ�������ֽڡ�
						 * Ҫ���ô��ֽڵ��ַ�����Чת����������ǰ�ӵײ�����ȡ������ֽڣ�ʹ�䳬�����㵱ǰ��ȡ����������ֽڡ�
						 * Ϊ�˴ﵽ���Ч�ʣ���Ҫ������ BufferedReader �ڰ�װ
						 * InputStreamReader�����磺 BufferedReader in = new
						 * BufferedReader(new InputStreamReader(System.in));
						 */
						new BufferedInputStream(
						/*
						 * public class BufferedInputStream extends FilterInputStream
						 * 
						 * BufferedInputStream Ϊ��һ�����������һЩ���ܣ������������Լ�֧�� mark ��
						 * reset ������������ �ڴ��� BufferedInputStream
						 * ʱ���ᴴ��һ���ڲ����������顣�ڶ�ȡ���������е��ֽ�ʱ���ɸ�����Ҫ�Ӱ������������ٴ������ڲ���������
						 * һ��������ֽڡ�mark ������¼�������е�ĳ���㣬reset
						 * ����ʹ���ڴӰ������������л�ȡ���ֽ�֮ǰ���ٴζ�ȡ�����һ�� mark �������ȡ�������ֽڡ�
						 * BufferedInputStream(InputStream in) ����һ��
						 * BufferedInputStream ��������������������� in���Ա㽫��ʹ��
						 */
						new FileInputStream(file)), "gbk"));
		/*
		 * FileInputStream ���ļ�ϵͳ�е�ĳ���ļ��л�������ֽڡ���Щ�ļ�����ȡ��������������
		 * 
		 * FileInputStream ���ڶ�ȡ����ͼ������֮���ԭʼ�ֽ�����Ҫ��ȡ�ַ������뿼��ʹ�� FileReader��
		 */
		String str;
		while ((str = in.readLine()) != null) {
			if (str.trim().equals("")) {
				continue;
			}
			System.out.println(str);
			// if(str.matches(".*o.*")){
			// System.out.println(str);
			// }
		}
		in.close();
	}
}
/**
 * BufferedReader extends Reader: Read text from a character-input stream,
 * buffering characters so as to provide for the efficient reading of
 * characters, arrays, and lines. ͨ����Reader ������ÿ����ȡ���󶼻ᵼ�¶Եײ��ַ����ֽ���������Ӧ�Ķ�ȡ����
 * ��ˣ������� BufferedReader ��װ������ read() �������ܿ����ܸߵ� Reader���� FileReader ��
 * InputStreamReader���� ���磬 BufferedReader in = new BufferedReader(new
 * FileReader("foo.in"));
 * 
 * public String readLine() throws IOException Read a line of text. A line is
 * considered to be terminated by any one of a line feed ('\n'), a carriage
 * return ('\r'), or a carriage return followed immediately by a linefeed.
 * ��ȡһ���ı��С�ͨ�������ַ�֮һ������Ϊĳ������ֹ������ ('\n')���س� ('\r') ��س���ֱ�Ӹ��Ż��С�
 */
