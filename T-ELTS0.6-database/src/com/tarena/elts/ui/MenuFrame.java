package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;
//import com.tarena.elts.util.Config;

/** ���˵����� */
public class MenuFrame extends JFrame {
	
	private static final long serialVersionUID = -1796834130339697339L;
	
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	
	public MenuFrame() {
		init();
	}

	/** ��ʼ����������Ͳ��� */
	private void init() {//
		setLocationRelativeTo(null);
		this.setTitle("������������");
		// JPanel contentPane = createContentPane();
		// this.setContentPane(contentPane);
		
		this.setContentPane(createContentPane());
		this.setSize(600, 400);
		//this.setVisible(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//e.getOldState();//e ��ǰ��״̬
				clientContext.exit(MenuFrame.this);
			}
		});
	}

	private JPanel createContentPane() {
		JPanel p = new JPanel(new BorderLayout());

		ImageIcon ico = new ImageIcon(this.getClass().getResource("title.png"));
		// MunuFrame.class.getResource("title.png");
		// p.setBorder(new EmptyBorder(8,8,8,8));
		p.add(BorderLayout.NORTH, new JLabel(ico));
		p.add(BorderLayout.CENTER, createCenterPane());
		p.add(BorderLayout.SOUTH,
				new JLabel("��Ȩ���У������ɱ�����ڿƼ�2012", JLabel.RIGHT));
		return p;
	}

	private JPanel createCenterPane() {
		JPanel p = new JPanel(new BorderLayout());
		// ��ؽ�info ���õ�����ؼ�����
		//p.add(BorderLayout.NORTH, new JLabel("��ӭ�������� ͬѧ", JLabel.CENTER));
	    info = new JLabel("��ӭ:XXX ͬѧ��ã�",JLabel.CENTER);
		p.add(BorderLayout.NORTH,info);
		p.add(BorderLayout.CENTER, createBtnPane());
		return p;
	}

	private JPanel createBtnPane() {
		JPanel p = new JPanel(new FlowLayout());

		JButton start = createImgBtn("exam.png", "��ʼ");
		JButton result = createImgBtn("result.png", "���Գɼ�");
		JButton msg = createImgBtn("message.png", "���Թ���");
		JButton exit = createImgBtn("exit.png", "�뿪");

		getRootPane().setDefaultButton(start);//�س���Ĭ�ϰ�ť
		
		p.add(start);
		p.add(result);
		p.add(msg);
		p.add(exit);
		
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.start();
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//System.out.println("clsi");
				clientContext.exit(MenuFrame.this);
			}
		});
		result.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//e ��������ʲô
				//long clickTime = e.getWhen();//������鷢��ʱ��
				clientContext.result();
			}
		});
		msg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.msg();
			}
		});

		return p;
	}

	/** ����ͼƬ��ť�ķ��� */
	private JButton createImgBtn(String img, String txt) {
		ImageIcon ico = new ImageIcon(this.getClass().getResource(img));
		JButton button = new JButton(txt, ico);
		//button.setIcon(ico);
		//��ֱ�ı�����λ��
		button.setVerticalTextPosition(JButton.BOTTOM);
		//ˮƽ�ı�����λ��
		button.setHorizontalTextPosition(JButton.CENTER);
		return button;
	}
	private JLabel info;
	
	public void updateView(User user) {
		info.setText("��ã� "+user+" СͯЬ����ӭ���뿼��ϵͳ ");
	}
}
