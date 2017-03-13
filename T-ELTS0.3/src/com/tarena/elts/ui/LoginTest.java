package com.tarena.elts.ui;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;
/**
 * 10)	����ExamService����ʵ��. ��װ����, ������� 
 */
public class LoginTest {

	public static void main(String[] args) {
		// ��ʼ��������(���)
		LoginFrame loginFrame = new LoginFrame();
		ExamFrame examFrame = new ExamFrame();
		MenuFrame menuFrame = new MenuFrame();
		WelcomeWindow welcomeWindow = new WelcomeWindow();
		ClientContext clientContext = new ClientContext();
		ExamService service = new ExamServiceDemo();

		// ��װ���
		loginFrame.setClientContext(clientContext);
		clientContext.setExamService(service);
		clientContext.setLoginFrame(loginFrame);
		clientContext.setExamFrame(examFrame);
		clientContext.setMenuFrame(menuFrame);
//		clientContext.setWelcomeWindow(welcomeWindow);
		// �����������
		clientContext.show();
	}

	static class ExamServiceDemo implements ExamService {

		public User login(int id, String pwd) throws IdOrPwdException {
			if (id == 1000 && pwd.equals("1234")) {
				return new User("Robin", 1000, "1234");
			}
			throw new IdOrPwdException("�û���/�������!");
		}

		public QuestionInfo getQuestion(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		public ExamInfo startExam() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}