package service;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import entity.Account;
import exception.AccountLimitException;
import exception.AccountNotExistException;

/**
 * ����ҵ����
 * @author soft01
 *
 */
public class LoanService {
	public double apply(String accountNO,double amount) throws Exception{
		AccountDao dao = new AccountDaoImpl();
		Account a = dao.findByAccountNo(accountNO);
		if(a == null){
			/*
			 		�˺Ų�����  �����׳�һ��Ӧ���쳣������ �ߡ�
			 		Ӧ���쳣��һ���������û��������������쳣������������һ�������ڵ��˺š�
			 		�������쳣һ�㶼�ǿ��Իָ��ġ��������û���������һ���˺š�
			 */
			throw new AccountNotExistException();
		}
		if(a.getBalance()*2<amount){
			throw new AccountLimitException();
		}
		return amount;
	}
}
