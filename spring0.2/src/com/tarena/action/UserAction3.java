package com.tarena.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tarena.dao.UserDAO;
@Controller("useraction3")
//@Service
//@Component
public class UserAction3 {
	
	//@Resource(name="hibernateUserDAO")
	@Autowired
	@Qualifier("hibernateUserDAO")
	private UserDAO userDao;//�ӿ����ͣ�ʵ���಻�ܳ���
	//setter��ʽע��,�Զ�����
//	public void setUserDao(UserDAO userDao){
//		this.userDao = userDao;
//	}
	

	public String register() {
		// TODO..
		userDao.save();
		userDao.delete();
		return "success";
	}
}
