package basic.day07;

import java.util.Scanner;

public class QuestionDemo {

	/**
	 * �̳й�ϵ��ʹ�ã������
	 */
	public static void main(String[] args) {
		//paper ��ʾ�Ծ����Ծ�������ѡ����
		//�������飬Ԫ���Զ���ʼ��Ϊnull��Ԫ��������ΪQuestion
		//Ԫ�������ñ���,��ʾ�Ծ�������������Ŀ�(null)λ��
		Question[] paper = {null,null};//new Question[2];
		//��̬����ֻ�����ڣ�����ͬʱ��ʼ��ʱ������
		paper[0] = new SingleQuestion("java�ص���",new String[]
		          {"A�������","B���߳�","C ��C����һ��","D �ǿ���Ʒ��"},'B');
		paper[1] = new MultiQuestion("java�������Ͱ���",new String[]
		         {"A String","B int","C long","D Boolean"},new char[]{'B','C'});//AD�ǰ�װ�࣬����ĸ��д
		Scanner console = new Scanner(System.in);
		for(int i=0;i<paper.length;i++){
			Question question = paper[i];
			question.print();//print(question)
			System.out.println("��ѡ��");
			//console,nextLine()�ӿ���̨��ȡ��һ���ַ���
			String ans = console.nextLine();//'A','ABC'.
			char[] answers = ans.toCharArray();//"ABC"->��'A','B','C'��
			//�����Ƕ�̬�󶨵�������ķ����ϣ������ڼ䰴�����ͼ�飡���������а��������ķ���
			if(question.check(answers)){
				System.out.println("��ѽ��");
			}else{
				System.out.println("����Ŭ����");
			}
		}
	}
}
