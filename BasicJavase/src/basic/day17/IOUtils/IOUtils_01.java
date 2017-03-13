package basic.day17.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//IO ������
public class IOUtils_01 {
	/**
	 * ��ȡ�ļ����Ұ���16���������ÿ10byteΪһ��
	 * 
	 * @param fileName�����ļ���
	 * @throws IOException
	 * @throws IOException
	 *             �ļ���ȡ�쳣
	 */
	public static void printHex(String fileName) throws IOException {
		// 1�������ļ�����������
		FileInputStream in = new FileInputStream(fileName);
		int b;
		// 2.ѭ����ȡbyte
		while ((b = in.read()) != -1) {// �ڴζ�ȡһ��byte,�����EOF
			if (b <= 0xf) {// ��λ��ǰ�油0���磺8����08
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b) + "");
		}
		in.close();
	}
}
