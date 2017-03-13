package basic.day13;

import java.util.ArrayList;

/**
 	���Ա�List ��ʾ���Ⱥ����Ķ��󼯺ϣ����磺�����б�
		1)   ArrayList = Object[] + ���Ա����(��ɾ�Ĳ�)
		2)   StringBuilder = char[] + ����(��ɾ�Ĳ�)
	�� ArrayList �� StringBuilder �Աȣ��������£�
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		StringBuilder sbl = new StringBuilder();
		sbl.append("��");
		sbl.append("��");
		sbl.insert(0, "��");
		sbl.insert(1, "��");
		System.out.println(sbl);
		System.out.println(sbl.charAt(2));//�����ڼ���λ����ʲô 
		
		ArrayList al = new ArrayList();
		al.add("��");
		al.add("��");
		al.add(0, "��");
		al.add(1, "��");
		al.set(2, "��");
		al.set(3, "��");
		System.out.println(al);
		System.out.println(al.indexOf("��"));//���ĸ�λ����
		System.out.println(al.get(2));//�õ����λ���ϵ��ַ�
		
//ArrayList��StringBuilder��ȣ�����������ͬ������ ArrayList ���˿������ String�����������������������ͼ��ʾ
		ArrayList cards = new ArrayList();
		cards.add(0, new Card(Card.SPADE,Card.KING));
		cards.add(0, new Card(Card.DIAMOND,Card.THREE));
		cards.add(0, new Card(Card.SPADE,Card.FOUR));
		cards.add(0, new Card(Card.DIAMOND,Card.KING));
		System.out.println(cards);
		
		//ArrayList �� contains()����Ĭ�ϵ��ö���Card���� equals()�������Ƚϣ�����ͼ��ʾ��
		//  ��� Card.java آ���� equals()����������Ϊ false
		Card ace = new Card(Card.DIAMOND,Card.THREE);
		System.out.println(cards.contains(ace));//true
		System.out.println(cards);

	}
}
