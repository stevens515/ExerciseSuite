package com.wangxin.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.wangxin.util.PropertiesUtil;

//�����齨���ڷ�װ������־�齨
public class LogAspect {
	Logger logger = Logger.getLogger(LogAspect.class);
	//���û���֪ͨ����
	public Object logger(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("��ʼִ��");
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getSimpleName();
		String key = className+"."+methodName;
		String message = PropertiesUtil.getValue(key);
		Object obj = pjp.proceed();//����Ŀ�����ķ���
		System.out.println(message+"�������");
		logger.info(message);
		return obj;
	}
}
