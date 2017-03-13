package com.tarena.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Person;
import com.tarena.entity.PersonAddress;
import com.tarena.util.HibernateUtil;

public class TestPerson {
//	@Test
	public void testAdd(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//���
		Person person = new Person();
		person.setName("����");
		person.setSex("��");
		person.setHome(new PersonAddress(
				       "1323223243",
						"����������",
						"102222"));
		person.setCompany(new PersonAddress(
				"6456545",
				"�йش���",
				"212222"
				));
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		Person p = (Person)session.get(Person.class, 1);
		System.out.println(p.getId()+" "+p.getName());
		System.out.println("-----��ͥ��ַ-----");
		System.out.println(p.getHome().getPhone());
		System.out.println(p.getHome().getAddress());
		System.out.println(p.getHome().getZipcode());
		System.out.println("-----��˾��ַ-----");
		System.out.println(p.getCompany().getPhone());
		System.out.println(p.getCompany().getAddress());
		System.out.println(p.getCompany().getZipcode());
		HibernateUtil.closeSession();
	}
	
	
}
