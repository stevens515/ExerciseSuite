package basic.day19.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

/**����API ���� 
 * 1.����API��Java���Ժ��Ĺ���API����java�ĵײ㹤������
 * 	 ��Object���Ͼʹ���֧�ַ���API�ķ���(getClass())
 * 	����API�Ĺ���
 * 		A.���ֶ��������
 * 		B.�������͵����ԣ���������������
 * 		C.���ʶ�������ԣ����ö���ķ������������͵�ʵ����
 */
public class RefDemo {
	public static void main(String[] args) {
//		discovery(1);
//		discovery("1");
		Scanner s = new Scanner(System.in);
		System.out.print("��������");
		String name =s.nextLine();
		Object obj = create(name);
		discovery(obj);
		
		Class c  = int.class;
		System.out.println(c.getName());//int
		//һ�нԶ���
		//�κ�����(��������)����Class��ʵ��
		//int.class,double.class,String.class,Integer.class.........�������͵�ʵ��
		//Card.class
		//Class ��ʵ����3�ֻ�÷�����
		//A String.class  ������Class
		//B "abc".getClass()
		//C  Class.forName("java.lang.String")
		//3�ַ�ʽ��õĶ���ͬһ������
		//String.class=="abc".getClass();//����true
		obj = create("basic.day19.reflection.RefDemo.Foo",
				new Class[]{int.class,String.class},new Object[]{5,"��"});
		discovery(obj);
		System.out.println(get(obj,"n"));
		System.out.println(call(obj,"add",new Class[]{int.class,int.class,String.class},new Object[]{5,5,"55"}));
		
	}
	/**
	 * ����ĳ���͵�ʵ�������ù�������
	 * @param className ����
	 * @return paramTypes ���������б�
	 * 		�磺new Class[]{int.class,String.class}��ʾ��int,String
	 * @param params �����б�
	 * 		�磺new Object[]{5,"50"}��ʾ��5����50��
	 */
	public static Object create(String className,Class[] paramTypes,Object[] params){
		try{
		//�ҵ�����
			Class cls = Class.forName(className);
		//�ҵ�������
			Constructor c = cls.getDeclaredConstructor(paramTypes);
		//���ù�����������ʵ��
			Object obj = c.newInstance(params);
		return obj;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��������
	 * ��һ�֣������ʹ��Ĭ�Ϲ���������ʵ��
	 * @param className ����
	 * @return �����̻Ҹ��޲�������������������ʵ��
	 */
	public static Object create(String className){
		try{
		//����API������ڶ��Ǵ�Classʵ����ʼ
		//class.forName()�Ǿ�̬������ȥ�����ڴ��Ƿ���className
		//��Ӧ�����ʵ�������û�оͼ�������࣬��CLASSPATH�ϼ���
		//���CLASSPATH��û���ҵ���Ķ����׳���ClassNotFounException
		Class cls = Class.forName(className);
		//newInstance()�����cls���޲����������������ʵ��
		Object obj = cls.newInstance();
		return obj;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		return className;
	}
	
	/**
	 * ����ĳ���͵�ʵ��(���ù�����)
	 */

	/**
	 * ����ĳ���������
	 * @param objĳ����
	 * @param filedNameĳ������
	 * @return ���Ե�ֵ
	 */
	public static Object get(Object obj,String fileldName){
		try {
			Class cls = obj.getClass();
			Field field = cls.getDeclaredField(fileldName);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}
	
	/**
	 * ����ĳ����ķ���
	 * @param obj �����÷����Ķ���
	 * @param method ������
	 * @param   paramTypes �������������б�
	 * @param params ���������б�
	 * @return ��������ֵ
	 */
	public static Object call(Object obj,String method,Class[] paramTypes,Object[] params){
		try {
			Class cls  = obj.getClass();
			Method m = cls.getDeclaredMethod(method, paramTypes);
			//invoke:����
			Object value = m.invoke(obj, params);//obj->this
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
		A.���ֶ��������
 * 		B.�������͵����ԣ���������������
	 */
	public 	static void discovery(Object obj){
		System.out.println("����:"+obj);
		//"�±�ģ��"���±�������
		//�±����ͱ��� Ҳ�Ƕ��� �����͵�ʵ��
		//�±�ģ�ӱ���Ҳ����ģ�ӵ�ʵ����ģ���൱������е���,class
		//obj.getClass()�������Ի�ȡ��ǰ���������
		//���������Object�϶��壬��java�ĺ��ķ���֮һ
		//����ֵ��class���͵�ʵ����class���������
		System.out.println("�������ͣ�");
		Class cls  = obj.getClass();
		//cls����Ӳ����.class�ļ�װ��(class load)���ڴ�Ľ��
		System.out.println(cls.getName());//������	
		//�����������ϣ����Ե�ֵ�ڶ�����
		//�����������ԣ�����ֵ�ڶ�����
		//�����Ա𣬾�����Ů������
		//���������cls�����������ԣ�Field:�ֶΣ����ԡ���Ϊ�ж�����ԣ�����Ҫ������
		System.out.println("�������ԣ�");
		Field[] fields = cls.getDeclaredFields();
		for(Field field:fields){
			System.out.println(
				field.getType()+" "+field.getName());//���Ե�����
		}
		//Method:������getDeclareMethods()�������Ϸ��������ķ���
		//Declared : ������ �����,��Ȼ��;
		System.out.println("���ַ�����");
		Method[] methods = cls.getDeclaredMethods();
		for(Method method:methods){
			System.out.println(method.getReturnType());
			System.out.println(method.getName());
//			System.out.println(method.getParameterTypes());//���ص������飬�ÿ���д�������
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
		System.out.println("���ֹ�������");
		//Constructor:������
		Constructor[] constructors = cls.getDeclaredConstructors();
		for(Constructor c :constructors){
			System.out.print(c.getName());
			System.out.println(Arrays.toString(c.getParameterTypes()));
		}
	}
}
class Foo{
	int a;
	String n;
	public Foo(){
	}
	public Foo(int a,String s){
		this.a = a;
		this.n = s;
	}
	public int add(int b,int c,String s){
		return b+c+s.charAt(0)-'0';
	}
}
