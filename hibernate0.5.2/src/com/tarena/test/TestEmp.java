package com.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Emp;
import com.tarena.entity.EmpKey;
import com.tarena.util.HibernateUtil;

public class TestEmp {
//	@Test
	public void testAdd(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Emp emp = new Emp();
		emp.setKey(new EmpKey("��","��"));
		emp.setSex("��");
		session.save(emp);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//ע��EmpKeyҪʵ��Serializable
		Emp emp = 
			(Emp)session.get(Emp.class,
					new EmpKey("��","��"));
		System.out.println(emp.getKey().getFirstName()+
				emp.getKey().getLastName());
		System.out.println(emp.getSex());
		tx.commit();
		HibernateUtil.closeSession();
	}
}
