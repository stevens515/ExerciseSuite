package basic.day02;

import java.util.Scanner;

public class IfDemo2 {

	/**
	 * �ڶ������
	 */
	public static void main(String[] args) {
		
		while(true){
			Scanner console = new Scanner(System.in);
			System.out.println("��������Ҫ���ٱ���");
			int qty = console.nextInt();//������5��
			int price =5;//�۸�5��һ��
			double pay = pay(qty,price);
			System.out.println(pay);
		}
		
	}
	public static double pay(int qty,int price){
/*		double pay = 0;
		if(qty%2==0){//ż��
			pay = (price + (double)price/2)*(qty/2);
		}else{
			pay = (price + (double)price/2)*(qty/2)+price;
		}*/
		
		double pay = (price + (double)price/2)*(qty/2);
		if(qty%2!=0){
			pay = pay+price;//pay+=price;
		}
		return pay;
	}

}
