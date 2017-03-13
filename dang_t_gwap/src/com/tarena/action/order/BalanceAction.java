package com.tarena.action.order;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.tarena.action.BaseAction;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartItem;
import com.tarena.service.impl.CartServiceImpl;

/**
 * �������ʱ���е�action����
 * 
 * @author soft01
 * 
 */
public class BalanceAction extends BaseAction {
	private static final long serialVersionUID = 2025409779948165807L;
	// ���������Ʒ����ϸ�ļ���
	private List<CartItem> list;
	// ���ﳵ����������
	private CartService cartService;

	public String execute() {
		// ��ȡ��ǰ�������е�session
		session = ActionContext.getContext().getSession();
		try {
			// �������ﳵ��ʵ������
			setCartService(CartServiceImpl.getInstance(session, request));
		} catch (UnsupportedEncodingException e) {
			Logger logger = Logger.getLogger(BalanceAction.class);
			logger.error("��֧��utf-8�������", e);
		}
		// �鿴���ﳵ�еĹ������Ʒ�ļ���
		list = cartService.getItems(true);
		// ����˼���Ϊ��
		if (list.size() == 0) {
			// ���ӵ�main.jsp
			return "main";
		}
		// ���ӵ�order_info.jsp
		return "success";
	}

	// getter and setter
	public void setList(List<CartItem> list) {
		this.list = list;
	}

	public List<CartItem> getList() {
		return list;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public CartService getCartService() {
		return cartService;
	}

}
