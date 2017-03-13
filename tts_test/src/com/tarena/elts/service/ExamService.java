package com.tarena.elts.service;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/**����ĺ��Ĺ��ܣ���¼����ʼ(����)������*/
public interface ExamService {
	User login(int id,String pwd)
			throws IdOrPwdException;

	ExamInfo startExam();

	QuestionInfo getQuestion(int i);

	void saveUserAnswers(int idx, List<Integer> userAnswers);

	int send();

	int getScore();
}
