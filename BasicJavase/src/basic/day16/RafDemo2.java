package basic.day16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RafDemo2 {
	public static void main(String[] args) throws IOException {
		String file = "raf.demo";
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// raf.write(-2);
		raf.writeInt(-2);// ��-2���л�Ϊ4��byteд�뵽ʱ�ļ���
		raf.writeLong(-2L);//���˸��ֽڽ� long д����ļ�����д���ֽڡ�
		raf.writeDouble(3.141592653589793);
		raf.seek(0);
		int b;
		while((b=raf.read())!=-1){
			if(b<=0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
		}
		System.out.println();
		//�����㹻�˽��ļ����ݲ��ܺ����ȡ�ļ�
		raf.seek(12);//�ƶ��α굽ʱdouble���ݵ���ʼλ�ã���ȡ����
		double pi = raf.readDouble();
		System.out.println(pi);
		//һ���򵥰취������д����˳���ȡ
		
		raf.close();
	}
}
