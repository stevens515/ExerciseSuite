package com.tarena.util;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class SessionUtil {
	private static SessionFactory sessionbFactory;
	// ����connection�뵱ǰִ���̰߳�
	private static ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
	static{
		Configuration conf = new Configuration();
		//Ĭ�ϼ���src�µ�hibernate.cfg.xml
		conf.configure();
		//��ȡSession���󹤳�
		sessionbFactory = conf.buildSessionFactory();
	}
	public static Session getSession() throws SQLException {
		//�����ǰ�߳�ǰ�洴����session����session����
		Session session = sessionLocal.get();
		if (session == null) {
			session = sessionbFactory.openSession();
			sessionLocal.set(session);
		}
		return session;
	}
	public static void closeSession() throws SQLException {
		Session session = sessionLocal.get();
		sessionLocal.set(null);
		if (session != null) {
			session.close();
		}
	}
	public static void main(String[] args) throws Exception {
		Session session = getSession();
		System.out.println(session.hashCode());
		Session session1 = getSession();
		System.out.println(session1.hashCode());
		
		
	}
}
