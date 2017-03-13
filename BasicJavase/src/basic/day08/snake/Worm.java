package basic.day08.snake;

import java.util.LinkedList;

/**
���ɣ������ֵ�ֱ�Ϊ UP=-10��DOWN=10��LEFT=-1��RIGHT=1
	����ֵ�෴������ֵ�෴
	�ƶ����������ֵΪ��i+dir/10 �� j+dir%10��
*/
public class Worm {
//	������һ���ڵ㣨Node���ļ���
	private LinkedList<Node> nodes = new LinkedList<Node>();
	private int dir;//��ǰĬ�ϵ����߷���
	public static final int UP = -10;
	public static final int DOWN = 10;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	
	//Ĭ�ϵ���
	public Worm(){
		nodes.add(new Node(3,9));
		nodes.add(new Node(4,9));
		nodes.add(new Node(5,9));
		nodes.add(new Node(5,10));
		nodes.add(new Node(6,11));
		nodes.add(new Node(7,11));
		dir = RIGHT;//Ĭ��������
	}
	//ָ������
	public Worm(LinkedList<Node> nodes){
		this.nodes.clear();
		this.nodes.addAll(nodes);
	}
	//��һ��
	public void step(){
		//1���ҵ�ͷ�ڵ�
		Node head = nodes.getFirst();//�൱��:get(0)
		//2.���ݵ�ǰ��������½ڵ�
		int i = head.getI()+dir/10;
		int j = head.getJ()+dir%10;
		head = new Node(i,j);
		//3����ڵ㵽ͷ��
		nodes.addFirst(head);//�൱�ڣ�add(0,head)
		//4.ɾ��ĩβ�ڵ�
		nodes.removeLast();//�൱��remove(nodes.size()-1)
	}
	//����������һ��
	public void step(int dir){
		if(this.dir+dir==0){
			throw new RuntimeException("���ܵ�ͷ��ʻ��");
		}
		this.dir = dir;
		step();
	}
	public boolean contain(int i,int j){
		return nodes.contains(new Node(i,j));
	}
	@Override
	public String toString(){
		return nodes.toString();
	}
	
}
