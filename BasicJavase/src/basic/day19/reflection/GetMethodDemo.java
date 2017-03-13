package basic.day19.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *	�������Ϸ���ȡ��һ�����е�ȫ���������� 
 */
public class GetMethodDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try{
			c1 = Class.forName("basic.day19.reflection.Person");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Method m[] = c1.getMethods();//ȡ��ȫ���ķ���
		for(int i=0;i<m.length;i++){
			Class<?> r = m[i].getReturnType();//�õ������ķ���ֵ����
			Class<?> p[] = m[i].getParameterTypes();//�õ�ȫ���Ĳ�������
			int xx = m[i].getModifiers();//�õ����������η�
			System.out.print(Modifier.toString(xx)+" ");//��ԭ���η�
			System.out.print(r.getName()+" ");//�õ���������
			System.out.print(m[i].getName());//ȡ�÷�������
			System.out.print("(");
			for(int x=0;x<p.length;x++){
				System.out.print(p[x].getName()+""+"arg"+x);
				if(x<p.length-1){//�ж��Ƿ����","
					System.out.print(",");
				}
				Class<?> ex[] = m[i].getExceptionTypes();//�õ�ȫ�����쳣�׳�
				if(ex.length>0){//�ж��Ƿ����쳣
					System.out.print(") throws ");
				}else{
					System.out.print(") ");
				}
				for(int j=0;j<ex.length;j++){
					System.out.print(ex[j].getName());//����쳣��Ϣ
					if(j<ex.length-1){//�ж��Ƿ����","
						System.out.print(",");//���","
					}
				}
				System.out.println();//����
			}
			
		}
	}
}
