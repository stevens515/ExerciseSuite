package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Item;

/**
 * d_item����Ϣ�����߼�
 * 
 * @author soft01
 * 
 */
public interface ItemDAO {
	/**
	 * ��������
	 * 
	 * @param item
	 * @throws Exception
	 */
	public void insert(Item item) throws Exception;

	/**
	 * ͨ��product_id�ҳ���Ʒ��ϸ
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<Item> findByProductId(int productId) throws Exception;
}
