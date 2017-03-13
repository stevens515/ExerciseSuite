package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DAOFactory;

/**
 * ����������newhot.jsp����ʾ�߼�
 * 
 * @author soft01
 * 
 */
public class NewHotProductAction implements Serializable {
	private static final long serialVersionUID = -4106185149840831938L;
	// ���ҵ��������ŵ����ϵ���
	private List<Product> pros;

	public String execute() {
		// ʵ����һ����Ʒ��DAO����
		ProductDAO productDAO = (ProductDAO) DAOFactory
				.getInstance("ProductDAO");
		try {
			// ���÷�����ȡ����������ͼ��
			pros = productDAO.findNewHotProduct();
			// ���ӵ�newhot.jsp
			return "success";
		} catch (Exception e) {
			// ��¼��־
			Logger logger=Logger.getLogger(NewHotProductAction.class);
			logger.error("�ڲ�������������ͼ��ʱ�����쳣", e);
			// ���ӵ�error.jsp
			return "error";
		}
	}

	// getter and setter 
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}

	public List<Product> getPros() {
		return pros;
	}
}
