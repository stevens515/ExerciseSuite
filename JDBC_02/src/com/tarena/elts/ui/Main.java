package com.tarena.elts.ui;

import com.tarena.elts.dao.UserDao;

public class Main {
  public static void main(String[] args) {
    // �������ж���, ע��, ���������ϵ
    LoginFrame loginFrame = new LoginFrame();

    WelcomeWindow welcomeWindow = new WelcomeWindow();
    ClientContext clientContext = new ClientContext();
    UserDao userDao = new UserDao();
    clientContext.setUserDao(userDao);

    clientContext.setWelcomeWindow(welcomeWindow);

    loginFrame.setClientContext(clientContext);
    clientContext.setLoginFrame(loginFrame);

    // ʹ��show()��ʾ��¼����
    clientContext.show();
  }

}
