package basic.day18.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
/**
 * ��ʱ����ʹ��java.util.Timer
 *  void 	schedule(TimerTask task, Date time)
	  		������ָ����ʱ��ִ��ָ��������
 	void 	schedule(TimerTask task, Date firstTime, long period)
          ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
 */
public class TimerDemo2 {
	public static void main(String[] args) {
		final Timer timer = new Timer();
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 7);//�����ߵ�
		cal.set(Calendar.SECOND, 0);
		date = cal.getTime();
		//������ʹ�����£�����TMT��ʽ
//		long utc = cal.getTimeInMillis();//���ص���UTC��׼
//		Date d = new Date(utc);
//		System.out.println(d);
		
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
		
		
		//10��ĵ���ʱ
		final long end = System.currentTimeMillis()+10*1000;//��ǰ��������ʮ��
		//�����������ӳֶ೤ʱ��ִ�С��±������ڿ�ʼ��ÿ1�룬��..
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				long now = System.currentTimeMillis();//run()��������ʱ�ĵ�ǰʱ�� 
				long show = end-now;//ʣ��ʱ�������
				long s = show/1000;//ת������
				System.out.println(s);//��ʾʣ��ʱ��
			}}, 0,1000);
		
		//�ڽ�����һʱ��ִ��
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("��ʱ������");
				timer.cancel();//ȡ�����м�ʱ��
			}
		}, new Date(end));//
		
	}
}
