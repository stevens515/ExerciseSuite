package basic.day16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

/**
 * �������ʾ
 */
public class OutputStreamDemo {
	public static void main(String[] args) throws IOException{
		String file = "out.demo";
		//OutputString���������������ڴ棨���������󣩵��ⲿ���ļ����������
		//����out.write(int)ÿ�ο������һ��byte
		//FileOutputStream��OutputStream��ʵ���࣬�ڴ����ļ���
		//ʵ�������������out.write(int)ÿ�����ļ����һ��byte
		//���ص�out.write(byte[])�������Խ�byte���������ȫ��д���ļ���
		OutputStream out = new FileOutputStream(file);
		//data:	  41	42	43	d6	d0	??	??
		//index:   0	1	2	3	4	5	6	7	8	9	10
		//pointer:	
		out.write(0x841);
		out.write(66);
		out.write('C');//67.ʮ��λ�ģ�ֻ�ѵͰ�λд�����ˡ�
		byte[] buf = "�й�".getBytes("GBK");//{d6,d0,??,??}
		out.write(buf);
		out.write(buf, 0, 2);
		out.flush();//����ϵͳ���棬��֤���ݵĿɿ�д��
		out.close();//�����棬�ر��ļ����ļ�ʹ����һ���ر�
		//��������ָ���������
		//
		InputStream in = new FileInputStream(file);
		int b ;
		while((b = in.read())!=-1){
			if(b<=0xf){
				System.out.println("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
		}
		System.out.println();
		in.close();
	}
}
