package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;

public class MenuFrame extends JFrame{
	public MenuFrame(){
		init();
	}
	private void init(){
		setTitle("������������");
		setSize(600,400);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);//����
		//�󶨴��ڹر��¼�
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				clientContext.exit(MenuFrame.this);
			}
		});
	}

	private JPanel createContentPane(){
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(this.getClass().getResource("title.png"));//ͼƬ����
		pane.add(BorderLayout.NORTH,new JLabel(icon));
		pane.add(BorderLayout.CENTER,createMenuPane());
		pane.add(BorderLayout.SOUTH,new JLabel("���ڿƼ�����Ȩ���� ����ؾ�",JLabel.RIGHT));
		return pane;
	}
	public JPanel createMenuPane(){
		JPanel pane = new JPanel(new BorderLayout());
		JLabel info = new JLabel("�ֶ���ͬѧ����",JLabel.CENTER);
		this.info = info;
		pane.add(BorderLayout.NORTH,info);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}
	public JPanel createBtnPane(){
		JPanel pane = new JPanel(new FlowLayout());
		JButton start = createImgBtn("exam.png","��ʼ");
		JButton result = createImgBtn("result.png","�鿴�ɼ�");
		JButton message = createImgBtn("message.png","���Թ���");
		JButton exit = createImgBtn("exit.png","�뿪");
		pane.add(start);
		pane.add(result);
		pane.add(message);
		pane.add(exit);
		//ͨ���˽ӿڻ��������������
		// setDefaultButton(JButton) ���� defaultButton ���ԣ���ȷ���� JRootPane �ĵ�ǰĬ�ϰ�ť��
		getRootPane().setDefaultButton(start);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.start();
			}
		});
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.exit(MenuFrame.this);
			}
		});
		message.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.getRules();
			}
		});
		result.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					clientContext.result();
				}
		});
		return pane;
	}
	//����ͼƬ��ť�ķ���
	private JButton createImgBtn(String img,String txt){
		ImageIcon icon = new ImageIcon(this.getClass().getResource(img));
		JButton button = new JButton(txt,icon);
		button.setVerticalTextPosition(JButton.BOTTOM);//��ֱ�ı�����λ�� 
		button.setHorizontalTextPosition(JButton.CENTER);//ˮƽ�ı�����λ��
		return button;
	}
	private JLabel info;
	public void updateView(User user) {
		String str = "��ӭ "+user+"�μ�ɱ�ֿ��ԣ�";
		info.setText(str);
	}
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
		this.clientContext = clientContext;
	}
}
