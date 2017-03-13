package basic.day19.reflection;

import java.lang.reflect.Array;

/**����߼�
 * ����ͨ��Array��������е����������������µ���������������
 * ʹ��Array���һ�������޸����������С�Ĺ���
 */
public class ChangeArrayDemo {
	public static void main(String[] args) {
		int temp[] = {1,2,3};
		int newTemp[] = (int[])arrayInc(temp,5);//�������鳤��
		print(newTemp);//��ӡ������Ϣ
		System.out.println("\n----------------------------");
		String t[] = {"lxh","mldn","mldnjava"};//����һ���ַ�������
		String nt[] = (String[])arrayInc(t,8);//�������鳤��
		print(nt);//��ӡ������Ϣ
	}
	/**java.lang.reflect.Array
	 	newInstance(Class<?> componentType, int length)throws NegativeArraySizeException
    		Creates a new array with the specified component type and length. 
    		Invoking this method is equivalent to creating an array as follows:
         		int[] x = {length};
         		Array.newInstance(componentType, x);
    	Parameters:
        	componentType - the Class object representing the component type of the new array
        	length - the length of the new array 
    	Returns:
        	the new array 
	 */
	public static Object arrayInc(Object obj,int len){//�޸������С
		Class<?> c = obj.getClass();//ͨ������õ�Class
		Class<?> arr = c.getComponentType();//�õ������Class����
		Object newO = Array.newInstance(arr,len);//���¿����µ������С
		int co = Array.getLength(obj);//ȡ�����鳤��
		System.arraycopy(obj,0,newO,0,co);//������������
		return newO;
	}
	public static void print(Object obj){//�������
		Class<?> c = obj.getClass();//ͨ������õ�Class����
		if(!c.isArray()){//�ж��Ƿ�������
			return;
		}
		Class<?> arr = c.getComponentType();//ȡ�������Class
		System.out.println(arr.getName()+"����ĳ����ǣ�"+Array.getLength(obj));//���������Ϣ
		for(int i=0;i<Array.getLength(obj);i++){//ѭ�����
			System.out.print(Array.get(obj, i)+",");//ͨ��Array���
		}
	}
}
