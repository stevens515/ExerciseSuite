package com.tarena.elts.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**1
 * ����������������д + ��Ŀ���� 
 * test ���԰�
 */
/**ͼƬ���ز���*/
public class JFrameTest {
	public static void main(String[] args) {
		//��package�м�����Դ(image,text,��...)
		//JFrameTest.class �� img.png ��ͬһ������
		//URL ur1 = JFrameTest.class.getResource("img.jpg");//��ȡ img ��Դ
		//Ҳ����ʹ�þݶ�package·��������Դ�� �硰
		URL ur1 = JFrameTest.class.getResource(
				"/com/tarena/elts/test/img.jpg");
		ImageIcon ico= new ImageIcon(ur1); 
		JFrame frame = new JFrame("����ͼƬ����");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(ico);
		panel.add(label);
		frame.setContentPane(panel);
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}
