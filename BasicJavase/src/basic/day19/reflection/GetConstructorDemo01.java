package basic.day19.reflection;

import java.lang.reflect.Constructor;
/**ȡ��ȫ�����췽��1
 *Class���getConstructors()
 */
public class GetConstructorDemo01 {
	public static void main(String[] args) {
		Class<?> c1 = null;//����Class����
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");//ʵ����Class����
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Constructor<?> con[] = c1.getConstructors();//�õ�ȫ�����췽��
		for(int i=0;i<con.length;i++){//ѭ�����
			System.out.println("���췽����"+con[i]);//ֱ�Ӵ�ӡ���
		}
	}
}
