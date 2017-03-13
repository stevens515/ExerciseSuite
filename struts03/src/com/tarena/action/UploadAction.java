package com.tarena.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

public class UploadAction {
	private File mf;//�ϴ������ʱ�ļ�
	private String mfFileName;//��ȡԭ�ļ���
	private String mfContentType;//��ȡԭ�ļ�����

	//����ʱ�ļ����Ƶ�Ŀ��λ��
	public String execute(){
		System.out.println("����ʱ�ļ����Ƶ�Ŀ��λ��");
		try {
			FileInputStream fis = 
				     	new FileInputStream(mf);
			//��ȡ�洢�ļ���Ŀ��·��
			String path = ServletActionContext
				.getServletContext().getRealPath("/upload");
			String file = path+File.separatorChar
								+mfFileName;
			System.out.println("Ŀ��λ��:"+file);
			FileOutputStream fos = 
					new FileOutputStream(file);
			//һ�߶�һ��д
			byte[] b = new byte[1024];
			int size = -1;
			while((size = fis.read(b)) != -1){
				fos.write(b,0,size);
			}
			fis.close();
			fos.close();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	public String getMfContentType() {
		return mfContentType;
	}

	public void setMfContentType(String mfContentType) {
		this.mfContentType = mfContentType;
	}

	public String getMfFileName() {
		return mfFileName;
	}

	public void setMfFileName(String mfFileName) {
		this.mfFileName = mfFileName;
	}

	
	public File getMf() {
		return mf;
	}

	public void setMf(File mf) {
		this.mf = mf;
	}

}
