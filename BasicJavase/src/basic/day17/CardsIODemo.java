package basic.day17;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import basic.day16.IOUtils;

/*
 * 8 ǳ�㸴������㸴��
 *	1) Java��Ĭ�ϸ��ƹ�����ǳ�㸴��, ���ܺ�, �����Բ�ǳ�㸴������, ֻ���Ƶ�һ�����
 *	2) �������л�ʵ����㸴��
 *DataInputStream:��������������Ӧ�ó�����������޹ط�ʽ�ӵײ��������ж�ȡ���� Java �������͡�
 *					Ӧ�ó������ʹ�����������д���Ժ���������������ȡ�����ݡ� 
 *DataOutputStream:�������������Ӧ�ó������ʵ���ʽ������ Java ��������д��������С�
 *					Ȼ��Ӧ�ó������ʹ�����������������ݶ��롣
 *		writeInt(int v) ��һ�� int ֵ�� 4-byte ֵ��ʽд�����������У���д����ֽڡ�
 */
public class CardsIODemo {
	public static void main(String[] args) throws IOException {
		List<Card> cards = new ArrayList<Card>();
		for (int rank = Card.THREE; rank <= Card.DEUCE; rank++) {
			cards.add(new Card(Card.DIAMOND, rank));
			cards.add(new Card(Card.CLUB, rank));
			cards.add(new Card(Card.SPADE, rank));
			cards.add(new Card(Card.HEART, rank));
		}
		cards.add(new Card(Card.JOKER, Card.BLACK));
		cards.add(new Card(Card.JOKER, Card.COLOR));
		Collections.shuffle(cards);
		String file = "cards.dat";
		OutputStream out = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(out);
		for (Card card : cards) {// card����cards�е�ÿһ���˿��ƶ���
			dos.writeInt(card.getSuit());
			dos.writeInt(card.getRank());
		}
		dos.close();
		IOUtils.print(file);
		// ���ļ�cards.dat ��ȡΪCard�ļ���others
		DataInputStream dis = new DataInputStream(new BufferedInputStream(// �������뻺����,�Զ�������
				new FileInputStream(file)));
		List<Card> others = new ArrayList<Card>();
		for (;;) {// while(true)
			try {
				int suit = dis.readInt();// �ȶ�ȡ��ɫ
				int rank = dis.readInt();// �ٶ�ȡ����, ˳����д��һ��
				others.add(new Card(suit, rank));
			} catch (EOFException e) {// ��readInt()���������ļ�ĩβʱ��
				System.out.println("��ȡ����!");
				break;// ���ļ�β���ͽ���whileѭ����
			}
		}
		System.out.println(others);
		System.out.println(others.equals(cards));// ������������һ��
		System.out.println("others��cards����㸴�Ƶĸ�����");
		System.out.println(others == cards);// false
		System.out.println(others.get(0) == cards.get(0));// false
		// System.out.println(others.get(0).equals(cards.get(0)));
		// ǳ�㸴��
		List<Card> cards2 = new ArrayList<Card>(cards);
		System.out.println("cards2��cardsǳ�㸴�Ƶĸ�����");
		System.out.println(cards2 == cards);// false
		System.out.println(cards2.get(0) == cards.get(0));// true
	}
}
