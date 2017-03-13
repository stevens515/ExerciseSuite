package com.tarena.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tarena.dao.ProjectDAO;
import com.tarena.dao.impl.ProjectDAOImpl;
import com.tarena.entity.Option;
import com.tarena.entity.Project;

public class PersonAction {
	private int id;
	private String name;
	private String password;
	private int age;
	private String description;
	private boolean marry;//�뵥��checkbox��Ӧ
	private String[]  course;//����checkbox��Ӧ
	private String cradio;//��һ��radio��Ӧ
	private String cselect;//��select��Ӧ
	private String sex;

	public String execute(){
		id = 100;
		name = "����";
		age = 20;
		password = "123456";
		description = "����һ������";
		marry = true;//�����Ƿ��ѻ鵥ѡ��ѡ��
		ProjectDAO proDao = new ProjectDAOImpl();
		try {
			//���γ̼���д��session,
			//����radio,select,checkboxlist��̬��ʾ
			List<Project> projects = proDao.findAll();
			Map<String,Object> session = 
					ActionContext.getContext().getSession();
			session.put("pros", projects);
			//���Ա�ѡ��д��session
			List<Option> opts = new ArrayList<Option>();
			opts.add(new Option("M","��"));
			opts.add(new Option("F","Ů"));
			session.put("opts", opts);
			sex = "F";//�����Ա�Ůѡ��
			//�����ļ���checkboxѡ��
			course = new String[]{"jd10004","jd10008","jd10009"};
			//�����ĸ�radioѡ��
			cradio = "jd10004";
			//�����ĸ�optionѡ��
			cselect = "jd10009";
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCselect() {
		return cselect;
	}

	public void setCselect(String cselect) {
		this.cselect = cselect;
	}

	public String getCradio() {
		return cradio;
	}

	public void setCradio(String cradio) {
		this.cradio = cradio;
	}

	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}
	public boolean isMarry() {
		return marry;
	}


	public void setMarry(boolean marry) {
		this.marry = marry;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
