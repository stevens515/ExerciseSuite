package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;
import com.tarena.entity.Category;
import com.tarena.util.DAOFactory;
import com.tarena.util.DbPoolUtil;

/**
 * d_book��Ϣ����
 * 
 * @author soft01
 * 
 */
public class BookDAOJdbcImpl implements BookDAO,Serializable {
	private static final long serialVersionUID = -2833834404930676595L;
	// ͨ���������
	private static final String findByCatId = "select * from d_category_product "
			+ "dcp join d_product dp on (dcp.product_id=dp.id) join d_book "
			+ "db on(dp.id=db.id) where dcp.cat_id=? limit ?,?";
	// �г�ȫ����
	private static final String findAll = "select * from d_book db join "
			+ "d_product dp on (db.id=dp.id)";
	// ��ȡ��ҳ��
	private static final String getTotalPages = "select count(*) from "
			+ "d_category_product dcp join d_product dp on (dcp.product_id="
			+ "dp.id) join d_book db on(dp.id=db.id) where dcp.cat_id=?";
	// �鿴��ϸ��Ϣ
	private static final String findDetailById = "select * from d_product "
			+ "dp join d_book db on (dp.id=db.id) where db.id=?";
	// �鿴�丸�����
	private static final String findParentNameById = "select * from "
			+ "d_category where id=?";
	// ͨ��id�鿴���������
	private static final String findTotalNumById = "select sum(product_num) "
			+ "from d_item where product_id=? group by product_id";
	// ͨ��id������
	private static final String findNameById = "select dc.name from "
			+ "d_category dc join d_category_product dcp on (dc.id="
			+ "dcp.cat_id) join d_product dp on (dcp.product_id=dp.id) "
			+ "where dp.id=?";

	/**
	 * ͨ���������
	 * 
	 * @param cid
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<Book> findByCatId(int cid, int page, int size) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findByCatId);
		// 4.���ò���
		stat.setInt(1, cid);
		int begin = (page - 1) * size;
		stat.setInt(2, begin);
		stat.setInt(3, size);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Book> list = new ArrayList<Book>();
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		while (set.next()) {
			// 7.��ֵ
			Book book = new Book();
			// ����d_product������ֵ
			int id = set.getInt("id");
			book.setId(id);
			book.setBookNum(bookDAO.findTotalNumById(id));
			book.setProductName(set.getString("product_name"));
			book.setDangPrice(set.getDouble("dang_price"));
			book.setFixedPrice(set.getDouble("fixed_price"));
			book.setDescription(set.getString("description"));
			book.setAddTime(set.getLong("add_time"));
			book.setProductPic(set.getString("product_pic"));
			book.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				book.setHasDeleted(false);
			} else {
				book.setHasDeleted(true);
			}
			// ����d_book������ֵ
			book.setId(set.getInt("id"));
			book.setAuthor(set.getString("author"));
			book.setPublishing(set.getString("publishing"));
			book.setPublishTime(set.getLong("publish_time"));
			book.setWordNumber(set.getString("word_number"));
			book.setWhichEdtion(set.getString("which_edtion"));
			book.setTotalPage(set.getString("total_page"));
			book.setPrintTime(set.getInt("print_time"));
			book.setPrintNumber(set.getString("print_number"));
			book.setIsbn(set.getString("isbn"));
			book.setAuthorSummary(set.getString("author_summary"));
			book.setCatalogue(set.getString("catalogue"));
			// ����book����������ֵ
			list.add(book);
		}
		return list;
	}

	/**
	 * �г�ȫ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Book> findAll() throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findAll);
		// 4.ִ��������
		// 5.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (set.next()) {
			// 6.��ֵ
			Book book = new Book();
			// ����d_product������ֵ
			book.setId(set.getInt("id"));
			book.setProductName(set.getString("product_name"));
			book.setDangPrice(set.getDouble("dang_price"));
			book.setFixedPrice(set.getDouble("fixed_price"));
			book.setDescription(set.getString("description"));
			book.setAddTime(set.getLong("add_time"));
			book.setProductPic(set.getString("product_pic"));
			book.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				book.setHasDeleted(false);
			} else {
				book.setHasDeleted(true);
			}
			// ����d_book������ֵ
			book.setId(set.getInt("id"));
			book.setAuthor(set.getString("author"));
			book.setPublishing(set.getString("publishing"));
			book.setPublishTime(set.getLong("publish_time"));
			book.setWordNumber(set.getString("word_number"));
			book.setWhichEdtion(set.getString("which_edtion"));
			book.setTotalPage(set.getString("total_page"));
			book.setPrintTime(set.getInt("print_time"));
			book.setPrintNumber(set.getString("print_number"));
			book.setIsbn(set.getString("isbn"));
			book.setAuthorSummary(set.getString("author_summary"));
			book.setCatalogue(set.getString("catalogue"));
			// ����book����������ֵ
			list.add(book);
		}
		return list;
	}

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @param cid
	 * @param rowsPerPage
	 * @return
	 * @throws Exception
	 */
	public int getTotalPages(int cid, int rowsPerPage) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				getTotalPages);
		// 4.���ò���
		stat.setInt(1, cid);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		set.next();
		int totalRows = set.getInt(1);
		int totalPages;
		if (totalRows == 0) {
			totalPages = 1;
		} else {
			totalPages = totalRows % rowsPerPage == 0 ? totalRows / rowsPerPage
					: totalRows / rowsPerPage + 1;
		}
		return totalPages;
	}

	/**
	 * �鿴��ϸ��Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Book findDetailById(int id) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findDetailById);
		// 4.���ò���
		stat.setInt(1, id);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		set.next();
		Book book = new Book();
		// ����book������
		book.setId(id);
		book.setAuthor(set.getString("author"));
		book.setPublishing(set.getString("publishing"));
		book.setPublishTime(set.getLong("publish_time"));
		book.setWordNumber(set.getString("word_number"));
		book.setWhichEdtion(set.getString("which_edtion"));
		book.setTotalPage(set.getString("total_page"));
		book.setPrintTime(set.getInt("print_time"));
		book.setPrintNumber(set.getString("print_number"));
		book.setIsbn(set.getString("isbn"));
		book.setAuthorSummary(set.getString("author_summary"));
		book.setCatalogue(set.getString("catalogue"));

		// ����product������
		book.setProductName(set.getString("product_name"));
		book.setDescription(set.getString("description"));
		book.setAddTime(set.getLong("add_time"));
		book.setFixedPrice(set.getDouble("fixed_price"));
		book.setDangPrice(set.getDouble("dang_price"));
		book.setKeywords(set.getString("keywords"));
		if (set.getInt("has_deleted") == 0) {
			book.setHasDeleted(false);
		} else {
			book.setHasDeleted(true);
		}
		book.setProductPic(set.getString("product_pic"));
		return book;
	}

	/**
	 * �鿴�丸�����
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public String findParentName(Integer pid) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findParentNameById);
		// 4.���ò���
		stat.setInt(1, pid);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		Category cat = null;
		while (set.next()) {
			cat = new Category();
			cat.setId(set.getInt("id"));
			cat.setTurn(set.getInt("turn"));
			cat.setEnName(set.getString("en_name"));
			cat.setName(set.getString("name"));
			cat.setDescription(set.getString("description"));
			cat.setParentId(set.getInt("parent_id"));
		}
		return cat.getName();
	}

	/**
	 * ͨ��id�鿴���������
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int findTotalNumById(int id) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findTotalNumById);
		// 4.���ò���
		stat.setInt(1, id);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet rs = stat.executeQuery();

		int sum = 0;
		if (rs.next()) {
			sum = rs.getInt(1);
		}
		return sum;
	}

	/**
	 * ͨ��id������
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<String> findNameById(int id) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findNameById);
		// 4.���ò���
		stat.setInt(1, id);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		List<String> list = new ArrayList<String>();
		while (set.next()) {
			list.add(set.getString(1));
		}
		return list;
	}
}
