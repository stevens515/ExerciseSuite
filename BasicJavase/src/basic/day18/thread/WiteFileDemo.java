package basic.day18.thread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *ͬ��������ͬʱ��ͬ����ָ�����Ⱥ����һ��һ��ִ��
 *		�磺����
 *		���ܲ
 *ͬʱ��(�ڼ����в����ڣ�)��������ڲ��У�������������൱�ڡ�ͬʱ��
 *�첽�����ǲ������첽���ǲ�����һ�£��Ĳ�������������
 *		�磺������Ƶ�����غͲ������첽�ģ��ǲ���������
 *		   �����߳�ʵ�ֵģ�һ���̸߳������أ�һ���̸߳��𲥷�
 *		�첽���ܺ�
 */
public class WiteFileDemo {
	public static void main(String[] args) throws IOException {
		//�ӿ���̨��ȡ��Ϣд�뵽�ļ���
		String file = "sync.txt";
		PrintWriter out = new PrintWriter(new FileOutputStream(file));
		Scanner in = new Scanner(System.in);
		while (true) {
			String str = in.nextLine();
			out.println(str);
			if (str.equals("quit")) {
				break;
			}
		}
		out.close();
	}
}
