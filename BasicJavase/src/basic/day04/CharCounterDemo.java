package basic.day04;

import java.util.Arrays;

public class CharCounterDemo {

	/**
	 *���ַ��������ַ�
	 *ʲô�����鳤����չ
	 */
	public static void main(String[] args) {
		String str = "abdkfjkbfbdafjb";
		int[] ary = count(str,'b');
		System.out.println(Arrays.toString(ary));
	}
	public static int[] count(String str ,char key){
		int[] ary = {};//null pk {}0
		for(int i=0;i<str.length();i++){
			//i=0 1 2 3...
			char ch = str.charAt(i);
			if(ch==key){
				//i ->{}
				ary = Arrays.copyOf(ary, ary.length+1);
				ary[ary.length-1]=i;
			}
		}
		return ary;
	}

}
