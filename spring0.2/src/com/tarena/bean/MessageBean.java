package com.tarena.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean {
	// Properties Map�й�ϵ��
	private String username;
	private String password;
	private int size;
	private List<String> citys;
	private Set<String> friends;
	private Map<Integer, String> books;
	private Properties props;

	public void show() {
		System.out.println("�û���:" + username);
		System.out.println("���룺" + password);
		System.out.println("����������:" + size);
		System.out.println("-----�����б�----");
		for (String str : citys) {
			System.out.println(str);
		}
		System.out.println("----�����б�----");
		for (String str : friends) {
			System.out.println(str);
		}
		System.out.println("----ͼ���б�---");
		Set<Integer> keys = books.keySet();
		for (Integer key : keys) {
			System.out.println(key + "  " + books.get(key));
		}
		System.out.println("----ϵͳ������Ϣ----");
		Set params = props.keySet();
		for(Object obj:params){
			System.out.println(obj+" : "+props.getProperty(obj.toString()));
		}
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public void setBooks(Map<Integer, String> books) {
		this.books = books;
	}

	public void setFriends(Set<String> friends) {
		this.friends = friends;
	}

	public void setCitys(List<String> citys) {
		this.citys = citys;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
