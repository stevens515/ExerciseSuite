package basic.day03;

import java.util.Scanner;

public class DoWhileDemo {

	public static void main(String[] args) {
		Scanner console  = new Scanner(System.in);
		int balance = 1000;
		int bet;
		//do while ���Ų�ϰ�ߣ�
//		do{
//			System.out.println("������Ѻע������");
//			bet = console.nextInt();
//		}while(bet<=0||bet>balance);
//		System.out.println("����:"+bet);

		while(true){
		System.out.println("������Ѻע������");
		bet = console.nextInt();
		if(bet>=0&&bet<=balance){
			break;
		}
		System.out.println("���ˣ�");
		}
		System.out.println("������"+bet);
	}
}