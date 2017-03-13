package test;

import exception.AccountLimitException;
import exception.AccountNotExistException;
import service.AccountService;

public class Test2 {

	public static void main(String[] args) {
		AccountService service = 
			new AccountService();
		try {
			String rs = 
				service.apply("6225881003192000", 100000);
			System.out.println("��������ͨ���������:" + rs);
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof AccountNotExistException){
				System.out.println("�ʺŲ�����");
			}else if(e instanceof AccountLimitException){
				System.out.println("����");
			}else{
				System.out.println("ϵͳ������������");
			}
		}
	}

}
