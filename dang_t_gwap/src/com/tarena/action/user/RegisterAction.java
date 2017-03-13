package com.tarena.action.user;


import com.tarena.action.BaseAction;
import com.tarena.entity.User;
import com.tarena.service.UserSerivice;
import com.tarena.util.DAOFactory;

/**
 * ע�ᴦ��
 * 
 *
 * 
 */
public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 8694976724357168116L;
	//�����û�����
	private User user;
	//��ȡ������֤��
	private String emailCode;

	public String execute() {
		// ʵ����UserSerivice����
		UserSerivice userSerivice = (UserSerivice) DAOFactory
				.getInstance("UserSerivice");
		// ���û�������ȥ����ע�����
		// �������success�����ӵ�verify_form.jspҳ��
		// �������error�����ӵ�error.jsjpҳ��
		String str = userSerivice.register(user,session, request) == true ? "success"
				: "errror";
		return str;
	}

	// getter and setter
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public String getEmailCode() {
		return emailCode;
	}
}
