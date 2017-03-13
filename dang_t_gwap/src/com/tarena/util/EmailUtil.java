package com.tarena.util;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * Send Email Util
 * 
 * @author soft01
 * 
 */
public class EmailUtil implements Serializable {
	private static final long serialVersionUID = -1297114529213853132L;

	/**
	 * send email
	 * 
	 * @param email
	 * @param title
	 * @param content
	 */
	public static void sendEmail(String email, String title, String content) {
		Logger logger = Logger.getLogger(EmailUtil.class);
		logger.info("-----send email:" + email + "-----");
		logger.info("-----����:" + title + "-----");
		logger.info("-----����:" + content + "-----");
		// ��ʾ,ʵ��ʱ�ɲο��ʼ�����ʾ��
	}
}
