package com.tarena.action.user;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.tarena.action.BaseAction;
import com.tarena.util.ImageUtil;

/**
 * ������������ͼƬ
 * @author soft01
 *
 */
public class ImageAction extends BaseAction {
	private static final long serialVersionUID = 2442787106435367353L;
	//input
	private InputStream imageStream;

	public ImageAction() {
	}
	public String execute() {
		// ��������ͼƬ�ķ�������ֵ��map����
		Map<String, BufferedImage> map = ImageUtil.createImage();
		String code = map.keySet().iterator().next();
		// �����ɵ�code����session�����ں������û�����ıȶ�
		session.put("code", code);
		// ����ͼƬ
		BufferedImage img = map.get(code);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
		try {
			encoder.encode(img);
			byte[] bts = baos.toByteArray();
			imageStream = new ByteArrayInputStream(bts);
		} catch (Exception e) {
			Logger logger=Logger.getLogger(ImageAction.class);
			logger.error("����ͼƬ��action��������", e);
		}
		// ����ɹ�����һ��������
		return "success";
	}

	// getter and setter
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

	public InputStream getImageStream() {
		return imageStream;
	}
}
