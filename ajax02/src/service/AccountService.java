package service;

import java.util.Random;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import entity.Account;
import exception.AccountLimitException;
import exception.AccountNotExistException;

public class AccountService {
		public String apply(String accountNo,double amount) throws Exception{
			//�������˺Ų�ѯ���ݿ�
			AccountDao dao = new AccountDaoImpl();
			Account a = dao.findByAccountNo(accountNo);
			if(a == null){
				//�˺Ų�����
				throw new AccountNotExistException();
			}
			if(amount > a.getBalance()*10){
				//����
				throw new AccountLimitException();
			}
			//����һ����ţ��û�����ͨ��������ȥ���Ѻ��ʣ�������
			Random r = new Random();
			return r.nextInt(99999)+"";
		}
}
