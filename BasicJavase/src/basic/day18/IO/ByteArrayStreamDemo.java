package basic.day18.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

//�����������Զ��ļ� 
public class ByteArrayStreamDemo {
	public static void main(String[] args) throws IOException {
		// FileInputStream
		byte[] buf = { 5, (byte) 0xff, -1 };//{05,ff,ff};
		//			   ^
		//��byte������Ϊ�����ж�ȡ����,���������ǳ����ļ��ģ�
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		int b = in.read();//5
		//byte[] buf = { 5, (byte) 0xff, -1 };
		//			   			 ^
		System.out.println(b);
		b = in.read();//255
		System.out.println(b);
		//byte[] buf = { 5, (byte) 0xff, -1 };
		//								  ^	
		//byte���͵ģ�1��Ϊint��,ffff ffffת����ʮ������0000 0000 ffff ffff����Ϊʮ����255
		b = in.read();//255,
		System.out.println(b);
		//byte[] buf = { 5, (byte) 0xff, -1 };
		//    								 ^	
		b =in.read();//-1,�������һλ�ˣ�API�涨����-1
		System.out.println(b);
		in.close();
		
		//���ڴ��еı䳤byte[]������Ϊ�����
		//ByteArrayOutputStream�а���һ���䳤Byte����
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(5);
		out.write(65);
		out.write("�й�".getBytes("GBK"));
		out.close();
		byte[] ary = out.toByteArray();//����Ч�����ݵ�����
		System.out.println(Arrays.toString(ary));
		IOUtils.print(ary);//ʮ���������
	}
}
