package com.tarena.elts.test;

import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** ͼƬ���ز��� */
public class JFrameTest {
  public static void main(String[] args) {
    //��package�м�����Դ(image, text, �� ...)
    // JFrameTest.class �� img.png ��ͬһ������
    //URL url = JFrameTest.class.getResource("img.png"); 
    //Ҳ����ʹ�þ���package·��������Դ: ��:
    URL url = JFrameTest.class.getResource(
        "/com/tarena/elts/test/img.png");
    //InputStream in = url.openStream();
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






