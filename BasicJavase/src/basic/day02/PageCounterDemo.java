package basic.day02;

import java.util.Scanner;

	/**�������ʽ*/
public class PageCounterDemo {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("������������");
		int rows = console.nextInt();
//		int rows = 35;//����
		System.out.println("������ҳ���С��");
		int size = console.nextInt();//ҳ���С
		int pages = count(rows,size);//ҳ��
		System.out.println("�����һ��Ҫ��"+pages+"ҳ��");
	}
	public static int count(int rows,int size){
		return rows%size==0?rows/size:rows/size+1;
	}
	
}
