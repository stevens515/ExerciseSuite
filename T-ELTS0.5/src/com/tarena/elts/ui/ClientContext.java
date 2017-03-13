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

/** �ͻ����������: �ͻ��������Ļ���  */
public class ClientContext {

  //private LoginFrame loginFrame = new LoginFrame();
  private LoginFrame loginFrame;
  /** ����ע��(IOC) ����ע�����loginFrame��ʵ�� */
  public void setLoginFrame(LoginFrame loginFrame) {
    this.loginFrame = loginFrame;
  }
  private ExamService examService;
  public void setExamService(ExamService examService) {
    this.examService = examService;
  }
  private MenuFrame menuFrame;
  public void setMenuFrame(MenuFrame menuFrame) {
    //System.out.println("setMenuFrame()" + menuFrame); 
    this.menuFrame = menuFrame;
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
   * ��ʾ����Ŀ�ʼ����,  ����ʾ��¼����
   * show()����������, ���������� loginFrame��������
   * ����Ľ������, ���������������������setLoginFrame()
   * ע��, ע������������ʵ��!
   **/
  public void show(){
    welcomeWindow.setVisible(true);
    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      public void run() {
        welcomeWindow.setVisible(false);
        loginFrame.setVisible(true); 
        timer.cancel();
      }
    }, 2000); 
  }
  /**
   * �˷����� login��ť����!
   * ��¼ϵͳ, �����߼�
   *  1 �ӵ�¼�������û���ID��pwd
   *  2 ����ҵ��ģ�͵�login������ɵ�¼����
   *  3 ���ݵ�¼�Ľ��, ����ɹ��� ���²˵�����,��ʾ�û���Ϣ
   *     �رյ�¼����, �򿪲˵�����
   *  4 �����¼ʧ�ܾ��ڵ�¼��������ʾʧ����Ϣ
   */
  public void login(){
    try{
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPassword();
      User user = examService.login(id, pwd);
      //System.out.println("loing():menuFrame:"+menuFrame);
      //System.out.println("loing():user+"+user);
      menuFrame.updateView(user);//���²˵�����
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
  /**
   * �˳�ϵͳ �����߼�
   * @param source �������һ�������˳�. ��һ�����ڵ�����
   */
  public void exit(JFrame source){
    //Confirm ȷ��
    // Dialog �Ի���
    int val = 
      JOptionPane.showConfirmDialog(source, "�뿪��?");
    if(val==JOptionPane.YES_OPTION){
      System.exit(0);//������ǰJava����
    }
  }

  public void start(){
    try{
      examInfo = examService.start();//���ɿ���
      QuestionInfo questionInfo = 
        examService.getQuestion(0);
      currentQuestionInfo = questionInfo;
      examFrame.updateView(examInfo, questionInfo);
      menuFrame.setVisible(false);
      examFrame.setVisible(true);
      startTimer();
    }catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
      menuFrame.repaint();//�ػ����
    }
  }
  private QuestionInfo currentQuestionInfo;
  private ExamInfo examInfo;
  
  public void next(){
    try{
      //ȡ�õ�ǰ�����
      int index = currentQuestionInfo.getQuestionIndex();
      //���浱ǰ������û��𰸵�ҵ���
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //ȡ����һ��Ŀ
      QuestionInfo questionInfo = 
        examService.getQuestion(index+1);
      currentQuestionInfo = questionInfo;
      //���¿��Խ���, ��ʾ��һ��Ŀ
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  public void prev(){
    try{
      //ȡ�õ�ǰ�����
      int index = currentQuestionInfo.getQuestionIndex();
      //���浱ǰ������û��𰸵�ҵ���
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //ȡ����һ��Ŀ
      QuestionInfo questionInfo = 
        examService.getQuestion(index-1);
      currentQuestionInfo = questionInfo;
      //���¿��Խ���, ��ʾ��һ��Ŀ
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  
  public void send(){
    int val = JOptionPane
      .showConfirmDialog(examFrame, "��Ľ�����?");
    if(val==JOptionPane.YES_OPTION){
      gameOver();
    }
  }
  
  private void gameOver(){
    try{
      //�������ѡ��Ŀ����
      List<Integer> ans = examFrame.getUserAnswers();
      int index = currentQuestionInfo.getQuestionIndex();
      examService.saveUserAnswers(index, ans);
      //��������, �õ�����
      int socre = examService.examOver();
      //��ʾ����
      JOptionPane.showMessageDialog(
          examFrame, "���ķ���"+socre);
      //�л�����
      examFrame.setVisible(false);
      menuFrame.setVisible(true);
      timer.cancel();
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  private Timer timer = new Timer();
  private void startTimer(){
    final long end = System.currentTimeMillis() + 
      examInfo.getTimeLimit() * 1000 * 60;
    timer.schedule(new TimerTask() {
      public void run() {
        long now = System.currentTimeMillis();
        long show = end-now;
        long h = show/1000/60/60;
        long m = show/1000/60%60;
        long s = show/1000%60;
        examFrame.showTime(h,m,s);
      }
    }, 0, 1000);
    timer.schedule(new TimerTask() {
      public void run() {
        gameOver();
      }
    }, new Date(end));
  }
  public void result() {
    try {
      int score = examService.getScore();
      JOptionPane.showMessageDialog(
          menuFrame, "���Է���:"+score);
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
    }
  }
}

















