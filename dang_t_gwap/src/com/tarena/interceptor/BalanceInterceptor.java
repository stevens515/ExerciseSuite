package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * �����Ƿ��¼������
 * @author soft01
 *
 */
public class BalanceInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2547451996639196789L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ��ȡsession
		Map<String, Object> session = ActionContext.getContext().getSession();
		// ���sessionΪ��
		if (session.get("user") == null) {
			// ���ӵ�login_from.jsp
			return "login";
		}
		invocation.invoke();
		// ���ӵ�order_info.jsp
		return "success";
	}

}
