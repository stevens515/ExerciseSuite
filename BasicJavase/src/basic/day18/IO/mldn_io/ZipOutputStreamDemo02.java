package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**ѹ���ļ���
 *	1.�г�ȫ���ļ�
 *	2.�Ƿ����ļ���
 *		��,ȡ��ÿ��File
 *	3.����ZipEntry
 *	4.����ZipEntry,������д��ѹ�������
 *	5.���أ������ж�2���ݡ�
 *	���2�в�������ֱ�ӹر�ѹ���������
 *
 * 	��ÿһ��ѹ���ļ��ж�����ڶ�����ļ�����ôÿһ�����ļ���java��ʹ��ZipEntry��ʾ��ZipEntry���÷������£�
 	public ZipEntry(string name)	����		��������ָ��Ҫ������ZipEnty����
 	public boolean isDirectory()	��ͨ		�жϴ�ZipEnty�Ƿ���Ŀ¼
 	
 	ZipOutputStream��ĳ��÷�����
 		public ZipOutputStream(OutputStream out)	����	�����µ�ZIP�����
 		public void putNextEntry(ZipEnty e)throw IOEception ����ÿһ��ZipEntry����
 		pulic void setConment(string connment)		����ZIP�ļ���ע��
 */
public class ZipOutputStreamDemo02 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo" + File.separator + "file");//Ҫѹ�����ļ���
		File zipFile = new File("demo" + File.separator + "file.zip");// ѹ���ļ�������
		InputStream input = null;// �����ļ�������
		ZipOutputStream zipOut = null; // ����ѹ�������
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile));// ʵ����ѹ�������
		zipOut.setComment("www.mldnjava.cn");// ����ע��
		if (file.isDirectory()) {// �ж��Ƿ���Ŀ¼
			File lists[] = file.listFiles();// �г�ȫ���ļ�
			for (int i = 0; i < lists.length; i++) {
				input = new FileInputStream(lists[i]);// �����ļ�������
				// ÿһ����ѹ�����ļ�����ZipEntry��ʾ����ҪΪÿһ��ѹ������ļ���������
				zipOut.putNextEntry(new ZipEntry(file.getName()
						+ File.separator + lists[i].getName()));// ����ZipEntry
				int temp = 0;// ������������
				while ((temp = input.read()) != -1) {// ��ȡ����
					zipOut.write(temp);// ѹ���������
				}
				input.close();// �ر�������
			}
		}
		zipOut.close();// �ر�ѹ�������
	}
}
