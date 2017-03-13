package basic.day12;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {
public static void main(String[] args) {
	Set<String> eggs = new HashSet<String>();
	eggs.add("����");
	eggs.add("Ѽ��");
	eggs.add("Ƥ��");
	eggs.add("�쵰");
	eggs.add("����");
	int n = 0;
	Iterator<String> ite = eggs.iterator();//��set���Ͻ��е���
	while(ite.hasNext()){
		String egg = ite.next();
		System.out.println(egg);
		n++;
		if(egg.equals("����")){
			ite.remove();
			n--;
		}
	}
	System.out.println(n);
	System.out.println(eggs);
}
}
