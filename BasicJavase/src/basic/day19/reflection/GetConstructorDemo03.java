package basic.day19.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**ȡ��ȫ�����췽��3 ʹ��MOdifier��ԭ���η�
 * ��2�п���֪��ȡ��Ȩ��ʱȴ���ַ��ص���һ�����ֶ�����public��������Ϊ������java�ж��ڷ��������η���ʹ��
 * һ�������ֱ�ʾ�����ģ������Ҫ��������ֻ�ԭ���û����Կ����Ĺؼ��֣����������Modifier����ɣ����ඨ��
 * ��java.lang.refect���С�ֱ��ʹ��Modifier������·������ɻ�ԭ���η���
 * 	public static String toString(int mod)
 */
public class GetConstructorDemo03 {
	public static void main(String[] args) {
		Class<?> c1 = null;//����Class����
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");//ʵ����Class����
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Constructor<?> con[] = c1.getConstructors();//�õ�ȫ������
		for(int i=0;i<con.length;i++){//ѭ�����
			Class<?> p[] = con[i].getParameterTypes();//�г������еĲ�������
			System.out.println("���췽����");
			int mod = con[i].getModifiers();//ȡ��Ȩ��
			System.out.print(Modifier.toString(mod)+" ");//��ԭȨ��
			System.out.print(con[i].getName());//������� ��������
			
			System.out.print("(");
			for(int j=0;j<p.length;j++){
				System.out.print(p[j].getName()+" arg"+i);//��ӡ����
				
				if(j<p.length-1){//�ж��Ƿ�Ҫ���","
					System.out.print(",");
				}
			}
			System.out.println("){}");//���"){}"
		}
	}
}
