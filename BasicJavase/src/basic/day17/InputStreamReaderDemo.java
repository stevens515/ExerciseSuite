package basic.day17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		String file="test/liyi.txt";
		InputStream in = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(in,"GBK");
		//read() �����Ǽ̳���Reader�࣬���Ǽ̳���InputStream
		//read()��ӻ���byte����ȡ���ݲ�����Ϊchar�ַ���
		//��䵽int���͵ĵ�16λ����16λ����0�������������
		//����ֵ��Χ��0000 0000 ��0000 ffff����-1��ʾ��ȡ���ļ�β
		int c ;
		while((c=reader.read())!=-1){
			System.out.println((char)c);
		}
//		int c = reader.read();
//		System.out.println(c+":"+(char)c);
//		c = reader.read();
//		System.out.println(c+":"+(char)c);
		//......

	}
}
