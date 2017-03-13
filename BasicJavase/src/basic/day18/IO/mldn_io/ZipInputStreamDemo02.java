package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipInputStreamDemo02 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo"+File.separator+"demo.zip");//�ҵ�ѹ���ļ�
		File outFile = null;//����������ļ�����
		ZipFile zipFile = new ZipFile(file);//ʵ����ZipFile����
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));//ʵ����ZIP������
		ZipEntry entry = null;//����һ��ZipEntry�������ڽ���ѹ���ļ��е�ÿһ��ʵ��
		InputStream input = null;//���������������ڶ�ȡÿһ��ZipEntry
		OutputStream out =null;//������������������ÿһ��ʵ������
		while((entry=zipInput.getNextEntry())!=null){//�õ�ÿһ��ZipEntry
			System.out.println("��ѹ��"+entry.getName()+"�ļ�");
			outFile = new File("demo"+File.separator+entry.getName());//ʵ��������ļ�
			if(!outFile.getParentFile().exists());{//�ж��ļ����Ƿ����
				outFile.getParentFile().mkdir();//�����ļ���
			}
			if(!outFile.exists()){//�ж��ļ��Ƿ����
				outFile.createNewFile();
			}
			input = zipFile.getInputStream(entry);//�õ�ѹ��ʵ���������
			out = new FileOutputStream(outFile);//ʵ�������������
			int temp =0;
			while((temp=input.read())!=-1){//��ȡ����
				out.write(temp);//�������
			}
			input.close();//�ر�������
			out.close();//�ر������
		}
	}
}
