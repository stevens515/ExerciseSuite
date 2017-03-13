package basic.day06;

/**Բ */
public class Circle {
	Point center;
	double r;
	public Circle(Point center,double r){
		this.center=center;
		this.r= r;
	}
	public Circle(int x,int y,double r){
		this(new Point(x,y),r);//this(�㣬�뾶��
	}
	public double area(){
		return Math.PI*this.r*r;//Բ���
	}
	public boolean contains(Point p){
		return this.center.distance(p)<=r;
//		if(this.center.distance(p)<=r){
//			return true;
//		}else{
//			return false;
//		}
	}
	public boolean contains(int x,int y){
		return this.center.distance(x,y)<=r;
	}

}
