package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
/** ����ҵ���ܵ�ʵ���� */
public class ExamServiceImpl implements ExamService {
  private boolean finished = false;
  private EntityContext entityContext;
  public void setEntityContext(EntityContext entityContext) {
    this.entityContext = entityContext;
  }

  public User login(int id, String pwd) 
    throws IdOrPwdException {
    User user = entityContext.findUserById(id);
    if(user==null){
      throw new IdOrPwdException("���û�!");
    }
    if(user.getPasswd().equals(pwd)){
      loginUser = user;
      return user;//��¼�ɹ�
    }
    throw new IdOrPwdException("�������!");
  }
 
  private User loginUser;
  private List<QuestionInfo> paper =
    new ArrayList<QuestionInfo>();
  
  private void createPaper(){
    //ÿ�������ȡ��������
    Random r = new Random();
    int i=0;
    for(int level=Question.LEVEL1; 
      level<=Question.LEVEL10; level++){
      List<Question> list = 
        entityContext.findQuestions(level);
      
      int index = r.nextInt(list.size());
      Question q = list.remove(index);
      paper.add(new QuestionInfo(i++, q));
      
      index = r.nextInt(list.size());
      q = list.remove(index);
      paper.add(new QuestionInfo(i++, q));
    }
  }
  
  public ExamInfo start() {
    if(finished)
      throw new RuntimeException("�����Ѿ�����!");
    //��������
    createPaper();
    //��֯������Ϣ
    ExamInfo examInfo = new ExamInfo();
    examInfo.setQuestionCount(paper.size());
    examInfo.setTimeLimit(entityContext.getTimeLimit());
    examInfo.setTitle(entityContext.getTitle());
    examInfo.setUser(loginUser);//��ǰϵͳ��¼�û�
    return examInfo;
  }
  
  public QuestionInfo getQuestion(int index) {
    return paper.get(index); 
  }
  public void saveUserAnswers(
      int index, List<Integer> userAnswers) {
    QuestionInfo q = paper.get(index);
    q.getUserAnswers().clear();
    q.getUserAnswers().addAll(userAnswers);
  }
  private int score; 
  public int examOver() {
    if(finished)
      throw new RuntimeException("�����Ѿ�����!");
    
    for (QuestionInfo q : paper) {
      Question question = q.getQuestion();
      List<Integer> userAnswers = q.getUserAnswers();
      if(userAnswers.equals(question.getAnswers())){
        score+=question.getScore();
      }
    }
    finished=true;
    return score;
  }
  
  public int getScore() {
    if(! finished )
      throw new RuntimeException("û�п������з���!");
    return score;
  }
}








