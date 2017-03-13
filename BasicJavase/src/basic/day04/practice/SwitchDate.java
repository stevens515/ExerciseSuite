package basic.day04.practice;

import java.util.Scanner;

public class SwitchDate {

	static int year,weekDay;
	public static void main(String[] args) {
		System.out.println("������һ����ݣ�");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		year = Integer.parseInt(str);
		weekDay = firstWeekDayOfYear(year);
		System.out.print("\n       "+year+"�� ");
		showMonths();
	}

	public static boolean isLeapYear(int year){//����
		return ((year % 4 == 0 && year % 100 !=0)||(year % 400 ==0));
	}
	public static int firstWeekDayOfYear(int year){//��������һ�������ڼ�
		long day = year*365;
		for(int i=1;i<year;i++)
			if(isLeapYear(i))
				day+=1;
		return (int)day%7;
	}
	public static int getMonthOfDays(int month){//��ȡÿ���µ�����
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if(isLeapYear(year))
				return 29;
			else
				return 28;
			default:
				return 0;
						
		}
	}
	public static void showMonths(){		//���ָ����12�����е���������
		for(int m=1;m<=12;m++){
			System.out.println(m+"��");
			System.out.println("Sunday Monday Tuesday Wednesday Thursday Friday Saturday");//ÿ���µ�������
		
		for(int j=1;j<=weekDay;j++){	//��ÿ���µ�һ�������ڼ���ӡ��Ӧ�Ŀո�
			System.out.println("       ");
		}
		int monthDay = getMonthOfDays(m);	//��ȡÿ���µ�����
		for(int d = 1;d<=monthDay;d++){  //��ÿ���µ�������һ���������ʽ��ӡ����
			if(d<10)
				System.out.println(" " + "0"+d+"    ");
			else
				System.out.print(" "+d+"  ");
			weekDay = (weekDay + 1)%7; 	//�жϵ���ĵڶ��������ڼ�
			if(weekDay==0)		//����ڶ����������죬�㻻��
				System.out.println();
		}
		System.out.println();
	}
  }
}
