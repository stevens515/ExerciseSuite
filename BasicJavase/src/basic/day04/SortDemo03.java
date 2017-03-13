package basic.day04;

import java.util.Arrays;

/**
	3) ��������
  ԭ��: a �������Ϊ������, ���󲿷ֵĵ�һ����һ
         ��ǰ����ÿһ�űȽ�, �����ǰԪ��С, ��
         ����ǰ��
        temp ����ȡ���Ĵ�����Ԫ��
   		i ������������Ԫ�� λ��
   		j ����ǰ��ÿ��Ԫ�ص�λ��
 */
public class SortDemo03 {


	public static void main(String[] args) {
		int[] ary = {8,2,3,7,1};
		insertSort(ary);
		System.out.println(Arrays.toString(ary));
		

	}
	//i����������Ԫ�أ�j����ǰ�ߵ�Ԫ�ء�temp��ʱ�� ȡ����
	public static void insertSort(int[] ary){
		int i,j,temp;
		for(i=1;i<ary.length;i++){
			temp = ary[i];
			for(j=i-1;j>=0&& temp<ary[j];j--){
				//move ary[j] ->ary[j++1]
				ary[j+1] = ary[j];
			}
			ary[j+1]=temp;
		}
	}
}

/**
	  ԭ��˵��:
   temp = 1
  {8|2,3,7,1}
  {2,8|3,7,1}
  {2,3,8|7,1}
  {2,3,7,8|1}
  {2,3,7,7|8}
  {2,3,3,7|8}
  {2,2,3,7|8}
  {1,2,3,7|8}


                                     (�ƶ�)     ����
   ary      i  t  j  ary[j]  t<[j] [j]->[j+1] t->[j+1]
{8|2,3,7,5} 1  2  0    8     true   8->[j+1]   
{8|8,3,7,5} 1  2 -1                            2->[j+1]
{2,8|3,7,5} 2  3  1    8     true   8->[j+1]
{2,3|8,7,5} 2  3  0    2     false             3->[j+1]
{2,3,8|7,5} 3  7  2    8     true   8->[j+1]
{2,3,7|8,5} 3  7  2    3     false             7->[j+1]
{2,3,7,8|5} 4  5  3    8     true   8->[j+1] 
{2,3,7,5|8} 4  5  2    7     true   7->[j+1] 
{2,3,7,7|8} 4  5  1    3     false             5->[j+1]
{2,3,5,7|8} 5
 
 i= 1 ~ <ary.length, i++
	 t = [i];
		 j= i-1 ~ >=0, j--
		 if(t<[j]){
		 	[j]->[j+1] //�ƶ�
		 }else{
		  	break j;
		 }
	 t->[j+1]//����
 */