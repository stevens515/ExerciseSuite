package com.tarena.elts.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

/** �ͻ�������������ͻ��������Ļ��� 
 *  3) ������������ClientContext��, ��ӵ�¼��Ӧ����
 *  4) ������������ClientContext��, ����ӽ���������ú�
 		ע�뷽��. �ﵽ�������ܹ�������Щ�����Ŀ�� 
 */
public class ClientContext {
	// private LoginFrame loginFrame = new LoginFrame();//�Լ��죬����

	private LoginFrame loginFrame;// Ĭ��null,��ã�ע�룬����ע��,����ע��
	/** ����ע��(IOC) ����ע�����loginFrame��ʵ��,���������͵Ĺ�ϵ */
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	/**
	 * 7) ΪClientContext ����ҵ���ӿڵ�����
  			private ExamService examService;
  			public void setExamService(ExamService examService) {
    			this.examService = examService;
  			}
	 */
	private ExamService examService;// ��������examService

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
//	private WelcomeWindow welcomeWindow;
//	public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
//		this.welcomeWindow = welcomeWindow;
//	}
	private ExamFrame examFrame;
	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}
	private MenuFrame menuFrame;
	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	/**
	 * 9) ΪClientContext ����show() ����, ������ʾ�������.
	 * ��ʾ����Ŀ�ʼ����,����ʾ��¼���� show()���������б���������loginFrame�������þ���Ľ������,
	 * ���������������������setLoginFrame()����ע��,ע������������ʵ����
	 */
	public void show() {
		loginFrame.setVisible(true);// ��ʾ����
	}

	/**
	 * 4. ʵ���˳�ϵͳ�Ĺ��� 1) ΪClientContext���exit����
	 */
	public void exit(JFrame from){
		int val = JOptionPane.showConfirmDialog(from, "ȷ��Ҫ�뿪��");
		if(val==JOptionPane.YES_OPTION){
			System.exit(0);//ϵͳ�˳�
		}
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
			menuFrame.setVisible(true);
			loginFrame.setVisible(false);
			menuFrame.updateView(user);//���²˵�����
			
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
	public void start() {
		// ������, �����¼���Ӧ����start()
		  /** ��ʼ���� */
		try{
		ExamInfo examInfo = examService.startExam();
		//��һ����
		QuestionInfo questionInfo = examService.getQuestion(0);
		examFrame.updateView(examInfo,questionInfo);
		menuFrame.setVisible(false);
		examFrame.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
			 JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
		
	}

}
