package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.BookDAO;
import com.tarena.dao.SortDAO;
import com.tarena.entity.Book;
import com.tarena.util.DAOFactory;
import com.tarena.util.DbPoolUtil;

/**
 * רΪ�����׼����DAO����
 * 
 * @author soft01
 * 
 */
public class SortDAOJdbcImpl implements SortDAO, Serializable {
	private static final long serialVersionUID = 5451454187654662279L;

	/**
	 * book_listҳ�������
	 * 
	 * @param cid
	 *            ���id
	 * @param page
	 *            ��ҳ��
	 * @param size
	 *            ÿҳ��С
	 * @param rule
	 *            �������
	 * @return ����һ����ļ���
	 * @throws Exception
	 */
	public List<Book> order(int cid, int page, int size, int rule)
			throws Exception {
		// ����������
		PreparedStatement stat;
		String str = null;
		// ͨ�����id�ҵ�ȫ����
		String byCatId = "select dp.*,db.* from d_category_product dcp"
				+ " join d_product dp on (dcp.product_id=dp.id)"
				+ " join d_book db on(dp.id=db.id) where"
				+ " dcp.cat_id=? limit ?,?";
		if (rule == 1) {
			// ���������
			// 1.��������
			// 2.����������
			// 3.����sql���
			stat = DbPoolUtil.getConnection().prepareStatement(byCatId);
			// 4.���ò���
			stat.setInt(1, cid);
			int begin = (page - 1) * size;
			stat.setInt(2, begin);
			stat.setInt(3, size);
		} else if (rule == 2) {
			// ���ϼ�ʱ�併��
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.add_time desc limit ?,?";
			// 1.��������
			// 2.����������
			// 3.����sql���
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.���ò���
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else if (rule == 3) {
			// ���ϼ�ʱ������
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.add_time limit ?,?";
			// 1.��������
			// 2.����������
			// 3.����sql���
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.���ò���
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else if (rule == 4) {
			// ���ּ۽���
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.dang_price desc limit ?,?";
			// 1.��������
			// 2.����������
			// 3.����sql���
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.���ò���
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else if (rule == 5) {
			// ���ּ�����
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.dang_price limit ?,?";
			// 1.��������
			// 2.����������
			// 3.����sql���
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.���ò���
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else {
			// ����������
			str = "select dp.*,db.*,di.*,sum(di.product_num) nums from"
					+ " d_item di join d_product dp on(di.product_id=dp.id)"
					+ " join d_book db on (dp.id=db.id) group by dp.id order"
					+ " by nums desc limit ?,?";
			// 1.��������
			// 2.����������
			// 3.����sql���
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.���ò���
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		}
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		List<Book> list = new ArrayList<Book>();
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		// 7.��book��ֵ
		while (set.next()) {
			Book book = new Book();
			// ����d_product������ֵ
			book.setBookNum(bookDAO.findTotalNumById(set.getInt("id")));
			book.setId(set.getInt("id"));
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
			// ����d_book������ֵ
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

	// public static void main(String[] args) throws Exception {
	// SortDAO sortDAO = (SortDAO) DAOFactory.getInstance("SortDAO");
	// List<Book> list = sortDAO.order(9, 1, 10, 6);
	// for (Book book : list) {
	// System.out.println(book.getDangPrice());
	// }
	// }
}
