package basic.day08;
import java.util.ArrayList;

import basic.day08.Swat.Card;
public class ArrayListDemoCard {
public static void main(String[] args) {
	//2��ArrayList�����Card����
	ArrayList cards = new ArrayList();//�䳤����
	cards.add(new Card(Card.SPADE,Card.TEN));
	cards.add(new Card(Card.SPADE,Card.JACK));
	cards.add(new Card(Card.SPADE,Card.QUEEN));
	cards.add(new Card(Card.SPADE,Card.KING));
	cards.add(new Card(Card.SPADE,Card.ACE));
	
	System.out.println(cards);//ͬ��˳��Ĭ�ϵ���toString()
	
}
}
