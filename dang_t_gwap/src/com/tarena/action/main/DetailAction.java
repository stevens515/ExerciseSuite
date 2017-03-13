package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;
import com.tarena.util.DAOFactory;

/**
 * �鼮��ϸ
 * 
 * @author soft01
 * 
 */
public class DetailAction implements Serializable {
	private static final long serialVersionUID = 7267484624980612551L;
	private Book book;
	private int id;
	private String name;

	public String execute() {
		// ����BookDAO����
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// ͨ��id���鼮��ϸ
			book = bookDAO.findDetailById(id);
			// ��ȡ���ػ������������
			List<String> names = bookDAO.findNameById(id);
			name = names.get(2) + ">>" + names.get(1) + ">>" + names.get(0);
			// ���ӵ�book_info.jsp
			return "success";
		} catch (Exception e) {
			// ��¼��־
			Logger logger = Logger.getLogger(DetailAction.class);
			logger.error("�������ݿ�ʱ����һ����쳣", e);
			return "error";
		}
	}

	// getter and setter
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
