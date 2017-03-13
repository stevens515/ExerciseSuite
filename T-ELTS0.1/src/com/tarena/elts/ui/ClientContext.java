package com.tarena.elts.ui;

import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

/** �ͻ�������������ͻ��������Ļ��� */
public class ClientContext {
	// private LoginFrame loginFrame = new LoginFrame();//�Լ��죬����

	private LoginFrame loginFrame;// Ĭ��null,��ã�ע�룬����ע��,����ע��

	/** ����ע��(IOC) ����ע�����loginFrame��ʵ��,���������͵Ĺ�ϵ */
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	private ExamService examService;// ��������examService

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	private MenuFrame menuFrame;

	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	/**
	 * ��ʾ����Ŀ�ʼ����,����ʾ��¼���� show()���������б���������loginFrame�������þ���Ľ������,
	 * ���������������������setLoginFrame()����ע��,ע������������ʵ����
	 */
	public void show() {
		loginFrame.setVisible(true);// ��ʾ����
	}

	/**
	 * �˷�����login��ť���� ��½ϵͳ�������߼� 
	 * 		1.�ӵ�¼�������û���ID��pwd 
	 * 		2.����ҵ��ģ�͵�login������ɵ�¼����
	 *	 	3.���ݵ�½�Ľ��������ɹ��͸��²˵����棬��ʾ�û���Ϣ �رյ�¼���棬�򿪲˵�����
	 *		4.�����¼ʧ�ܾ��ڵ�½��������ʾʧ����Ϣ
	 */
	public void login() {
		try {
			// 1.�ӵ�¼�����ȡID��pwd
			int id = loginFrame.getUserId();// �û������id
			String pwd = loginFrame.getPassword();
			// 2.����ҵ��ģ�͵ĵ�¼����
			// examService.login()���ýӿڵ����ͣ��������Ͱ󶨵������ϡ�����Ҳ�󶨵������ϡ�����ҵ��ģ��
			User user = examService.login(id, pwd);
			// 3.�����¼�ɹ��͹رյ�¼���棬�򿪲˵�����
			// menuFrame.updateView(user);//���²˵�����
			loginFrame.setVisible(false);
			menuFrame.setVisible(true);
		  }catch(IdOrPwdException e){
	        e.printStackTrace();
	        loginFrame.showMessage("��¼ʧ��:"+e.getMessage());
	      }catch(NumberFormatException e){
	        e.printStackTrace();
	        loginFrame.showMessage("ID ����������");
	      }catch(Exception e){
	        e.printStackTrace();
	        loginFrame.showMessage("��¼ʧ��:"+e.getMessage());
	      }
	}

}
