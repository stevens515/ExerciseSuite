package basic.day19.reflection;

import java.lang.reflect.Array;

/**����߼�
 *ȡ��������Ϣ���޸���������
 *��ͨ��Array���е�set()�����޸��������е�Ԫ������
 */
public class ClassArrayDemo {
	public static void main(String[] args) {
		int temp[] ={1,2,3};//����һ����������
		Class<?> c = temp.getClass().getComponentType();//ȡ�������Class����
		System.out.println("���ͣ�"+c.getName());//�õ�������������
		System.out.println("���ȣ�"+Array.getLength(temp));//�õ����鳤��
		System.out.println("��һ�����ݣ�"+Array.get(temp, 0));//�õ���һ������
		
		Array.set(temp, 0, 6);//�޸ĵ�һ������
		System.out.println("��һ�����ݣ�"+Array.get(temp,0));//�õ���һ������
	}
}
