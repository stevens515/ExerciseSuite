package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SaleDao;

import net.sf.json.JSONArray;

import service.AccountService;
import entity.Sale;
import exception.AccountLimitException;
import exception.AccountNotExistException;


public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service......");
		String uri = request.getRequestURI();
		String action = 
			uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		//step1 ��������·������������ͬ�����ú��ʵ�ģ��������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(action.equals("/apply")){
			System.out.println("apply...........");
			AccountService service = new AccountService();
			String accountNo = request.getParameter("accountNo");
			Double amount = Double.parseDouble(request.getParameter("amount"));
			try{
				String rs = service.apply(accountNo, amount);
				request.setAttribute("rs", rs);
				request.getRequestDispatcher("viewapply.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				if(e instanceof AccountNotExistException){
					request.setAttribute("apply error","�˺Ų����� ");
				}else if(e instanceof AccountLimitException){
					request.setAttribute("apply_error", "����");
					request.getRequestDispatcher("apply.jsp").forward(request, response);
				}else{
					//ϵͳ�쳣�������û��Ժ�����
					throw new ServletException(e);
				}
			}
		}else if(action.equals("/city")){
			System.out.println("ActionServlet->city.....");
			String name = request.getParameter("name");
			if(name.equals("hn")){
				out.println("yy,����;hh,����;cs,��ɳ");
			}else if(name.equals("bj")){
				out.println("cy,����;hd,����;dc,����;xc,����");
			}
		out.close();
	}else if(action.equals("/saleinfo")){
		System.out.println("get saleinfo...;.");
		SaleDao dao = new SaleDao();
		try{
			List<Sale> sales = dao.find();
			JSONArray arry = JSONArray.fromObject(sales);
			out.println(arry.toString());
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
		out.close();
	}
}
