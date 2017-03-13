package com.tarena.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tarena.util.DbPoolUtil;

/**
 * ����������
 * 
 * @author soft01
 * 
 */
public class TransactionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2996969084618907383L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			// ���Զ��ύ���false
			DbPoolUtil.getConnection().setAutoCommit(false);
			// ����������
			invocation.invoke();
			// �ύ
			DbPoolUtil.getConnection().commit();
		} catch (Exception e) {
			Logger logger = Logger.getLogger(TransactionInterceptor.class);
			logger.error("��������ع�֮ǰ���쳣��Ϣ", e);
			DbPoolUtil.getConnection().rollback();
		} finally {
			// �ر����ݿ�����
			DbPoolUtil.close();
		}
		return null;
	}

}
