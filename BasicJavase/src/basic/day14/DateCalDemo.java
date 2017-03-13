package basic.day14;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCalDemo {
	public static void main(String[] args) {
		// ʱ������ԭ��
		long now = System.currentTimeMillis();//  ��ǰʱ��
		long l = now + 1000L * 60 * 60 * 24;// ����
		System.out.println(l);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(new Date(l)));
		//�õ�������ʱ��
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.MONTH, 5);//����5���µĺ�����
		cal.add(Calendar.YEAR, 5);//����5��ĺ�����
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//�����ڸ�Ϊ���ܵ���һ
		System.out.println(fmt.format(cal.getTime()));
	}
}
