package web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import exception.ExtException;

import utils.IOUtils;

@SuppressWarnings("serial")
public class UploadServlet2 extends HttpServlet {

	@SuppressWarnings("unchecked")
	private List exts = Arrays.asList("jpg", "gif", "png", "jsp", "txt", "java");

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		// request.setCharacterEncoding("UTF-8");//mime

		if (!ServletFileUpload.isMultipartContent(request)) {
			// ִ�մ�ͳ��ʽ��ȡ����
			return;
		}

		try {
			// 1.������������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));

			// 2.����������
			ServletFileUpload upload = new ServletFileUpload(factory);

			// upload.setFileSizeMax(1024*1024);
			upload.setHeaderEncoding("UTF-8");// ���ô���ͷ�ļ� �ı���

			// 3.����request
			List<FileItem> list = upload.parseRequest(request);

			// 4.����list���õ������ÿ���������fileitem
			for (FileItem item : list) {
				if (item.isFormField()) {
					// ��ǰ�õ�������ͨ������
					String name = item.getFieldName();
					String value = item.getString("UTF-8");// ����ͬ�¾䣬�ѵõ�������
															// ת��utf-8
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
					System.out.println(name + "=" + value);
				} else {
					// ��ǰitem�� װ�����ϴ��ļ�

					// ��ȡ���ļ���
					String filename = item.getName();// Settings\ThinkPad\����\a.txt
														// , a.txt
					if (filename == null || filename.trim().equals("")) {
						continue;
					}

					// �ж��ļ��Ƿ�Ϊ�����ϴ����ļ�
					String ext = filename.substring(filename.lastIndexOf(".") + 1);// "jpg","gif","bmp","jsp","txt","java"
					if (!exts.contains(ext)) {
						// ���䴦�� MVC��servlet���ת��һ��jsp�ļ� ����������õİ취�����쳣��
						// �쳣��̳���Exception���Ǳ���ʱ�쳣�����봦��ģ����û��Ѻ���ʾ��Ҫ��
						// ��RuntimeException������ʱ������������Ǵ����Ͳ��Ѻ���
						// ԭ��:��������Ҫ�������쳣�̳�Exception������Ҫ��������̳���RuntimeExcepiton
						throw new ExtException("�ļ�ֻ���ǣ�" + exts.toString());
					}

					filename = filename.substring(filename.lastIndexOf("\\") + 1); // �õ��ϴ��ļ�������
					String saveFilename = makeFileName(filename);// Ϊ�ϴ��ļ�����һ��Ψһ���ļ���

					String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
					savepath = makeSavePath(saveFilename, savepath);// �õ��ļ�
																	// �ı���Ŀ¼

					InputStream in = item.getInputStream();

					FileOutputStream out = new FileOutputStream(savepath + "/" + saveFilename);
					IOUtils.in2Out(in, out);
					item.delete();// ɾ��item��Ӧ����ʱ�ļ�

				}
			}
			response.getWriter().write("�ϴ��ɹ� �� ��");
		} catch (ExtException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;// ���ط������ô�
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("message", "�ļ����ܳ���1M");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String makeSavePath(String filename, String uploadPath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf;
		int dir2 = (hashcode >> 4) & 0xf;

		String savepath = uploadPath + File.separator + dir1 + File.separator + dir2;

		File file = new File(savepath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return savepath;
	}

	public String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;// //sdfjlsjflsjflkjfds_1.html
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
