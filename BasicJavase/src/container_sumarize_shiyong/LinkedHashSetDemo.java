package container_sumarize_shiyong;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
public static void main(String[] args) {
	HashSet hs = new HashSet();
	LinkedHashSet lhs = new LinkedHashSet();
	hs.add("һ");
	lhs.add("һ");
	hs.add("��");
	lhs.add("��");
	hs.add("��");
	lhs.add("��");
	System.out.println(hs);//����,[��, һ, ��]
	System.out.println(lhs);//���˳��,[һ, ��, ��]
}
}
