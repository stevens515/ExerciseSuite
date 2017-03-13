package com.tarena.action.user;

import com.tarena.action.BaseAction;
import com.tarena.entity.User;
import com.tarena.service.UserSerivice;
import com.tarena.util.DAOFactory;

/**
 * ��ActionΪ�����û���½���ѵ�½��Ϣ��ʾ���û�
 * 
 * @author soft01
 * 
 */
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 377910275586090069L;
	// input �û������email
	private String name;
	// input �û������password
	private String password;
	private User user;
	// output ��ʾ���û�����Ϣ��Ϣ
	private String errorMessage;

	public String execute() {
		// ��ȡ�û������ʵ��
		UserSerivice userSerivice = (UserSerivice) DAOFactory
				.getInstance("UserSerivice");
		// ���ü���û�����ķ���
		String str = userSerivice.checkLogin(name, password, request, session);

		if (str.equals("success")) {
			// ����ɹ����ӵ�main.jspҳ��
			return "success";
		} else if (str.equals("verify")) {
			// ���û�н���������֤����verify_form.jspҳ��
			return "verify";
		} else if (str.equals("login")) {
			// �����½ʧ�ܣ����û�������������ڵ�ǰҳ��
			errorMessage = "�û������������";
			return "login";
		} else {
			// �������ȥerror.jspҳ��
			return "error";
		}
	}

	// �ǳ��߼�
	public String logout() {
		// ��session���Ƴ�user
		session.remove("user");
		// ���ӵ�main.jspҳ��
		return "success";
	}
	
	// getter and setter
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
