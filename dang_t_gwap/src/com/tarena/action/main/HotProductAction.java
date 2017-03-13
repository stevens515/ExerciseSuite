package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DAOFactory;

/**
 * ����ͼ��hot.jsp����ʾ�߼�
 * 
 * @author soft01
 * 
 */
public class HotProductAction implements Serializable {
	private static final long serialVersionUID = 929243047619563046L;
	//���ڴ������ͼ��ļ���
	private List<Product> products;

	public String execute() {
		//ʵ����һ����Ʒ��DAO����
		ProductDAO productDAO = (ProductDAO) DAOFactory
				.getInstance("ProductDAO");
		try {
			//���÷����ѽ����ӵ�������
			products = productDAO.findHotProduct();
			// ���ӵ�hot.jsp
			return "success";
		} catch (Exception e) {
			// ��¼��־
			Logger logger=Logger.getLogger(HotProductAction.class);
			logger.error("�ڲ�������ͼ���ʱ������쳣", e);
			return "error";
		}
	}

	// getter and setter
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}
}
