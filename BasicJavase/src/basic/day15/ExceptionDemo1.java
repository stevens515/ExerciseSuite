package basic.day15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String str = "2012-50-16";
		// parse���������˿��ܻ�����쳣
		// ������������쳣�����ķ������ͱ��봦���쳣!
		Date date = fmt.parse(str);// ��������쳣��
		System.out.println(date);
		// date = fmt.parse("20120316");// ������쳣����ʽ����ȷ
		// System.out.println(date);// �����쳣����ǰ���Ժ����䲻ִ��
	}

}
