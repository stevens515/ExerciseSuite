package basic.day06;

public class BookDemo {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = book1;
		book1.name = "�¼����ǵ���";
		System.out.println(book1.name);
		book1 = new Book();
		//book1��ֵ��һ����ֵַ����Book������׵�ַ��
		//book1ͨ����ֵַ������Bookʵ��������
		//��ȷ�е�˵����book1��ֵ��Book����ͨ����ˣ�
		//����ֵ����ַ���Ĺ�����͸���ģ����ɼ��ģ���û�а취�����
		//���Լ�ӵĸ��ܵ������磽���Ƚϵľ��Ǳ�����ֵ
		System.out.println(book1==book2);//�Ƚϵľ��Ǳ�����ֵ����ֵַ��
		book1.name="��Щ�꣬����һ��׷����Ů��";
		System.out.println(book1.name);
		book1 = null;
		System.out.println(book1==null);//true
		System.out.println(book1.name);

	}

}
