package web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.IOUtils;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//���Ҫ���ص��ļ���
			String filename = request.getParameter("filename");
			//�Ѵ��ļ� �еõ����ļ���is08859-1���룩��ת����UTF��8����֤������������
			//�ļ� ���ϴ�������ͨ��MIMEЭ�鴫��ģ���������롣��Ҫָ��ת����
			filename = new String(filename.getBytes("iso8859-1"),"UTF-8");
			
			//�õ��ļ��ı���Ŀ¼
			String filepath = this.getServletContext().getRealPath("/WEB-INF/upload")+"\\"+getFilePath(filename);
			
			//�õ��ļ��Ƿ����
			File file = new File(filepath+"\\"+filename);
			if(!file.exists()){
				request.setAttribute("message", "�Բ�����Ҫ������Դ�ѱ�ɾ������");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			//indexOf()���Ҳ�������-1�����䣡
			String realname = filename.substring(filename.indexOf("_")+1);
			//�����ʾ���û������ضԻ������������ļ����Ļ���Ҫ����url���룬��Ϊһ����Ϣͷ������������˵�����ѡ�� �����ز���
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(realname,"UTF-8"));
			
			FileInputStream in = new FileInputStream(file);
			//��out�����عرգ�����response�õ��ģ��ɷ������Լ��رգ��������дIOUtils.in2Out2��in,out����ԭ��
			OutputStream out = response.getOutputStream();
			IOUtils.in2Out2(in,out);
			
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request,response);
}
	/**
	 * 	ͨ����ϣ��õ��ļ�·�����ڹ�ϣ�����ļ���ͨ������洢�ġ�
	 * @param filename	�ļ���
	 * @return		�ļ�·��
	 */
	public String getFilePath(String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf;
		int dir2 = (hashcode>>4)&0xf;
		return dir1+"\\"+dir2;
	}
}
