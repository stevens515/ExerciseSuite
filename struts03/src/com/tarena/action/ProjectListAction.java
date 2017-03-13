package com.tarena.action;

import java.util.List;

import com.tarena.dao.ProjectDAO;
import com.tarena.dao.impl.ProjectDAOImpl;
import com.tarena.entity.Project;

public class ProjectListAction {
	//��������
	private int page = 1;//��ǰҪ��ʾ�ڼ�ҳ
	//��������
	private List<Project> projects;
	private int totalPage = 1;//��ҳ��
	//
	private static final int SIZE = 5;//һҳ��ʾ������
	
	public String execute(){
		ProjectDAO proDao = new ProjectDAOImpl();
		try {//��ȡ�ڼ�ҳ�ļ�¼
			projects = proDao.findPage(page, SIZE);
			//��ȡ��ҳ��
			totalPage = proDao.countTotalPage(SIZE);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
