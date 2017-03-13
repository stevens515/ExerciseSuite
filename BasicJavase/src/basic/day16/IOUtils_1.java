package basic.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils_1 {
	// ��ȡ,1K X 1024

	public static void cp(String src, String dst) {
		try {
			// in�����ȡ�ļ���out����д���ļ�
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			int b;
			while ((b = in.read()) != -1) {// ��ȡԴ�ļ�(in)��b
				out.write(b);// ��bд�뵽Ŀ���ļ�(out)
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	// ��ȡ���٣�ÿ1K,�������
	public static void cp2(String src, String dst) {
		try {
			// in�����ȡ�ļ���out����д���ļ�
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			byte[] buf = new byte[1024];// 1K Byte
			int num;
			while ((num = in.read(buf)) != -1) {
				out.write(buf, 0, num);
				System.out.println("num:" + num);// ���ڲ���
			}
			;
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static void print(String file) {
		try {
			InputStream in = new FileInputStream(file);
			int b;
			int i = 1;
			while ((b = in.read()) != -1) {
				if (b <= 0xf) {
					System.out.println("0");
				}
				System.out.println(Integer.toHexString(b) + " ");
				if (i++ % 16 == 0) {
					System.out.println();
				}
				System.out.println();
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// ��ary���ݰ���16������ʽ��ӡ��ÿ16��byteΪһ�� @param ary����
	public static void print(byte[] ary) {

	}

}