package com.tarena.action.user;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DAOFactory;

/**
 * ����register_form.jspҳ�����֤nickname�ĺϷ���
 * 
 * @author soft01
 * 
 */
public class ValidNickNameAction implements Serializable {
	private static final long serialVersionUID = 984731460159551471L;
	// ����һ���������������û������nickname
	private String nickname;
	// ����һ����������ȷ����nickname�Ƿ���ȷ
	private boolean ok;

	public String execute() {
		// ���UserDAO��ʵ��
		UserDAO userDAO = (UserDAO) DAOFactory.getInstance("UserDAO");
		try {
			// ��̬����1500����
			Thread.sleep(1500);
			// ͨ����ʵ��ͨ����nickname�����ݿ������û�
			User user = userDAO.findByNickName(nickname);
			// ����û�Ϊ�գ�����nickname����
			if (user == null) {
				ok = true;
			} else {
				// ����nickname��ռ��
				ok = false;
			}
			// ����ajax�����json�����ֵ
			return "success";
		} catch (Exception e) {
			Logger log=Logger.getLogger(ValidNickNameAction.class);
			log.error("�û����Ϸ��Գ���", e);
			// ���ӵ�error.jspҳ��
			return "error";
		}
	}

	// getter and setter
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}
}
