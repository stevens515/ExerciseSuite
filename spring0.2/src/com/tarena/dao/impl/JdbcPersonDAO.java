package com.tarena.dao.impl;

import com.tarena.dao.PersonDAO;

public class JdbcPersonDAO implements PersonDAO {

	public void delete() {
		System.out.println("jdbc�û�ɾ��!");

	}

	public void findById() {
		System.out.println("jdbc�û���ѯ!");

	}

	public void save() {
		System.out.println("jdbc�û�����!");

	}

	public void update() {
		System.out.println("jdbc�û�����!");

	}

}
