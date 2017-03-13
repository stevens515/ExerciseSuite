package basic.day16;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * ����ļ���д��ʾ ���� A ��demo�ļ����д���raf.dat B ������ļ� C д�롮A���͡�B�� D д��GBK����ġ��С���d6d0 E
 * д������0x7fffffff(int�������ֵ�� F һ���Զ�ȡ�ļ�����
 */
/*
 * raf.write( 'A' )��д����̣� 
 * ���ȣ��ַ� A ���ڴ����� 16 λ�޷������� 0000 0000 0000 0041
 * ��Σ���۽����ת����תΪ int ���� 0000 0000 0000 0000 0000 0000 0000 0041 
 * ��󣬽�ȡ�� 8 λ������ 8λ������д�롰������ 0000 0041
 * 
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		// ����Ŀ¼ demo
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		// A ��demo�ļ����д���raf.dat
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		// B ������ļ����������ȡ
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// ���Ĭ�ϵġ��αꡰλ��
		System.out.println(raf.getFilePointer());// 0
		// C д���ַ���A���͡�B��
		raf.write('A');
		System.out.println(raf.getFilePointer());// 1
		raf.write('B');
		// D д������0x7fffffff
		// D-1д��int ���ݵĵײ�д��
		int i = 0x7fffffff;
		raf.write(i >>> 24);// i>>>24 00 00 00 7f
		raf.write(i >>> 16);// i>>>16 00 00 7f ff
		raf.write(i >>> 8);// i>>>8 00 7f ff ff
		raf.write(i);// i 7f ff ff ff
		// D-2 д��int���ݵķ�װ����
		raf.writeInt(i);
		// E д��GBK������ַ����С���GBK����Ϊd6d0
		String s = "��";// Ĭ��ϵͳ����Ϊ4e2d
		// E-1 �õ����С���gbk������ʽ
		byte[] gbk = s.getBytes("gbk");// gbk={d6,d0 }
		raf.write(gbk);
		System.out.println(raf.length());// 12
		System.out.println(raf.getFilePointer());// 12

		// �ƶ��ļ��α굽��ͷ'
		raf.seek(0);
		// F һ���Զ�ȡȫ�����ݵ�buf��
		byte[] buf = new byte[(int) raf.length()];
		// F-1 ���ļ��ж�ȡ���ݵ�ʱbuf���飬����������
		raf.read(buf);
		// F-2 ���byte���飨Ĭ�ϰ�10���ƴ�ӡ��
		System.out.println(Arrays.toString(buf));
		// F-3 ���16������ʽ
		for (byte b : buf) {
			System.out.println(Integer.toHexString(b & 0xff) + "");
		}
		// �ر�
		raf.close();
	}
}
/**
 * 4. RandomAccessFile ** RandomAccessFile ���� Java �ṩ�Ĺ��ܷḻ���ļ����ݷ����࣬���ṩ���ڶ෽���������ļ�
 * ���ݣ��ȿ��Զ�ȡ�ļ����ݣ�Ҳ�������ļ�������ݣ�RandomAccessFile ֧�֡�������ʡ���ʽ���� �Է����ļ�������λ�á� 1) Java
 * �ļ�ģ�� ��Ӳ�����ļ��� byte by byte �洢�ģ������ݵļ��� 2) ���ļ� ������ģʽ "r w"����д),"r"��ֻ����
 * RandomAccessFile raf = new RandomAccessFile(file, "r w"); ���ļ�ʱ��Ĭ���ļ�ָ���ڿ�ͷ
 * pointer=0 3) д�뷽�� raf.write(int)���Խ������ġ��Ͱ�λ��д�뵽�ļ��У�ͬʱָ���Զ��ƶ�����һ��λ��, ׼�� �ٴ�д��
 * ע�⣺�ļ�������չ��Ҫ��ȷָ��, û��Ĭ����չ������ RandomAccessFile raf = new
 * RandomAccessFile("Hello.java", "r w"); 4) ��ȡ�ļ� int b = raf.read() ���ļ��ж�ȡһ��
 * byte(8 λ) ��䵽 int �ĵͰ�λ, �� 24 λΪ 0, ����ֵ ��Χ����: 0~255, �������-1 ��ʾ��ȡ�����ļ�ĩβ!
 * ÿ�ζ�ȡ���Զ��ƶ��ļ�ָ��, ׼���´ζ�ȡ�� 5) �ļ���д����Ժ�һ���ر��ļ� Sun
 * �ٷ�˵����������رգ���������һЩ���벻���Ĵ��󣬸��ݾ������ƽ̨��ͬ���в�ͬ�� ��ʹ�ù����У��м��ļ���д��ɺ�Ҫ�ر��ļ���
 */
