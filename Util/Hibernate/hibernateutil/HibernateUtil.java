package com.wangxin.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * (һ)����
 * ThreadLocal��Struts��������ʹ��
 * ���������е���closeSession�ķ���
 * (��)
 * currentSession��openSessionInView
 * 
 */


public class HibernateUtil {
	private static Configuration conf;
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> sessionLocal =
					new ThreadLocal<Session>();
	
	static{
		//	����hibernate.cfg.xml��hbm.xmlӳ������
		conf = new Configuration();
		conf.configure();//Ĭ�ϼ���src/hibernate.cfg.xml
		//conf.configure(new File("/abc.cfg.xml"));
		//��ȡSession����
		sessionFactory = 
						conf.buildSessionFactory();
	}
	
	public static Session openSession(){
		Session session = sessionLocal.get();
		//��ȡһ���µĴ򿪵�Session
		if(session  == null){
			session = sessionFactory.openSession();
			sessionLocal.set(session);
		}
		return session;
	}
	
	public static void closeSession(){
		Session session = sessionLocal.get();
		sessionLocal.set(null);
		if(session != null){
			session.close();
		}
	}
	
	
}

