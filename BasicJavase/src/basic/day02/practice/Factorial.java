package basic.day02.practice;

import java.util.Scanner;

public class Factorial {

	/**
	 * factorial �׳ˣ�
	 */
	public static void main(String[] args) {
		System.out.println("������һ����������");
		Scanner sc = new Scanner(System.in);
		int fac = sc.nextInt();
		int layer = fac;
		int j = 1;
		loop: while(true){
			//Ϊʲô������layer???
			layer=layer*(fac-j);//�׳˵ľ���ʵ��
			j++;
			if(fac==j)
				break loop;
		}
		System.out.println(fac+"�Ľ׳�Ϊ��"+layer);
	}


}
