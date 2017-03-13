package com.tarena.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tarena.entity.User;

/**
 * �û�������
 * @author soft01
 *
 */
public interface UserSerivice {
	/**
	 * ����û���½
	 * 
	 * @param email
	 *            �û����������
	 * @param password
	 *            �û����������
	 * @param servletRequest
	 *            ������request
	 * @param session
	 *            ������session
	 * @return ����һ����½�ɹ���ʧ�ܵ��ַ���
	 */
	public String checkLogin(String email, String password,
			HttpServletRequest servletRequest, Map<String, Object> session);

	/**
	 * �û�ע���߼�
	 * @param user �û�
	 * @param session ������session
	 * @param servletRequest ������request
	 * @return
	 */
	public boolean register(User user,Map<String, Object> session, HttpServletRequest servletRequest);

	/**
	 * ��֤�����߼�
	 * @param code
	 * @param session
	 * @return
	 */
	public String verifyEmail(String code,Map<String, Object> session);
}
