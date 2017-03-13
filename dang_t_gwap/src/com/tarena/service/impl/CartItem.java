package com.tarena.service.impl;

import java.io.Serializable;

import com.tarena.entity.Product;

public class CartItem implements Serializable {
	private static final long serialVersionUID = -5961734667623410043L;
	private Product pro;// ��Ʒ
	private int qty = 1;// ��������
	private boolean buy = true;// �Ƿ���

	// �����ǹ�����
	public CartItem() {
	}

	public CartItem(Product pro) {
		this.pro = pro;
	}

	public CartItem(int qty, Product pro) {
		this.qty = qty;
		this.pro = pro;
	}

	public CartItem(int qty, Product pro, boolean buy) {
		this.qty = qty;
		this.pro = pro;
		this.buy = buy;
	}

	// ������getter and setter
	public void setPro(Product pro) {
		this.pro = pro;
	}

	public Product getPro() {
		return pro;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	public boolean isBuy() {
		return buy;
	}

}
