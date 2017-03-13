package basic.day17.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//IO�����������Ӷ�ȡ�ļ����ݵķ���read(String filename)�����ط���read(File file)���÷��������ڶ�ȡС�ļ�
public class IOUtils {
	/**
	 * ��ȡ�ļ����ݵ�byte�����У�������С�ļ�
	 * @throws IOException 
	 */
	public static byte[] read(String filename) throws IOException{
		File file = new File(filename);
		//1.�����ļ����ȴ���byte����
		byte[] buf = new byte[(int)file.length()];
		//2.���ļ�
		FileInputStream in = new FileInputStream(file);
		//3.��ȡ�ļ���read���������ܶ�Ķ�ȡ�������ݣ���䵽buf����ֵsize�Ƕ�ȡ������
		int size = in.read(buf);//һ�ζ�ȡȫ��
		in.close();
		return buf;
	}
	//���ط���
	public static byte[] read(File file) throws IOException{
		//1.�����ļ����ȴ���byte����
		byte[] buf = new byte[(int)file.length()];
		//2.���ļ�
		FileInputStream in = new FileInputStream(file);
		//3.��ȡ�ļ���read���������ܶ�Ķ�ȡ�������ݣ���䵽buf����ֵsize�Ƕ�ȡ������
		int size = in.read(buf);//һ�ζ�ȡȫ��
		in.close();
		return buf;
	}
}
