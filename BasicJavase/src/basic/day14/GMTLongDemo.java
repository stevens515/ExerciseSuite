package basic.day14;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * GMT ʱ���׼
 */
public class GMTLongDemo {
public static void main(String[] args) {
	long now = System.currentTimeMillis();
	long year = now/1000/60/60/24/365+1970;
	System.out.println(year);//2012
	//long month = ? ;
	//������Date = GMT Long + ����(����������
	Date date = new Date(now);//����Date����ʱ���ǵ�ǰʱ��
	//Date getYear()�������ݹ�����������(����)2λ�����
	//��1900������2000���Ժ����3λ���ˣ���y2k��ǧ�����⣩
	int y = date.getYear()+1900;
	//getMonth()����2λ���·ݣ���0��ʼ
	int m = date.getMonth()+1;
	System.out.println(y);//2012
	System.out.println(m);
	
	//Calendar �����������������ࡣ
	//GregorianCalendar()�����������������������㷨
	//GregorianCalendar = long + ���������㷨
	//�κ��������͵�Ĭ��ֵ���ǵ�ǰʱ��
	Calendar cal = new GregorianCalendar();
	y = cal.get(Calendar.YEAR);
	m = cal.get(Calendar.MONDAY)+1;
	System.out.println(y);//2012
	System.out.println(m);//3
	
	}
}
