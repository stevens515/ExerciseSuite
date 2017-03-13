package com.tarena.elts.entity;

import java.io.Serializable;

//entity ʵ��, ����ҵ�񷶳��еľ������� User ����ϵͳ��¼�û�
public class User implements Serializable {
	private static final long serialVersionUID = 7318700563429079527L;
	private int id;
	private String name;
	private String passwd;
	private String phone;
	private String email;
	public User(){
	}
	public User(String name,int id,String passwd){
		super();
		this.name = name;
		this.id = id;
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(this==obj)
			return true;
		if(obj instanceof User){
			User other = (User)obj;
			return this.id==other.id;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return id;
	}
}
