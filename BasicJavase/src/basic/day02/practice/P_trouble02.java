package basic.day02.practice;

import java.util.Scanner;

public class P_trouble02 {

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
		
			
			/**
			 * factorial �׳ˣ�
			 */

			System.out.println("������һ����������");
			Scanner console = new Scanner(System.in);
			int fac =console.nextInt();
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
