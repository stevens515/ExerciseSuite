package cn.itcast.dao;

import java.sql.Connection;
import java.util.List;

import cn.itcast.domain.Book;
import cn.itcast.util.QueryResult;

public interface BookDao {
	void saveBook(Connection conn, Book book);

	List<Book> findAllBooks(Connection conn);
	/**
	 * ͨ��ͼ��id��ȡ ͼ����Ϣ
	 * @param conn
	 * @param id
	 * @return
	 */
	Book findBookById(Connection conn,String id);
	/**
	 * �޸�ͼ����Ϣ
	 * @param conn
	 * @param book
	 */
	void updateBook(Connection conn,Book book);
	
	/**
	 * �ܹ�idɾ��ͼ����Ϣ
	 * @param conn
	 * @param id
	 */
	void deleteBookById(Connection conn,String id);
	
	/**
	 * 	�÷���ִ�д���ҳ�Ĳ�ѯ
	 * @param conn
	 * @param beginIndex
	 * @param maxSize
	 * @param category_id
	 * @return
	 */
	QueryResult<Book> findPageBooksByCondition(Connection conn,
			Integer beginIndex,Integer maxSize,String category_id);
	
}
