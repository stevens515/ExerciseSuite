package com.tarena.elts.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * ������û��𰸵�ֵ����, ��ʾ�����ϵ�һ����Ͷ�Ӧ���û���
 * ��ֵ����
 * QuestionInfo �����û������ϵ�����, ������Ŀ,�û��𰸺��������
 */
public class QuestionInfo{
	//��Ŀ
	private Question question;
	//���Ծ��е����0��1��2
	private int questionIndex;
	//�û���
	private List<Integer> userAnswers = new ArrayList<Integer>();
	public QuestionInfo(){
	}
	public QuestionInfo(int questionIndex,Question question){
		this.question = question;
		this.questionIndex = questionIndex;
	}
	public QuestionInfo(int questionIndex,Question question,List<Integer> userAnswers){
		super();
		this.question =question;
		this.userAnswers = userAnswers;
		this.questionIndex = questionIndex;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getQuestionIndex() {
		return questionIndex;
	}
	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}
	public List<Integer> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(List<Integer> userAnswers) {
		this.userAnswers = userAnswers;
	}
	@Override
	public String toString() {
		return question.toString();
	}
	
}
