package com.tarena.elts.net;

//import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.ExamFrame;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;
import com.tarena.elts.ui.WelcomeWindow;
import com.tarena.elts.util.Config;

/** ����ͻ������*/
public class ClientMain {
	public static void main(String[] args){
		//�����ļ�
		Config config = new Config("client.properties");
		//����� �� ��ͼ �� ������
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ExamFrame examFrame = new ExamFrame();
		WelcomeWindow welcomeWindow = new WelcomeWindow();
		//������
		ClientContext clientContext = new ClientContext();
		
		//ҵ��ģ��
		//ExamServiceImpl examService = new ExamServiceImpl();
		ExamServiceAgent examService = new ExamServiceAgent();
		
		//��װ ����� ҵ��� �� ���ݲ�
		loginFrame.setClientContext(clientContext);
		clientContext.setLoginFrame(loginFrame);
		menuFrame.setClientContext(clientContext);
		clientContext.setMenuFrame(menuFrame);
		examFrame.setClientContext(clientContext);
		clientContext.setExamFrame(examFrame);
		clientContext.setWelcomeWindow(welcomeWindow);
		
		//��� examService �� ���ֲ������
		clientContext.setExamService(examService);
		examService.setConfig(config);
		
		clientContext.show();
	}
}