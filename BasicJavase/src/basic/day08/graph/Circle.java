package basic.day08.graph;


/**
 	Բ������ͼ��
  	extends�̳У��������Ϊ���ǡ�
 */
public class Circle extends Shape{
	/**�뾶*/
	int r;
	public Circle(){
	}
	public Circle(Point center,int r){
		super();
		this.location=center;
		this.r=r;
	}
	public Circle(int x,int y,int r){
		this(new Point(x,y),r);
	}
	public double area(){
		return Math.PI*r*r;
	}
//	public boolean contains(int x,int y){
//		return super.contains(x,y);
//	}
	public boolean contains(int x,int y){
		return this.location.distance(x,y)<=r;
	}
}
