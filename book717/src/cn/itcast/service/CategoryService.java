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
		try{	
		//��ȡ����
		conn=JdbcUtils.getConnection();
		list=categoryDao.findAllCategorys(conn);
	}finally{
		JdbcUtils.closeResource(conn, null, null);
		}
	return list;
	}
	/**
	 * ͨ��id��ѯͼ�������Ϣ
	 * @param id
	 * @return
	 */
	public Category findCategoryById(String id){
		Connection conn = null;
		Category category = null;
		try{
			conn = JdbcUtils.getConnection();
			category = categoryDao.findCategoryById(conn,id);
		}finally{
			JdbcUtils.closeResource(conn, null, null);
		}
		return category;
	}
	/**
	 * �޸�ͼ�������Ϣ
	 * @param category
	 */
	public void updateCategory(Category category){
		Connection conn = null;
		try{
			//��ȡ����
			conn = JdbcUtils.getConnection();
			categoryDao.updateCategory(conn,category);
		}finally{
			JdbcUtils.closeResource(conn, null, null);
		}
	}
	/**
	 * 	ͨ��Idɾ��ͼ�������Ϣ
	 * @param id
	 */
	public void deleteCategoryById(String id) {
		Connection conn = null;
		try{
			//��ȡ����
			conn = JdbcUtils.getConnection();
			categoryDao.deleteCategoryById(conn,id);
		}finally{
			JdbcUtils.closeResource(conn, null, null);
		}
	}

}
