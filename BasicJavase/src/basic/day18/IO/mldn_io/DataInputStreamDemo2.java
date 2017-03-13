package basic.day18.IO.mldn_io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/*
 * ��ȡDataOutputStreamDemo.java��д����ļ� 
 * ��order.txt�ж�ȡ����
 * ʹ����������ȡʱ����Ϊÿ����¼֮��ʹ�á�\t'��Ϊ�ָ���ÿ�м�¼֮��ʹ�á�\n'��Ϊ�ָ���
 * ����Ҫ�ֱ�ʹ��readChar()��ȡ�������ָ��������ܽ�������ȷ�ػ�ԭ
 */
public class DataInputStreamDemo2 {
	public static void main(String[] args) throws IOException {
		DataInputStream dis = null;// ������������������
		File f = new File("test" + File.separator + "order.txt");// Ҫ��ȡ�ļ�
		dis = new DataInputStream(new FileInputStream(f));// ʵ������������������

		String name = null;// ��������
		float price = 0.0f;// ���ռ۸�
		int num = 0;// ��������
		char temp[] = null;// �����ַ�������
		char c = 0;// �����ַ�����
		int len = 0;// ���ն�ȡ����
		try {
			while (true) {// ѭ����ȡ
				temp = new char[200];// ���ٿռ�
				len = 0;
				while ((c = dis.readChar()) != '\t') {// ��ȡ�ַ�
					temp[len] = c;// ��������
					len++;// ��ȡ���ȼ�1
				}
				name = new String(temp, 0, len);// ���ַ������ΪString
				price = dis.readFloat();// ��ȡfloat
				dis.readChar();// ����\t
				num = dis.readInt();// ��ȡint
				dis.readChar();// ��ȡ\n

				// ʹ��ָ����ʽ�ַ����Ͳ�������ʽ�����ַ���д���������ı�ݷ�����
				System.out.printf("���ƣ�%s:�۸�%5.2f:������%d\n", name, price, num);
			}
		} catch (Exception e) {// ��������ף�������쳣
			e.printStackTrace();
			System.out.println("��������ˡ�");
		}
		dis.close();// �ر������
	}
}
/*
 * public PrintStream printf(String format, Object ... args) 
 * {returnformat(format, args); 
 * ���ô˷����� out.printf(format, args) ��ʽ����Ϊ�����µ�����ȫ��ͬ��
 * out.format(format, args) 
 * ������ format - �ڸ�ʽ�ַ������﷨�������ĸ�ʽ�ַ��� 
 * 		args -��ʽ�ַ����еĸ�ʽ˵�������õĲ���������������ڸ�ʽ˵����������Զ���Ĳ����� 
 * �����������ǿɱ�ģ����ҿ���Ϊ�㡣��������������ܵ� JavaVirtual Machine Specification �����
 *  Java ��������ά�������ơ���� null ��������Ϊ������conversion��
 *���أ� �������
 */