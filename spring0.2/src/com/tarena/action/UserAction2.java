package com.tarena.action;

import com.tarena.dao.UserDAO;

public class UserAction2 {

	private UserDAO userDao;//�ӿ����ͣ�ʵ���಻�ܳ���

	//���췽��ע��
	public UserAction2(UserDAO userDao){
		this.userDao=userDao;
	}
	public String register() {
		// TODO..
		userDao.save();
		userDao.delete();
		return "success";
	}
}
