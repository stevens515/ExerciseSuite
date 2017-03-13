package basic.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CollectionsDemo {
public static void main(String[] args) {
	List<String> names = new ArrayList<String>();
	names.add("Tom");
	names.add("Andy");
	names.add("Nimo");
	names.add("Jerry");
	names.add("John");
	names.add("Jack");
	System.out.println(names);//[Tom, Andy, Nimo, Jerry, John, Jack]
	Collections.shuffle(names);
	System.out.println("����:"+names);//����:[John, Jerry, Tom, Andy, Jack, Nimo]
	Collections.sort(names);
	System.out.println("����"+names);//����[Andy, Jack, Jerry, John, Nimo, Tom]
	int index = Collections.binarySearch(names, "Tom");
	System.out.println("���ֲ��ң�"+index);//���ֲ��ң�5
	System.out.println(names);//[Andy, Jack, Jerry, John, Nimo, Tom]
	Collections.fill(names, "����");
	System.out.println("��䣺"+names);//��䣺[����, ����, ����, ����, ����, ����]
	

	/**����
		Collection  VS  Collections
		һ���ӿڣ�һ����
		Collection �Ǽ��Ͽ�ܵĸ��ӿ�֮һ������������ϸ���ĳ���
		�������ļ��Ϲ��ܣ�������List��Set���̳���Collection
		Collections �Ǽ��ϵĹ����࣬�ṩ�˼��ϵĹ��߷�����
		���������򣬴��ң����ֲ��ң�����
	 */
}
}
