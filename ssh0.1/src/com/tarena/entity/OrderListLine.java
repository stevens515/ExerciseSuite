package com.tarena.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * һ��ҳ������Ҫ�ü������ϵ�ĳЩ�ֶΣ����ǿ��԰����ǳ�ȡ��һ����
 * @author soft01
 *
 */
public class OrderListLine {	
	private Integer id;
	private String nickname;
	private Date orderTime;
	private BigDecimal totalPrice;//���ȸ�
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
