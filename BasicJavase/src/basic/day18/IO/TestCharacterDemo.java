package basic.day18.IO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * ����֪�����ڼ�������ŵľ���һ�ѵĶ����ƣ��������������ʾһ���ַ������֣���ĸ��������ţ��ȣ� ���Ҫ��������ˣ�
 * �ַ����Ϳ�����������ַ���������⣬ʹ���������Ա�֤�����ͳһ����ֹ�������롣 ���磺һ���ַ��� A�������� ASCII ���׼����Ϊ 0X41��
 * �ַ����룺
 */
public class TestCharacterDemo {
	public static void main(String[] args) throws IOException {
		String s1 = "���ڿƼ�";
		byte[] b1 = s1.getBytes("UTF-8");//ָ��ʹ��UTF��8���뷽ʽ 
		String s2 = new String(b1,"GBK");//ʹ��GBK��ʽ���룬��ʱ�ͻ������������
		System.out.println(s2);
		
		byte[] b2 = s2.getBytes("GBK");//����ͬ����ʽ�������
		String s3 = new String("UTF-8");//�������������ʱһ�£���ӡ����
		System.out.println(s3);
	}
}
