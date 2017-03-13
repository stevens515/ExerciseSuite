package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * ��ѹ��,demo/demo.zip,demo.zip��demo1.txt��ѹ���ļ�
 */
public class ZipFileDemo02 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo" + File.separator + "demo.zip");// �ҵ�ѹ���ļ�
		File outputFile = new File("demo" + File.separator + "demo.txt");// �����ѹ�����ļ�����,���ȡ
		ZipFile zipFile = new ZipFile(file);// ʵ����ZipFile����
		// �õ�һ��ѹ��ʵ�壬��ѹ����demo1.txt��ѹ���������ֲ��ܱ�
		ZipEntry entry = zipFile.getEntry("demo1.txt");
		InputStream input = zipFile.getInputStream(entry);// �õ�һ��ѹ��ʵ��
		OutputStream out = new FileOutputStream(outputFile);// ʵ�������������
		int temp = 0;// �����������
		while ((temp = input.read()) != -1) {// ��ȡ����
			out.write(temp);// �������
		}
		input.close();// �ر�������
		out.close();// �ر������
	}
}
