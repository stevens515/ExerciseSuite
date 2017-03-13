package com.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Address;
import com.tarena.entity.Order;
import com.tarena.util.HibernateUtil;

public class TestOrder {
//	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		Order order = 
			(Order)session.get(Order.class, 1);
		System.out.println(order.getId());
		System.out.println(order.getTotalPrice());
		System.out.println(order.getAddress().getReceiveName());
		System.out.println(order.getAddress().getFullAddress());
		HibernateUtil.closeSession();
	}
	
	@Test
	public void testAdd(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Order order = new Order();
		order.setTotalPrice(880);
		order.setOrderTime(System.currentTimeMillis());
		order.setStatus(0);
		//��ȡһ��Address
		Address address = 
			(Address)session.get(Address.class, 3);
		//��id=3��address���󵱶������ջ��ַ
		order.setAddress(address);
		//����
		session.save(order);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	
}
