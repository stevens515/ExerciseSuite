package basic.day18.mldn.generics;

import java.util.ArrayList;
//ɾ��list�����еġ�java���Ĵ���
public class testArrayListDemo05 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("java");
		list.add("aaa");
		list.add("java");
		list.add("java");
		list.add("bbb");
		
		//A������
//		for(int i=list.size()-1;i>=0;i--){
//			if("java".equals(list.get(i))){
//				list.remove(i);
//			}
//			System.out.println(list);
//		}
		
		//B�����������ɾ��һ��"java"
//		for (int i = 0; i < list.size(); i++) {
//			if("java".equals(list.get(i))){
//				list.remove(i);
//			}
//			System.out.println(list);
//		}
		
		//C->���� 
//		list.removeAll(Collection c);�����ֻ�ܷż��ϣ����ܷ�Ԫ��
//		list.removeAll("java");//�������	
		
		//D����ֻ��ɾ��һ��
//		list.remove("java");
//		System.out.println(list);//ֻ��ɾ��һ��
	}
}	
