package basic.day02.practice;

import java.util.Scanner;

/**
 * ����һ���ٷ��Ƶķ����������Ӧ�ĵȼ���
    90������        A��
    80~89          B��
    70~79          C��
    60~69          D��
    60������        E��

 */

public class Mark {


	public static void main(String[] args) {
		System.out.println("��������Ҫ��ѯ�ķ�����");
		Scanner console = new Scanner(System.in);
		double mark = console.nextDouble();
		if(mark>100||mark<0){
			System.out.println("�������󣬳����˳���");
			System.exit(0);
		}
		if(mark>90){
			System.out.println("this mark is grade \'A\' ");
		}else if(mark>80){
			System.out.println("this mark is grade \'B\' ");
		}else if(mark>70){
			System.out.println("this mark is grade \'C\' ");
		}else if(mark>60){
			System.out.println("this mark is grade \'D\' ");
		}else{
			System.out.println("this mark is grade \'E\' ");
		}

	}

}
