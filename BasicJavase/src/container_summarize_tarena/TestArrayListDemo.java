package container_summarize_tarena;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**ע��
 	���Ҫ��ʹ�ù����ࣺCollections.sort(List)����List�������������Ҫ������
 	������ŵ�����ʵ��java.lang.Comparable�ӿ�
 */
public class TestArrayListDemo {
	public static void main(String[] args) {
		List list =new ArrayList();
		list.add("abc");
		list.add("hik");
		list.add(new Integer(4));
		list.add(new Double(3.45));
		//----
		print(list);
	}
	public static void print(List list){
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object o = it.next();
			System.out.println(o);//�����ᰴ�մ�ŵ��ڡ�˳�����
		}
	}
}
