package com.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.ChoiceQuestion;
import com.tarena.entity.EssayQuestion;
import com.tarena.entity.Question;
import com.tarena.util.HibernateUtil;

public class TestQuestion {
//	@Test
	public void testAddChoiceQuestion(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//���ѡ����
		ChoiceQuestion question = new ChoiceQuestion();
		question.setName("������һλ������");
		question.setOptions("Aܽ��|BС����|C���|D��¥");
		question.setLevel("��");
		question.setAnswerOptions("D");
		session.save(question);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
//	@Test
	public void testAddEssayQuestion(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//��Ӽ����
		EssayQuestion question = new EssayQuestion();
		question.setName("��ĸ�׺����ŵ�ˮ��,�Ⱦ�˭?");
		question.setLevel("��");
		question.setAnswerEssay("��Ҳ��");
		session.save(question);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
//	@Test
	public void testLoadChoiceQuestion(){
		Session session = HibernateUtil.getSession();
		ChoiceQuestion question = (ChoiceQuestion)
			session.load(ChoiceQuestion.class, 1);
		System.out.println(question.getName());
		System.out.println(question.getOptions());
		System.out.println(question.getAnswerOptions());
		HibernateUtil.closeSession();
	}
	
//	@Test
	public void testLoadEssayQuestion(){
		Session session = HibernateUtil.getSession();
		EssayQuestion question = (EssayQuestion)
			session.load(EssayQuestion.class, 2);
		System.out.println(question.getName());
		System.out.println(question.getAnswerEssay());
		HibernateUtil.closeSession();
	}
	
	@Test
	public void testLoadQuestion(){
		Session session = HibernateUtil.getSession();
		Query query = 
			session.createQuery("from Question");
		List<Question> list = query.list();
		//��ȡ�����������
		for(Question q:list){
			if(q instanceof ChoiceQuestion){
				ChoiceQuestion c = (ChoiceQuestion)q;
				System.out.println("ѡ����:"+c.getName());
				String[] options = c.getOptions().split("\\|");
				for(String opt : options){
					System.out.println(opt);
				}
			}
			if(q instanceof EssayQuestion){
				System.out.println("�����:"+q.getName());
			}
		}
		HibernateUtil.closeSession();
	}
	
	
}
