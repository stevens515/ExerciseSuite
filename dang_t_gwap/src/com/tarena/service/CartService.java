package com.tarena.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.tarena.service.impl.CartItem;
/**
 * ���ﳵcart_list.jsp����ʾ�߼�
 * @author soft01
 *
 */
public interface CartService {

	/**
	 * ������Ʒ
	 * 
	 * @param pid
	 *            ������Ʒ��id
	 * @return ����ɹ�����ʧ��
	 */
	public boolean add(int pid);

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
			throws UnsupportedEncodingException;

	/**
	 * ɾ��
	 * 
	 * @param pid
	 * @return
	 */
	public boolean delete(int pid);

	/**
	 * �ָ�
	 * 
	 * @param pid
	 * @return
	 */
	public boolean recovery(int pid);

	/**
	 * ���㹺����Ʒ���ܶ�
	 * 
	 * @return
	 */
	public double countCost();

	/**
	 * �����ʡ���
	 * 
	 * @return
	 */
	public double countSales();

	/**
	 * ���ع���/ɾ��״̬�ļ���
	 * 
	 * @param buy
	 *            true����,falseɾ��
	 * @return
	 */
	public List<CartItem> getItems(boolean buy);

	/**
	 * ��չ��ﳵ�߼�
	 * 
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean clear(HttpServletResponse response)
			throws UnsupportedEncodingException;

	/**
	 * ����content(���� "3,8;4,11;9,2"�������ַ���)
	 * 
	 * ���»ָ�cart���û����������Ʒ����items���ϡ�
	 * 
	 * @param content
	 */
	public void load(String content);

	/**
	 * ��cart�е�������Ʒ��Ϣ����items�����е�����ת���һ������
	 * 
	 * "3,8;4,11;9,2"�������ַ������������Ϊ�գ�����"0"��
	 * 
	 * @return
	 */
	public String store();
}
