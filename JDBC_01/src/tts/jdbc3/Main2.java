package tts.jdbc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * a' or 'c' = 'c��Ϊ����ʱ����¼���ɹ��ˡ�SQLע����������
 */
public class Main2 {
	public static void main(String[] args) throws Exception {
		UserService userService = new UserService();
//		Scanner br = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br.nextLine();
		br.readLine();
		System.out.println("�������û�����");
//		String username = br.nextLine();
		String username = br.readLine();
		System.out.println("���������룺");
		String password = br.readLine();
//		String password = br.nextLine();
		
		boolean b = userService.login(username, password);
		
		if(b){
			System.out.println("��¼�ɹ���");
		}else{
			System.out.println("��¼ʧ�ܣ�");
		}
	}
}
