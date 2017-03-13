package basic.day09;

public class Circle extends Shape {

	private int r ;
	public Circle(){
	}
	public Circle(int x,int y,int r){
		this(new Point(x,y),r);
	}
	public Circle(Point center,int r){
		super.location = center;
		this.r = r;
	}
	/**ʵ�ָ����еĳ��󷽷�*/
	public double area() {
		return Math.PI*r*r;
	}

	public boolean contains(int x, int y) {
		return super.location.distance(x,y)<=r;
	}

}
