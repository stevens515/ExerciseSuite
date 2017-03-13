package com.tarena.test;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.tarena.entity.Category;
import com.tarena.entity.Product;
import com.tarena.util.HibernateSessionFactory;

public class TestCategory {
	@Test
	public void testLoad(){
		Session session = 
			HibernateSessionFactory.getSession();
		Category cat = 
			(Category)session.load(Category.class, 9);
		System.out.println(cat.getId()+" "+cat.getName());
		System.out.println("-----����������Ʒ-----");
		Set<Product> pros = cat.getPros();
		for(Product pro:pros){
			System.out.println("��ƷID:"+pro.getId()+" "
					+"��Ʒ��:"+pro.getProductName()+" "
					+"��ƷͼƬ:"+pro.getProductPic());
		}
		HibernateSessionFactory.closeSession();
	}
}
