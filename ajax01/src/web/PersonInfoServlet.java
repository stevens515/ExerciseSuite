package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.DateProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import bean.Person;

@SuppressWarnings("serial")
public class PersonInfoServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PersonInfoServlet->service.......");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Person p = new Person();
		p.setName("zs");
		p.setBirthday(new Date());
		 	//	step2,ע�����ת������
		JsonConfig config = new JsonConfig();//����JsonConfig����
		DateProcessor processor = new DateProcessor();
		processor.setPattern("yyyy/MM/dd");
		//����Json����ʲô��ʽ
		config.registerJsonValueProcessor(Date.class, processor);//ע��һ��ת����
		JSONObject obj = JSONObject.fromObject(p, config);
		String str = obj.toString();
		out.println(str);
		out.close();
		
	}

}
