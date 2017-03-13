package com.tarena.elts.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.dao.UserDao;
import com.tarena.elts.entity.User;

/** �ͻ����������: �ͻ��������Ļ��� */
public class ClientContext {
  private UserDao userDao;

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  // private LoginFrame loginFrame = new LoginFrame();
  private LoginFrame loginFrame;

  /** ����ע��(IOC) ����ע�����loginFrame��ʵ�� */
  public void setLoginFrame(LoginFrame loginFrame) {
    this.loginFrame = loginFrame;
  }

  private WelcomeWindow welcomeWindow;

  public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
    this.welcomeWindow = welcomeWindow;
  }

  /**
   * ��ʾ����Ŀ�ʼ����, ����ʾ��¼���� show()����������, ���������� loginFrame�������� ����Ľ������,
   * ���������������������setLoginFrame() ע��, ע������������ʵ��!
   **/
  public void show() {
    loginFrame.setVisible(true);
  }

  /**
   * �˷����� login��ť����! ��¼ϵͳ, �����߼� 1 �ӵ�¼�������û���ID��pwd 2 ����ҵ��ģ�͵�login������ɵ�¼���� 3
   * ���ݵ�¼�Ľ��, ����ɹ��� ���²˵�����,��ʾ�û���Ϣ �رյ�¼����, �򿪲˵����� 4 �����¼ʧ�ܾ��ڵ�¼��������ʾʧ����Ϣ
   */
  public void login() {
    try {
      System.out.println("login");
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPassword();
      User user = userDao.findUserByIdAndPwd(id, pwd);
      if (user != null) {
        System.out.println("��¼�ɹ�!!!");
      } else {
        System.out.println("��¼ʧ��!!!");
      }
    } catch (Exception e) {
      // ��ʾ�������....
    }
  }

  /**
   * �˳�ϵͳ �����߼�
   * 
   * @param source
   *          �������һ�������˳�. ��һ�����ڵ�����
   */
  public void exit(JFrame source) {
    // Confirm ȷ��
    // Dialog �Ի���
    int val = JOptionPane.showConfirmDialog(source, "�뿪��?");
    if (val == JOptionPane.YES_OPTION) {
      System.exit(0);// ������ǰJava����
    }
  }
}
