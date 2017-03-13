package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Book;

/**
 * רΪ�����׼����DAO����
 * 
 * @author soft01
 * 
 */
public interface SortDAO {
	/**
	 * book_listҳ�������
	 * 
	 * @param cid
	 *            ���id
	 * @param page
	 *            ��ҳ��
	 * @param size
	 *            ÿҳ��С
	 * @param rule
	 *            �������
	 * @return ����һ����ļ���
	 * @throws Exception
	 */
	public List<Book> order(int cid, int page, int size, int rule)
			throws Exception;
}
