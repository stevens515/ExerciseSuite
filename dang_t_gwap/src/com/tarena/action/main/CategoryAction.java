package com.tarena.action.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.CategoryDAO;
import com.tarena.entity.Category;
import com.tarena.util.DAOFactory;

/**
 * ���category.jsp����ʾ�߼�
 * 
 * @author soft01
 * 
 */
public class CategoryAction implements Serializable {
	private static final long serialVersionUID = 7008313760713395351L;
	// ���ڴ��������𼯺�
	private List<Category> cats;

	public String execute() {
		// ��ʼ��һ������DAO����
		CategoryDAO categoryDAO = (CategoryDAO) DAOFactory
				.getInstance("CategoryDAO");
		try {
			// �ҳ����е������е�����
			List<Category> all = categoryDAO.findAll();
			// ��parentId=1��Ԫ����䵽cats����
			cats = findByParentId(all, 1);// ���е���Ʒ�ĸ�idΪ1����Ʒ
			// ���parentId=1��Category�����subCats
			for (Category category : cats) {
				// �Ѹ�idΪ1����Ʒ��������оٳ���
				List<Category> subCats = findByParentId(all, category.getId());
				// �Ѹ�idΪ1����Ʒ���������䵽subCats���ϵ���
				category.setSubCats(subCats);
			}
			// ���ӵ�category.jsp
			return "success";
		} catch (Exception e) {
			// ��¼��־
			Logger logger = Logger.getLogger(CategoryAction.class);
			logger.error("�ڲ������ݿ�ʱ����һ���쳣", e);
			return "error";
		}
	}

	/**
	 * ��all������ѡȡparent_id=parentId�������
	 * 
	 * @param all
	 * @param parentId
	 * @return
	 */
	private List<Category> findByParentId(List<Category> all, int parentId) {
		// ��ʼ�����ļ���
		List<Category> list = new ArrayList<Category>();
		// ��������all
		for (Category category : all) {
			// ��Ѱcategory�ĸ�id�������id���ڴ����parentId
			if (category.getParentId() == parentId) {
				// ���category���뵽������
				list.add(category);
			}
		}
		// ����һ��list����
		return list;
	}

	// getter and setter
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public List<Category> getCats() {
		return cats;
	}

}
