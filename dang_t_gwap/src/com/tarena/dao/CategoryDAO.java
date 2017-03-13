package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Category;

/**
 * d_category����Ϣ����
 * 
 * @author soft01
 * 
 */
public interface CategoryDAO {
	/**
	 * ����turn�ҳ���Ʒ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception;

	/**
	 * ͨ�������id����Ʒ������turn����
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(int pid) throws Exception;

	/**
	 * ��ѯ��Ʒ����
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findBookNumber(int cid) throws Exception;

	/**
	 * ĳ����������������
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findCountByCatId(int cid) throws Exception;

	/**
	 * ͨ�����id�ҵ������
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public String findNameByCatId(Integer cid) throws Exception;
}
