package basic.day02.practice;

import java.util.Scanner;

public class BasePower {

	/**
	 *	����������ݣ����ֵ
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������");
		int base = sc.nextInt();
		System.out.println("�������ݣ�");
		int power = sc.nextInt();
		int result = 1;
		for(int i = 0;i<power;i++){
			result = result*base;
		}
		System.out.println(base+"��"+power+"�η���"+result);
	}
}
