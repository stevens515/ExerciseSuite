package com.tarena.action;

import com.tarena.dao.UserDAO;

public class UserAction {

	private UserDAO userDao;//�ӿ����ͣ�ʵ���಻�ܳ���

	// setter��ʽע�룬�Զ�����
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public String register() {
		// TODO..
		userDao.save();
		userDao.delete();
		return "success";
	}
}
