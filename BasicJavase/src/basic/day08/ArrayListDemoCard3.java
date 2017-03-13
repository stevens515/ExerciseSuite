package basic.day08;

import java.util.ArrayList;
import java.util.Random;

import basic.day08.Swat.Card;
/**
 	��ʾArrayList��ɾ�Ĳ�
 */
public class ArrayListDemoCard3 {
public static void main(String[] args) {
	ArrayList cards = new ArrayList();//�䳤����
	cards.add(new Card(Card.SPADE,Card.TEN));
	cards.add(new Card(Card.SPADE,Card.JACK));
	cards.add(new Card(Card.SPADE,Card.QUEEN));
	cards.add(new Card(Card.SPADE,Card.KING));
	cards.add(new Card(Card.SPADE,Card.ACE));
	System.out.println(cards);//[����10, ����J, ����Q, ����K, ����A]
	
	//1.	ɾ��remove()������ʾ
	Card ace  = new Card(Card.SPADE,Card.ACE);
	//1.1������ɾ��
	cards.remove(ace);
	System.out.println(cards);
	//1.2 �����ɾ��
	cards.remove(0);
	
	//2. ģ�⡰����
	Random r = new Random();//�����ȡһ��
	Card c1 = (Card)cards.remove(r.nextInt(cards.size()));
	System.out.println(cards);
	
	//3. �޸�set()������ʾ
	//�޸�ArrayList�еĵ�0��Ԫ��Ϊ��������
	Card joker = new Card(Card.JOKER,Card.COLOR);
	Card first = (Card)cards.set(0, joker);
	
	//4. ��ѯindexOf()������ʾ����ѯArrayList�е�Ԫ��
	int i = cards.indexOf(joker);//Ĭ�ϵ���equals()�Ƚ�
	System.out.println(cards);//
}
}
