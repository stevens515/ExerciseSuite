package com.tarena.elts.ui;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.elts.util.Config;
//8. �������ϲ��� Main.class
public class Main{
	public static void main(String[] args) throws Exception {
		//��ʼ���������������
		LoginFrame loginFrame = new LoginFrame();//��½����
		ExamFrame examFrame = new ExamFrame();	//�������
		MenuFrame menuFrame = new MenuFrame();
		WelcomeWindow welcomWindow = new WelcomeWindow();//����
		ClientContext clientContext = new ClientContext();//�ͻ�������������ͻ��������Ļ��� 
		ExamServiceImpl service = new ExamServiceImpl();//����ҵ����ʵ����,��½����
		Config config = new Config("client.properties");//Config��ȡϵͳ�������ļ�
		EntityContext entityContext = new EntityContext(config);
		
		//��װ���
		service.setEntityContext(entityContext);
		loginFrame.setClientContext(clientContext);
		clientContext.setExamService(service);//examService
		clientContext.setLoginFrame(loginFrame);
		clientContext.setExamFrame(examFrame);
		clientContext.setMenuFrame(menuFrame);
		//clientContext.setWelcomeWindow(welcomeWindow);//����δ���
		//�����������
		clientContext.show();
		
	/*	//�������ж���ע�룬���������ϵ
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ClientContext clientContext = new ClientContext();
		ExamService examService = new ExamService() {
			public User login(int id, String pwd) throws IdOrPwdException {
				if (id == 1 && pwd.equals("1234")) {
					return new User("�ֶ���", 1, "1234");
				}
				throw new IdOrPwdException("��½����");
			}
		};
		ExamServiceImpl examService = new ExamServiceImpl();
		Config config = new Congfig("client.properties");
		EntityContext entityContext = new EntityContext(config);
		
		examService.setEntityContext = new  EntityContext(config);
		
			clientContext.setExamService(examService);
			clientContext.setLoginFrame(loginFrame);
			clientContext.setMenuFrame(menuFrame);
			loginFrame.setClientContext(clientContext);
			
			//ʹ��show()��ʾ��¼����
			clientContext.show();*/
	}
}
