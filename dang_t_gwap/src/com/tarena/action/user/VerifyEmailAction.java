package com.tarena.action.user;

import com.tarena.action.BaseAction;
import com.tarena.service.UserSerivice;
import com.tarena.util.DAOFactory;

/**
 * ��֤�����Action,����verify_form.jsp,��ɴ�ҳ�����֤�߼�
 * 
 * @author soft01
 * 
 */
public class VerifyEmailAction extends BaseAction {
	private static final long serialVersionUID = 1174957779621635968L;
	// ���û������code����������н���
	private String code;

	public String execute() {
		// ʵ����һ��userSerivice����
		UserSerivice userSerivice = (UserSerivice) DAOFactory
				.getInstance("UserSerivice");
		// �������ж�code�Ľ�������
		String str = userSerivice.verifyEmail(code, session);
		if (str.equals("success")) {
			// ���ӵ�register_ok.jspҳ��
			return "success";
		} else if (str.equals("verify")) {
			// ���ӵ�verify_form.jspҳ��
			return "verify";
		} else if (str.equals("main")) {
			// ���ӵ�main.jspҳ��
			return "main";
		} else {
			// ���ӵ�error.jspҳ��
			return "error";
		}
	}

	// getter and setter
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
