package com.tarena.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.service.CartService;
import com.tarena.util.Constant;
import com.tarena.util.CookieUtil;
import com.tarena.util.DAOFactory;

/**
 * ���ﳵcart_list.jsp����ʾ�߼�
 * 
 * @author soft01
 * 
 */
public class CartServiceImpl implements CartService {
	private static final long serialVersionUID = -7203518833040195267L;
	private List<CartItem> store = new ArrayList<CartItem>();

	// �޲���������
	public CartServiceImpl() {
		
	}

	// �������ﳵʵ������
	public static CartService getInstance(Map<String, Object> session,
			HttpServletRequest request) throws UnsupportedEncodingException {
		CartService cart = (CartService) session.get(Constant.SESSION_CART);
		if (cart == null) {
			// �����һ�ι���
			cart = (CartService) DAOFactory.getInstance("CartService");
			// ȥ����������е�cookie
			cart.load(CookieUtil.findCookie(Constant.SESSION_CART, request));
			// �ѹ��ﳵ����session
			session.put(Constant.SESSION_CART, cart);
		}
		return cart;
	}

	/**
	 * ������Ʒ
	 * 
	 * @param pid
	 *            ������Ʒ��id
	 * @return ����ɹ�����ʧ��
	 */
	public boolean add(int pid) {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// �����
			if (item.getPro().getId() == pid) {
				item.setBuy(true);
				item.setQty(item.getQty() + 1);
				return true;
			}
		}

		try {
			// ��һ�ι���
			Product pro = new Product();
			ProductDAO productDAO = (ProductDAO) DAOFactory
					.getInstance("ProductDAO");
			pro = productDAO.findProductById(pid);
			CartItem item = new CartItem(1, pro, true);
			store.add(item);
		} catch (Exception e) {
			Logger logger = Logger.getLogger(CartServiceImpl.class);
			logger.error("������Ʒʧ��", e);
		}
		return true;
	}

	/**
	 * ���㹺����Ʒ���ܶ�
	 * 
	 * @return
	 */
	public double countCost() {
		double sum = 0;
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// ����store����,ͳ��buy=true��Ԫ�ؽ��
			if (item.isBuy() == true) {
				sum += item.getPro().getDangPrice() * item.getQty();
			}
		}
		return sum;
	}

	/**
	 * �����ʡ���
	 * 
	 * @return
	 */
	public double countSales() {
		double sum = 0;
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// ����store����,ͳ��buy=true��Ԫ��
			if (item.isBuy() == true) {
				// ͳ�ƽ�ʡ��(fixedPrice-dangPrice)*����
				sum += (item.getPro().getFixedPrice() - item.getPro()
						.getDangPrice())
						* item.getQty();
			}
		}
		return sum;
	}

	/**
	 * ɾ��
	 * 
	 * @param pid
	 * @return
	 */
	public boolean delete(int pid) {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			if (item.getPro().getId() == pid) {
				// �ҵ�pid��Ӧ��item����,�޸�buy=false
				item.setBuy(false);
			}
		}
		return true;
	}

	/**
	 * ���ع���/ɾ��״̬�ļ���
	 * 
	 * @param buy
	 *            true����,falseɾ��
	 * @return
	 */
	public List<CartItem> getItems(boolean buy) {
		List<CartItem> list = new ArrayList<CartItem>();
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// ��store ������buy���Ե���buy������Ԫ�ط���
			if (item.isBuy() == buy) {
				list.add(item);
			}
		}
		return list;
	}

	/**
	 * �ָ�
	 * 
	 * @param pid
	 * @return
	 */
	public boolean recovery(int pid) {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			if (item.getPro().getId() == pid) {
				// �ҵ�pid��Ӧ��item����,�޸�buy=true
				item.setBuy(true);
			}
		}
		return true;
	}

	/**
	 * ���¹�������
	 * 
	 * @param pid
	 *            ������Ʒ��id
	 * @param pnum
	 *            ���������
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean update(int pid, int pnum)
			throws UnsupportedEncodingException {
		for (int i = 0; i < store.size(); i++) {
			CartItem item = store.get(i);
			// pid��Ӧ��item����,�޸�qty=pnum
			if (item.getPro().getId() == pid) {
				item.setQty(pnum);
				return true;
			}
		}
		return false;
	}

	/**
	 * ��չ��ﳵ�߼�
	 * 
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean clear(HttpServletResponse response)
			throws UnsupportedEncodingException {
		// ���Cookie
		CookieUtil.deleteCookie(Constant.SESSION_CART, response);
		store.clear();
		return true;
	}

	/**
	 * ��cart�е�������Ʒ��Ϣ����items�����е�����ת���һ������
	 * 
	 * "3,8;4,11;9,2"�������ַ������������Ϊ�գ�����"0"��
	 * 
	 * @return
	 */
	public String store() {
		StringBuffer sb = new StringBuffer();
		if (store.size() == 0) {
			sb.append("0");
		} else {
			for (int i = 0; i < store.size(); i++) {
				CartItem item = store.get(i);
				sb.append(item.getPro().getId() + "," + item.getQty() + ","
						+ item.isBuy() + ";");
			}
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * ����content(���� "3,8;4,11;9,2"�������ַ���)
	 * 
	 * ���»ָ�cart���û����������Ʒ����items���ϡ�
	 * 
	 * @param content
	 */
	public void load(String content) {
		if (content == null || content.equals("0")) {
			return;
		}
		String[] pcs = content.split(";");
		CartItem item = null;
		for (int i = 0; i < pcs.length; i++) {
			String pc = pcs[i];
			String[] strs = pc.split(",");
			int id = Integer.parseInt(strs[0]);
			int qty = Integer.parseInt(strs[1]);
			boolean buy = Boolean.parseBoolean(strs[2]);

			ProductDAO productDAO = (ProductDAO) DAOFactory
					.getInstance("ProductDAO");
			try {
				Product pro = productDAO.findProductById(id);
				item = new CartItem();
				item.setPro(pro);
				item.setQty(qty);
				item.setBuy(buy);
				store.add(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ������getter and setter
	public void setStore(List<CartItem> store) {
		this.store = store;
	}

	public List<CartItem> getStore() {
		return store;
	}

}
