package basic.day08;

import basic.day08.graph.Circle;
import basic.day08.graph.Rectangle;
import basic.day08.graph.Shape;

public class CastDemo {

	public static void main(String[] args) {
		//�����Ͷ���ı�����������������ʵ��,��С���͵������ͣ������Զ�ת����
//		Shape s = new Circle(3,4,5);
		//�������͵��Զ�����(��ʽ����ת��)ת��
		Circle c = new Circle(3,4,5);
		//ת���������ñ���������
		//��С���͵��������Զ����
		Shape s = c;
		print(c);
		
		//�������ͱ�����ǿ������ת��(��ʾ����ת��)
		//�ɴ����͵�С���͵�ת��(����)
		//ת�����з��յ�
		Circle cc = (Circle)s;//��s���õ�ʵ�ʶ�����Բ�����ת����ɹ�
		s = new Rectangle(4,5,6,7);
		print(s);
		cc = (Circle)s;//���д���sʵ�����õĶ�����Բ��ɵġ� java.lang.ClassCastException
	}
	public static void print(Shape s){
		//instanceof ����������ж�s���õı����Ƿ���Circle���͵�
		if(s instanceof Circle){
			System.out.println("���ͼ����Բ��");
		}
		System.out.println("ͼ�������"+s.area());
	}
}
