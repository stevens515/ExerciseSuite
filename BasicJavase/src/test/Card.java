package test;

public class Card {
	public static int CLUB = 0;//club÷��
	public static int DIAMOND = 1;//diamond����
	public static int HEART = 2;//heart,����
	public static int SPADE =3;//spade����
	public static final int JOKER = 4;// ��
	
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
		setRank(rank);
		setSuit(suit);
	}
	public int getRank(){
		return rank;
	}
	public void setRank(int rank){
		if(rank<THREE||rank>COLOR){
			throw new RuntimeException("����");
		}
		this.rank=rank;
	}
	public int getSuit(){
		return suit;
	}
	public void setSuit(int suit){
		if(suit<CLUB ||suit>JOKER){
			throw new RuntimeException("����");
		}
		this.suit=suit;
	}
}
