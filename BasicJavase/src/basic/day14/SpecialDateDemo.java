package basic.day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SpecialDateDemo {

	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		System.out.println("�����������ڣ�yyyy-MM-dd��");
		String str = in.nextLine();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date create = fmt.parse(str);
		Date special = specialDate(create,3);
		System.out.println("�������ڣ�"+fmt.format(special));
		
		System.out.println(special.compareTo(create));
	}
	/**
	 * 
	 * @param create ��������
	 * @param months����������
	 * @return	��������
	 */
	public static Date specialDate(Date create,int months){
		Calendar cal = Calendar.getInstance();//��õ�ǰʱ��
		cal.setTime(create);
		cal.add(Calendar.MONTH, months);//���㵽����ʱ��
		cal.add(Calendar.WEEK_OF_YEAR, -2);//����2��
		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
			cal.add(Calendar.WEEK_OF_YEAR, -1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		return cal.getTime();
	}
}
