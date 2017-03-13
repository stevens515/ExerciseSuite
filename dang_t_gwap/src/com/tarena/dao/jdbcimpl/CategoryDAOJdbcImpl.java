package com.tarena.dao.jdbcimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.CategoryDAO;
import com.tarena.entity.Category;
import com.tarena.util.DbPoolUtil;

/**
 * d_category����Ϣ����
 * 
 * @author soft01
 * 
 */
public class CategoryDAOJdbcImpl extends BaseAction implements CategoryDAO {
	private static final long serialVersionUID = 7223501434109216229L;
	// ����turn�ҳ���Ʒ������
	private static final String findAll = "select * from d_category order by turn";
	// ��ѯ�������Ϣ�����Ұ�����Ʒ����
	// ��Ҫ���d_category_product��
	private static final String findByParentId = "select * from d_category "
			+ "where parent_id=? order by turn";
	// ��ѯ��Ʒ����
	private static final String findBookNumber = "select count(*) from "
			+ "d_category dc join d_category_product dcp on (dc.id="
			+ "dcp.cat_id) join d_product dp on (dcp.product_id=dp.id) "
			+ "join d_book db on (dp.id=db.id) where dc.id=?";
	// ͨ�����id�ҳ�ȫ����Ϣ
	private static final String findByCatId = "select * from d_category "
			+ "dc join d_category_product dcp on (dcp.cat_id=dc.id) "
			+ "where dc.id=?";
	// ͨ��id������
	private static final String findNameByCatId = "select name from "
			+ "d_category where id=?";

	/**
	 * ����turn�ҳ���Ʒ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findAll);
		// 4.ִ��������
		// 5.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while (set.next()) {
			// 6.��ֵ
			Category cat = new Category();
			cat.setId(set.getInt("id"));
			cat.setName(set.getString("name"));
			cat.setParentId(set.getInt("parent_id"));
			cat.setPnum(findBookNumber(set.getInt(1)));// ����ͳ�Ƴ���Ʒ����
			list.add(cat);
		}
		return list;
	}

	/**
	 * ͨ�������id����Ʒ������turn����
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(int pid) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findByParentId);
		// 4.���ò���
		stat.setInt(1, pid);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while (set.next()) {
			// 7.��ֵ
			Category cat = new Category();
			cat.setId(set.getInt("id"));
			cat.setTurn(set.getInt("turn"));
			cat.setEnName(set.getString("en_name"));
			cat.setName(set.getString("name"));
			cat.setDescription(set.getString("description"));
			cat.setParentId(set.getInt("parent_id"));
			// ������������ֵ
			cat.setPnum(findBookNumber(set.getInt(1)));// ����ͳ�Ƴ���Ʒ����
			list.add(cat);
		}
		return list;
	}

	/**
	 * ��ѯ��Ʒ����
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findCountByCatId(int cid) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findByCatId);
		// 4.���ò���
		stat.setInt(1, cid);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while (set.next()) {
			// 7.��ֵ
			Category cat = new Category();
			cat.setId(set.getInt("id"));
			cat.setTurn(set.getInt("turn"));
			cat.setEnName(set.getString("en_name"));
			cat.setName(set.getString("name"));
			cat.setDescription(set.getString("description"));
			cat.setParentId(set.getInt("parent_id"));
			// ������������ֵ
			cat.setPnum(findBookNumber(cid));// ����ͳ�Ƴ���Ʒ����
			list.add(cat);
		}
		return list.size();
	}

	/**
	 * ĳ����������������
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findBookNumber(int cid) throws Exception {
		int bookNum = 0;
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findBookNumber);
		// 4.���ò���
		stat.setInt(1, cid);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		while (set.next()) {
			bookNum = set.getInt(1);
		}
		return bookNum;
	}

	/**
	 * ͨ�����id�ҵ������
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public String findNameByCatId(Integer cid) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findNameByCatId);
		// 4.���ò���
		stat.setInt(1, cid);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		String name = "";
		if (set.next()) {
			name = set.getString(1);
		}
		return name;
	}
}
