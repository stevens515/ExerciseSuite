package control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import util.ImageUtil;

public class ImageAction extends BaseAction{
		private InputStream imageStream;
		public String execute(){
			//map��key��ͼƬ���������ݣ�value��ͼƬ����
			Map<String,BufferedImage> map = ImageUtil.createImage();
			//��ȡkeyֵ����ͼƬ�����ݲ����뵽session��
			String code = map.keySet().iterator().next();
			session.put("code", code);
			BufferedImage image = map.get(code);
			//��iamge��ֵ��iamgeStream����
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			try {
				encoder.encode(image);
				byte[] bts = bos.toByteArray();
				imageStream = new ByteArrayInputStream(bts);
			} catch (ImageFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			return "success";
		}
		public InputStream getImageStream() {
			return imageStream;
		}
		public void setImageStream(InputStream imageStream) {
			this.imageStream = imageStream;
		}
		
}
