package basic.day13;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		ArrayList als = new ArrayList();
		als.add(new Card(Card.DIAMOND,Card.THREE));
		als.add(new Card(Card.DIAMOND,Card.FOUR));
		als.add(new Card(Card.DIAMOND,Card.FIVE));
		als.add(new Card(Card.DIAMOND,Card.SIX));
		
		//1.ɾ��remove()������ʾ
//		Card ace = new Card(Card.DIAMOND,Card.SIX);
		//1.1ɾ������
//		als.remove(ace);
		//1.2�����ɾ�� 
//		als.remove(2);
		//ģ�����
		Random r = new Random();//�����ȡһ��
		Card c1 = (Card)als.remove(r.nextInt(als.size()));
		System.out.println(c1);//��ɾ����Ԫ��
		System.out.println(als);
		//3.�޸�set()������ʾ��
		//�޸�ArrayList�еĵ�0��Ԫ��Ϊ��������
		Card joker = new Card(Card.JOKER,Card.COLOR);
		Card first = (Card)als.set(0, joker);
		System.out.println(als);
		
	}
}
