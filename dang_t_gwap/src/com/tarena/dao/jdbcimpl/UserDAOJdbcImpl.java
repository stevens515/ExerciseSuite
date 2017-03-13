package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DbPoolUtil;

/**
 * ��������û�������������Ϣ
 * 
 * @author soft01
 * 
 */
public class UserDAOJdbcImpl implements UserDAO, Serializable {
	private static final long serialVersionUID = 760277934329265703L;
	// ��user���в�������(ע��)
	private static final String INSERT = "insert into d_user(email,"
			+ "nickname,password,user_integral,is_email_verify,"
			+ "email_verify_code,last_login_time,last_login_ip)"
			+ "values(?,?,?,?,?,?,?,?)";
	// ͨ��email��һ��User(��֤email�Ϸ���)
	private static final String FIND_BY_EMAIL = "select * from d_user "
			+ "where email=?";
	// ͨ��nickname��һ��User(��֤nickname�Ϸ��ԣ��������ֲ�����ʹ�ô�sql���)
	private static final String FIND_BY_NICKNAME = "select * from "
			+ "d_user where nickname=?";
	// ͨ��id��һ��User(��֤������֤��Ϸ���)
	private static final String FIND_BY_ID = "select * from "
			+ "d_user where id=?";
	// ͨ��id����ĳ���û���is_email_verify��״̬(�����֤ͨ��,����ֵ���ó�Y)
	private static final String UPDATE_BY_ID = "update "
			+ "d_user set is_email_verify=? where id=?";

	/**
	 * @param user
	 *            �û���Ϣ
	 * @exception Exception
	 */
	public void insert(User user) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql��䣬����������ֵ
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				INSERT, Statement.RETURN_GENERATED_KEYS);
		// 4.���ò���
		stat.setString(1, user.getEmail());
		stat.setString(2, user.getNickname());
		stat.setString(3, user.getPassword());
		stat.setInt(4, user.getUserIntegral());
		String verify = user.isEmailVerify() == true ? "Y" : "N";
		stat.setString(5, verify);
		stat.setString(6, user.getEmailVerifyCode());
		stat.setLong(7, user.getLastLoginTime());
		stat.setString(8, user.getLastLoginIp());
		// 5.ִ��������
		stat.executeUpdate();
		// 6.���ؽ����
		ResultSet set = stat.getGeneratedKeys();
		set.next();
		// 7.�ѽ�����ĵ�һ������id
		int id = set.getInt(1);
		// 8.����use����
		user.setId(id);
	}

	/**
	 * ͨ��email��һ���û�
	 * 
	 * @param email
	 *            �����email
	 * @return ����һ���û�
	 * @throws Exception
	 */
	public User findByEmail(String email) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				FIND_BY_EMAIL);
		// 4.���ò���
		stat.setString(1, email);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		User user = null;
		if (set.next()) {
			user = new User();
			user.setId(set.getInt("id"));
			user.setEmail(email);
			user.setNickname(set.getString("nickname"));
			user.setPassword(set.getString("password"));
			user.setUserIntegral(set.getInt("user_integral"));
			user.setEmailVerify(set.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(set.getString("email_verify_code"));
			user.setLastLoginTime(set.getLong("last_login_time"));
			user.setLastLoginIp(set.getString("last_login_ip"));
		}
		return user;
	}

	/**
	 * ͨ��nickname��һ���û�
	 * 
	 * @param nickName
	 *            �����nickname
	 * @return ����һ���û�
	 * @throws Exception
	 */
	public User findByNickName(String nickName) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				FIND_BY_NICKNAME);
		// 4.���ò���
		stat.setString(1, nickName);
		// 5.ִ�������󲢷��ؽ����
		ResultSet set = stat.executeQuery();
		User user = null;
		if (set.next()) {
			user = new User();
			user.setId(set.getInt("id"));
			user.setEmail(set.getString("email"));
			user.setNickname(nickName);
			user.setPassword(set.getString("password"));
			user.setUserIntegral(set.getInt("user_integral"));
			user.setEmailVerify(set.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(set.getString("email_verify_code"));
			user.setLastLoginTime(set.getLong("last_login_time"));
			user.setLastLoginIp(set.getString("last_login_ip"));
		}
		return user;
	}

	/**
	 * ͨ��id��һ���û�
	 * 
	 * @param id
	 *            �����id
	 * @return ����һ���û�
	 * @throws Exception
	 */
	public User findById(int id) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				FIND_BY_ID);
		// 4.���ò���
		stat.setInt(1, id);
		// 5.ִ��������
		// 6.���ؽ����
		ResultSet set = stat.executeQuery();
		User user = null;
		if (set.next()) {
			user = new User();
			user.setId(id);
			user.setEmail(set.getString("email"));
			user.setNickname(set.getString("nickname"));
			user.setPassword(set.getString("password"));
			user.setUserIntegral(set.getInt("user_integral"));
			user.setEmailVerify(set.getBoolean("is_email_verify"));
			user.setEmailVerifyCode(set.getString("email_verify_code"));
			user.setLastLoginTime(set.getLong("last_login_time"));
			user.setLastLoginIp(set.getString("last_login_ip"));
		}
		return user;
	}

	/**
	 * ͨ��id�����û���Ϣ
	 * 
	 * @param id
	 *            �û�id
	 * @throws Exception
	 */
	public void updateById(int id) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				UPDATE_BY_ID);
		// 4.ͨ��id��һ���û�
		User user = findById(id);
		String verify = user.isEmailVerify() == true ? "Y" : "N";
		// 5.���ò���
		stat.setString(1, verify);
		stat.setInt(2, id);
		// 6.ִ��������
		stat.executeUpdate();
	}

	/**
	 * �����û�����֤��״̬
	 * 
	 * @param id
	 *            �û�id
	 * @param verify
	 *            �Ƿ�ͨ����֤
	 * @return ����Y��N
	 * @throws Exception
	 */
	public String updateVerify(int id, boolean verify) throws Exception {
		// 1.��������
		// 2.����������
		// 3.����sql���
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				UPDATE_BY_ID);
		String verifyStr = verify == true ? "Y" : "N";
		// 4.���ò���
		stat.setString(1, verifyStr);
		stat.setInt(2, id);
		// 5.ִ��������
		stat.executeUpdate();
		return verifyStr;
	}

}
