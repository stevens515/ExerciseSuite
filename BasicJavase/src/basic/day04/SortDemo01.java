package basic.day04;

import java.util.Arrays;

public class SortDemo01 {

	/**
		 1) ѡ������
   ԭ��:a �������е�ÿ��Ԫ��,���һ��Ԫ�رȽ�
          ������Ԫ��С�ڵ�һ��Ԫ��, �ͽ����
         ����Ԫ�ؽ���.
       b ÿ��ʹ��a�Ĺ���, ����ѡ���һ����СԪ��
        �ŵ���һ��λ��.
       c ����n-1�ֱȽ��������
	   d �����һ�����ݵ�λ��
	   e �����ÿһ�����ݵ�λ��+..
   ��˵: ÿ��ѡ����С�ķŵ�ǰ��.
      i �����һ����                       �ݵ�λ��
	   j �����ÿһ�����ݵ�λ��
	 */

	public static void main(String[] args) {
		int[] ary = {6,9,2,4,1,5};
		selectionSort(ary);
		System.out.println(Arrays.toString(ary));
		

	}
	public static void selectionSort(int[] ary){
		for(int i = 0;i<ary.length-1;i++){
			for(int j=i+1;j<ary.length;j++){
				if(ary[i]>ary[j]){
					int t = ary[i];
					ary[i] = ary[j];
					ary[j] = t;
				}
			}
		}
	}
}
/**
 	��8,2��3��7��1}	i	j	ary[i] ary[j] ary[i]>ary[j] [i]<->[j]
	��8|2��3��7��1��	0	1	8		2		true		8<->2
	��2|8��3��7��1��	0	2	2		3		false		
	��2|8��3��7��1��	0	3	2		7		false		
	��2|8��3��7��1��	0	4	2		1		true		2<->1
	��1,8|3��7��2��	1	2	8		3		true		8<->3
	��1,3|8��7��2��	1	3	3		7		false
	��1,3|8��7��2��	1	4	3		2		true		3<->2
	��1,2,8|7��3��	2	3	8		7		true		8<->7
	��1,2,7|8��3��	2	4	7		3		true		7<->3
	��1,2,3,8|7��	3	4	8		7		true		8<->7
	��1,2,3,7,8��	,,,,,,,,,,,,
 */
/**
	 	  ԭ��˵��:
	   ary={8,2,3,7,1} 
	   ary={1|8,3,7,2}
	   ary={1,2|8,7,3}
	   ary={1,2,3|8,7}
	   ary={1,2,3,7|8}
	   �������:
	
	   ary      i j ary[i] ary[j] ary[i]>ary[j] [i]<->[j]
	{8|2,3,7,1} 0 1   8      2        true        8<->2
	{2|8,3,7,1} 0 2   2      3        false
	{2|8,3,7,1} 0 3   2      7        false
	{2|8,3,7,1} 0 4   2      1        true        2<->1
	{1,8|3,7,2} 1 2   8      3        true        8<->3
	{1,3|8,7,2} 1 3   3      7        false        
	{1,3|8,7,2} 1 4   3      2        true        3<->2
	{1,2,8|7,3} 2 3   8      7        true        8<->7
	{1,2,7|8,3} 2 4   7      3        true        7<->3
	{1,2,3,8|7} 3 4   8      7        true        8<->7
	{1,2,3,7,8}   
	  i= 0 ~ < ary.length - 1;
	    j=i+1 ~ <ary.length
		  if(ary[i]>ary[j]){
		  	int t=ary[i];ary[i]=ary[j];ary[j]=t;
		  }
	      
 */
