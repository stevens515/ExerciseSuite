package basic.day08.graph;


/**ͼ��*/
public class Shape {
	/**ͼ��λ��*/
	Point location;
	/**������������ڼ�������Ĺ��ܣ����幦����Ҫ����ͼ���ṩ�����ǣ�*/
	public double area(){
		return 0;
	}
	/**����contains,�жϵ�ǰͼ���Ƿ����һ�����꣬���������า��*/
	public boolean contains(int x,int y){
		return false;
	}
	/**�жϵ�ǰͼ���Ƿ����һ�������*/
	   //�����ط����е��ã�������д������򵥣�����ֻҪ��д contains(int x , int y )����
	  //contains(Point p)һ����ʹ��
	public boolean contains(Point p){
		//���õ�ǰ����İ�������contains(int ,int)ʵ��
		//�����ǰ���������ڼ�ľ�����󣬿�����һ��Բʵ��
		//���������������Բ����ķ���
		return this.contains(p.x,p.y);
	}
}
