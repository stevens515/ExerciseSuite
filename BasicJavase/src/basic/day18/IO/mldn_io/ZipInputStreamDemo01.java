package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ȡ��demo.zip�е�ZipEntry
 *  ZipInputStream�ࣺ��InputStream�����࣬ͨ��������Է����ȡzip��ʽ���ļ������÷������£�
 	public ZipInputStream(InputStream in)	����	ʵ����ZipInputStream����
 	public ZipEntry getEntry()throws IOException ȡ����һ��ZipEntry
 	������ZipFileһ��ȡ��ZIPѹ���ļ��е�ÿ��ZipEntry.
 */
/*
 * ZipInputStream���getNextEntry()������������ȡ��ÿһ��ZipEntry��
 * ��������ZipFile��ϾͿ��Խ��н�ѹ������������Ҫע����ǣ���demo.zip�ļ��б����ǰ���ѹ�����ļ��еģ������ڽ��н�ѹǰ��
 * Ӧ���ȸ���ZIP�ļ��е��ļ��е�������Ӳ���ϴ�����һ����Ӧ���ļ��У�Ȼ����ܰ��ļ���ѹ����ȥ�������ڲ�������ʱ����ÿһ����ѹ��
 * �ļ��������ȴ�����File���createNewFile()�������Դ������ļ������ٽ��������
 * 
 */
public class ZipInputStreamDemo01 {
	public static void main(String[] args) throws IOException {
		File zipFile = new File("demo"+File.separator+"demo.zip");//����ѹ���ļ�����
		ZipInputStream input = null;//����ѹ��������
		input = new ZipInputStream(new FileInputStream(zipFile));//ʵ����ѹ��������
		ZipEntry entry = input.getNextEntry();//�õ�һ��ѹ��ʵ��
		System.out.println("ѹ��ʵ�����ƣ�"+entry.getName());//���ʵ������
		input.close();//�ر�ѹ��������
	}
}
