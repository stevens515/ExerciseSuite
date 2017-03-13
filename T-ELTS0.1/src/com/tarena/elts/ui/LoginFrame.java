package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * ��½������һ���崰�ڿ�
 * ������ƣ�һ��ֻ���һ��������ʹ�õ�ԭ�� 
 */
public class LoginFrame extends JFrame{

	private static final long serialVersionUID = -7993721800179709451L;
	public LoginFrame(){
		init();
	}
	/**��ʼ����������Ͳ��ֵ�*/
	private void init(){
		this.setTitle("��¼ϵͳ");//���ñ�����
		JPanel contentPane = createContentPane();//����������壬frame�м�Ĵ����
		this.setContentPane(contentPane);//���ڴ����ϡ�this��contentPane.
		setLocationRelativeTo(null);//����
		setSize(270,288);
	}
	private JPanel createContentPane(){
		JPanel p = new JPanel(new BorderLayout());//��������ָ�����ֹ��������»��� JPanel��
		//EmptyBorder(int top, int left, int bottom, int right)��������ָ�� insets �Ŀձ߿�
		p.setBorder(new EmptyBorder(8,8,8,8));//���ñ߿�
		p.add(BorderLayout.NORTH, new JLabel("��½����ϵͳ",JLabel.CENTER));
		p.add(BorderLayout.CENTER, createCenterPane());
		p.add(BorderLayout.SOUTH,createBtnPane());
		return p;
	}
	private JPanel createBtnPane(){
		JPanel p = new JPanel(new FlowLayout());
		JButton login = new JButton("Login"); //��½
		JButton cancel = new JButton("Cancel");
		
		getRootPane().setDefaultButton(login);//����Ĭ�ϻس���Ŧ
		
		p.add(login);
		p.add(cancel);
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 //System.out.println("click login button");
				clientContext.login();
			}
		});
		return p;
	}
	private JPanel createCenterPane(){
		JPanel p = new JPanel(new BorderLayout());
		p.add(BorderLayout.NORTH,createIdPwdPane());
		return p;
	}
	private JPanel createIdPwdPane(){
		JPanel p = new JPanel(new GridLayout(2,1));//��񲼾�,����һ��
		p.add(createIdPane());
		p.add(createPwdPane());
		return p;
	}
	private JPanel createIdPane(){//������������
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("��ţ�"));
		JTextField idField  = new JTextField();
		p.add(BorderLayout.CENTER,idField);
		//ʵ������idField���õ�����ؼ���
		this.idField = idField;//�ѽ����ϵ����룬���뵽....
		idField.enableInputMethods(true);//Linux bug
		p.add(BorderLayout.CENTER,idField);
		return p;
	}
	/**
	 * �򵥹�����������װ�ĸ��Ӷ���Ĵ������̣�����һ������ʵ��
	 */
	private JPanel createPwdPane(){
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("���룺"));
		JPasswordField pwdField = new JPasswordField();
		pwdField.enableInputMethods(true);//�������뷨
		p.add(BorderLayout.CENTER,pwdField);
		this.pwdField = pwdField;//���뵽������
		pwdField.enableInputMethods(true);//Linux bug
		p.add(BorderLayout.CENTER,pwdField);
		return p;
	}
	private JPanel createBottomPane(){
		JPanel p = new JPanel(new FlowLayout());
		JButton login = new JButton("��¼");
		JButton cancel = new JButton("ȡ��");
		p.add(login);
		p.add(cancel);
		login.addActionListener(new ActionListener(){
		 /**����ť���󱻵��ʱ��, ��ִ�з���actionPerformed()
		   ActionListener����login��ť��ʱ����� 
		   ActionEvent e �ǰ�ť�����ʱ��, ������Ϣ(���λ��)
		   ������Ǹ�����(�Ǹ���ť)��
		  */
			public void actionPerformed(ActionEvent e) {
			/**
			 	System.out.println("�����Login"+e.getWhen());
        		���ʿ������ṩ�ĵ�¼����, ��ɵ�¼����
        		clientContext.login()����ClientContextʵ��
			 */
				clientContext.login();
			}
		});
		return p;
	}
	//...........
	/**ClientContext:�ͻ��������ģ���Ϊ�ͻ��˽��������*/
	ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
	    //clientContext��ʵ��ͨ��setClientContext()ע�뵽
	    //��ǰ���������this.clientContext��
	    //����ע��: IOC
		this.clientContext = clientContext;
	}
	private JTextField idField;
	private JPasswordField pwdField;
	private JLabel message;
	public int getUserId(){
		return Integer.parseInt(idField.getText());
	}
	public String getPassword(){
		char[] pwd = pwdField.getPassword();//Ϊ��ȫ��sun�涨����char����
	    return new String(pwd);//ת�����ַ���
	    //return new String(pwdField.getPassword());//���������д
	}
	public void showMessage(String message){
		this.message.setText(message);
	}
}
