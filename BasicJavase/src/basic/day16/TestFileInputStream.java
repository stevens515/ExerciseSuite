package basic.day16;
/**InputStream��������
 *	1. ��ȡһ���ֽڲ�����������ʽ���أ�0��255����������أ�1�ѵ���������ĩβ
 *		int read() throws IOException
 *	2. ��ȡһϵ���ֽڲ��洢��һ������buffer������ʵ�ʶ�ȡ���ֽ�����ĩβ��1
 *		int read(byte[] buffer) throws IOExcetion
 *	3. ��ȡlength���ֽڣ����洢��һ���ֽ�����buffer����lengthλ��
 *		����ʵ�ʶ�ȡ���ֽ����������ȡǰ�Ե���������ĩβ���أ�1
 *		int read(byte[] buffer,int offset,int length)throw IOException
 *	4. �ر����ͷ��ڴ���Դ
 *		void close() throws IOExcetion
 *	5.����n���ֽڲ���������ʵ���������ֽ���
 *		long skip(long n)throws IOException
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String[] args) {
		int b = 0;
		FileInputStream in = null;
		try {
			in = new FileInputStream("/etc");
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ���");
			System.exit(-1);
		}
		try {
			long num = 0;
			while ((b = in.read()) != -1) {
				System.out.println((char) b);
				num++;
			}
			in.close();
			System.out.println();
			System.out.println("����ȡ��" + num + "���ֽ�");
		} catch (IOException e1) {
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}

	}
}
