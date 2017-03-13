package com.tarena.dao;

import java.util.List;

import com.tarena.entity.ReceiveAddress;

/**
 * Ϊd_receive_address��������DAO
 * 
 * @author soft01
 * 
 */
public interface ReceiveAddressDAO {
	/**
	 * �����ռ��˵�ַ��Ϣ
	 * 
	 * @param receiveAddress
	 *            �ռ��˵�ַ����
	 * @throws Exception
	 */
	public void insert(ReceiveAddress receiveAddress) throws Exception;

	/**
	 * �г�ȫ���ռ��˵�ַ
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReceiveAddress> findAll() throws Exception;

	/**
	 * ͨ��id��һ���ռ��˵�ַ
	 * 
	 * @param id
	 *            �ռ��˵�ַ��id
	 * @return
	 * @throws Exception
	 */
	public ReceiveAddress findById(int id) throws Exception;
}
