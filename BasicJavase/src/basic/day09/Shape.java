package basic.day09;

/**
 	ͼ�β����壨����ģ���ͼ��һ�����Լ������
 	��μ������Ҳ�ǳ����
 	�������﷨��
 		1.��������Զ������
 		2.�����಻��ʵ��������������
 		3.������ֻ�ܱ��̳�
 		4.�����������ʵ�����г��󷽷�
 		5.�������ͱ����������þ���������ʵ��
 */
public abstract class Shape {
	
	protected Point location;
	
	public abstract double area();
	public abstract boolean contains(int x,int y);
	
	public boolean contains(Point p){
		return this.contains(p.x, p.y);
	}
	public Object getR() {//debug,�Զ�����
		return null;
	}
}
