package basic.day17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.stream.FileImageInputStream;

import basic.day16.IOUtils;

/**
 * �����ص� UTF��8��UTF-16BE��GBK(GB2312)��ISO8859��1
 * utf-16be��2���ֽ�  UTF-8Ӣ��1���ֽڣ����������ֽ�
 */
public class CharEncodingDemo {
	public static void main(String[] args) throws IOException {
		String str = "ABCDE�й�";// char(unicode)����
		System.out.println(str);
		// ��ʮ��λunicode char���б���Ϊbyte���У�ʹ�ñ��뷽��utf-16be
		// utf-16be,��һ��16λ��char���м���Ϊ����byte
		// �磺��A����0041�����Ϊ��00 41��
		System.out.println("UTF-16BE");
		byte[] utf16be = str.getBytes("UTF-16BE");
		String file = "utf16be.txt";// utf-16������ı��ļ�
		OutputStream out = new FileOutputStream(file);
		out.write(utf16be);
		out.close();

		IOUtils.print(file);// 00 41 00 42 00 43 00 44 00 45 4e 2d 56 fd

		System.out.println("UTF-8");
		// �У� 4e2d 0100 1110 0010 1101
		// utf-8:e4 b8 ad: 1110 0100 1011 1000 1010 1101
		// ����λ��1110 10.. .... 10.. ....��ʽ
		// �У� 4e2d: 1110 0100 1011 1000 1010 1101
		// utf-8:e4 b8 ad: 1110 0100 1011 1000 1010 1101
		byte[] utf8 = str.getBytes("utf-8");
		file = "utf8.txt";
		out = new FileOutputStream(file);
		out.write(utf8);
		out.close();
		IOUtils.print(file);// 41 42 43 44 45 e4 b8 ad e5 9b bd
		// GBK���ı��ر��룬�й���׼֧��ȫ���й��ַ���20000�����ַ�
		// ���ñ��룺1��2�ֽ� ����Ӣ����1�ֽڣ�����2�ֽ�
		// GBK����֧��ȫ�������ַ�
		// �У� 4e 2d
		// GBK: d6 d0
		// GB2312:d6 d0
		// java�ڲ�����ɢ�б�ʵ�ֵĲ���
		// GB2312��GBK���Ӽ���GB2312֧��6000������ú���
		System.out.println("GBK");
		byte[] gbk = str.getBytes("GBK");
		file = "gbk.txt";
		out = new FileOutputStream(file);
		out.write(gbk);
		out.close();
		IOUtils.print(file);// 41 42 43 44 45 d6 d0 b9 fa

		// ����ISO8859-1���룺����ŷ���뷽����֧����ĸ�ͷ��ţ���֧������
		System.out.println("ISO8859-1");
		byte[] iso8895 = str.getBytes("ISO8859-1");
		file = "iso8859.txt";
		out = new FileOutputStream(file);
		out.write(iso8895);
		IOUtils.print(file);// 41 42 43 44 45 3f 3f,���к������3f

		// ���ֵı��룺����(unicode char)������Ϊbyte���еķ���
		// ���ֵĽ��룺�������byte���н���Ϊ�ַ�����(unicode char)
		System.out.println("��ȡutf8.txt���ҽ��룺");
		file = "utf8.txt";
		InputStream in = new FileInputStream(file);
		// in.available()��in�п���������ȡ�����á���byte����
		// С�ļ�ʱ��һ�����ļ��ĳ���
		byte[] buf = new byte[in.available()];// buf���ļ�����һ��,��С�ļ����ڴ��е�һ������
		in.read(buf);// ��С�ļ�һ���Զ�ȡ��byte������
		in.close();// ����
		String s = new String(buf, "utf-8");
		System.out.println(s);// ABCDE�й�
		// ʲô������
		String s2 = new String(buf, "gbk");// ����д����
		System.out.println("���룺" + s2);// ���룺ABCDE�??
		// ϵͳĬ���ı�����
		// System.getProperty(key)��ѯϵͳ����ɢ�б����ϵͳĬ������
		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);// GB2312�����ص�ǰϵͳ�ı���Ĭ�ϱ���
	}
}
