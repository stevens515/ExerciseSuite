package com.tarena.elts.test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**2
 * �ղ�����ʾ
 */
public class NullLayoutDemo {
	public static void main(String[] args) {
		ImageIcon ico =new ImageIcon(
				NullLayoutDemo.class.getResource("course.png"));
		
		JFrame frame = new JFrame("�Զ��岼����ʾ");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(ico);
		JButton ok = new JButton("OK");//��ť
		JButton cancel = new JButton("Cancel");
		
		frame.setSize(464,321);
		//���Ĭ�ϵĲ��ֹ���ʹ���Զ��岼�֣������λ�úʹ�С
		//panel.setLayout(null);//layout:���� ��null:û��
		
		label.setLocation(1, 1);
		label.setSize(300,300);
		ok.setLocation(291,262);//��ť����λ��
		ok.setSize(76,23);//��ť��С
		cancel.setLocation(371,262);
		cancel.setSize(76,23);
		
		panel.add(label);
		panel.add(ok);
		panel.add(cancel);
		
		
		frame.setContentPane(panel);//ContentPane swing ��׼����
		//���� panel ���
		frame.setVisible(true);
	}
}
