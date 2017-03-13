package basic.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import basic.day16.IOUtils;
/**
 *ImageIO�ṩ�˽�byte�����ˣ������л���ΪͼƬ����ķ���
 *���ڴ�Image����д�뵽�ļ��У�����Ҫ���룯���л�
 */
//��ȡ��Ƭ������ʾ��ͼ�ν�����
//ImageIO:�������һЩ�������� ImageReader �� ImageWriter �Լ�ִ�м򵥱���ͽ���ľ�̬��ݷ����� 
public class ImageIODemo {
	public static void main(String[] args) throws IOException {
		
		File dir = new File(".");
		String pathname = dir.getCanonicalPath();
		// ��eclipse�У���ǰĿ¼�ǡ���Ŀ�ļ��С�
		System.out.println(pathname);//pwd
		
		String file = "test/zhaopian1.jpg";
		InputStream in = new FileInputStream(file);//byte��

		BufferedImage img = ImageIO.read(in);//����
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.BLUE);
		g.drawString("By Robin", 50, 50);
		OutputStream out = new FileOutputStream("zhaopian3.jpeg");//���ʱ���������ĸ�ʽ
		ImageIO.write(img, "jpeg", out);//����Ƭ����jpeg��ʽȡ��
		IOUtils.print("img.jpeg");
		JFrame frame = new JFrame("�鿴��Ƭ");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon(img));
		panel.add(label);
		frame.setContentPane(panel);
		frame.setSize(800,700);
		frame.setVisible(true);
		
	
		
	}
}
