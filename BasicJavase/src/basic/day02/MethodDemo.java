package basic.day02;

import java.util.Scanner;

public class MethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("����x:");
		int x = console.nextInt();//�ӿ���̨��ȡһ������
//		int x =5;
		int y = f(x);
		System.out.println(y);

	}
	public static int f(int x){
		int y =3*x+6;
		return y;
	}

}
