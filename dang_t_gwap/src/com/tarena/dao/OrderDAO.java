package com.tarena.dao;

import com.tarena.entity.Order;
/**
 * ��������
 * @author soft01
 *
 */
public interface OrderDAO {
	/**
	 * ��������
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public int createOrder(Order order) throws Exception;
}
