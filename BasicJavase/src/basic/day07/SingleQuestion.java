package basic.day07;

/**
 * ��ѡ�⣬��ѡ����չ��ѡ���⣬
*/

public class SingleQuestion extends Question {
	char answer;//��ѡ�ı�׼��
	public SingleQuestion(String title,String[] options,char answer){
		this.title = title;//this.title�̳��ڸ�����Question
		this.options=options;
		this.answer=answer;//������������������
	}
	/**���ǣ���д�������ķ������޸ģ�ʵ�֣�����ļ���߼�
	 *����ķ���ǩ���븸���еķ����еķ���ǩ��һ���� 
	 */
	public boolean check(char[] answers){
		if(answers==null||answers.length!=1){
			return false;
		}
		return this.answer==answers[0];
	}
}
