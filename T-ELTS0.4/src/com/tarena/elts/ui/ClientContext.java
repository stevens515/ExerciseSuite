package com.tarena.elts.ui;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	private ExamFrame examFrame;
	private MenuFrame menuFrame;
	private ExamService examService;// ��������examService
	private WelcomeWindow welcomeWindow;

	/** ����ע��(IOC) ����ע�����loginFrame��ʵ��,���������͵Ĺ�ϵ */
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	
	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}
	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
		this.welcomeWindow = welcomeWindow;
	}
	/**
	 * 9) ΪClientContext ����show() ����, ������ʾ�������.
	 * ��ʾ����Ŀ�ʼ����,����ʾ��¼���� show()���������б���������loginFrame�������þ���Ľ������,
	 * ���������������������setLoginFrame()����ע��,ע������������ʵ����
	 */
	public void show() {
		welcomeWindow.setVisible(true);//������
		final Timer timer = new Timer();//������ʱ��
		timer.schedule(new TimerTask(){	//�������񣬶����ر����������loginFrame
			public void run(){
				welcomeWindow.setVisible(false);
				loginFrame.setVisible(true);
				timer.cancel();
			}
		}, 2000);
	}
	 //4. ʵ���˳�ϵͳ�Ĺ��� 1) ΪClientContext���exit����
	public void exit(JFrame from){
		int value = JOptionPane.showConfirmDialog(from, "��ƣ�ȷ��Ҫ�뿪��");
		if(value==JOptionPane.YES_OPTION){
			from.setVisible(false);
			System.exit(0);//ϵͳ�˳���������ǰjava����
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
			System.out.println("examService:"+examService);
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
//	 ������, �����¼���Ӧ����start()��ʼ����
	public void start() {
		
		try{
//			����ҵ��㷽����ʼ����, ���ؿ�����ϸ��Ϣ
		ExamInfo examInfo = examService.startExam();
		//��һ����,����ҵ��㷽��ȡ�ص�һ����
		QuestionInfo questionInfo = examService.getQuestion(0);
//		���ֵ�ǰ��Ŀ״̬  private QuestionInfo currentQuestionInfo;
		currentQuestionInfo = questionInfo;
//		QuestionInfo currentQuestionInfo = questionInfo;
//		this.currentQuestionInfo = questionInfo;
//		���ֿ�����Ϣ״̬
		this.examInfo = examInfo;
		//����ExamFrame��ʾ������Ϣ, �͵�һ����
		examFrame.updateView(examInfo,questionInfo);
//		�رղ˵�����
		menuFrame.setVisible(false);
		 //�򿪿��Խ���
		examFrame.setVisible(true);
		startTimer();
		}catch(Exception e){
			e.printStackTrace();
			 JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
		
	}
	private QuestionInfo currentQuestionInfo;
	private ExamInfo examInfo;
	public void prev() {
		try{
			//ȡ�õ�ǰ�����
			int index = currentQuestionInfo.getQuestionIndex();
			//���浱ǰ������û��𰸵�ҵ���
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(index, userAnswers);
			//ȡ����һ��Ŀ
			QuestionInfo questionInfo = examService.getQuestion(index-1);
			currentQuestionInfo = questionInfo;
			//���¿��Խ��棬��ʾ��һ��Ŀ
			examFrame.updateView(examInfo, questionInfo);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}
	public void next() {
		try{
			//ȡ�õ�ǰ�����
			int index = currentQuestionInfo.getQuestionIndex();
			//���浱ǰ������û��𰸵�ҵ���
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(index, userAnswers);
			//ȡ����һ��Ŀ
			QuestionInfo questionInfo = examService.getQuestion(index+1);
			currentQuestionInfo = questionInfo;
			//���¿��Խ��棬��ʾ��һ��Ŀ
			examFrame.updateView(examInfo, questionInfo);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
		
	}
	public void send() {
		int val = JOptionPane.showConfirmDialog(examFrame, "��ȷ��Ҫ����������");
		if(val ==JOptionPane.YES_OPTION){
			gameOver();
		}
	}
	public void gameOver(){
		try{
			int index = currentQuestionInfo.getQuestionIndex();
			//��ȡ�����û���
			List<Integer> userAnswers = examFrame.getUserAnswers();
			//�����û���
			examService.saveUserAnswers(index, userAnswers);
			//������
			int score = examService.send();
			//��ʾ����
			timer.cancel();
			JOptionPane.showMessageDialog(examFrame, "������"+score);
			//�رտ��Խ���
			examFrame.setVisible(false);
			//���ز˵�����
			menuFrame.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}
	
	public void result() {
		try{
			int score =examService.getScore();
			JOptionPane.showMessageDialog(menuFrame, "������"+score);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
		
	}
	private Timer timer;
	private void startTimer(){
		timer = new Timer();
		long start = System.currentTimeMillis();
		final long end = examInfo.getTimeLimit()*60*1000+start;
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				long show = end-System.currentTimeMillis();
				long h = show/1000/60/60;
				long m = show/1000/60%60;
				long s = show/1000%60;
				examFrame.updateTime(h, m, s);
			}
		}, 0,1000);
		timer.schedule(new TimerTask(){
		      @Override
		      public void run() {

		        gameOver();
		      }
		    }, new Date(end));
	}
}
