package basic.day14;

import java.util.Arrays;
import java.util.Comparator;
/**
 	�����ڲ����Ӧ��
 */
public class CardSortDemo {
public static void main(String[] args) {
	Card[] cards = {new Card(Card.SPADE,Card.ACE),
			new Card(Card.SPADE,Card.DEUCE),
			new Card(Card.SPADE,Card.JACK)};

	//��˾�������򣬷���1
	Arrays.sort(cards,new Comparator<Card>(){
		public int compare(Card o1,Card o2){
			return o1.getRank()-o2.getRank();
		}
	});
	
	//������,�����ڲ��࣬����2
//	Comparator<Card> byRank = new Comparator<Card>(){
//		public int compare(Card c1,Card c2){
//			return c1.getRank()-c2.getRank();
//		}
//	};
//	Arrays.sort(cards,byRank);
	System.out.println(Arrays.toString(cards));//[����J, ����A, ����2]
	}
}
