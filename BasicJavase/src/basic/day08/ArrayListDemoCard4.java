package basic.day08;
import java.util.LinkedList;

import basic.day08.Swat.Card;
/**
 	LinkedList��ArrayListʹ�÷�����ͬ���ײ�ʵ�ֲ���ͬ
 */
public class ArrayListDemoCard4 {
	public static void main(String[] args) {
		LinkedList cards = new LinkedList();
		//1.����Ԫ��
		cards.add(new Card(Card.SPADE,Card.TEN));
		cards.add(new Card(Card.SPADE,Card.JACK));
		cards.add(new Card(Card.SPADE,Card.QUEEN));
		System.out.println(cards);//[����10, ����J, ����Q]
		//2.ɾ��Ԫ��
		cards.remove(0);
		cards.remove(new Card(Card.SPADE,Card.QUEEN));
		System.out.println(cards);//[����J]
		//3.�޸�Ԫ��
		Card joker = new Card(Card.JOKER,Card.COLOR);
		cards.set(0, joker);
		System.out.println(cards);//[����]]
		//4. ��ѯԪ��
		System.out.println(cards.indexOf(joker));//-1

	}
}
