package com.tarena.elts.ui;//ui �����

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

/**
 * create �򵥹�����������װ�˸��Ӷ���Ĵ������̣�����һ������ʵ��
 */
/** ��¼���� ��һ�����崰�ڿ�*/
public class LoginFrame extends JFrame{
	private static final long serialVersionUID = -5402512922068320807L;
	
	public LoginFrame(){//���������� init()
		init();
	}
	/** ��ʼ����������Ͳ��ֵ�*/
	private void init(){
		this.setTitle("��¼ϵͳ");  //���ô��ڿ������
		JPanel contentPane = createContentPane(); //
		this.setContentPane(contentPane);
		
		//���ô��������ָ�������λ��
		setLocationRelativeTo(null);//����
		
		this.setSize(270, 188);
		//this.setVisible(true);
		
		//���ùرհ�ť   ����رհ�ťʱ�Ĳ��� 
		//DO_NOTHING_ON_CLOSE  �����κβ���
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				clientContext.exit(LoginFrame.this);
			}
		});
		
	}
	private JPanel createContentPane(){//����������
		JPanel p = new JPanel(new BorderLayout());
		//setBorder()���ñ߿�    EmptyBorder() ���ÿհױ߿�
		p.setBorder(new EmptyBorder(8,8,8,8)); //�������� ��ʱ��
		//��山����� �������ֱ�ǩ
		p.add(BorderLayout.NORTH,new JLabel("��¼����ϵͳ",JLabel.CENTER));
		//����м���� ����createCententPane()���� �������
		p.add(BorderLayout.CENTER,createCenterPane());//��װ
		//����ϱ���� ����createBtnPane()���� ��Ӱ�ť���
		p.add(BorderLayout.SOUTH,createBtnPane());
		return p;
	}
	private JPanel createBtnPane(){
		JPanel p = new JPanel(new FlowLayout());
		JButton login= new JButton("Login");
		JButton cancel = new JButton("Cancel");
		
		getRootPane().setDefaultButton(login);//�س���Ĭ�ϰ�ť
		
		p.add(login);
		p.add(cancel);
		
		//����ť��Ӷ���
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//System.out.println("click login button");//����
				clientContext.login();
			}
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//LoginFrame.this �ǵ�ǰLoginFrame�����ʵ��
				//���ǵ�¼���ڶ��������
				clientContext.exit(LoginFrame.this);
				//��ClientContext�����õ�¼����Ĵ���
			}
		});
		return p;
	}
	private JPanel createCenterPane(){
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(10,0,0,0));
		p.add(BorderLayout.NORTH,createIdPwdPane());
		message = new JLabel("",JLabel.CENTER);
		p.add(BorderLayout.CENTER,message);
		return p;
	}
	private JPanel createIdPwdPane(){
		//GridLayout() ��񲼾�
		//����ָ����������  2��1��     �м�࣬�м�� 
		JPanel p = new JPanel(new GridLayout(2,1,0,6));
		//��˳������
		p.add(createIdPane());
		p.add(createPwdPane());
		return p;
	}
	private JPanel createIdPane(){
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("��ţ�"));
		//JTextField() �ı���ؼ� �ı������ ���뵥���ı�
		JTextField idField = new JTextField();
		p.add(BorderLayout.CENTER,idField);
		//��ʵ������idField Ӧ�õ�����ؼ���
		this.idField = idField;//���������仰��
		//���淢����ָ���쳣
		return p;
	}
	private JPanel createPwdPane(){
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("���룺"));
		//JPasswordField()  ���������  �ԡ�*����ʾ 
		JPasswordField pwdField = new JPasswordField();
		pwdField.enableInputMethods(true);//��������뷨
		p.add(BorderLayout.CENTER,pwdField);
		this.pwdField = pwdField;
		return p;
	}
	
	private ClientContext clientContext;//����
	//��ֵ  IOC  ����ע��   ���������Ҫ��main��������
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	
	private JTextField idField;//�������
	private JPasswordField pwdField;
	private JLabel message;
	public int getUserId(){
		return Integer.parseInt(idField.getText());	//����ʮ���Ʊ�ʾ������ֵ
		//parseInt(s) ���ַ���������Ϊ�з��ŵ�ʮ�����������н���  ���صõ�������ֵ
		//����ַ����������ɽ��������� �׳�NumberFormatException  ���ָ�ʽ�쳣
		//s ����Ҫ������int ������ʽ��String   
		//idField.getText()//����idField�а������ı�
	}
	public String getPassword(){
		char[] pwd = pwdField.getPassword();
		//����pwdField�а������ı�
		return new String(pwd);
		//����һ���µ�String,ʹ���ʾ�ַ���������е�ǰ�������ַ�����
	}
	public void showMessage(String message){
		this.message.setText(message);
		//����������Ҫ��ʾ�ĵ����ı�
	}
}
