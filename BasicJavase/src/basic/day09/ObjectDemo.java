package basic.day09;

public class ObjectDemo {
	public static void main(String[] args) {
		Point2  p = new Point2();
		String str = p.toString();
		System.out.println(str);//basic.day09.Point2@9304b1
		System.out.println(p);//basic.day09.Point2@9304b1,javaĬ�ϵ���p.toString()
		/**
		  	��ӡ������Ϣ.Object.toString() ����ȫ�޶�����hashCode()
		  	ȫ�޶�����package.classname
		  	hashCode:���ڴ��ַ����ת���õ���һ���������������ڴ��ַ
		  	java(sun)���鸲�ǵ�toString()!
		  	����Ϊ������ı��������磨��
		 */
		
	}
}
class Point2 /** extends Object*/ { //java��Ĭ�ϼ̳���Object,ɶ���Ƕ���
	
}