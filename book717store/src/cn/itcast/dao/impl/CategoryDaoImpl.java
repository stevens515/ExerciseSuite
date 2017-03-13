package cn.itcast.dao.impl;

import java.sql.Connection;
import java.util.List;


import cn.itcast.dao.BaseDao;
import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;
import cn.itcast.util.Global;

public class CategoryDaoImpl extends BaseDao implements CategoryDao{

	public void saveCategory(Connection conn, Category category) {
		// ���ô�����ʾ��Ϣ
		String errorMsg = Global.DAO��CATEGORY_ADD_EXCEPTION;
		//��֯sql
		String sql = "insert into category(id,name,description) values(?,?,?)";
		//����sql�����Ҫ�Ĳ���
		Object[] params ={category.getId(),category.getName(),category.getDescription()};
		//���ø���ķ���
		super.update(conn,sql,params,errorMsg);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllCategorys(Connection conn) {
		//���ô�����ʾ��Ϣ
		String errorMsg="��ѯͼ�������Ϣʧ��";
		//��֯sql
		String sql = "select id,name,description from category";
		
		Object[] params=null;
		
		/*QueryRunner query=new QueryRunner();
		query.query(conn,sql, new BeanListHandlet(Category.class), params);*/
		
		return super.findObjectByCondition(conn,sql,params,Category.class,errorMsg);
	}

	public List<Category> findAllCategorys() {
		// TODO Auto-generated method stub
		return null;
	}


}
