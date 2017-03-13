package com.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Computer;
import com.tarena.entity.Product;
import com.tarena.util.HibernateSessionFactory;

public class TestComputer {
//	@Test
	public void testAddComputer(){
		Session session =
			HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Computer computer = new Computer();
		//	д��d_product�����Ϣ
		computer.setProductName("apple");
		computer.setFixedPrice(10000);
		computer.setDangPrice(2000);
		computer.setHasDeleted(0);
		//д��d_computer����Ϣ
		computer.setCpu("ben4");
		computer.setMemory("2G");
		session.save(computer);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
//	@Test
	public void testLoadComputer(){
		Session session =
			HibernateSessionFactory.getSession();
		Computer computer = 
			(Computer)session.get(Computer.class, 26);
		System.out.println(computer.getId());
		System.out.println(computer.getProductName());
		System.out.println(computer.getCpu());
		System.out.println(computer.getMemory());
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void testLoadProduct(){
		Session session =
			HibernateSessionFactory.getSession();
		//����������computer,book����ȫ������
		String hql = "from Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		for(Product pro:list){
			System.out.println(pro.getId()+" "+pro.getClass().getName());
		}
		HibernateSessionFactory.closeSession();
	}
	
}
