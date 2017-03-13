package basic.day08.graph;


public class ShapeDemo {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(3,4,5);//Բ�����ù�Բ���Բ
		shapes[1] = new Rectangle(4,4,8,6);
		/**��̬���Ǽ̳��е�����
		 		1.�����͵�������ʵ���Ƕ��ֶ����ģ�
		 		2.����������Ϊ�����������Ŷ���Ͳ������ͷ����仯
		 			�磺ͼ���Ƕ�̬�ģ�����ͼ����������Ƕ�̬��
		 		3.�����Ķ�̬����ͨ���������ǺͶ�̬������֧�ֵ�
		 */
		Shape s = shapes[0];
		System.out.println(s.area());//Բ���
		s = shapes[1];
		System.out.println(s.area());//�������
		print(s);
		print(new Circle(8,8,6));
	}
	public static void print(Shape s){//��̬�Ĵ�ӡ����
		for(int y=0;y<40;y++){//�����У�����������y,x����,y����
			for(int x=0;x<40;x++){//�����У����Ǻ�����x
				if(s.contains(x,y)){//���������ͼ�η�Χ�ھ������0��
					System.out.print("0");//��Ҫ����س�
				}else{
					System.out.print("");//�հ�λ������ո񣡲��ǿմ�
				}
			}
			System.out.println();//һ�����һ���س�
		}
	}
}
