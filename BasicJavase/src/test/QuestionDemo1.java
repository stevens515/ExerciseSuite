package test;

public class QuestionDemo1 {

	public static void main(String[] args) {
		SingleQuestion q1 = new SingleQuestion(1001,"���߳������������������˭��",
						new String[]{"A.���","B.����","C.����","D.�����"},"B");
		//����̳��˸�������
		System.out.println(q1.id);
		System.out.println(q1.text);
		//�����Լ�������
		System.out.println(q1.answer);
		//�Ӹ����ͼ̳з���print()
		q1.print();
		//��д����check()����
		System.out.println(q1.check(new String[]{"B"}));
	}

}
