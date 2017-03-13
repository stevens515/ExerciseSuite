package com.tarena.action.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;
import com.tarena.util.DAOFactory;

/**
 * �༭�Ƽ�recommend.jsp���ֵ���ʾ�߼�
 * 
 * @author soft01
 * 
 */
public class RecommendAction implements Serializable {
	private static final long serialVersionUID = -8707206896610682354L;
	private List<Book> books;// ���ڴ��������ɵ�������

	public String execute() {
		// ʵ����һ�����DAO����
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// ʵ������ļ��϶���
			books = new ArrayList<Book>();
			// �г����е���
			List<Book> list = bookDAO.findAll();
			// ���д�ѭ���ҳ�������
			for (int i = 0; i < 2; i++) {
				// 1.��������ĸ������ȡ����ĳ������
				// 2.�Ƴ�������λ�õ��鲢��ø���ľ�������
				// 3.�Ѵ�����뵽books������
				books.add(list.remove((int) (Math.random() * list.size())));
			}
			// ����recommend.jsp
			return "success";
		} catch (Exception e) {
			// ��¼��־
			Logger  logger=Logger.getLogger(RecommendAction.class);
			logger.error("�ڹ����༭�Ƽ�ͼ��ʱ�����쳣", e);
			// error.jsp
			return "error";
		}
	}

	// getter and setter
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

}
