package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DbPoolUtil;

/**
 * ��Ʒ��ʾ����Ϣ����
 * 
 * @author soft01
 * 
 */
public class ProductDAOJdbcImpl extends BaseAction implements ProductDAO,
		Serializable {
	private static final long serialVersionUID = -7080452519628045049L;

	// ��ѯ����
	private static final String findNewProduct = "select dp.* from "
			+ "d_product dp join d_book db on (dp.id=db.id) where "
			+ "has_deleted=0 order by add_time desc limit ?,?";
	// ��ѯ����
	private static final String findHotProduct = "select dp.*,"
			+ "sum(di.product_num) nums from d_item di join d_product "
			+ "dp on(di.product_id=dp.id) join d_book db on (dp.id=db.id) "
			+ "group by dp.id order by nums desc limit 4";
	// ��ѯ��������
	private static final String findNewHotProduct = "select dp.*,"
			+ "sum(di.product_num) nums from d_product dp join d_item "
			+ "di on(dp.id=di.product_id) join d_book db on (dp.id=db.id) "
			+ "where dp.add_time>? group by dp.id order by nums desc limit 8";
	// ͨ��id����Ʒ
	private static final String findProductById = "select * from d_product "
			+ "where id=?";

	/**
	 * ��ѯǰn�������ϼ���Ʒ
	 * 
	 * @param size
	 *            ��ȡǰn��
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewProduct(int size) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findNewProduct);
		// 4.���ò���
		stat.setInt(1, 0);
		stat.setInt(2, size);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		// 7.��ֵ
		List<Product> list = new ArrayList<Product>();
		while (set.next()) {
			Product pro = new Product();
			pro.setId(set.getInt("id"));
			pro.setProductName(set.getString("product_name"));
			pro.setDangPrice(set.getDouble("dang_price"));
			pro.setFixedPrice(set.getDouble("fixed_price"));
			pro.setDescription(set.getString("description"));
			pro.setAddTime(set.getLong("add_time"));
			pro.setProductPic(set.getString("product_pic"));
			pro.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				pro.setHasDeleted(false);
			} else {
				pro.setHasDeleted(true);
			}
			list.add(pro);
		}
		return list;
	}

	/**
	 * ��ѯǰn������ͼ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findHotProduct() throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql��䣬����������ֵ
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findHotProduct, PreparedStatement.RETURN_GENERATED_KEYS);
		// 4.ִ��������
		// 5.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Product> list = new ArrayList<Product>();
		// 6.��ֵ
		while (set.next()) {
			Product pro = new Product();
			pro.setId(set.getInt("id"));
			pro.setProductName(set.getString("product_name"));
			pro.setDangPrice(set.getDouble("dang_price"));
			pro.setFixedPrice(set.getDouble("fixed_price"));
			pro.setDescription(set.getString("description"));
			pro.setAddTime(set.getLong("add_time"));
			pro.setProductPic(set.getString("product_pic"));
			pro.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				pro.setHasDeleted(false);
			} else {
				pro.setHasDeleted(true);
			}
			list.add(pro);
		}
		return list;
	}

	/**
	 * ��ѯǰn����������ͼ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewHotProduct() throws Exception {
		// ������ʮ��֮ǰ��ʲôʱ��
		long thirthDayBefore = System.currentTimeMillis() - 30 * 24 * 60 * 60
				* 1000L;
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findNewHotProduct);
		// 4.���ò���
		stat.setLong(1, thirthDayBefore);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Product> list = new ArrayList<Product>();
		// 7.��ֵ
		while (set.next()) {
			Product pro = new Product();
			pro.setId(set.getInt("id"));
			pro.setProductName(set.getString("product_name"));
			pro.setDescription(set.getString("description"));
			pro.setAddTime(set.getLong("add_time"));
			pro.setFixedPrice(set.getDouble("fixed_price"));
			pro.setDangPrice(set.getDouble("dang_price"));
			pro.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				pro.setHasDeleted(false);
			} else {
				pro.setHasDeleted(true);
			}
			pro.setProductPic(set.getString("product_pic"));
			list.add(pro);
		}
		return list;
	}

	/**
	 * ͨ��id��ѯһ����Ʒ
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public Product findProductById(int pid) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findProductById);
		// 4.���ò���
		stat.setInt(1, pid);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		set.next();
		Product pro = new Product();
		pro.setId(set.getInt("id"));
		pro.setProductName(set.getString("product_name"));
		pro.setDescription(set.getString("description"));
		pro.setAddTime(set.getLong("add_time"));
		pro.setFixedPrice(set.getDouble("fixed_price"));
		pro.setDangPrice(set.getDouble("dang_price"));
		pro.setKeywords(set.getString("keywords"));
		if (set.getInt("has_deleted") == 0) {
			pro.setHasDeleted(false);
		} else {
			pro.setHasDeleted(true);
		}
		pro.setProductPic(set.getString("product_pic"));
		return pro;
	}

	// public static void main(String[] args) throws Exception {
	// ProductDAOImpl daoImpl = new ProductDAOImpl();
	// Product pro = daoImpl.findProductById(2);
	// System.out.println(pro.getProductName());
	// }
}
