package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Book;

/**
 * d_book��Ϣ����
 * 
 * @author soft01
 * 
 */
public interface BookDAO {
	/**
	 * ͨ���������
	 * 
	 * @param cid
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<Book> findByCatId(int cid, int page, int size) throws Exception;

	/**
	 * �г�ȫ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Book> findAll() throws Exception;

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @param cid
	 * @param rowsPerPage
	 * @return
	 * @throws Exception
	 */
	public int getTotalPages(int cid, int rowsPerPage) throws Exception;

	/**
	 * �鿴��ϸ��Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Book findDetailById(int id) throws Exception;

	/**
	 * �鿴�丸�����
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public String findParentName(Integer pid) throws Exception;

	/**
	 * ͨ��id�鿴���������
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int findTotalNumById(int id) throws Exception;

	/**
	 * ͨ��id������
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<String> findNameById(int id) throws Exception;
}
