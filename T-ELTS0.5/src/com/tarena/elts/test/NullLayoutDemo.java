package com.tarena.elts.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NullLayoutDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("�Զ��岼����ʾ");
    JPanel panel = new JPanel();
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    frame.setSize(464, 321);
    //���Ĭ�ϵĲ��ֹ���, ʹ���Զ��岼��. �Զ��������λ�úʹ�С
    panel.setLayout(null);//layout:����, null:û��, 
    ok.setLocation(291,262);
    ok.setSize(76,23);
    cancel.setLocation(371, 262);
    cancel.setSize(76,23);
    panel.add(ok);
    panel.add(cancel);
    frame.setContentPane(panel);
    frame.setVisible(true);
  }
}






