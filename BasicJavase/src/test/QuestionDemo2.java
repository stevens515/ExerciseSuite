package test;

public class QuestionDemo2 {
	public static void main(String[] args) {
		MultiChoiceQuestion q2 = new MultiChoiceQuestion(1002,"��Щ��Ӱ�㿴���Ĳ���",
				new String[]{"A. ��������","B.�¸ҵ���","c.<�����","D.<��ţ��Ĵ��죾"},new String[]{"A","B"});
		q2.print();
		System.out.println(q2.check(new String[]{"A","B"}));
	}
}
