package basic.day08.graph;

/**��*/
public class Point {
	int x;
	int y;
	public Point(){
	}
	/**����һ�������������(x,y)Ϊǰ��*/
	public Point(int x ,int y){
		this.x=x;
		this.y=y;
	}
	/**���㵱ǰ�㵽һ������ľ���*/
	public double distance(int x,int y){
		return Math.sqrt(this.x-x)*(this.x-x)+(this.y-y)*(this.y-y);
	}
	public double distance(Point other){
		return this.distance(other.x,other.y);
	}
	public double distance(){
		return this.distance(0,0);
	}
}
