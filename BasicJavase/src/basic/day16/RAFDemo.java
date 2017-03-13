package basic.day16;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * �ļ������漴���� RandomAccessFile
 */
public class RAFDemo {
	public static void main(String[] args) throws IOException {
		String file = "ra.dat";
		// ��λ�൱��һ���ֽڣ������32λ�����и��4��
		// ��ݼ���"Alt + /"��������
		//��һ���ļ�
		//date:	  41 42 42 ff ff ff fe d6 d0 ??  ??  08									ʮ������
		//index:   0  1  2  3  4  5  6  7  8  9  10  11  12 
		//pointer:                                        ^
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		System.out.println(raf.length());// 0,���ļ����ȣ�0
		System.out.println(raf.getFilePointer());// 0   ָ��λ��
		raf.write(0x841);// ���Ͱ�λ��41��д���ļ�
		System.out.println(raf.length());// 1
		System.out.println(raf.getFilePointer());// 1
		raf.write(66);// ʮ���ƣ�������42���൱��raf.write('B');
		raf.write('B');
		int a = -2;// Oxfffffffe;
		// raf.write((a);//�����ˣ���λȥ���ˡ�
		// raf.write(a >>> 24);// �������޷�����λ����λ����000000ff;��ǰ��Ӧ��24���㣬Ϊ�˰Ѹ߰�λ�ƶ����Ͱ�λ�ϡ�
		// raf.write(a>>24);//2����λ�����з�����λ��������1����������
		raf.write(a >>> 24);// 000000ff
		raf.write(a >>> 16);// 0000ffff
		raf.write(a >>> 8);// 0000ffff
		raf.write(a);// fffffffe
//		raf.close();
		byte[] buf= "�й�".getBytes("GBK");//���ַ�������GBK������ַ�����
		raf.write(buf);
//		raf.write(8);
//		raf.write(0);
//		raf.write(-1);
		System.out.println(raf.length());
		
		///��ȡ�ļ�
		raf.seek(0);//�ƶ��α굽��ʼλ��
		int b = raf.read();//��������00-ff��-1�������ļ�ĩβ��EOF��
		System.out.println(b+":"+Integer.toHexString(b));
		
		b = raf.read();
		System.out.println(b+":"+Integer.toHexString(b));
		//...
		//��һ���ļ�
//		java�ļ�ģ�ͣ��ļ���byte by byte���������򼯺�
//		data :	41	42	42	ff	ff	ff	fe	d6	d0	??	??	08	00	ff ....
//		index: 	0	1	2	3	4	5	6	7	8 	9	10	11	12	13	14....
//		pointer:														^
		//��ȡ�ļ� ��ȫ�����ݣ�����Hex��ʽ��ӡ����
		raf.seek(0);
		while((b=raf.read())!=-1){
			if(b<=0xf){//��λHEX������0����Ϊ����ʾ�ġ��ÿ���
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+"");
		}
		System.out.println();
		raf.seek(3);//���ص�int ���ݵ���ʼλ��
		int b1 = raf.read();// 00 00 00 ff
		int b2 = raf.read();// 00 00 00 ff
		int b3 = raf.read();// 00 00 00 ff
		int b4 = raf.read();// 00 00 00 fe
		//<<��λ���˲��㡣
		//b1<<24 -->ff 00 00 00
		//b2<<16 -->00 ff 00 00
		//b3<<8	-->00 00 ff 00
		//b4	= 00 00 00 fe
		int i = (b1<<24)+(b2<<16)+(b3<<8)+b4;
		System.out.println("i:"+i);//i=-2
		
		//��һ���ļ�
//		java�ļ�ģ�ͣ��ļ���byte by byte���������򼯺�
//		data :	41	42	42	ff	ff	ff	fe	d6	d0	??	??	08	00	ff ....
//		index: 	0	1	2	3	4	5	6	7	8 	9	10	11	12	13	14....
//		pointer:							^
		raf.seek(7);
		byte[] ary = new byte[4];//{00,00,00,00};
//		raf.read(ary);�����ܶ�Ķ�ȡraf�е�������䵽����ary��
		int num = raf.read(ary);//�ӵ�ǰ���λ�ÿ�ʼ�������ܶ�������������(ary)
		System.out.println("num:"+num+Arrays.toString(ary));
		num = raf.read(ary);
		System.out.println("num:"+num+Arrays.toString(ary));
		num = raf.read(ary);
		System.out.println("num:"+num+Arrays.toString(ary));
		//?
		raf.seek(7);
		num = raf.read();
		String str = new String(ary,"GBK");
		System.out.println(str);//�й�
		raf.close();

	}
}
