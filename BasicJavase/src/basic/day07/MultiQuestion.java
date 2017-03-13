package basic.day07;

import java.util.Arrays;

/**��ѡҲ��ѡ���⣬Ҳ�̳���ѡ����*/
public class MultiQuestion extends Question {
	char[] answers;//�û�����������ѡ��
	//���췽������Ϊ���Խ��г�ʼ����
	public MultiQuestion(String title,String[] options,char[] answers){
		this.title=title;
		this.options=options;
		this.answers=answers;
	}
	/**���Ǽ�鷽��*/
	public boolean check(char[] answers){
		if(answers==null){
			return false;
		}
		return Arrays.equals(this.answers,answers);
	}
}
