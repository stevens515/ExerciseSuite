package basic.day03;

import java.util.Arrays;

public class ArrayDemo2 {

	/**
	 *����ĸ��ƺ������㷨
	 */
	public static void main(String[] args) {
		//��������ĸ�ֵ
		int[] ary1 = new int[]{3,4,5};
		int[] ary2 = ary1;
		ary2[1] = 8;
		System.out.println(ary1[1]);//8
		//�������ĸ���
		int[] ary3 = new int[ary1.length];//{0,0,0}
		for(int i=0;i<ary1.length;i++){
			ary3[i]=ary1[i];
		}
		ary3[1] = 10;
		System.out.println("ary1:"+Arrays.toString(ary1));
		System.out.println("ary2:"+Arrays.toString(ary2));
		System.out.println("ary3:"+Arrays.toString(ary3));

//		ary3[1] = 10;
//		System.out.println(ary1[0]);
//		System.out.println(ary1[1]);
//		System.out.println(ary1[2]);
//		System.out.println(ary3[0]);
//		System.out.println(ary3[1]);
//		System.out.println(ary3[2]);
		
		//java API�ṩ�ˡ���Ч��������Ʒ���������Cʵ��
		int[] ary4 = new int[ary1.length];
		System.arraycopy(ary1,0,ary4,0,ary1.length);
		ary4[1] = 12;
		System.out.println("ary4:"+Arrays.toString(ary4));
		
		//java 5 API�ṩ�˸��Ӽ��ĸ��Ʒ�����
		int[] ary5 = Arrays.copyOf(ary1, ary1.length);
		ary4[1] = 20;
		System.out.println("ary5:"+Arrays.toString(ary5));
	}
}
