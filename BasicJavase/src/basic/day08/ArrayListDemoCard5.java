package basic.day08;
import java.util.ArrayList;

import basic.day08.Swat.Card;
public class ArrayListDemoCard5 {
	public static void main(String[] args) {
		ArrayList cards = new ArrayList();//�䳤����
		cards.add(new Card(Card.SPADE,Card.TEN));
		cards.add(new Card(Card.SPADE,Card.JACK));
		cards.add(new Card(Card.SPADE,Card.QUEEN));
		cards.add(new Card(Card.SPADE,Card.KING));
		cards.add(new Card(Card.SPADE,Card.ACE));
		System.out.println(cards);//[����10, ����J, ����Q, ����K, ����A]
		
		ArrayList others  = new ArrayList();
		others.add(new Card(Card.CLUB,Card.DEUCE));
		others.add(new Card(Card.CLUB,Card.ACE));
		System.out.println(others);//[÷��2, ÷��A]
		
		//1.��cards��others�ϲ����ͣ�
		cards.addAll(others);
		System.out.println(cards);//[����10, ����J, ����Q, ����K, ����A, ÷��2, ÷��A]
		//2.��cards�а���others��Ԫ��ɾ�����
//		cards.removeAll(others);
		System.out.println(cards);//[����10, ����J, ����Q, ����K, ����A, ÷��2, ÷��A]
		//3.��cards�а���others��Ԫ�ر�����������
		cards.retainAll(others);
		System.out.println(cards);//[]
		//4 .�ж�cards�Ƿ�Ϊ�ռ����գ�
		System.out.println(cards.isEmpty());//true
		//5. "�ռ����͡��գ�null)����������
		cards = null;
		System.out.println(cards);//null 
	}	
}
