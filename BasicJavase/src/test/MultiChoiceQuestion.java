package test;

import java.util.Arrays;

public class MultiChoiceQuestion extends Question{
	String[] answers={};//��ѡ��׼��
	public MultiChoiceQuestion(int id,String text,String[] options,String[] answers){
		this.id=id;
		this.text=text;
		this.options=options;
		this.answers=answers;
	}
	public boolean check(String[] answers){
		return Arrays.equals(this.answers, answers);
	}
}
