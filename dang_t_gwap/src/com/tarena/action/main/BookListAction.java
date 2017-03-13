package com.tarena.action.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.action.BaseAction;
import com.tarena.dao.BookDAO;
import com.tarena.dao.CategoryDAO;
import com.tarena.dao.SortDAO;
import com.tarena.entity.Book;
import com.tarena.entity.Category;
import com.tarena.util.DAOFactory;

/**
 * ��book_list.jspҳ�����ʾ�߼�
 * 
 * @author soft01
 * 
 */
public class BookListAction extends BaseAction {
	private static final long serialVersionUID = 7591352879827939606L;
	private Integer cid;// ��ǰ���ID
	private Integer pid;// ��ǰ���ĸ�ID
	private int page = 1;// ��ǰҳ
	private int maxPage = 1;// ���ҳ
	private List<Category> cats;// ����book_list.jsp������������
	private List<Book> pros;// ����book_list.jsp���Ҳ��Ʒ����
	private int allSum;// ��������������Ĳ�Ʒ����֮��
	// Action����ע��
	private int size = 5;// ÿҳ5��
	private String pname;
	private int rule;
	private String cname;

	public String execute() {
		CategoryDAO categoryDAO = (CategoryDAO) DAOFactory
				.getInstance("CategoryDAO");// ʵ����һ������DAO����
		// ʵ����һ�����DAO����
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// ���ݸ�ID��ȡҳ�������ֵܲ˵���
			cats = categoryDAO.findByParentId(pid);
			// ͳ��allSum����������Ʒ�ϼ�
			allSum = categoryDAO.findCountByCatId(pid);
			// ���ݵ�ǰID��ȡҳ���Ҳ��ͼ����Ϣ
			cname = categoryDAO.findNameByCatId(cid);

			// ���ݰ�
			session.put("cid", cid);
			session.put("page", page);
			session.put("size", size);
			session.put("pid", pid);
			pros = bookDAO.findByCatId(cid, page, size);
			// ͳ�����ҳ��
			maxPage = bookDAO.getTotalPages(cid, 3);
			pname = bookDAO.findParentName(pid);
			// ���ӵ�book_list.jsp
			return "success";
		} catch (Exception e) {
			Logger logger=Logger.getLogger(BookListAction.class);
			logger.error("�ڲ������ݿ�ʱ�������쳣", e);
			return "error";
		}
	}

	// �������
	public String sort() {
		// ��ȡsession�еĶ���
		page = (Integer) session.get("page");
		cid = (Integer) session.get("cid");
		pid = (Integer) session.get("pid");
		SortDAO sortDAO = (SortDAO) DAOFactory.getInstance("SortDAO");
		// ʵ����һ������DAO����
		CategoryDAO categoryDAO = (CategoryDAO) DAOFactory
				.getInstance("CategoryDAO");
		// ʵ����һ�����DAO����
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		try {
			// ���ݸ�ID��ȡҳ�������ֵܲ˵���
			cats = categoryDAO.findByParentId(pid);
			// ͳ��allSum����������Ʒ�ϼ�
			allSum = categoryDAO.findCountByCatId(pid);
			// ���ݵ�ǰID��ȡҳ���Ҳ��ͼ����Ϣ
			// ͳ�����ҳ��
			maxPage = bookDAO.getTotalPages(cid, 3);
			// �����
			cname = categoryDAO.findNameByCatId(cid);
			// ������
			pname = bookDAO.findParentName(pid);
			// ����
			pros = sortDAO.order(cid, page, size, rule);
			// ���ӵ�book_list.jsp
			return "success";
		} catch (Exception e) {
			Logger logger=Logger.getLogger(BookListAction.class);
			logger.error("�ڲ������ݿ�ʱ���˵��쳣", e);
			return "error";
		}
	}

	// getter and setter
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public List<Book> getPros() {
		return pros;
	}

	public void setPros(List<Book> pros) {
		this.pros = pros;
	}

	public int getAllSum() {
		return allSum;
	}

	public void setAllSum(int allSum) {
		this.allSum = allSum;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPname() {
		return pname;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public int getRule() {
		return rule;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return cname;
	}
}
