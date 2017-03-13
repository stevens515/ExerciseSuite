package com.tarena.dao;

import com.tarena.entity.User;

public interface UserDAO {
	/**
	 * @param user
	 *            �û���Ϣ
	 * @exception Exception
	 */
	public void insert(User user) throws Exception;

	/**
	 * ͨ��email��һ���û�
	 * 
	 * @param email
	 *            �����email
	 * @return ����һ���û�
	 * @throws Exception
	 */
	public User findByEmail(String email) throws Exception;

	/**
	 * ͨ��nickname��һ���û�
	 * 
	 * @param nickName
	 *            �����nickname
	 * @return ����һ���û�
	 * @throws Exception
	 */
	public User findByNickName(String nickName) throws Exception;

	/**
	 * ͨ��id��һ���û�
	 * 
	 * @param id
	 *            �����id
	 * @return ����һ���û�
	 * @throws Exception
	 */
	public User findById(int id) throws Exception;

	/**
	 * ͨ��id�����û���Ϣ
	 * 
	 * @param id
	 *            �û�id
	 * @throws Exception
	 */
	public void updateById(int id) throws Exception;

	/**
	 * �����û�����֤��״̬
	 * 
	 * @param id
	 *            �û�id
	 * @param verify
	 *            �Ƿ�ͨ����֤
	 * @return ����Y��N
	 * @throws Exception
	 */
	public String updateVerify(int id, boolean verify) throws Exception;

}
