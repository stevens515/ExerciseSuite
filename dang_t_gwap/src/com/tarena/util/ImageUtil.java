package com.tarena.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ����Ϊ����ͼƬ�Ĺ�����
 * 
 * @author soft01
 * 
 */
public class ImageUtil implements Serializable {
	private static final long serialVersionUID = -8309498246462328056L;
	// ����ͼƬ�ϵ��ַ�
	private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z" };
	// ͼƬ�ϵ��ַ�����
	private static final int SIZE = 4;
	// ͼƬ���ߵ�����
	private static final int LINES = 10;
	// ͼƬ�Ŀ��
	private static final int WIDTH = 300;
	// ͼƬ�ĸ߶�
	private static final int HEIGHT = 100;
	// ͼƬ���ַ�������
	private static final int FONT_SIZE = 60;

	/**
	 * ����ͼƬ�ķ���
	 * 
	 * @return ����һ�������ַ���ͼƬ��������Map����
	 */
	public static Map<String, BufferedImage> createImage() {
		StringBuffer sb = new StringBuffer();
		BufferedImage img = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = img.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		Random random = new Random();
		// ������ַ�
		for (int i = 1; i <= SIZE; i++) {
			int ran = random.nextInt(chars.length);
			graphics.setColor(getRandomColor());
			graphics
					.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			graphics.drawString(chars[ran], (i - 1) * WIDTH / SIZE, HEIGHT / 2);
			// ���ַ����棬����Session
			sb.append(chars[ran]);
		}
		// ��������
		for (int i = 1; i <= LINES; i++) {
			graphics.setColor(getRandomColor());
			graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
					random.nextInt(WIDTH), random.nextInt(HEIGHT));
		}
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(sb.toString(), img);
		return map;
	}

	/**
	 * ��ȡ�����ɫ
	 * 
	 * @return
	 */
	private static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran
				.nextInt(256));
		return color;
	}

	// public static void main(String[] args) {
	// Map<String, BufferedImage> map = createImage();
	// System.out.println(map.size());
	// }
}
