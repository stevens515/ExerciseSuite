package com.tarena.elts.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**Frame  picture.jpg
 * ͼƬ���ز���
 */
public class JFrameTest {
	public static void main(String[] args) {
		//��package�м�����Դ(image,text...,��)
		//JFrameTest.class��picture.jpg��ͬһ��������
		URL url = JFrameTest.class.getResource("picture.jpg");//URL��Դ��λ.getResource�ҵ�ͬһ�����е���Դ
		//Ҳ����ʹ�þ��Ե�package·��������Դ,������ϵͳ������ĵط����磺
		//ImageIcon(URL location)����ָ���� URL ����һ�� ImageIcon��
//		URL url = JFrameTest.class.getResource("/com/tarena/elts/test/picture.jpg");
		ImageIcon ico = new ImageIcon(url);
		JFrame frame = new JFrame("����ͼƬ����");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(ico);
		panel.add(label);
		frame.setContentPane(panel);
		frame.setSize(300,200);
		frame.setVisible(true);
	}
}
