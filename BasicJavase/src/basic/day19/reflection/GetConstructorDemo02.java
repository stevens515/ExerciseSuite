package basic.day19.reflection;

import java.lang.reflect.Constructor;

/**ȡ��ȫ�����췽��2
 * ����1�еķ���������Ҳ�����Լ��ֹ�ƴ�ճ���Ϣ��
 * 
 * �˴�ʹ����Construtor�࣬��ʾ���췽�������÷������£�
	public int getMedifiers()	�õ����췽�������η�
	public String getName()	�õ����췽��������
	public Class<?>[]getParameterType()�õ����췽���в���������
	pubic String toString()  ���ش˹��췽������Ϣ
	public T newInstance(Object...initrgs)throws InstantiationException,
		IllegalAccessException,IllegalArgumentException,InvocationTargetException
		���췽���д��ݲ�����ʵ��������
 */
public class GetConstructorDemo02 {
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
			System.out.print(con[i].getModifiers()+" ");//ȡ��Ȩ��
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
