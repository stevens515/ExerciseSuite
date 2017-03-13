package basic.day14;

/**�˿���*/
public class Card {

	public static final int DIAMOND = 0;//diamond����
	public static final int CLUB = 1;//club÷��
	public static final int HEART = 2;//heart,����
	public static final int SPADE =3;//spade����
	public static final int JOKER = 4;//��
	
	private int suit;//��ɫ��0���� ���飬1����÷��
	private int rank;//������0����3 1����4
	
	public final static int THREE = 0;//three
	public final static int FOUR = 1;
	public final static int FIVE = 2;
	public final static int SIX = 3;
	public final static int SEVEN = 4;
	public final static int EIGHT = 5;
	public final static int NINE = 6;
	public final static int TEN = 7;
	public final static int JACK = 8;//J,jack
	public final static int QUEEN = 9;//Q,queen
	public final static int KING = 10;//K��king
	public final static int ACE = 11;//A��ace�㣬����
	public final static int DEUCE = 12;//2,deuce����
	public final static int BLACK = 13;//black,С��
	public final static int COLOR = 14;//color,����
	
	public Card(){
	}
	public Card(int suit,int rank){
		this.suit = suit;
		this.rank = rank;
	}

	public static int getDIAMOND() {
		return DIAMOND;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	private final static String[] 
	     SUIT_NAMES = {"����","÷��","����","����",""};
	private final static String[]
	     RANK_NAMES = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","С��","����"};
	
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(this==obj)
			return false;
		if(obj instanceof Card){
			Card other = (Card)obj;
			return this.rank==other.rank && this.suit ==other.suit;
		}
		return false;
	}
	public int hashCode(){
		//suit = 2  00000000 00000000 00000000 00000010
		//rank = 3	00000000 00000000 00000000 00000011
//		return (this.suit<<16)+this.rank;//ͬ�£�����λ�ķ���Ҳ����,�������ƶ�������ƴ��
		return this.suit*100 + this.rank;//��100����Ϊ�˲���ֵ��ȣ�ʮ�����ƶ�������ƴ��
	}
	
	public String toString(){
		/*
		 	����ɫsuit�͵���rank��Ϊ����
		 	SUIT_NAMES��RANK��NAMES���±�
		 	���ʱΪ��Ӧ���˿��ƣ��磺÷��A
		 */
		return SUIT_NAMES[suit]+RANK_NAMES[rank];
	}
}
