package annotation;
//@Deprecated�ڷ�����������Ҳ���������н���������
public class  DeprecatedAnnotationDemo2{
	public static void main(String[] args) {
		Demo2 d = new Demo2();//����ʱ�������־�����Ϣ
		System.out.println(d.getInfo());
	}
}
@Deprecated	
class Demo2{
				//����������ʹ�õĲ���
	public String getInfo(){//�˷����������û�ʹ��
		return "����һ��Person��";//������Ϣ
	}
}