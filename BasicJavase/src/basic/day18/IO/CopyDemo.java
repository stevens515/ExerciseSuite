package basic.day18.IO;

import java.util.Arrays;


public class CopyDemo {
	public static void main(String[] args) {
		String[] ary = {"Tom","Jerry"};
		String[] ary1 = Arrays.copyOf(ary, ary.length);
		String[] ary2 = (String[])(IOUtils.deepCopy(ary));
		System.out.println("ǳ�㸴��");
		System.out.println(ary==ary1);//false
		System.out.println(ary[1]==ary1[1]);//true
		System.out.println("��㸴��");
		System.out.println(ary==ary2);//false
		System.out.println(ary2[1]==ary[1]);//false
	}
}
