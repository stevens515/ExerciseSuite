package container_sumarize_shiyong;

import java.util.PriorityQueue;

public class TestPriorityQueueDemo {

	/**Queue�ӿ�
 	PriorityQueueʵ����
 */
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		//������qq�����ĸ�Ԫ��
		pq.offer(5);
		pq.offer(8);
		pq.offer(4);
		pq.offer(-8);
		System.out.println(pq);//�����ǰ�����˳�������������Ȼ����
		
	}

}
