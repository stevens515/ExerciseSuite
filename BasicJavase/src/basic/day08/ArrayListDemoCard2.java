package basic.day08;

import java.util.ArrayList;

import basic.day08.Swat.Card;

/**
 	ArrayList ��contains()����Ĭ�ϵ��ö���Card����equals�����������Ƚ�
 * */
public class ArrayListDemoCard2 {
public static void main(String[] args) {
	ArrayList cards = new ArrayList();
	cards.add(new Card(Card.SPADE,Card.ACE));
	System.out.println(cards);//[����A]
	
	//3.��ʾArrayList��contain()����
	Card ace = new Card(Card.SPADE,Card.ACE);
	System.out.println(ace);//����A
	System.out.println(cards.contains(ace));//Ĭ�ϵ���equals()
}
}
