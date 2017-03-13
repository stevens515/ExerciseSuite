package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
/**����ҵ����ʵ����
 * 6. �����û�����ʵ�ֵ�¼ҵ���߼�
 	1) ʵ��ҵ����ʵ���� ExamServiceImpl ��login����
 */
public class ExamServiceImpl implements ExamService{
	
	//6. �����û�����ʵ�ֵ�¼ҵ���߼�->ʵ��EntityContext��ע�뷽��
	private EntityContext entityContext;
	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}
	
	//6. �����û�����ʵ�ֵ�¼ҵ���߼�->ʵ��ҵ����ʵ���� ExamServiceImpl ��login����
	public User login(int id,String pwd) throws IdOrPwdException{
		User user = entityContext.findUserById(id);
		if(user==null){
			throw new IdOrPwdException("�Ҳ��������ƣ�");
		}
		if(user.getPasswd().equals(pwd)){
			return user;//��½�ɹ�
		}
		throw new IdOrPwdException("����������!");
	}
	/***
	 * 3) ҵ���: ����: startExam() getQuestion()
 			��ʼ����ҵ������: ��ʼ����ʱ��, ��ȡ��������, ÿ��level��ȡ2��
 			���ؿ���������Ϣ:ExamInfo
 			������: �г�ȡ����Ŀ��ɵ����Ա���
 			��ȡ����: ������Ŀ��Ż�ȡָ������
	 */
	private List<QuestionInfo> paper = new ArrayList<QuestionInfo>();
	
	public QuestionInfo getQuestion(int index) {
		return paper.get(index);
	}
	private User loginUser;
	public ExamInfo startExam() {
		  createPaper();
		    ExamInfo info = new ExamInfo();
		    //��ʼ��info ...
		    info.setQuestionCount(paper.size());
		    info.setTimeLimit(entityContext.getTimeLimit());
		    info.setTitle(entityContext.getTitle());
		    info.setUser(loginUser);
		    return info;
	}
		  
		  private void createPaper(){
		    Random r = new Random();
		    int idx = 0;
		    for(int i=Question.LEVEL1; i<=Question.LEVEL10; i++){
		      List<Question> list = 
		        entityContext.findQuestions(i);
		      //���2����
		      Question q1 = list.remove(r.nextInt(list.size()));
		      Question q2 = list.remove(r.nextInt(list.size()));
		      paper.add(new QuestionInfo(idx++, q1));
		      paper.add(new QuestionInfo(idx++, q2));
		    }
		  }
}	  
