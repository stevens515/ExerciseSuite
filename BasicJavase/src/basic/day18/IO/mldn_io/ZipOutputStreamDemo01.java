package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * ѹ������java�пɽ��ļ�ѹ����ZIP,JAR,GZIP����ʽ
 	ZIP��һ�ֳ��õ�ѹ����ʽ����java��Ҫʵ��ZIP��ѹ����Ҫ����java.util.zip��������ʹ�ô˰���
 	ZipFile,ZipOutputStream,ZipInputStream��ZipEntry��������ʵ�ֲ�����
 	
 	ZipOutputStream��ĳ��÷�����
 		public ZipOutputStream(OutputStream out)	����	�����µ�ZIP�����
 		public void putNextEntry(ZipEnty e)throw IOEception ����ÿһ��ZipEntry����
 		pulic void setComment((string connment)		����ZIP�ļ���ע��
 
 */
public class ZipOutputStreamDemo01 {
	public static void main(String[] args) throws IOException {
		File file = new File("demo"+File.separator+"demo1.txt");//����Ҫѹ�����ļ�
		File zipFile = new File("demo"+File.separator+"demo.zip");//����ѹ���ļ���
		InputStream input  =new FileInputStream(file);//���������ļ���
		
		ZipOutputStream zipOut =null;//����ѹ�������
		//ʵ����ѹ����������󣬲�ָ��ѹ���ļ������·��
		zipOut=new ZipOutputStream(new FileOutputStream(zipFile));
		//ÿһ����ѹ�����ļ�����ZipEntry��ʾ����Ҫÿһ��ѹ������ļ���������
		zipOut.putNextEntry(new ZipEntry(file.getName()));//����ZipEntry
		zipOut.setComment("www.mldnjava.cn");//����ע��
		int temp =0;//�������������
		while((temp=input.read())!=-1){//��ȡ����
			zipOut.write(temp);//ѹ���������
		}
		input.close();//�ر�������
		zipOut.close();//�ر�ѹ�������
	}
}
