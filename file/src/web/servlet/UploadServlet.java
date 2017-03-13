package web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.IOUtils;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ύ��������Ϊmultipart/form-data,�ڷ������˾Ͳ��ܲ��ô�ͳ��ʽ��ȡ����
		// String username = request.getParameter("username");
		// System.out.println(username);

		/*InputStream in = request.getInputStream();
		int len = 0;
		byte buffer[] = new byte[1024];
		while ((len = in.read(buffer)) > 0) {
			System.out.println(new String(buffer));
		}*/
		
		response.setContentType("text/html;charset=UTF-8");
		try{
			//1.������������
					DiskFileItemFactory factory = new DiskFileItemFactory();
					
			//2.����������
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//3.����request
			List<FileItem> list = upload.parseRequest(request);
			
			//4.����list,�õ������ÿ���������fileitem
			for(FileItem item:list){
				if(item.isFormField()){
					//��ǰ�õ�������ͨ������
					String name = item.getFieldName();//�õ�������name
					String value = item.getString();	//�õ������ֵ
					System.out.println(name+"="+value);
				}else{
					//��ǰitem��װ�����ϴ��ļ� 
					
					//��ȡ���ļ���
					String filename = item.getName(); //C:\Documents and Settings\ThinkPad\����\a.txt   a.txt				}
					//������İ汾��һ���õ���·���Ϳ��ܲ�ͳһ
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					
					InputStream in = item.getInputStream();
					String savepath=this.getServletContext().getRealPath("/WEB-INF/upload");
					FileOutputStream out = new FileOutputStream(savepath+"/"+filename);
					IOUtils.in2Out(in, out);
				}
			}
			response.getWriter().write("�ϴ��ɹ�!!!");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
