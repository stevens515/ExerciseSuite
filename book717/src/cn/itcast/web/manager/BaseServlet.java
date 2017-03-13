package cn.itcast.web.manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			// ��ȡҪ���÷��������ƣ����䣩
			String methodName = request.getParameter("method");

			// ��ȡ�����Ĳ�������
			Class parameterTypes[] = { HttpServletRequest.class,
					HttpServletResponse.class };

			// ��ȡҪ���� �ķ����ķ�װ����
			Method method = this.getClass().getMethod(methodName,
					parameterTypes);

			// �����Ĳ���
			Object[] args = { request, response };

			// ���������ķ���
			method.invoke(this, args);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
