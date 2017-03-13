package com.tarena.elts.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("���ֹ���");
		JPanel content = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel btnPanel = new JPanel(new FlowLayout());
		JButton ok = new JButton("OK");
		JButton cancel =new JButton("Cannel");
//		JButton help = new JButton("help");
//		bottom.add(help);
		btnPanel.add(ok);
		btnPanel.add(cancel);
		bottom.add(BorderLayout.EAST,btnPanel);
		content.add(BorderLayout.SOUTH,bottom);
		frame.setContentPane(content);
		frame.setSize(380,300);
		frame.setVisible(true);
	}
}
