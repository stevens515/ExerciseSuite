package basic.day19.reflection;
/**�õ�����
 *ȡ�ø��ࣺ
	һ�������ʵ�ֶ���ӿڣ�����ֻ�ܼ̳�һ�����࣬�������Ҫȡ��һ����ĸ��࣬����ֱ��ʹ��Class���е�getSuperclass()������
	�˷����������£�	public Class<? super T>getSuperclass()
	getSuperclass()���ص���Classʵ������֮ǰ�õ�һ���ӿ�һ��������ͨ��getName()����ȡ������  
 */
public class GetSuperClassDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;//����Class����
		try{
			c1 = Class.forName("basic.day19.reflection.Person");//ʵ����Class����
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Class<?> c2 = c1.getSuperclass();//ȡ�ø���
		System.out.println("�������ƣ�"+c2.getName());
	}
}
