package cn.itcast.web.manager;

import java.io.IOException;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;
import cn.itcast.util.Global;

@SuppressWarnings("serial")
public class CategoryServlet extends BaseServlet {

	private Logger log = Logger.getLogger(this.getClass());

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ʵ����ҵ���CategoryService
		CategoryService categoryService = new CategoryService();
		
		List<Category> categorys = categoryService.findAllCategorys();
		
		request.setAttribute("categorys", categorys);
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "/message.jsp";
		try {
			// ��ȡ��������
			String name = request.getParameter("name");
			log.debug("name  " + name);// log4j��¼��־
			String description = request.getParameter("description");
			log.debug("description  " + description);// log4j��¼��־

			// ��װ�������ݵ�category
			Category category = new Category();
			category.setId(UUID.randomUUID().toString());
			category.setName(name);
			category.setDescription(description);

			// ʵ����ҵ���CategoryService
			CategoryService categoryService = new CategoryService();

			// ����ҳҵ��ķ���categoryService.save(category)
			categoryService.saveCategory(category);

			request.setAttribute("message",
					Global.CONTROLLER_CATEGORY_ADD_EXCEPTION);
			path = "/message.jsp";

		} catch (Exception e) {
			// e.printStackTrace();
			log.warn("e   " + e);
			log.debug("e.getMessage()  " + e.getMessage());
			System.out.println("e.getMessage():" + e.getMessage());
			request.setAttribute("message", e.getMessage());
			path = "/message.jsp";

		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
