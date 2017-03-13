package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = -4133538643155019229L;

	public MenuFrame() {
		init();
	}

	private void init() {
		setTitle("������������");
		setSize(600, 400);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);// ����
	}

	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(this.getClass().getResource("title.png"));// ͼƬ����:
		pane.add(BorderLayout.NORTH, new JLabel(icon));
		pane.add(BorderLayout.CENTER, createMenuPane());

		pane.add(BorderLayout.SOUTH,
				new JLabel("���ڿƼ�--��Ȩ���� ����ؾ�", JLabel.RIGHT));
		return pane;
	}

	public JPanel createMenuPane() {
		JPanel pane = new JPanel(new BorderLayout());
		// ��ؽ�info ���õ�����ؼ�����
		JLabel info = new JLabel("�ֶ��� ͬѧ ����", JLabel.CENTER);
		this.info=info;//�ֲ���������Ϊ��Ա����
		pane.add(BorderLayout.NORTH, info);
		pane.add(BorderLayout.CENTER, createBtnPane());
		
		return pane;
	}

	public JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton start = createImgBtn("exam.png", "��ʼ");
		JButton result = createImgBtn("result.png", "�鿴�ɼ�");
		JButton message = createImgBtn("message.png", "���Թ���");
		JButton exit = createImgBtn("exit.png", "�뿪");

		pane.add(start);
		pane.add(result);
		pane.add(message);
		pane.add(exit);
		// ͨ���˽ӿڻ��������������
		// setDefaultButton(JButton) ���� defaultButton ���ԣ���ȷ���� JRootPane �ĵ�ǰĬ�ϰ�ť��
		getRootPane().setDefaultButton(start);
		
	
		return pane;
	}
	
	

	// ����ͼƬ��ť�ķ���
	private JButton createImgBtn(String img, String txt) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource(img));
		/**JButton
				public JButton(String text,Icon icon)
    					����һ������ʼ�ı���ͼ��İ�ť��
    				������
        			text - ��ť���ı�
        			icon - ��ʾ�ڰ�ť�ϵ� Icon ͼ��
		 */
		JButton button = new JButton(txt, icon);
		button.setVerticalTextPosition(JButton.BOTTOM);// ��ֱ�ı�����λ��
		button.setHorizontalTextPosition(JButton.CENTER);// ˮƽ�ı�����λ��
		return button;
	}

	/**
	 *  8) ΪMenuFrame�������Ӹ����û���Ϣ�ķ��� updateView
  			��ؽ�info ���õ�����ؼ�����
  			private JLabel info;
  			public void updateView(User user) {
    				String str = "��ӭ "+user+" �μ�ɱ�ֿ���!";
    				info.setText(str);
	  		}
	 */
	private JLabel info;//�ֲ���������Ϊ��Ա����
	public void updateView(User user) {
		String str ="��ӭ " +user+" �μ�ɱ�ֿ��ԣ�";
		info.setText(str);
	}
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContxt){
		this.clientContext = clientContext;
	}

}
