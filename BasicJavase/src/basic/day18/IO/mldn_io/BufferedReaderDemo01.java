package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**�����������ݵı�׼��ʽ
 * 
 *��System.in��Ϊ�ַ������뵽BufferedReader�󣬿���ͨ��readerLine()�����ȴ��û�������Ϣ��
 */
 /*BufferedReader�ࣺ
	���ڴӻ������ж�ȡ���ݣ����е������ֽ����ݶ������ڻ������У�
	����:public BufferedReader(Reader in)  ����  ����һ��Reader���ʵ��
	public String readLine() throws IOException ��ͨ  һ���Դӻ������н�����ȫ����ȡ����
	BufferedReader�ж���Ĺ��췽��ֻ�ܽ����ַ���������ʵ�������Ա���ʹ���ַ���������
	�ֽ���������ת����InputStreamReader���ֽ�������System.in��Ϊ�ַ������磺
	//BufferedReaderʵ��������
	BufferedReader buf = null;
	buf=new BufferedReader (new InputStreamReader(System.in));
	System.in���ֽ���������InputStreamReader()�ǽ��ֽڱ�Ϊ�ַ�����
	BrfferedReader�ǽ��ַ����ŵ��ַ���������֮�С�
 */
public class BufferedReaderDemo01 {
	public static void main(String[] args) {
		BufferedReader buf =null;//����BufferedReader����
		buf = new BufferedReader(new InputStreamReader(System.in));//ʵ����BufferedReader
		
		String str =null;				//������������
		System.out.println("���������ݣ�");
		try {
			str = buf.readLine();		//��ȡ��������
		} catch (IOException e) {		//Ҫ�����쳣����
			e.printStackTrace();
		}
		System.out.println("���������Ϊ��"+str);
		
	}
}
