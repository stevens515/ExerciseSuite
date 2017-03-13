package com.tarena.elts.entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/** ʵ�����ݹ���������ȡ�����ļ��ŵ��ڴ漯���� */
public class EntityContext {
	/**key���û���ID��value���û�ʵ��*/
	private HashMap<Integer, User> users = new HashMap<Integer, User>();

	public User findUserById(int id) {
		return users.get(id);
	}
	private void loadUsers(String filename) throws Exception {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(filename),"GBK"));//���ļ�
			String line;//һ�����ݣ�һ��һ�ж�ȡ
			while((line=in.readLine())!=null){
				line = line.trim();
				if(line.startsWith("#")||line.equals("")){
					continue;//���Կ��к�ע��(#)
				}
				User one = parseUser(line);
				users.put(one.getId(), one);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//1002:����:1234:13810381038:zhangsan@tarena.com.cn
	//0		1    2   3            4                 
	private User parseUser(String line) {
		String[] data = line.split(":");
		User user = new User();
		user.setId(Integer.parseInt(data[0]	));
		user.setName(data[1]);
		user.setPasswd(data[2]);
		user.setPhone(data[3]);
		user.setEmail(data[4]);
		return user;
	}
	/**���Է���*/
	public static void main(String[] args) throws Exception {
		EntityContext context =new EntityContext();//��Ϊ������˽�� ��
		context.loadUsers("user.txt");
		System.out.println(context.users);
	}
}
