package basic.day09;

public class ShapeDemo {

	public static void main(String[] args) {
		Shape s = new Circle(3,4,5);
//		Shape ss = new Shape();//�������
		System.out.println(s.area());
		//�����ڼ������� �ķ���
		//�����ڼ��ڶ�����ִ�ж���ķ���Circle.area()
		Point p1 = new Point(6,8);
		System.out.println(s.contains(p1));
		System.out.println(s.getR());//�����ͼ��
		System.out.println(((Circle)s));//ǿת
		System.out.println(((Circle)s).getR());//�з��գ������ڼ�
//		System.out.println(s.r);//������java��������,����û�뾶
	}

}
