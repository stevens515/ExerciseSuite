package tarena.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController{
	
	//Ĭ��ִ�еĴ�����
	public ModelAndView onSubmit(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object command,
			BindException errors) throws Exception {
		User user = (User)command;
		String name = user.getName();
		String pwd = user.getPassword();
		Map model = new ModelMap();
		if("scott".equalsIgnoreCase(name) 
				&& "123456".equals(pwd)){
			model.put("name", name);
			//ע��:��ʾ����Ҫʹ����ͼ�����
			//����ok.jsp��дok
			return new ModelAndView("ok",model);
		}else{
			model.put("error", "�û������������");
			return new ModelAndView("login",model);
		}
		
	}

}
