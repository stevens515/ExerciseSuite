package com.tarena.elts.service;

import com.tarena.elts.entity.User;

/**����ĺ��Ĺ��ܣ���¼����ʼ(����)������
 * 6) ����ҵ����ģ�ͽӿ� ExamService, �����ṩ��¼����
    	��������ĺ���ҵ��ģ�� 
 */
public interface ExamService {
	User login(int id ,String pwd)
		throws IdOrPwdException;
}
