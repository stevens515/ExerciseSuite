package basic.day06;

public class PointDemo {

	public static void main(String[] args) {
		  Point p1 = new Point(3,4);
		//�±�  �����±� �� new �±����棬�ͣ�
//		p1.x=3;
//		p1.y=4;
		System.out.println(p1.x+","+p1.y);
		Point p2 = new Point(5,5);
//		p2.x=5;
//		p2.y=5;
		System.out.println(p2.x+", "+p2.y);
	}
}
/**
public class Point {
	int x;
	int y;
	public Point(int x,int y){
		//this����ǰ����
		this.x=x;
		this.y=y;
	}
}*/