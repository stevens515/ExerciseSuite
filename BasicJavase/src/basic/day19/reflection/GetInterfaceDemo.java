package basic.day19.reflection;
/**ȡ����ʵ�ֵ�ȫ���ӿ�
 *	Ҫȡ��һ������ʵ�ֵ�ȫ���ӿڣ������ʹ��Class���е�getInterfaces()����.�������£�
		public Class[] getInterface()
	getInterface()����һ��Class��Ķ������飬֮��ֱ������Class���е�getName()�����������
 */
public class GetInterfaceDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;//����Class����
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");//ʵ����Class����
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Class<?> c[] = c1.getInterfaces();//ȡ��ʵ�ֵ�ȫ���ӿ�
		for(int i=0;i<c.length;i++){
			System.out.println("ʵ�ֵĽӿ����ƣ�"+c[i].getName());//������ӿ�����
		}
	}
}
