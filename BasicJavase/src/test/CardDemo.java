package test;

public class CardDemo {
	public static void main(String[] args) {
		//�����˿ˣ�����3
		Card card = new Card(Card.DIAMOND,Card.THREE);
		//����A
		Card c = new Card(3,11);
		//����A
		Card ace  = new Card(Card.SPADE,Card.ACE);
		ace.setRank(1000);//����������ף�����쳣
	}
}
