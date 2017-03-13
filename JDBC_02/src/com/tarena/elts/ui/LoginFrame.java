package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** ��¼���� ��һ�����崰�ڿ� */
public class LoginFrame extends JFrame{
  /**
   * 
   */
  private static final long serialVersionUID = -7993721800179709451L;
  public LoginFrame() {
    init();
  }
  /** ��ʼ����������Ͳ��ֵ� */
  private void init(){
    this.setTitle("��¼ϵͳ");
    JPanel contentPane = createContentPane();
    this.setContentPane(contentPane);
    setSize(270,188);
    setLocationRelativeTo(null);//����
    
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        clientContext.exit(LoginFrame.this);
      }
    });
    
  }
  private JPanel createContentPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(new EmptyBorder(8,8,8,8));
    p.add(BorderLayout.NORTH, 
        new JLabel("��¼����ϵͳ", JLabel.CENTER));
    p.add(BorderLayout.CENTER, createCenterPane());
    p.add(BorderLayout.SOUTH, createBtnPane());
    return p;
  }
  private JPanel createBtnPane(){
    JPanel p = new JPanel(new FlowLayout());
    JButton login = new JButton("Login");
    JButton cancel = new JButton("Cancel");
    
    getRootPane().setDefaultButton(login);
    
    p.add(login);
    p.add(cancel);
    
    login.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        //System.out.println("click login button");
        clientContext.login();
      }
    });
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //LoginFrame.this �ǵ�ǰLoginFrame�����ʵ��
        //���ǵ�¼���ڶ��������
        clientContext.exit(LoginFrame.this);
      }
    });
    
    return p;
  }
  private JPanel createCenterPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(new EmptyBorder(8,0,0,0));
    p.add(BorderLayout.NORTH, createIdPwdPane());
    message = new JLabel("",JLabel.CENTER);
    p.add(BorderLayout.CENTER, message);
    return p;
  }
  private JPanel createIdPwdPane(){
    JPanel p =  new JPanel(new GridLayout(2, 1, 0, 6));
    p.add(createIdPane());
    p.add(createPwdPane());
    return p;
  }
  private JPanel createIdPane(){
    JPanel p = new JPanel(new BorderLayout(6,0));
    p.add(BorderLayout.WEST, new JLabel("���:"));
    JTextField idField = new JTextField();
    p.add(BorderLayout.CENTER, idField);
    //��ʵ������idField ���õ�����ؼ���
    this.idField = idField;
    return p;
  }
  /** �򵥹�������, ��װ�ĸ��Ӷ���Ĵ�������, ����һ������ʵ�� */
  private JPanel createPwdPane(){
    JPanel p = new JPanel(new BorderLayout(6,0));
    p.add(BorderLayout.WEST, new JLabel("����:"));
    JPasswordField pwdField = new JPasswordField();
    pwdField.enableInputMethods(true);
    p.add(BorderLayout.CENTER, pwdField);
    this.pwdField = pwdField;
    return p;
  }
  private ClientContext clientContext;
  public void setClientContext(ClientContext clientContext) {
    this.clientContext = clientContext;
  }
  private JTextField idField;
  private JPasswordField pwdField;
  private JLabel message;
  public int getUserId(){
    return Integer.parseInt(idField.getText());
  }
  public String getPassword(){
    char[] pwd = pwdField.getPassword();
    return new String(pwd);
  }
  public void showMessage(String message){
    this.message.setText(message);
  }
}








