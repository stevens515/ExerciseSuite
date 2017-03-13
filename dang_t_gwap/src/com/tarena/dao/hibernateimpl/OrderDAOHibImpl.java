package com.tarena.dao.hibernateimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.dao.OrderDAO;
import com.tarena.entity.Order;
import com.tarena.util.HibernateUtil;

/**
 * ��������
 * 
 * @author soft01
 * 
 */
public class OrderDAOHibImpl implements OrderDAO, Serializable {
	private static final long serialVersionUID = 8289583595560112490L;

	public int createOrder(Order order) throws Exception {
		// 1.����session����
		Session session = HibernateUtil.getSession();
		// 2.��ʼ����
		Transaction transaction = session.beginTransaction();
		// 3.���涨��,��������ֵ
		Serializable identifier = session.save(order);
		// 4.�����ύ
		transaction.commit();
		// 5.�ر�session����
		HibernateUtil.closeSession();
		// 6.��������ֵ
		return (Integer) identifier;
	}

}
