package com.tarena.action.main;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DAOFactory;

/**
 * �����ϼ�new.jsp����ʾ�߼�
 * 
 * @author soft01
 * 
 */
public class NewProductAction implements Serializable {
	private static final long serialVersionUID = 2211088643858860874L;
	// ��ȡ������8������뵽���ϵ���
	private List<Product> pros;

	public String execute() {
		// ʵ����һ����Ʒ��DAO����
		ProductDAO productDAO = (ProductDAO) DAOFactory
				.getInstance("ProductDAO");
		try {
			// ͨ��dao�������findNewProduct����ȡ��8����
			setPros(productDAO.findNewProduct(8));
			for (Product product : pros) {
				System.out.println(product.getId() + " "
						+ product.getProductName());
			}
			// new.jsp��ʾ
			return "success";
		} catch (Exception e) {
			// �����˼�¼��־��ת��error.jsp
			Logger logger = Logger.getLogger(NewProductAction.class);
			logger.error("�ڹ��������ʱ����˵��쳣", e);
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
