package com.tarena.elts.test;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.ExamFrame;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;
import com.tarena.elts.util.Config;

//�������ϲ��� Main.class
public class Main {
	public static void main(String[] args) {
		//��ʼ��������(���)
		LoginFrame loginFrame = new LoginFrame();
		ExamFrame examFrame = new ExamFrame();
		MenuFrame menuFrame = new MenuFrame();
		ClientContext clientContext =new ClientContext();
		ExamServiceImpl service = new ExamServiceImpl();
		Config config = new Config("client.properties");
		EntityContext entityContext = new EntityContext(config);
		//��װ���
		service.setEntityContext(entityContext);
		loginFrame.setClientContext(clientContext);
		clientContext.setExamService(service);
		clientContext.setLoginFrame(loginFrame);
		clientContext.setMenuFrame(menuFrame);
		menuFrame.setClientContext(clientContext);
		//�����������
		clientContext.show();
		
	}
}
