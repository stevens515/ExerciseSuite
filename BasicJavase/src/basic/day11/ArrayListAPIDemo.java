package basic.day11;

import java.util.ArrayList;

public class ArrayListAPIDemo {
	public static void main(String[] args) {
		//�������Ա�ĳ��ȣ�size)�����Ա������1
		ArrayList cards = new ArrayList();
		//add�������Ա��������˳��׷��Ԫ��
		cards.add(new Card(Card.SPADE,Card.TEN));
		cards.add(new Card(Card.SPADE,Card.JACK));
		cards.add(new Card(Card.SPADE,Card.QUEEN));
		cards.add(new Card(Card.SPADE,Card.KING));
		cards.add(new Card(Card.SPADE,Card.ACE));
		cards.add(new Card(Card.SPADE,Card.DEUCE));
		
		System.out.println(cards.size());//6,����
		//add(index,element)��ָ��λ�ò���Ԫ��
		cards.add(0,new Card(Card.SPADE,Card.NINE));
		System.out.println(cards.toString());//��ҪCard�า��toString()����
		Card ace = new Card(Card.SPADE,Card.ACE);
		//contains()�ĵײ������ÿ�������equals����
		System.out.println(cards.contains(ace));//true
		
		ArrayList others = new ArrayList();
		others.add(new Card(Card.SPADE,Card.NINE));
		others.add(new Card(Card.SPADE,Card.TEN));
		others.add(new Card(Card.SPADE,Card.JACK));
		others.add(new Card(Card.SPADE,Card.QUEEN));
		others.add(new Card(Card.SPADE,Card.KING));

		System.out.println(cards.equals(others));//false
		System.out.println(cards.containsAll(others));//true
		others.add(new Card(Card.SPADE,Card.ACE));
		others.add(new Card(Card.SPADE,Card.DEUCE));
		
		System.out.println(cards.equals(others));//true
		
		//���Ա����ݵ���ɾ�Ĳ飬���Ա��ϵĲ���
		//		���ݵ���ɾ�Ĳ飺add()
		Card card = (Card)cards.remove(0);
		System.out.println("ɾ���ˣ�"+card);
		card = (Card)cards.set(0, new Card(Card.SPADE,Card.THREE));
		System.out.println("��������"+card);
		card = (Card)cards.get(0);
		System.out.println("0λ�����ǣ�"+card);
		System.out.println(cards);
		//���Ա�ļ��ϲ�����contains()�൱�ڼ��ϵġ����ڡ�����
			//containsAll()�൱�ڼ��ϵġ�����������
		
//		cards.add(others);
		cards.addAll(others);
//		cards.retainAll(others);//��cards�б���others �й��в���
//		cards.removeAll(others);//��cards��ɾ��others��������
		System.out.println(cards);
		
		int index = cards.indexOf(ace);
		
	}
}
