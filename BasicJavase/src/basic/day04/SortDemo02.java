package basic.day04;

import java.util.Arrays;

/**
 2) ð������
  ԭ��: a ��һ�Ƚ����������ڵ�����Ԫ��, �������
         ������С��ǰ�������, �ͽ����Ⱥ�Ԫ��.
       b ����һ���ִεıȽ�, һ����һ��������
         ������λ��.
       c ÿ�αȽ�ʣ�µ�Ԫ��, ����n-1�αȽ�, ����
         ʵ������ 
         	i�������
			j����Ƚ�λ��
 */
public class SortDemo02 {


	public static void main(String[] args) {
		int[] ary = {8,2,3,7,1};
		bobuble(ary);
		System.out.println(Arrays.toString(ary));
		

	}
	public static void bobuble(/*final*/ int[] ary){//����final��������������
		for(int i = 0;i<ary.length-1;i++){
			for(int j=0;j<ary.length-i-1;j++){
				System.out.print(Arrays.toString(ary));
				System.out.print(" i=" +i);
				System.out.print(" j=" +j);
				System.out.print(" j+1=" +(j+1));
				System.out.print(" [j]=" +ary[j]);
				System.out.print(" [j+1]" +ary[j+1]);
				System.out.print(" [j]>[j+1]" +(ary[j]>ary[j+1]));
				if(ary[j]>ary[j+1]){
					System.out.print(""+ary[j]+"<->"+ary[j+1]);
					int temp = ary[j];
					ary[j] = ary[j+1];
					ary[j+1] = temp;
				}
					System.out.println();
			}
		}
	}
}
/**
	��˵: �Ƚ�����Ԫ��,�����󽻻�
	ԭ��˵��:
	ary={8,2,3,7,1}
	ary={2,8,3,7,1}
	ary={2,3,8,7,1}
	ary={2,3,7,8,1}
	ary={2,3,7,1|8}
	ary={2,3,7,1|8}
	ary={2,3,7,1|8}
	ary={2,3,1|7,8}
	ary={2,3,1|7,8}
	ary={2,1|3,7,8}
	ary={1,2,3,7,8}

	 ary        i  j j+1  ary[j] ary[j+1] [j]>[j+1] [j]<->[j+1]
	{8,2,3,7,1} 0 0  1    8       2       true      8<->2
	{2,8,3,7,1} 0 1  2    8       3       true      8<->3
	{2,3,8,7,1} 0 2  3    8       7       true      8<->7
	{2,3,7,8,1} 0 3  4    8       1       true      8<->1
	{2,3,7,1|8} 1 0  1    2       3       false     
	{2,3,7,1|8} 1 1  2    3       7       false 
	{2,3,7,1|8} 1 2  3    7       1       true      7<->1
	{2,3,1|7,8} 2 0  1    2       3       false
	{2,3,1|7,8} 2 1  2    3       1       true      3<->1
	{2,1|3,7,8} 3 0  1    2       1       true      2<->1
	{1,2,3,7,8}
	i = 0~ < ary.length-1
	 j = 0~ < ary.length - i -1;  
	   if([j]>[j+1]){
		    [j]<->[j+1]
	   }
*/