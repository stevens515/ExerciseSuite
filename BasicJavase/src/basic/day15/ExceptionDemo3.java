package basic.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/** �쳣�ۺ���ϰ */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		AccountManager mgr = new AccountManager();
		Scanner in = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("ѡ��1ע�ᣬ2��½��3�鿴ȫ����0�뿪��");
				String cmd = in.nextLine();
				if (cmd.equals("1")) {
					System.out.println("����(email pwd):");
					String str = in.nextLine();
					String[] data = str.trim().split("\\s+");
					String email = data[0];
					String pwd = data[1];
					User user = mgr.reg(email, pwd);
					System.out.println("ע��ɹ���" + user);
				} else if ("2".equals(cmd)) {
					System.out.println("����(email pwd):");
					String str = in.nextLine();
					String[] data = str.trim().split("\\s+");
					String email = data[0];
					String pwd = data[1];
					User user = mgr.login(email, pwd);
					System.out.println("��½�ɹ���" + user);
				} else if ("3".equals(cmd)) {
					List<User> all = mgr.findAll();
					System.out.println("�鿴�ɹ���");
					// System.out.println(all);
					for (Iterator<User> i = all.iterator(); i.hasNext();) {
						User user = i.next();
						System.out.println(user);
					}
				} else if ("0".equals(cmd)) {
					System.out.println("Bye *_*!");
					break;
				} else {
					System.out.println("�������");
				}
			} catch (EmailExistException e) {
				e.printStackTrace();
				System.out.println("ע��ʧ��!" + e.getMessage());
				continue;
			} catch (EmailPwdException e) {
				e.printStackTrace();
				System.out.println("��½ʧ�ܣ�" + e.getMessage());
				continue;
			}
		}
	}
}

/** �ʺŹ���: ע��, ��¼,�� */
class AccountManager {
	private HashMap<String, User> users = new HashMap<String, User>();

	private int index = 1;

	/**
	 * ע��, ������: email, pwd, �����: ע��ɹ����û�. ���email�Ѿ���ע�����, ���׳��쳣
	 */
	// ע��
	public User reg(String email, String pwd) throws EmailExistException {
		if (users.containsKey(email)) {
			// �ڷ�����ʹ��throw �׳��쳣ʵ��
			throw new EmailExistException("�Ѿ�ע����ˣ�");
		}
		User user = new User(index++, email, pwd);
		users.put(email, user);
		return user;
	}

	// throws �����ڷ����������쳣��
	// �����������쳣, ��ʾ�������ִ��ʱ����ܳ��쳣
	/** ��¼ϵͳ,������: email, pwd, �����: ��¼�ɹ����û�. */
	public User login(String email, String pwd) throws EmailPwdException {
		User someone = users.get(email);
		if (someone == null) {
			throw new EmailPwdException("���޴��ˣ�");
		}
		if (someone.getPwd().equals(pwd)) {
			return someone;// ��½�ɹ�
		}
		throw new EmailPwdException("�������");
	}

	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}
}

class User {
	private int id;

	private String email;

	private String pwd;

	public User() {
	}

	public User(int id, String email, String pwd) {
		super();
		this.id = id;
		this.email = email;
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public String toString() {
		return id + ":" + email;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof User) {
			User o = (User) obj;
			return this.id == o.id;
		}
		return false;
	}
}

// �Զ����쳣Ӧ��ʵ��ȫ������Ĺ�����
class EmailExistException extends Exception {

	public EmailExistException() {
		super();
	}

	public EmailExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailExistException(String message) {
		super(message);
	}

	public EmailExistException(Throwable cause) {
		super(cause);
	}

}

class EmailPwdException extends Exception {

	public EmailPwdException() {
		super();
	}

	public EmailPwdException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailPwdException(String message) {
		super(message);
	}

	public EmailPwdException(Throwable cause) {
		super(cause);
	}

}