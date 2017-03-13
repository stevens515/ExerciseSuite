package basic.day16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**�ļ���ȡ����
 *����
 *	A ֻ�����ļ����ƶ���int����λ��
 *	B ������ȡ4��byte��ƴ��Ϊint (�����л���
 *�ļ�ģ�ͣ�
 *		data:	41	42	7f	ff	ff	ff	d6	d0	...
 *		index:	0	1	2	3	4	5	6	7	8
 *		pointer:		^
 */
public class RAFReaderDemo {
	public static void main(String[] args) throws IOException {
		//A-1ֻ�����ļ�
		RandomAccessFile raf = new RandomAccessFile("demo/raf.dat","r");
		int i=0;
		//A-2�ƶ���intλ��
		raf.seek(2);
		//B-1.1��ȡ��1��byte
		int b =raf.read();//7f
		System.out.println(raf.getFilePointer());//3
		//B-1.2 ��ʼƴ��Ϊint
		i = i|(b<<24);	//7f 00 00 00 00
		
	}
}
