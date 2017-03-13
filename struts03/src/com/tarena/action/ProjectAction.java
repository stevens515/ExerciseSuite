package com.tarena.action;

import com.tarena.dao.ProjectDAO;
import com.tarena.dao.impl.ProjectDAOImpl;
import com.tarena.entity.Project;

public class ProjectAction {
	private Project pro;
	ProjectDAO proDao = new ProjectDAOImpl();
	
	//���µ����ݿ�
	public String update(){
		try {
			proDao.update(pro);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//���³�ʼ��ʾ
	public String init(){
		try {
			pro = proDao.findById(pro.getId());
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//�鿴
	public String view(){
		try {
			pro = proDao.findById(pro.getId());
			return "view";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	//ɾ��
	public String delete(){
		try {
			proDao.deleteById(pro.getId());
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//���
	public String add(){
		try {
			proDao.save(pro);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	
	public Project getPro() {
		return pro;
	}

	public void setPro(Project pro) {
		this.pro = pro;
	}


}
