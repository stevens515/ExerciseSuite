package basic.day02.practice;

import java.util.Scanner;

/**
 * 1����д�����жϸ�����ĳ������Ƿ������ꡣ
  ������жϹ������£�
  ��1����ĳ������ܱ�4���������ܱ�100�������������ꡣ
  ��2����ĳ������ܱ�400��������Ҳ�����ꡣ
 */

public class Bissextile {

	public static void main(String[] args) {
		while(true){
			Scanner console = new Scanner(System.in);
			System.out.println("��������Ҫ��ѯ����ݣ�");
			int year = console.nextInt();
			if(year<0 || year>3000){
				System.out.println("�������󣬳����˳���");
				System.exit(0);
			}
			if((year%4==0)&& (year%100!=0)||(year%400==0)){
				System.out.println(year+"  is bissextile!");
			}else{
				System.out.println(year+" is not bissextile!");
			}
		}
		
	}
}