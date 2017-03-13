package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Product;

/**
 * ��Ʒ��ʾ����Ϣ����
 * 
 * @author soft01
 * 
 */
public interface ProductDAO {
	/**
	 * ��ѯǰn�������ϼ���Ʒ
	 * 
	 * @param size
	 *            ��ȡǰn��
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewProduct(int size) throws Exception;

	/**
	 * ��ѯǰn������ͼ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findHotProduct() throws Exception;

	/**
	 * ��ѯǰn����������ͼ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewHotProduct() throws Exception;

	/**
	 * ͨ��id��ѯһ����Ʒ
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public Product findProductById(int pid) throws Exception;
}
