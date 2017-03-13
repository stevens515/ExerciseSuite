package org.tarena.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.tarena.entity.ext.User;

public class UserTest {
	public static String HIBERNATE_COINFIG_FILE = "/hibernate.cfg.xml";
	@Test
	public void saveUserTest() {
		// ��ȡhibernate.cfg.xml�����ļ�����ȡ����
		/*
		 * //��ȡhibernate.properties 
		 * Configuration configuration = new Configuration(); 
		 * //��ȡxml�ļ� 
		 * Configuration c = configuration.configure();
		 */
		//Configuration c = new Configuration().configure("HIBERNATE_COINFIG_FILE");
		Configuration c = new Configuration().configure();
		// ��ȡ���ӹ���
		SessionFactory sessionFactory = c.buildSessionFactory();
		Session session = null;
		// ��ȡ����
		try {
			session = sessionFactory.openSession();
			//��ȡ����
			session.beginTransaction();
			
			User user = new User();
			user.setName("king");
			user.setPassword("1234");
			session.save(user);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}
}