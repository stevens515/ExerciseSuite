package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.ReceiveAddress;
import com.tarena.util.DbPoolUtil;

/**
 * Ϊd_receive_address��������DAO
 * 
 * @author soft01
 * 
 */
public class ReceiveAddressDAOJdbcImpl implements ReceiveAddressDAO, Serializable {
	private static final long serialVersionUID = -588456186499953201L;
	// ���û����������
	private static final String insert = "insert into d_receive_address"
			+ "(user_id,receive_name,full_address,postal_code,mobile,phone) "
			+ "values(?,?,?,?,?,?)";
	// �г�ȫ������
	private static final String findAll = "select * from "
			+ "d_receive_address";
	// ͨ��id��һ����ַ
	private static final String findById = "select * from "
			+ "d_receive_address where id=?";

	/**
	 * �����ռ��˵�ַ��Ϣ
	 * 
	 * @param receiveAddress
	 *            �ռ��˵�ַ����
	 * @throws Exception
	 */
	public void insert(ReceiveAddress receiveAddress) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				insert);
		// 4.���ò���
		stat.setInt(1, receiveAddress.getUserId());
		stat.setString(2, receiveAddress.getReceiveName());
		stat.setString(3, receiveAddress.getFullAddress());
		stat.setString(4, receiveAddress.getPostalCode());
		stat.setString(5, receiveAddress.getMobile());
		stat.setString(6, receiveAddress.getPhone());
		// 5.ִ��������
		stat.executeUpdate();
	}

	/**
	 * �г�ȫ���ռ��˵�ַ
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReceiveAddress> findAll() throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findAll);
		// 4.ִ��������
		// 5.���ؽ����
		ResultSet set = stat.executeQuery();
		List<ReceiveAddress> list = new ArrayList<ReceiveAddress>();
		// 6.ΪReceiveAddress��ֵ
		while (set.next()) {
			ReceiveAddress receiveAddress = new ReceiveAddress();
			int id = set.getInt("id");
			receiveAddress.setId(id);
			receiveAddress.setUserId(set.getInt("user_id"));
			receiveAddress.setReceiveName(set.getString("receive_name"));
			receiveAddress.setFullAddress(set.getString("full_address"));
			receiveAddress.setPostalCode(set.getString("postal_code"));
			receiveAddress.setMobile(set.getString("mobile"));
			receiveAddress.setPhone(set.getString("phone"));
			list.add(receiveAddress);
		}
		return list;
	}

	/**
	 * ͨ��id��һ���ռ��˵�ַ
	 * 
	 * @param id
	 *            �ռ��˵�ַ��id
	 * @return
	 * @throws Exception
	 */
	public ReceiveAddress findById(int id) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findById);
		// 4.���ò���
		stat.setInt(1, id);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		set.next();
		// 7.ΪReceiveAddress��ֵ
		ReceiveAddress receiveAddress = new ReceiveAddress(set
				.getInt("user_id"), set.getString("receive_name"), set
				.getString("full_address"), set.getString("postal_code"), set
				.getString("mobile"), set.getString("phone"));
		return receiveAddress;
	}

}
