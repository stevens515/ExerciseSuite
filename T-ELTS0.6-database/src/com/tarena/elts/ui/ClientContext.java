package com.tarena.elts.ui;//����������ͼ�������� so д����ͼ����

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.Serializable;
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

/** �ͻ������������ �ͻ��������Ļ��� */
public class ClientContext implements Serializable{
	//private LoginFrame loginFrame = new LoginFrame();//�Լ�����
	private static final long serialVersionUID = -7691963212048016326L;
	//����ע��
	private LoginFrame loginFrame;
	//���˸���  ������    
	/** ����ע��(IOC) ����ע�����loginFrame��ʵ�� */
	public void setLoginFrame(LoginFrame loginFrame){
		this.loginFrame = loginFrame;
		//������ӻ���ʾNullpointerException
	}
	
	private ExamService examService;
	public void setExamService(ExamService examService){
		this.examService = examService;
	}
	
	private MenuFrame menuFrame;
	public void setMenuFrame(MenuFrame menuFrame){
		//System.out.println("menuFrame:"+menuFrame);
		//�����ġ�Ȩ�޶�����
		com.tarena.elts.ui.ClientContext.this.menuFrame = menuFrame;
		//this.menuFrame = menuFrame;
	}
	
	private ExamFrame examFrame;
	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}
	private WelcomeWindow welcomeWindow;
	public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
		this.welcomeWindow = welcomeWindow;
	}
	
	/**
	 * �˷�����login��ť���ã�
	 * ��¼ϵͳ�������߼�
	 *  1 �ӵ�¼�������û���ID �� pwd
	 *  2 ����ҵ��ģ�͵�login������ɵ�¼����
	 *  3 ���ݵ�¼�Ľ��������ɹ��� ���²˵����棬��ʾ�û���Ϣ
	 *  	�رյ�¼���棬�򿪲˵�����
	 *  4 �����¼ʧ�ܾ��ڵ�¼��������ʾʧ����Ϣ
	 */
	public void login(){
		try{
			//�ӵ�¼�����ȡID��pwd
			int id = loginFrame.getUserId();
			String pwd = loginFrame.getPassword();
			//����ҵ��ģ�͵ĵ�¼����
			System.out.println("examService:"+examService);
			//examService �ӿ�����
			User loginUser = examService.login(id, pwd);//��������Ҫ��̬�󶨵� ����/��
			//�������
			//System.out.println("login():menuFrame:"+menuFrame);
			//System.out.println("login():user:"+user);
			//���²˵�����,��ʾ��¼�û���Ϣ
			menuFrame.updateView(loginUser);
			//�����¼�ɹ��͹رյ�¼���棬�򿪲˵�����
			loginFrame.setVisible(false);
		
			menuFrame.setVisible(true);
		}catch(IdOrPwdException e){
			e.printStackTrace();
			//�����¼ʧ�ܾ����ڵ�¼���棬�����ڽ�������ʾ����
			loginFrame.showMessage("��¼ʧ��"+e.getMessage());
			//��setText() 	����������Ҫ��ʾ�ĵ����ı�
		}catch(NumberFormatException e){
			e.printStackTrace();
			loginFrame.showMessage("��¼ʧ��"+e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			loginFrame.showMessage("��¼ʧ��"+ e.getMessage());
		}
	}
//	public void login1(){
//		System.out.println("login");
//		int id =loginFrame.getUserId();
//		String pwd = loginFrame.getPassword();
//		//User user = userDao.fin
//		catch(Exception e){
//			//��ʾ������档������
//		}
//	}
	/**
	 * ��ʾ����Ŀ�ʼ���� �� ����ʾ��¼����
	 * show()���������У�����������loginFrame�������þ���Ľ������
	 * ���������������������setLoginFrame() ע�룬ע������������ʵ����
	 */
	public void show(){//�������Ϊ�ջ���ֿ�ָ���쳣
		center(welcomeWindow);
		center(loginFrame);
		center(menuFrame);
		center(examFrame);
		welcomeWindow.setVisible(true);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				welcomeWindow.setVisible(false);
				loginFrame.setVisible(true);
				timer.cancel();
			}
		},2000);
	}
	// ���þ���  Ҳ����  setLocationRelativeTo(null);
	private void center(Window win){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - win.getWidth()) /2;
		int y = (screen.height - win.getHeight()) /2;
		win.setLocation(x, y);
	}
	
	/**
	 * �˳�ϵͳ  �����߼�
	 * @param source  �������һ�������˳�����һ�����ڵ�����
	 */
	public void exit(JFrame source){
		//confirm ȷ��
		//Dialog �Ի���
		//����ǰ��ĶԻ��� ģ̫�Ի���
		int val = 
			JOptionPane.showConfirmDialog(source, "�뿪��");
		//����source �����ǰ��
		if(val == JOptionPane.YES_OPTION){
			System.exit(0);//������ǰJava����  ����ϰ��д0��ʾ��ȷ�˳�(ֻҪ�����������ԣ�
			//ϰ��0��ʾ�����Գ�)
			//java ȫ��ǰ̨�̶߳������� ���̲Ż����
			//ͼ�ν�����߳̽϶࣬��������̲�����
		}
	}
	
	/**���Խ���*/
	public void start(){
		try{
			//����ҵ��㷽����ʼ���ԣ����ؿ�����Ϣ����
			ExamInfo examInfo = examService.start();//���ɿ���
			//����ҵ��㷽��ȡ�ص�һ����
			QuestionInfo questionInfo = 
				examService.getQuestion(0);
			//���ֵ�ǰ��Ŀ״̬
			currentQuestionInfo = questionInfo;
			//���ֿ�����Ϣ״̬
			this.examInfo = examInfo;
			//����ExamFrame��ʾ������Ϣ���͵�һ����
			examFrame.updateView(examInfo,questionInfo);
//			�رղ˵�����
			menuFrame.setVisible(false);
			//�򿪿��Խ���
			examFrame.setVisible(true);
			
			startTimer();
		}catch(Exception e){
			//һ�������쳣 ����ʾ��Ϣ�Ի���
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					menuFrame, e.getMessage());
			menuFrame.repaint();
			//�ػ����
		}
	}
	private QuestionInfo currentQuestionInfo;
	private ExamInfo examInfo;
	private Timer timer;
	
	public void prev(){
		try{
			//ȡ�õ�ǰ�����
			int index = currentQuestionInfo.getQuestionIndex();
			//���浱ǰ������û��𰸵�ҵ���
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(index,userAnswers);
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
	
	public void next(){
		try{
			//ȡ�õ�ǰ�����
			int index = currentQuestionInfo.getQuestionIndex();
			//���浱ǰ����Ĵ𰸵�ҵ���
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(index,userAnswers);
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
	/** ���� */
	public void send(){
		int val = JOptionPane.showConfirmDialog(examFrame, "��ľ�д��㽻��");
		if(val == JOptionPane.YES_OPTION){
			gameOver();
		}
	}
	public void gameOver(){
		try{
			int index = currentQuestionInfo.getQuestionIndex();
			//��ȡ�����û���
			List<Integer> userAnswers = examFrame.getUserAnswers();
			//�����û���
			examService.saveUserAnswers(index,userAnswers);
			//������
			int score = examService.send();
			//��ʾ����
			timer.cancel();
			JOptionPane.showMessageDialog(examFrame, "������"+score);
			//�رտ��Խ���
			examFrame.setVisible(false);
			//���ز˵�����
			menuFrame.setVisible(true);
			timer.cancel();
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}
	public void result(){
		try{
			int score = examService.getScore();
			JOptionPane.showMessageDialog(menuFrame, "������"+score);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
	}
	public void msg(){
		try{
//			String message = examService.getMessage();
			JOptionPane.showMessageDialog(menuFrame, "��˵��\n����Ϯ\n���ſ���\n��ʵ����");
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	private void startTimer(){
		timer = new Timer();
		//��ǰʱ��
		long start = System.currentTimeMillis();
		//����ʱ��  �� ��ǰʱ��+
		final long end = examInfo.getTimeLimit()*60*1000+start;
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				//show����Ҫ��ʾ��ʣ��ʱ��
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
				gameOver();//��ǰ����
			}
		}, new Date(end));
	}
	
}
