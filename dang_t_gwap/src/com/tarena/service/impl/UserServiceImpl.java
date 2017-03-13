package com.tarena.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.service.UserSerivice;
import com.tarena.util.Constant;
import com.tarena.util.DAOFactory;
import com.tarena.util.EmailUtil;
import com.tarena.util.MD5Util;
import com.tarena.util.VerifyUtil;

/**
 * �û�������
 * 
 * @author soft01
 * 
 */
public class UserServiceImpl implements UserSerivice {
	private static final long serialVersionUID = -7966927966405304824L;

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
			HttpServletRequest servletRequest, Map<String, Object> session) {

		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// 1.���email�������Ƿ���ȷ
			User user = userDAO.findByEmail(email);
			if (user != null
					&& MD5Util.md5(password).equals(user.getPassword())) {
				// 2.��������Ƿ�ͨ����֤
				if (user.isEmailVerify()) {
					// 3.����d_user������¼ʱ���ip
					user.setLastLoginTime(System.currentTimeMillis());
					user.setLastLoginIp(servletRequest.getRemoteAddr());
					userDAO.updateById(user.getId());
					// 4.��userд��session
					session.put("user", user);
					// 5.��ת��/main/main.jsp
					return "success";
				} else {
					// δ��֤��ת��verify_form.jsp
					return "verify";
				}
			} else {
				// ����ȷ��ת��login_form.jsp
				return "login";
			}
		} catch (Exception e) {
			// ��¼��־
			Logger logger = Logger.getLogger(UserServiceImpl.class);
			logger.error("����û���½ʱ�����쳣", e);
			// error.jsp
			return "errror";
		}
	}

	/**
	 * �û�ע���߼�
	 * 
	 * @param user
	 *            �û�
	 * @param session
	 *            ������session
	 * @param servletRequest
	 *            ������request
	 * @return
	 */
	public boolean register(User user, Map<String, Object> session,
			HttpServletRequest servletRequest) {
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// ����������MD5����
			String pwd = MD5Util.md5(user.getPassword());
			user.setPassword(pwd);
			user.setUserIntegral(Constant.INTEGRAL_NORMAL);
			// ��½ʱ��Ϊ��ǰʱ��
			user.setLastLoginTime(System.currentTimeMillis());
			// ��½IP
			user.setLastLoginIp(servletRequest.getRemoteAddr());
			user.setEmailVerify(false);
			// ����������֤��
			String verifyCode = VerifyUtil.randomUUID();
			user.setEmailVerifyCode(verifyCode);
			// �����û�
			userDAO.insert(user);
			session.put("registerUser", user);
			// ��������֤����û�����
			String emailCode = verifyCode + "-" + user.getId();
			EmailUtil.sendEmail(user.getEmail(), "����������֤", emailCode);
			return true;
		} catch (Exception e) {
			Logger logger = Logger.getLogger(UserServiceImpl.class);
			logger.error("ע���û�ʱ�����쳣", e);
			return false;
		}
	}

	/**
	 * ��֤�����߼�
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	public String verifyEmail(String code, Map<String, Object> session) {
		// �����յ���������֤�����
		// ��ȡ�û�ID��UUID
		String uuid = code.substring(0, code.lastIndexOf("-"));
		int id = Integer.parseInt(code.substring(code.lastIndexOf("-") + 1));
		User user = (User) session.get("registerUser");
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			boolean flag = userDAO.findById(user.getId()).isEmailVerify();
			if (flag) {
				// �ڶ�����֤�ص�main.jsp
				return "main";
			} else if (user.getId() != id) {
				// ����������֤�룬����������֤
				return "verify";
			}
			// ����ID��UUIDȥ���ݿ����
			String dbcode = userDAO.findById(id).getEmailVerifyCode();
			// �ж��Ƿ���ȷ
			if (dbcode.equals(uuid)) {
				// �����ȷ,����d_user��is_email_verify
				String str = userDAO.updateVerify(id, true);
				if (str.equals("Y")) {
					flag = true;
				} else {
					flag = false;
				}
				// ��֤ͨ����register_ok.jsp
				return "success";
			} else {
				// ������֤
				return "verify";
			}
		} catch (Exception e) {
			Logger logger = Logger.getLogger(UserServiceImpl.class);
			logger.error("��֤�û�codeʱ�����쳣", e);
			return "error";
		}
	}
}
