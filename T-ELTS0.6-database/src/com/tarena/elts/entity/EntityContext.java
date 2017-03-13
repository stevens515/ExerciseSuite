package com.tarena.elts.entity;

import java.util.List;

public interface EntityContext {
	/**
	 * ͨ���û���Id  ����
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	/**
	 * ��������ĵȼ�   �õ�����ļ���
	 * @param level
	 * @return
	 */
	List<Question> findQuestion(int level);
	/**
	 * �������ļ��� �õ�����ʱ�� 
	 * @return
	 */
	int getTimeLimit();
	/**
	 * �������ļ��еõ�������Ϣ 
	 */
	String getTitle();
}
