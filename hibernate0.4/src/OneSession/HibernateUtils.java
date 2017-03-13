package OneSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**��α�֤��ȡͬһ��Session  
 *����һ(�Ƽ�) ͬһ��Sesison���ع�HibernateUtil
 *���������޸�hibernate.cfg.xml
 *			�������ļ��м���һ�仰������HibernateҪ
 *			ʹ��ThreadLocal�ķ�ʽ���sesion.
 *			��hibernate.cfg.xml�м�����������
 *<property name="current_session_context_class">thread</property>
 */
public class HibernateUtils {
	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
	private static Configuration conf;
	private static SessionFactory factory;
	
	static{
		conf = new Configuration();
		conf.configure();
		factory=conf.buildSessionFactory();
	}
	public static Session getSession(){
		//factory.getCurrentSession();
		Session session = tl.get();
		if(session==null){
			session=factory.openSession();
			tl.set(session);
		}
		return session;
	}
	public static void closeSession(){
		Session session = tl.get();
		if(session!=null){
			session.close();
			tl.set(null);
		}
	}
	/**
	 ������ʾ�����ǿ�����Dao�е���getSession()������ȡһ��Session,
	 ��ҳ����ʾ���ݽ������������е���closeSession()�ر�Session.
	 �Ժ�ʹ�����HibernateUtil����
	 */
}
