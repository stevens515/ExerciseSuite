package basic.day19.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

//ȡ����������
public class GetFieldDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try {
			c1 = Class.forName("basic.day19.reflection.Person3");// ʵ����Class����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		{
			Field f[] = c1.getDeclaredFields();// �õ���������
			for (int i = 0; i < f.length; i++) {
				Class<?> r = f[i].getType();// �õ����Ե�����
				int mod = f[i].getModifiers();// �õ����η�����
				String priv = Modifier.toString(mod);// ȡ�����Ե����η�
				System.out.print("��������");
				System.out.print(priv + " ");// ������η�
				System.out.print(r.getName() + " ");// �����������
				System.out.print(f[i].getName());// �����������
				System.out.println(";");// ����
			}
		}
		System.out.println("------------------------------------------------");
		{
			Field f[] = c1.getFields();// �õ����๫������
			for (int i = 0; i < f.length; i++) {
				Class<?> r = f[i].getType();// �õ���������
				int mod = f[i].getModifiers();// ȡ�����η�����
				String priv = Modifier.toString(mod);// ȡ���������η�
				System.out.print("�������ԣ�");
				System.out.print(priv + " ");// ������η�
				System.out.print(r.getName() + " ");// �����������
				System.out.print(f[i].getName());// �����������
				System.out.println(";");// ����
			}
		}
	}
}
