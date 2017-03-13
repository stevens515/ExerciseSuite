package com.tarena.action.user;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DAOFactory;

/**
 * ����Ψһ�Լ��
 * 
 * @author soft01
 * 
 */
public class ValidEmailAction implements Serializable {
	private static final long serialVersionUID = 4736738956977619998L;
	// �����ȡ�û������email
	private String email;
	// email�����,true����,falseΪ��ռ��
	private boolean ok;

	public String execute() {
		// ʵ����һ��UserDAO����
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// ��̬����1500����
			Thread.sleep(1500);
			// ͨ���û������email�����ݿ��в���
			User user = userDAO.findByEmail(email);
			// û�ҵ�true����,
			if (user == null) {
				ok = true;
			} else {
				// �ҵ�false������
				ok = false;
			}
			// ����ҳ�淢�͵�ajax�����json����
			return "success";// json
		} catch (Exception e) {
			Logger logger = Logger.getLogger(ValidEmailAction.class);
			logger.error("����Ψһ����֤����", e);
			// ���ӵ�error.jspҳ��
			return "error";
		}
	}

	// getter and setter
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}
}
