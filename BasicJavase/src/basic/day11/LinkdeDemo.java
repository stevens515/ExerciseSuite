package basic.day11;

public class LinkdeDemo {
public static void main(String[] args) {
	Node head = new Node("����");
	head.next = new Node("����");
	head.next.next= new Node("����֮��");
	head.next.next.next= new Node("ѧϰ�׷�ð���");
	System.out.println(head);
}
}
class Node{//�ڵ㣬��������Ľڵ�����
	Object data;
	Node next;
	public Node(Object obj){
		data = obj;
	}
	public String toString(){//��Ҫ����������������Է���
		return next == null ?data.toString() : data+","+next;
	}
}