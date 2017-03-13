package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
/**����ҵ���ܵ�ʵ����
 * ���ҵ��ʵ�֣�ʵ���������ҵ���� login ����
*/
public class ExamServiceImpl implements ExamService{
	
	private EntityContext entityContext;
	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}
	
	public User login(int id,String pwd) 
		throws IdOrPwdException{
		
		User user = entityContext.findUserById(id);
		if(user == null){
			throw new IdOrPwdException("���û���");
		}
		if(user.getPasswd().equals(pwd)){
			this.loginUser = user;
			return user;//��¼�ɹ�
		}
		throw new IdOrPwdException("�������");
		//return null;
	}
	
	/** ���������ǿ�������Ա���*/
	private List<QuestionInfo> paper = new ArrayList<QuestionInfo>();
	
	private User loginUser;  //��¼�û�
	
	private void createPaper(){
		//ÿ�������ȡ��������
		Random random = new Random();
		int i = 0;
		//level ����ÿ������
		for(int level = Question.LEVEL1;level <= Question.LEVEL10;level++){
			//ȥ���ݲ������Ŀ  �����ⲻ���ظ�
			List<Question> list = entityContext.findQuestion(level);
			//int index = random.nextInt(list.size());//1-10
			//Question q1 = list.remove(index);
			Question q1 = list.remove(random.nextInt(list.size()));
			//remive ɾ��   �����ɾ����һ��  �������Ϊ     �����ݲ��г����һ����
			Question q2 = list.remove(random.nextInt(list.size()));
			paper.add(new QuestionInfo(i++,q1));
			paper.add(new QuestionInfo(i++,q2));
		}
	}
	public ExamInfo start(){
		if(finish){
			throw new RuntimeException("�����Ѿ���������");
		}
		//����/��֯����
		createPaper();
		//����������Ϣ������ֹ������Ϣ
		ExamInfo examInfo = new ExamInfo();
		//����Ĵ�С �� ��Ŀ������
		examInfo.setQuestionCount(paper.size());
		examInfo.setTimeLimit(entityContext.getTimeLimit());
		examInfo.setTitle(entityContext.getTitle());
		examInfo.setUser(loginUser);//��ǰϵͳ��¼�û�	
		//���ؿ�����Ϣ
		return examInfo;
	}
	//ȡ�ڼ�����
	public QuestionInfo getQuestion(int index) {
		// TODO Auto-generated method stub
		return paper.get(index);
	}

	public int getScore() {
		if(! finish){
			throw new RuntimeException("��û�п��ԣ�");
		}
		return score;
	}
//	public String getMessage(){
//		return entityContext;
//	}
//	private String message;

	public void saveUserAnswers(int index, List<Integer> userAnswers) {
		QuestionInfo q = paper.get(index);
		q.getUserAnswers().clear();
		q.getUserAnswers().addAll(userAnswers);
	}
	
	private int score;
	private boolean finish = false;
	public int send(){
		if(finish){
			throw new RuntimeException("�����Ѿ�������");
		}
		score = 0;
		for(QuestionInfo info: paper){
			Question q = info.getQuestion();
			List<Integer> answers = q.getAnswers();
			List<Integer> userAnswers = info.getUserAnswers();
			if(answers.equals(userAnswers)){
				score += q.getScore();
			}
		}
		finish = true;
		return score;
	}

}
