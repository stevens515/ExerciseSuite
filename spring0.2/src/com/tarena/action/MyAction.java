package com.tarena.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@Scope
public class MyAction {
	public MyAction(){
		System.out.println("����һ��MyAction����");
	}
	public void myinit(){
		System.out.println("��MyAction�����ʼ��");
	}
	public void mydestroy(){
		System.out.println("��MyAction��������");
	}
	
}	
