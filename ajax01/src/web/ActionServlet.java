package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("service...");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(
				uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(action.equals("/check_username")){
//			try {
//				Thread.sleep(6000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			//ģ��������ڴ�������ʱ�����˴���
			if(1==2){
				throw new ServletException();
			}
			String username = request.getParameter("username");
			System.out.println("username:" + username);
			if(username.equals("����")){
				//�û����Ѿ�����
				out.println("�û����Ѿ�����");
			}else{
				out.println("����ʹ��");
			}
		}else if(action.equals("/check_number")){
			System.out.println("checkcode...");
			String number1 = 
				request.getParameter("number");
			HttpSession session = 
				request.getSession();
			String number2 = 
				(String) session.getAttribute("number");
			System.out.println("nubmer1:" + number1);
			System.out.println("number2:" + number2);
			if(!number1.equals(number2)){
				out.println("��֤�����");
			}else{
				out.println("��֤����ȷ");
			}
		}
		
		out.close();
	}

}
