package com.tarena.elts.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**3
 * ����
 */
public class LayoutDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("���ֹ���");
		//���
		JPanel content = new JPanel(new BorderLayout());//����
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel btnPanel1 = new JPanel(new FlowLayout());
		JPanel btnPanel = new JPanel(new FlowLayout());
		//��ť
		JButton help = new JButton("HELP?");
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		
		btnPanel1.add(help);
		btnPanel.add(ok);
		btnPanel.add(cancel);
		bottom.add(BorderLayout.WEST,btnPanel1);
		bottom.add(BorderLayout.EAST,btnPanel);
		content.add(BorderLayout.SOUTH,bottom);
		
		frame.setContentPane(content);
		frame.setSize(380,300);
		frame.setVisible(true);
		//����������swing Ƥ��  ����
		//swing ��������Ƥ��
	}

}
