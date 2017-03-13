package basic.day18.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
/**
 * ��ʱ����ʹ��
 */
public class TimerDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 7);//�����ߵ�
		cal.set(Calendar.SECOND, 0);
		date = cal.getTime();
		//������ʹ�����£�����TMT��ʽ
		long utc = cal.getTimeInMillis();//���ص���UTC��׼
		Date d = new Date(utc);
		System.out.println(d);
		
		//û���ӳ�
//		timer.schedule(new TimerTask(){
//			public void run(){
//				System.out.println("������");
//			}
//		}, date);
		//���ӳ�
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("������");
			}
		}, date,1000L*60*60*24);//�ӳ�ʱ��1000L*60*60*24
		
	}
}
