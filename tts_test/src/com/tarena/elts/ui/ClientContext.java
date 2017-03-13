package com.tarena.elts.ui;

import java.awt.Color;
import java.sql.Date;
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

/** �ͻ�������������ͻ��������Ļ��� */
public class ClientContext {
	private LoginFrame loginFrame;

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	private ExamFrame examFrame;

	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}

	private MenuFrame menuFrame;

	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	private ExamService examService;

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public void show() {
		loginFrame.setVisible(true);// ��ʾ����
	}

	/**
	 * �˷�����login��ť���� ��½ϵͳ�������߼� 1.�ӵ�¼�������û���ID��pwd 2.����ҵ��ģ�͵�login������ɵ�¼����
	 * 3.���ݵ�½�Ľ��������ɹ��͸��²˵����棬��ʾ�û���Ϣ �رյ�¼���棬�򿪲˵����� 4.�����¼ʧ�ܾ��ڵ�½��������ʾʧ����Ϣ
	 */
	public void login() {
		try {
			// 1.�ӵ�¼�����ȡID��pwd
			int id = loginFrame.getUserId();
			String pwd = loginFrame.getPassword();
			// 2.����ҵ��ģ�͵ĵ�¼����
			// examService.login()���ýӿڵ����ͣ��������Ͱ󶨵������ϡ�����Ҳ�󶨵������ϡ�����ҵ��ģ��
			User user = examService.login(id, pwd);
			// 3.�����¼�ɹ��͹رյ�¼���棬�򿪲˵�����
			menuFrame.updateView(user);// ���²˵�����
			loginFrame.setVisible(false);
			menuFrame.setVisible(true);

		} catch (IdOrPwdException e) {
			e.printStackTrace();
			loginFrame.showMessage("��¼ʧ�ܣ�" + e.getMessage());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			loginFrame.showMessage("ID ����������");
		} catch (Exception e) {
			e.printStackTrace();
			loginFrame.showMessage("��¼ʧ�ܣ�" + e.getMessage());
		}
	}

	public void exit(JFrame from) {
		int val = JOptionPane.showConfirmDialog(from, "ȷ��Ҫ�뿪��");
		if (val == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void start() {
		try {
			ExamInfo examInfo = examService.startExam();
			QuestionInfo questionInfo = examService.getQuestion(0);
			currentQuestion = questionInfo;
			this.examInfo = examInfo;
			examFrame.updateView(examInfo, questionInfo);
			menuFrame.setVisible(false);
			examFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
	}

	/*
	 * 2 ����ʱ�������볬ʱ���� 1) ���¿����� start�������: startTimer(); 2) ���¿����� ���
	 */
	private Timer timer;

	private void startTimer() {
		timer = new Timer();
		long start = System.currentTimeMillis();
		int timeout = examInfo.getTimeLimit() * 60 * 1000;
		final long end = timeout + start;
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// show ����Ҫ��ʾ��ʣ��ʱ��
				long show = end - System.currentTimeMillis();
				long h = show / 1000 / 60 / 60;
				long m = show / 1000 / 60 % 60;
				long s = show / 1000 % 60;
				examFrame.updateTime(h, m, s);
			}
		}, 0, 1000);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				gameOver();// ��ǰ����
			}
		}, new Date(end));
	}

	public void gameOver() {
		try {
			int idx = currentQuestion.getQuestionIndex();
			//��ȡ�����û���
			List<Integer> userAnswers = examFrame.getUserAnswers();
			//�����û���
			examService.saveUserAnswers(idx, userAnswers);
			//������
			int score = examService.send();
			//��ʾ����
			timer.cancel();
			JOptionPane.showMessageDialog(examFrame, "��ķ���:" + score);
			examFrame.setVisible(false);
			menuFrame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}

	private QuestionInfo currentQuestion;
	private ExamInfo examInfo;

	public void next() {
		try {
			int idx = currentQuestion.getQuestionIndex();
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(idx, userAnswers);
			currentQuestion = examService.getQuestion(idx + 1);
			examFrame.updateView(examInfo, currentQuestion);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}

	public void prev() {
		try {
			int idx = currentQuestion.getQuestionIndex();
			List<Integer> userAnswers = examFrame.getUserAnswers();
			examService.saveUserAnswers(idx, userAnswers);
			currentQuestion = examService.getQuestion(idx - 1);
			examFrame.updateView(examInfo, currentQuestion);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(examFrame, e.getMessage());
		}
	}

	public void send() {
			int val = JOptionPane.showConfirmDialog(examFrame, "����");
			if (val != JOptionPane.YES_OPTION) {
				gameOver();
			}
	}

	public void result() {
		try {
			int score = examService.getScore();
			JOptionPane.showMessageDialog(menuFrame, "���Է�����" + score);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(menuFrame, e.getMessage());
		}
	}

	public void getRules() {
	 JOptionPane.showMessageDialog(menuFrame, "���ܳ�");
	}

}