package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**19.9.2 ʵ������һ���ӷ�����
 * 
 * Ҫ��Ӽ��������������֣�Ȼ��������������ļӷ���������Ϊ�Ӽ��̽��չ���������
 * ȫ���ǲ��ַ�������ʽ��ŵģ�����ֱ�ӽ��ַ���ͨ����װ��Intege���ַ�����Ϊ�����������͡�
 *
 */
public class ExecDemo01 {
	public static void main(String[] args) throws IOException {
		int i = 0;
		int j = 0;
		BufferedReader buf = null;		//���ռ��̵���������
		buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;				//׼����������
		System.out.println("�������һ�����֣�");
		str = buf.readLine();
		i = Integer.parseInt(str);		//���ַ������int��
		System.out.println("������ڶ������֣�");
		str = buf.readLine();
		j = Integer.parseInt(str);
		System.out.println(i+"+"+j+"="+(i+j));
		
	}
}
/**
	ʵ������ĿҪ�󣬵������������⣺
	1.	�����������ַ����������֣���϶��޷�ת������������ָ�ʽ���쳣��������ת��ʱӦ��ʹ�����������֤��
		�����֤�ɹ��ˣ����ʾ���Խ���ת�����������֤ʧ���ˣ���ʾ�޷�����ת������Ҫ�ȴ��û������������ֲſ��ԡ�
	2. ֻ����������
	3.�����ظ���ֻҪ�������ݣ���϶�ʹ��BufferedReader���ظ�����readLine()����
	
*/