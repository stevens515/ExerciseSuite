package basic.day09;

import java.util.Arrays;

public class ObjectDemo2 {
	public static void main(String[] args) {
		Point3  p = new Point3(3,4);
		String str = p.toString();
//		System.out.println(str);//basic.day09.Point3@9304b1
//		System.out.println(p);//basic.day09.Point3@9304b1,javaĬ�ϵ���p.toString()
		System.out.println(str);//��3��4��
		System.out.println(p);//��3��4��
		/**
		  	��ӡ������Ϣ.Object.toString() ����ȫ�޶�����hashCode()
		  	ȫ�޶�����package.classname
		  	hashCode:���ڴ��ַ����ת���õ���һ���������������ڴ��ַ
		  	java(sun)���鸲�ǵ�toString()!
		  	����Ϊ������ı��������磨2��3��
		  	�ܶ�java API�����������toString������Ϊ���������
		 */
		Point3[] stars = {new Point3(3,4),new Point3(6,7)};
		System.out.println(Arrays.toString(stars));
		
	}
}
class Point3 /** extends Object*/ { //java��Ĭ�ϼ̳���Object,ɶ���Ƕ���
	int x ;
	int y;
	public Point3(int x,int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){//����Object��toString()����
		return "("+x+","+y+")";//(3,4)
	}
}