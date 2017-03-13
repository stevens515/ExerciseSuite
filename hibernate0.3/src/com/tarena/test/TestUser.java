package com.tarena.test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.User;
import com.tarena.util.SessionUtil;

public class TestUser {
	@Test
	public void testAdd(){
		User user = new User();
		user.setNickname("goodbaby");
		user.setPassword("333");
		user.setUserIntegral(1);
		user.setEmail("goodbaby@163.com");
		user.setEmailVerify(true);
		Session session;
		try {
			session = SessionUtil.getSession();
			//����һ������
			Transaction tx = session.beginTransaction();
			//ִ����Ӳ���
			session.save(user);
			//�ύ����
			tx.commit();
			//�ر�session
			session.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//	@Test
	public void testDelete(){
		User user = new User();
		user.setId(18);
		Session session;
		try {
			session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			session.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void testUpdate(){
		//������������ֶ�,����new,ָ�������ֶ�ֵ
		//������²����ֶ�ֵ,�Ȳ����,���޸ĸ���
		Session session;
		try {
			session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();
			//������������ѯ,��ȡid=2��User����
			User user = (User)session.load(User.class, 2);
			user.setEmail("goodbaby@tarena.com");
			session.update(user);
			tx.commit();
			session.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll(){
		Session session;
		try {
			session = SessionUtil.getSession();
			//SQL : select * from d_user
			//HQL : from User
			Query query = session.createQuery("from User");
			List<User> list = query.list();//ִ�в�ѯ
			for(User user : list){
				System.out.println(user.getId()+"" +user.getEmail());
			}
			session.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
