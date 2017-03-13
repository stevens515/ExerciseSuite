package com.tarena.action.order;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.action.BaseAction;
import com.tarena.dao.ItemDAO;
import com.tarena.dao.OrderDAO;
import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.Item;
import com.tarena.entity.Order;
import com.tarena.entity.ReceiveAddress;
import com.tarena.entity.User;
import com.tarena.service.CartService;
import com.tarena.service.impl.CartItem;
import com.tarena.service.impl.CartServiceImpl;
import com.tarena.util.DAOFactory;

/**
 * ��address_form.jsp����Ϣ��ȡ���������ݿ�
 * 
 * @author soft01
 * 
 */
public class AddrFormAction extends BaseAction {
	private static final long serialVersionUID = 4734342926827189957L;
	private String receiveName;// �ռ�������
	private String fullAddress;// �ռ��˵�ַ
	private String postalCode;// �ռ�����������
	private String phone;// �ռ��˵绰
	private String mobile;// �ռ����ֻ�
	private double totalPrice;
	private CartService cartService;
	private List<CartItem> buyPro;
	private int orderId;
	private int address;

	public String execute() {
		// ��session�л�ȡUser
		User user = (User) session.get("user");
		int userId = user.getId();

		// �����ռ��˵�ַ����
		ReceiveAddress receiveAddress = new ReceiveAddress(userId, receiveName,
				fullAddress, postalCode, mobile, phone);
		// ������Ӷ����������ϸΪfalse
		boolean addOrder = false;
		boolean addItem = false;
		try {
			addOrder = addOrder(receiveAddress);
			addItem = addItem();
		} catch (UnsupportedEncodingException e) {
			// ��¼��־
			Logger logger = Logger.getLogger(AddrFormAction.class);
			logger.error("��֧��utf-8����", e);
		}
		try {
			// ���������չ��ﳵ
			cartService.clear(response);
		} catch (UnsupportedEncodingException e) {
			// ��¼��־
			Logger logger = Logger.getLogger(AddrFormAction.class);
			logger.error("��֧��utf-8����", e);
		}
		if (buyPro.size() == 0) {
			// ������ﳵ����Ʒ��СΪ0�����ӵ�main.jsp
			return "main";
		} else if (addOrder && addItem) {
			// �����ӳɹ������ӵ�order_ok.jsp
			return "success";
		} else {
			// ���ӵ�error.jsp
			return "error";
		}
	}

	/**
	 * ��Ӷ���
	 * 
	 * @param receiveAddress
	 *            �ռ��˵�ַ����
	 * @return ����һ��booleanֵ
	 * @throws UnsupportedEncodingException
	 *             ��֧��utf-8����
	 */
	private boolean addOrder(ReceiveAddress receiveAddress)
			throws UnsupportedEncodingException {
		// ��������DAO����
		OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance("OrderDAO");
		// ���������˵�ַDAO����
		ReceiveAddressDAO receiveAddressDAO = (ReceiveAddressDAO) DAOFactory
				.getInstance("ReceiveAddressDAO");
		// ʵ�������ﳵ����
		cartService = CartServiceImpl.getInstance(session, request);
		// �鿴���ﳵ����Ʒ���ܼ�
		totalPrice = cartService.countCost();
		// ������������
		Order order = new Order(receiveAddress.getUserId(), receiveAddress
				.getReceiveName(), receiveAddress.getFullAddress(),
				receiveAddress.getPostalCode(), receiveAddress.getMobile(),
				receiveAddress.getPhone(), totalPrice);
		try {
			// ��Ӷ���
			orderId = orderDAO.createOrder(order);
			// ���ѡ���������µ�ַ
			if (address == 0) {
				// �ѵ�ַ�ӵ����ݱ���
				receiveAddressDAO.insert(receiveAddress);
				return true;
			}
			return true;
		} catch (Exception e) {
			Logger logger = Logger.getLogger(AddrFormAction.class);
			logger.error("���涨���͵�ַ��ʱ����˵��쳣", e);
			return false;
		}
	}

	private boolean addItem() throws UnsupportedEncodingException {
		// �������ﳵ����
		cartService = CartServiceImpl.getInstance(session, request);
		// �鿴���ﳵ���Ѿ��������Ʒ
		buyPro = cartService.getItems(true);
		// ��������
		ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance("ItemDAO");
		// ��buyPro����
		for (int i = 0; i < buyPro.size(); i++) {
			// ��ÿ�����ﳵ����ϸ������
			CartItem cartItem = buyPro.get(i);
			Item item = new Item(orderId, cartItem.getPro().getId(), cartItem
					.getPro().getProductName(), cartItem.getPro()
					.getDangPrice(), cartItem.getQty(), cartItem.getPro()
					.getDangPrice()
					* cartItem.getQty());
			try {
				// ��������
				itemDAO.insert(item);
				// ����������һ������ʱ����һ��true
				if (i == buyPro.size() - 1) {
					return true;
				}
			} catch (Exception e) {
				Logger logger = Logger.getLogger(AddrFormAction.class);
				logger.error("����Ӷ�����ϸʱ����һ���쳣", e);
				return false;
			}
		}
		return false;
	}

	// getter and setter
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public List<CartItem> getBuyPro() {
		return buyPro;
	}

	public void setBuyPro(List<CartItem> buyPro) {
		this.buyPro = buyPro;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getAddress() {
		return address;
	}

}
