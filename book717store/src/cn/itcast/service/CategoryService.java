package cn.itcast.service;

import java.sql.Connection;
import java.util.List;

import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;
import cn.itcast.exception.ServiceException;
import cn.itcast.factory.DaoFactory;
import cn.itcast.util.JdbcUtils;

/**
 * ҵ���
 */
public class CategoryService {

	private CategoryDao categoryDao = DaoFactory.getCategoryDao();

	public void saveCategory(Category category) {
		Connection conn = null;
		try {
			// ��ȡ����
			conn = JdbcUtils.getConnection();

			// ��������Ϊ���Զ��ύ
			JdbcUtils.beginTransaction(conn);// �������װ

			// ����dao��ķ�������
			categoryDao.saveCategory(conn, category);

			// �ύ
			JdbcUtils.commitTransaction(conn);// ��װ
		} catch (Exception e) {
			JdbcUtils.rollbackTransaction(conn);// ��װ
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e);
		} finally {
			// �ر���Դ
			JdbcUtils.closeResource(conn, null, null);
		}
	}
	/**
	 * 	��ȡ���е�ͼ�������Ϣ
	 */
	public List<Category> findAllCategorys() {
		Connection conn =null;
		List<Category> list=null;
			//��ȡ����
		conn=JdbcUtils.getConnection();
		list=categoryDao.findAllCategorys(conn);
		return list;
	}

}
