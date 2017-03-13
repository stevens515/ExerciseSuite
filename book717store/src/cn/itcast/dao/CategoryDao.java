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

}
