package com.cenrise.proxy.dynamicproxy.section2;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class RealSubject implements Subject {

	//ҵ�����
	public void doSomething(String str) {
		System.out.println("do something!---->" + str);
	}

}
