package longtime;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestPersistence {
	public void testiterator(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Foo");
		
		//��ʽһ�����ӻ����أ�ʹ�ý϶ࣩ
		List<Foo> fooList = query.list();
		
		//��ʽ2���ӻ�����
		Iterator<Foo> fooIt = query.iterate();
		//select t_id from t_foo;
		
		while(fooIt.hasNext()){
			Foo foo = fooIt.next();
			//select* from t_foo where t_id=?
			System.out.println(foo.getValue());
		}
	}
}
