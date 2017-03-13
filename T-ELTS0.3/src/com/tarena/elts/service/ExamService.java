package com.tarena.elts.service;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/**����ĺ��Ĺ��ܣ���¼����ʼ(����)������
 * 6) ����ҵ����ģ�ͽӿ� ExamService, �����ṩ��¼����
    	��������ĺ���ҵ��ģ�� 
 */
public interface ExamService {
	User login(int id ,String pwd)
		throws IdOrPwdException;

	ExamInfo startExam();

	QuestionInfo getQuestion(int index);
}
