package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/**
 * ʵ����zipFile���󣬲�ͨ��getName()����ȡ��ѹ���ļ�������
 * �����ѹ���ļ�������Ϊ��demo/demo.zip
 */
public class ZipFileDemo01 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo"+File.separator+"demo.zip");//�ҵ�ѹ���ļ�
		ZipFile zipFile = new ZipFile(file);//ʵ����ZipFile����
		System.out.println("ѹ���ļ�������Ϊ��"+zipFile.getName());
	}
}
