package basic.day14;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCastDemo {
public static void main(String[] args) {
	long gmt = 0;//1970 1 1 00:00:00,000
	Date date = new Date();//Ĭ���ǵ�ǰʱ��
	//date.setTime(long time)���ô� Date �����Ա�ʾ 1970 �� 1 �� 1 �� 00:00:00 GMT �Ժ� time �����ʱ��㡣 
	date.setTime(gmt);
	//date.getYear():����һ��ֵ����ֵ�ǴӰ�����ʼ�ڴ� Date �����ʾ��˲�����ݼ�ȥ 1900 �Ľ�����ñ���ʱ�����н��ͣ�
	//����ֵΪ�����ڱ�ʾ����ݼ�ȥ 1900��
	System.out.println(date.getYear());//70
	System.out.println(date);//Thu Jan 01 08:00:00 CST 1970
	Calendar cal = new GregorianCalendar();
	//setTime(Date date):ʹ�ø����� Date ���ô� Calendar ��ʱ�䡣
	cal.setTime(date);//dateתΪcal
	//get(int field):����field�Ǹ����������ֶΡ����ؽ������ֶε�ֵ
	//Calendar:YEAR = 1970��MONTH = JANUARY��DAY_OF_MONTH = 1���ȵȡ� 
	System.out.println(cal.get(Calendar.YEAR));//1970
	
	//1969 12 31 00:00:00,000
	//add(int field,int amount)���������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
	cal.add(Calendar.DAY_OF_YEAR, -1);//��ǰʱ�����һ��
	//ʱ��ļ��㣬��������long���͵���������
	//����һ����ǣ�0-1000L*60*60*24
	System.out.println(cal.get(Calendar.YEAR));//1969
	Date d = cal.getTime();
	System.out.println(d.getYear());//69
	long l = d.getTime();
	System.out.println(l);
	System.out.println(1000L*60*60*24);
	}
}
