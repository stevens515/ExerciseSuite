package basic.day13;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	private int id ;//��ұ��
	private String name;//�������
	private ArrayList<Card> cards = new ArrayList<Card>(18);//���е���
	public Player(int id,String name){
		this.id = id;
		this.name = name;
	}
	//����
	public void add(Card card){
		cards.add(card);
	}
	public String toString(){
		return name;
	}
}
