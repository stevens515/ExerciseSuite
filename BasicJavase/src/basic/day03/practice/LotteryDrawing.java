package basic.day03.practice;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {

	/**
	 * �������򣬳�������Ϸ
	 */
	public static void main(String[] args) {
		
//		int[] numbers = new int[100];
//		for(int i=0;i<numbers.length;i++)
//			numbers[i]=i+1;
//		int[] result = new int[6];//���������ֵ
//		/*
//		 * Math.random����������һ��0~1֮�䣨��0������1���������������
//		 * ��n����������������Ϳɵõ���0��n-1֮���һ�������
//		 */
//		int r = (int)(Math.random()*100);
//		result[i] = numbers[r];
		
		/*
		 	ÿ�γ�ȡ�Ķ����±꣬������ʵ�ʵ�ֵ
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("How many numbers do you need to draw?");
		int n = in.nextInt();
		
		System.out.println("What is the highest number you can draw?");
		int k = in.nextInt();
		
		//fill an array with numbers 1,2,3,4,5......n
		int[] numbers = new int[n];
		for(int i=0;i<numbers.length;i++){
			numbers[i]=i+1;
		}
		
		//draw k numbers and put them into a second array
		int[] result = new int[k];
		for(int i=0;i<result.length;i++){
			
			//make a random index between 0 and n-1
			int r = (int)(Math.random()*n);
			
			//pick the element at the random location
			//��result�ĵ�i��Ԫ������Ϊnumbers[r]��ŵ���ֵ
			result[i] = numbers[r];
			
			//move the last element into random location
			//��Ϊ���齱����ֵ����һ�������������һ��ֵ�ĳ�number[r],����n-1
			numbers[r] =numbers[n-1];
			n--;
		}
		//print the sorted array
		Arrays.sort(result);
		System.out.println("Bet the following combination.It'll make you rich!");
		for(int r : result)
			System.out.println(r);
	}

}
