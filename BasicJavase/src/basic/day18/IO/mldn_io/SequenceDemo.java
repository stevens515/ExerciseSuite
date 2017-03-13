package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**�ϲ� �����ļ�  �ϲ���SequenceInputStream
 * �˳�����ʵ����SequenceInputStream��ʱָ��������������������SequenceInputStream
 * ���ڽ��ж�ȡʱʵ�����Ǵ�������������һ���ȡ���ݵ�
 * ִ����ɺ󣺰�demo1.txt��demo2.txt�����ݸ���demo3.txt��demo3.txt�ļ����ݶ���
 */
public class SequenceDemo {
	public static void main(String[] args) throws IOException {
		InputStream is1 = null;//������1
		InputStream is2 = null;//������2
		OutputStream os = null;//�����
		SequenceInputStream ais =null;//�ϲ���
		is1 = new FileInputStream("demo"+File.separator+"demo1.txt");
		is2 = new FileInputStream("demo"+File.separator+"demo2.txt");
		os = new FileOutputStream("demo"+File.separator+"demo3.txt");
		ais = new SequenceInputStream(is1,is2);//ʵ�����ϲ���
		int temp = 0;
		while((temp=ais.read())!=-1){//ѭ�����
			os.write(temp);//��������
		}
		ais.close();//�رպϲ���
		is1.close();//�ر�������1
		is2.close();//�ر�������2
		os.close();//�ر������
		
	}
}
