package basic.day03;

import java.util.Arrays;

public class ExpandArrayDemo {

	/**
	 * ���������㷨
	 */
	public static void main(String[] args) {
		//�������Ĵ�С�ǲ��ܸı�ģ�
		//��ʵ��Ӧ������Ҫ�ṩ�ܹ��޸Ĵ�С�����飡
		//���Բ��ø�����������µ������У�������ĳ��ȳ���ԭ����
		//��ͨʵ������������ı�
		int[] ary1 = {6,7,8};
		int[] temp = Arrays.copyOf(ary1, ary1.length+1);
		//temp = {6,7,8,0};
		ary1 = temp;//����ԭ����
		ary1[ary1.length-1] = 9;
		System.out.println(Arrays.toString(ary1));
		
		ary1 = Arrays.copyOf(ary1, ary1.length+1);
		ary1[ary1.length-1]=10;
		System.out.println(Arrays.toString(ary1));
	}

}
