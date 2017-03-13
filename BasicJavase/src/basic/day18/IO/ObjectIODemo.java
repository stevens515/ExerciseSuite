package basic.day18.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ObjectIODemo {
	public static void main(String[] args) throws Exception {
		String file = "obj.dat";
		// ��������
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)));
		Object obj = new Foo();// obj = cards
		// out.writeObject(obj);// ��������л����ļ�����

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Card.SPADE, Card.ACE));
		out.writeObject(obj);// ��������л����ļ�����
		out.writeObject(cards);

		out.close();
		IOUtils.print(file);
		// �������
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(file)));
		Foo f = (Foo) in.readObject();
		List<Card> others = (List<Card>) in.readObject();
		in.close();
		System.out.println(f.i + "," + f.name);// 5,tom
		System.out.println(others);
		/*���ƣ���㣯ǳ�㣩
		 * 8 ǳ�㸴������㸴��
		 *  1) Java��Ĭ�ϸ��ƹ�����ǳ�㸴��, ���ܺ�, �����Բ� ǳ�㸴������, ֻ���Ƶ�һ����� 
		 *  2)�������л�ʵ����㸴��
		 */
		System.out.println("˼��������㸴�ƣ�");
		System.out.println("obj==f:" + (obj == f));// false
		System.out.println("obj.name==f.name:" + ((Foo) obj).name == f.name);// false
		System.out.println("cards==others:" + (cards == others));// false
		System.out.println("cards.get(0)==others.get(0):"
				+ (cards.get(0) == others.get(0)));// false
		System.out.println("ǳ�㸴��");
		List<Card> list = new ArrayList(cards);
		System.out.println("list==cards:" + (list == cards));
		System.out.println("list.get(0)==cards.get(0):"
				+ (list.get(0) == cards.get(0)));// true

	}
}

class Foo implements Serializable {
	int i = 5;

	String name = "tom";
}