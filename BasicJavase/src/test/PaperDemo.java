package test;

import java.util.Scanner;

public class PaperDemo {
	public static void main(String[] args) {
		//��������paper������paper��Question�ļ���
		Question[] paper = new Question[2];
		paper[0]=new SingleQuestion(1001,"�߽����������������˭��",new String[]{"A.���","B.����","C.����","D.�����"},"A");
		paper[1]=new MultiChoiceQuestion(1002,"Ѱ�ҿƼ���������",new String[]{"A.���","B.����","C.����","D.�����"},new String[]{"A","B"});
		Scanner s = new Scanner(System.in);
		for(int i=0;i<paper.length;i++){
			Question q = paper[i];
			q.print();
			System.out.print("��ѡ��");
			String[] ans = s.nextLine().split(",");
			if(q.check(ans)){
				System.out.println("�а�");
			}else{
				System.out.println("����Ŭ��ѽ��");
			}
		}
		
	}
}
