package basic.day06;

public class Point {
	/**�� ����*/
		int x;
		int y;
		/**����������ʼ��һ������ʵ���Ĺ���
		 *�﷨Ҫ��
		 *		A.���������ʱ���������һ��
		 *		B.���ܶ��巵��ֵ
		 *		C.�����в����������ǳ�ʼ�������ǰ������
		 *������������У�����x,y�ǳ�ʼ��һ��������ǰ������
		 */
		public Point(int x,int y){//Point(int)
			//this����ǰ����
			System.out.println("this.x="+this.x+",="+x);
			this.x=x;
			this.y=y;
			//����ǩ���������������������б���������޹أ�
		//���������Point(int x)������ͬ�ķ���ǩ����Point(int)
		}
		
		/**���ع������������������ʼ���Խ����ϵĵ�
		 * ���صĹ������������б�ͬ���������ͣ���������������˳��
		 */
		
		public Point(int x){//Point(int)
			//this()���õ�����������
//		 this(x,x);
			this.x = x;
			this.y = x;
		}
		/*
		 * ���������ܣ����㵱ǰ�㵽ԭ��ľ���
		 * �����ڶ���ķ����������ڶ����ϵ��ã�this����ǰ����
		 * this��������ʡ��
		 */
		
		public double distance(){
			//��ǰ���������
//			return Math.sqrt(this.x*this.x*+this.y*this.y);
			return Math.sqrt(x*x*+y*y);
		}
		/**���㵱ǰ�㣨this)������һ��(other)�ľ���*/
		public double distance(Point other){
			return this.distance(other.x,other.y);//���÷���
		}
		/**���㵱ǰ��(this)��һ������(x,y)�ľ���*/
		public double distance(int x,int y){
			return Math.sqrt((this.x-x)*(this.x-x))+(this.y-y)*(this.y*y);
		}
}
