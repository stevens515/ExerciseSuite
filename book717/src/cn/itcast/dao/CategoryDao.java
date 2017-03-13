package cn.itcast.dao;

import java.sql.Connection;
import java.util.List;

import cn.itcast.domain.Category;

public interface CategoryDao {

	/**
	 * 	����ͼ�������
	 * @param conn
	 * @param category
	 */
	void saveCategory(Connection conn, Category category);
	/**
	 * 	��ѯ���е�ͼ�������Ϣ
	 * @return
	 */
	List<Category> findAllCategorys(Connection conn);
	/**
	 * ͨ��idɾ��ͼ����Ϣ
	 * @param conn
	 * @param id
	 */
	void deleteCategoryById(Connection conn, String id);
	/**
	 * �޸�ͼ�������Ϣ
	 * @param conn
	 * @param category
	 */
	void updateCategory(Connection conn, Category category);
	/**
	 * ͨ��id��ѯͼ�������Ϣ
	 * @param conn
	 * @param id
	 * @return
	 */
	Category findCategoryById(Connection conn, String id);

}
