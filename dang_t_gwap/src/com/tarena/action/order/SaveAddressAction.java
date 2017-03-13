package com.tarena.action.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.ReceiveAddress;
import com.tarena.util.DAOFactory;

/**
 * �������ڱ��涨����ַ��������Ϊd_receive_address
 * 
 * @author soft01
 * 
 */
public class SaveAddressAction implements Serializable {
	private static final long serialVersionUID = 7167335826449775537L;
	// �����ռ��˵�ַ�ļ���
	private List<ReceiveAddress> list = new ArrayList<ReceiveAddress>();
	private int id;
	// ͨ��id�ҳ�һ����ַ��Ȼ���͵�address_form.jsp
	private String msgStr;

	public String execute() {
		// ʵ����һ���ռ��˵�ַ�Ķ���
		ReceiveAddressDAO addressDAO = (ReceiveAddressDAO) DAOFactory
				.getInstance("ReceiveAddressDAO");
		try {
			// ��ȡ���е���Ϣ��ŵ�list���ϵ���
			list = addressDAO.findAll();
			// ���ӵ�address_form.jspҳ��
			return "success";
		} catch (Exception e) {
			// ����Logger���е��Թ���
			Logger logger = Logger.getLogger(SaveAddressAction.class);
			logger.error("��ȡ��Ϣʱ���ִ���", e);
			// ���ӵ�error.jspҳ��
			return "error";
		}
	}

	// ͨ��id�ҵ�һ���ռ��˵�ַ��Ϣ
	public String findById() {
		// ʵ��������
		ReceiveAddressDAO addressDAO = (ReceiveAddressDAO) DAOFactory
				.getInstance("ReceiveAddressDAO");
		try {
			// �ҳ��ռ��˵�ַ��ֵ���ռ��˵�ַ����
			ReceiveAddress receiveAddress = addressDAO.findById(id);
			// ���ռ��˵�ַ��Ϣ�����һ���ַ���
			msgStr = receiveAddress.toString();
			// ��json��ʽ����ajax�������
			return "success";
		} catch (Exception e) {
			// ��¼��־
			Logger logger = Logger.getLogger(SaveAddressAction.class);
			logger.error("ͨ��id���ռ��˵�ַʱ����", e);
			return "false";
		}
	}

	// getter and setter
	public void setList(List<ReceiveAddress> list) {
		this.list = list;
	}

	public List<ReceiveAddress> getList() {
		return list;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	public String getMsgStr() {
		return msgStr;
	}

}
