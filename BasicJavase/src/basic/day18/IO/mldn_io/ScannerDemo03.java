package basic.day18.IO.mldn_io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**ʵ����������ʵ�����ڸ�ʽ����������
 *	��Scanner����û���ṩר�ŵ����ڸ�ʽ������������ԣ������õ�һ���������͵�
 *���ݣ�������Լ���д������֤�����ֹ�ת���� 
 */
public class ScannerDemo03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������(yyyy-MM-dd):");
		String str = null;
		Date date = null;
		if(scan.hasNext("^\\d{4}-\\d{2}-\\d{2}$")){//�ж������ʽ�Ƿ�������
			str = scan.next("^\\d{4}-\\d{2}-\\d{2}$");//�������ڸ�ʽ���ַ���
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("��������ڸ�ʽ����");
		}
		System.out.println(date);
	}
}
