package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ��װ��¼���
 * @author Administrator
 *
 */
public class LoginInterceptor extends AbstractInterceptor{
	//������
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("������ǰ�ڴ���");
		//��¼���
		Map<String,Object> session = 
				ActionContext.getContext().getSession();
		if(session.get("user") == null){
			//δ��¼,��λ��login.jsp
			return "login";
		}
//		������һ������������Action-->Result��ҵ�񷽷�
		String result = invocation.invoke();
		//invocation.invokeActionOnly()
		System.out.println("���������ڴ���");
		return result;
	}

}
