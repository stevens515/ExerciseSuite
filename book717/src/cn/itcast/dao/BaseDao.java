package cn.itcast.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Category;
import cn.itcast.exception.DaoException;

public abstract class BaseDao {
	/** ҵ���
	 * 	ͨ�õĶ����ݽ���crud�������� 
	 * @param conn	���� 
	 * @param sql		sql���
	 * @param params		����
	 * @param errorMsg	������Ϣ
	 */
	public void update(Connection conn,String sql,Object[] params,String errorMsg){
		try {
			//���÷�������
			QueryRunner query = new QueryRunner();
			query.update(conn,sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(errorMsg,e);
		}
	}

	@SuppressWarnings("unchecked")
	public List findObjectByCondition(Connection conn, String sql,
			Object[] params, Class clazz, String errorMsg) {
		List list=null;
		try{
			QueryRunner query = new QueryRunner();
			list=(List)query.query(conn, sql,new BeanListHandler(clazz),params);
		}catch(SQLException e){
			e.printStackTrace();
			throw new DaoException(errorMsg,e);
		}
		return list;
	}

	/**
	 * ͨ�� id ��ѯͼ����Ϣ
	 * @param conn
	 * @param sql
	 * @param params
	 * @param clazz
	 * @param errorMsg
	 * @return
	 */
	public Object findObjectById(Connection conn, String sql,
			Object[] params, Class<Category> clazz, String errorMsg) {
			Object bean = null;
			try{
				QueryRunner query = new QueryRunner();
				bean = query.query(conn, sql,new BeanHandler(clazz),params);
			}catch(SQLException e){
				e.printStackTrace();
				throw new DaoException(errorMsg,e);
			}
			return bean;
	}
}
