package basic.day18.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 		StringBuilder�̲߳���ȫ���ǲ�ͬ����
		StringBuffer �̰߳�ȫ����ͬ����
		ArrayList�̲߳���ȫ
		Vector�̰߳�ȫ
		Vector��Hashtable��ͬ����
		ArrayList��HashMap����ͬ����
 */
public class JavaAPISyncDemo {
	public static void main(String[] args) {
		StringBuilder s;
		StringBuffer ss;
		
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		
		list = Collections.synchronizedList(list);
	}
}
class Tester{
//	StringBuffer str = new StringBuffer();
	public void test(){
		StringBuilder s = new StringBuilder();
	}
}