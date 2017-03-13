package com.tarena.elts.ui;

import com.tarena.elts.entity.EntityContextDaoImpl;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.util.Config;

public class Main {
	public static void main(String[] args){
		//�������ж���ע�룬���������ϵ
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame  = new MenuFrame();
		ExamFrame examFrame = new ExamFrame(); 
		WelcomeWindow welcomeWindow = new WelcomeWindow();
		ClientContext clientContext = new ClientContext();
		
//		ExamService examService = new ExamService(){
//			public User login(int id,String pwd) 
//				throws IdOrPwdException{
//				if(id == 1 && pwd.equals("1234")){
//					return new User("Robin",1,"1234");
//				}
//				throw new IdOrPwdException("��¼����");
//			}
//		};
		//ʹ��show()��ʾ��¼����
		ExamServiceImpl examService = new ExamServiceImpl();
		//ExamServiceAgent examService = new ExamServiceAgent();
		//Config config = new Config("client.properties");
		EntityContextDaoImpl entityContext = new EntityContextDaoImpl();
		
		
		//����������ϵ��װ
		loginFrame.setClientContext(clientContext);
		clientContext.setLoginFrame(loginFrame);
		menuFrame.setClientContext(clientContext);
		clientContext.setMenuFrame(menuFrame);
		examFrame.setClientContext(clientContext);
		clientContext.setExamFrame(examFrame);
		examService.setEntityContext(entityContext);
		//��entityContext������ �� examFrame 
		clientContext.setWelcomeWindow(welcomeWindow);
		clientContext.setExamService(examService);
		
		
		clientContext.show();
	}
}
