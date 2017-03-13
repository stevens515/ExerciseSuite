package com.wangxin.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UploadAction extends BaseAction{
		private String some;//�ͻ����ļ�xxx
		private String someFileName;//�ļ���xxxFileName
		private String ContentType;//�ļ�����
		//����ļ���·��
		private String imagePath;
		
		
		public String execute(){
			//��������ϴ��ļ���
			String imageName =
			     "file_" + System.currentTimeMillis()+ someFileName.substring(someFileName.lastIndexOf("."));
			/*
			 * �ϴ��ļ������·��
			 * ���ӵ�ʱ��ʹ��
			 */
			imagePath = "upload/" + imageName;
			/*
			  * �ϴ��ļ��ľ���·��
			  * д�ļ�ʱʹ��
			  */
			
			String realImagePath = httpApplication.getRealPath(imagePath);
			System.out.println(realImagePath);
			//�ӻ����ж�ȡͼƬ�ļ�
			BufferedInputStream is;
			try {
				is = new BufferedInputStream(
				            new FileInputStream(some));
				BufferedOutputStream os = new BufferedOutputStream(
						new FileOutputStream(realImagePath));
				int len = -1;
				byte[] buf = new byte[1024];
				while(-1!= (len = is.read(buf))){
					os.write(buf, 0, len);
				}
				is.close();
				os.close();
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}


		}
		public String getSome() {
			return some;
		}
		public void setSome(String some) {
			this.some = some;
		}
		public String getSomeFileName() {
			return someFileName;
		}
		public void setSomeFileName(String someFileName) {
			this.someFileName = someFileName;
		}
		public String getContentType() {
			return ContentType;
		}
		public void setContentType(String contentType) {
			ContentType = contentType;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		
		
}
