package org.tarena.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.tarena.entity.ext.User;
import org.tarena.util.hibernate.HibernateUtil;

public class UserDaoImpl {
	public static String HIBERNATE_COINFIG_FILE = "/hibernate.cfg.xml";
	
	@Test
	public int saveUser(User user) {
		int userid= 0;
		Session session = null;
		//��ȡ����
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			//��ȡ����
			session.beginTransaction();
			userid = (Integer)session.save(user);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.close(session);
		}
		return userid;
	}
	
	// ����ID��ѯ
	
	public User findUserById(User u){
		User user = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User)session.get(User.class, u.getName());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.close(session);
		}
		return user;
	}
	
	//��ѯ�����û���Ϣ
	public List<User> findAllUser(){
		List<User> users =null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			users = session.createCriteria(User.class).list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.close(session);
		}
		return users;
	}
	//�޸��û���Ϣ
	//@Test
	public void updateUserById(User user){
		Session session = null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
		    session.update(user);
		    session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
	}
	
//	�޸Ļ��������û���Ϣ
	
	public void updateOrSaveUserById(User user){
		Session session = null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
		    session.saveOrUpdate(user);
		    session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
	}
	
	//ɾ��
	public void deleteUserById(User user){
		Session session = null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
		    session.delete(user);
		    session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
	}
}