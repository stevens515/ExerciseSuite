package annotation;
//@Deprecated�ڷ�����������Ҳ���������н���������
public class  DeprecatedAnnotationDemo1{
	public static void main(String[] args) {
		Demo d = new Demo();//ʵ����Demo����
		System.out.println(d.getInfo());//����ʱ�������־�����Ϣ
	}
}
class Demo{
	@Deprecated				//����������ʹ�õĲ���
	public String getInfo(){//�˷����������û�ʹ��
		return "����һ��Person��";//������Ϣ
	}
}