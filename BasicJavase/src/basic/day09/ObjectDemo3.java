package basic.day09;

import java.util.Arrays;

public class ObjectDemo3 {
	public static void main(String[] args) {
		Point4  p = new Point4(3,4);
		String str = p.toString();
//		System.out.println(str);//basic.day09.Point4@9304b1
//		System.out.println(p);//basic.day09.Point4@9304b1,javaĬ�ϵ���p.toString()
		System.out.println(str);//��3��4��
		System.out.println(p);//��3��4��
		/**
		  	��ӡ������Ϣ.Object.toString() ����ȫ�޶�����hashCode()
		  	ȫ�޶�����package.classname
		  	hashCode:���ڴ��ַ����ת���õ���һ���������������ڴ��ַ
		  	java(sun)���鸲�ǵ�toString()!
		  	����Ϊ������ı��������磨2��3��
		  	�ܶ�java API�����������toString������Ϊ���������
		  	toString()API:����ָ���������ݵ��ַ�����ʾ��ʽ���ַ�����ʾ��ʽ�������Ԫ���б���ɣ�
		  	���ڷ����ţ�"[]"����.����Ԫ�����ַ� ", "�����żӿո񣩷ָ�
		 */
		Point4[] stars = {new Point4(3,4),new Point4(6,7)};
		System.out.println(Arrays.toString(stars));//[(3,4), (6,7)]
		
		int[] ary = {3,4,5};
		String[] names = {"Tom","Jerry"};
		System.out.println(ary);//[I@190d11
		System.out.println(names);//[Ljava.lang.String;@a90653
		System.out.println(Arrays.toString(ary));//[3, 4, 5]
		System.out.println(Arrays.toString(names));//[Tom, Jerry]
	}
}
class Point4 /** extends Object*/ { //java��Ĭ�ϼ̳���Object,ɶ���Ƕ���
	int x ;
	int y;
	public Point4(int x,int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){//����Object��toString()����
		return "("+x+","+y+")";//(3,4)
	}
}