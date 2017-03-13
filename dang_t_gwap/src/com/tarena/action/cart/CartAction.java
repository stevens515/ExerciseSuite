package com.tarena.action.cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.action.BaseAction;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartServiceImpl;
import com.tarena.service.impl.CartItem;
import com.tarena.util.Constant;
import com.tarena.util.CookieUtil;

/**
 * �Թ��ﳵ�Ĺ��������cart_list.jsp
 * 
 * @author soft01
 * 
 */
public class CartAction extends BaseAction {
	private static final long serialVersionUID = 5439995935441058652L;
	private int id;// input
	private int pnum;// input
	private boolean ok = false;
	private boolean flag;
	private List<CartItem> buyPro;// �������Ʒ
	private List<CartItem> delPro;// ɾ������Ʒ
	private CartService cartService;
	private double cartCost;// ����Ǯ��

	public String execute() {
		try {
			// ʵ�������ﳵ����
			cartService = CartServiceImpl.getInstance(session, request);
			init();
		} catch (UnsupportedEncodingException e) {
			Logger logger = Logger.getLogger(CartAction.class);
			logger.error("��֧��utf-8����", e);
		}
		return "success";
	}

	// ������
	public String add() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// ��Ӳ���
		flag = cartService.add(id);
		// ���cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		if (flag) {
			ok = true;
			// ����json���
			return "success";
		} else {
			return "error";
		}
	}

	// ���´���
	public String update() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// ����
		flag = cartService.update(id, pnum);
		// ��ʼ������
		init();
		// ���cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		if (flag) {
			// ����json���
			return "success";
		} else {
			return "error";
		}
	}

	// ɾ������
	public String delete() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// ɾ��
		flag = cartService.delete(id);
		// ���cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		// ��ʼ������
		init();
		if (flag) {
			// ����json���
			return "success";
		} else {
			return "error";
		}
	}

	// �ָ�����
	public String recovery() throws UnsupportedEncodingException {
		cartService = CartServiceImpl.getInstance(session, request);
		// �ָ�
		flag = cartService.recovery(id);
		// ���cookie
		CookieUtil.addCookie(Constant.SESSION_CART, cartService.store(),
				response);
		// ��ʼ��
		init();
		if (flag) {
			// ����json���
			return "success";
		} else {
			return "error";
		}
	}

	private void init() {
		// ��ȡ��ǰ���ﳵ�е������Ѿ������ɾ������Ʒ
		buyPro = cartService.getItems(true);
		delPro = cartService.getItems(false);
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setBuyPro(List<CartItem> buyPro) {
		this.buyPro = buyPro;
	}

	public List<CartItem> getBuyPro() {
		return buyPro;
	}

	public void setDelPro(List<CartItem> delPro) {
		this.delPro = delPro;
	}

	public List<CartItem> getDelPro() {
		return delPro;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public void setCartCost(double cartCost) {
		this.cartCost = cartCost;
	}

	public double getCartCost() {
		return cartCost;
	}

}
