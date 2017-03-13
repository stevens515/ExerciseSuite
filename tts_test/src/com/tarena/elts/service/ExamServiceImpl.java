package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/***
 * 3) ҵ���: ����: startExam() getQuestion()
			��ʼ����ҵ������: ��ʼ����ʱ��, ��ȡ��������, ÿ��level��ȡ2��
			���ؿ���������Ϣ:ExamInfo
			������: �г�ȡ����Ŀ��ɵ����Ա���
			��ȡ����: ������Ŀ��Ż�ȡָ������
 */
public class ExamServiceImpl implements ExamService {
	/** ��¼ҵ���߼�ʵ�� */
	public User login(int id, String pwd) throws IdOrPwdException {
		User user = entityContext.getUser(id);
		if (user == null)
			throw new IdOrPwdException("������ȥ���ˣ��Ҳ�������");
		if (user.getPasswd().equals(pwd)) {
			this.loginUser = user;//�����������᲻��ʾ�ı�
			return user;// ��½�ɹ�
		}
		throw new IdOrPwdException("��������ˣ�");
	}

	// 2) ʵ��EntityContext ��ע�뷽��
	private EntityContext entityContext;

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	private List<QuestionInfo> paper = new ArrayList<QuestionInfo>();

	public QuestionInfo getQuestion(int index) {
		return paper.get(index);
	}

	private User loginUser;

	public ExamInfo startExam() {
		createPape();
		ExamInfo info = new ExamInfo();
		info.setQuestionCount(paper.size());
		info.setTimeLimit(entityContext.getTimeLimit());
		info.setTitle(entityContext.getTitle());
		info.setUser(loginUser);
		return info;
	}

	private void createPape() {
		Random r = new Random();
		int idx = 0;
		for (int i = Question.LEVEL1; i <= Question.LEVEL10; i++) {
			List<Question> list = entityContext.findQuestions(i);
			//�ҳ�2����
			Question q1 = list.remove(r.nextInt(list.size()));
			Question q2 = list.remove(r.nextInt(list.size()));
			paper.add(new QuestionInfo(idx++, q1));
			paper.add(new QuestionInfo(idx++, q2));
		}
	}

	// ҵ��㱣���û���
	public void saveUserAnswers(int idx, List<Integer> userAnswers) {
		paper.get(idx).setUserAnswers(userAnswers);
	}

	private int score = 0;
	public int examOver() {
		// �з�
		for (QuestionInfo qInfo : paper) {
			Question q = qInfo.getQuestion();
			if (qInfo.getUserAnswers().equals(q.getAnswers())) {
				score += q.getScore();
			}
		}
		return score;
	}
	private boolean finish=false;
	public int send(){
		if(finish){
			throw new RuntimeException("�����Ѿ�������");
		}
		score = 0;
		for(QuestionInfo info :paper){
			Question q = info.getQuestion();
			List<Integer> answers = q.getAnswers();
			List<Integer> userAnswers = info.getUserAnswers();
			if(answers.equals(userAnswers)){
				score+=q.getScore();
			}
		}
		finish=true;
		return score;
	}

	@Override
	public int getScore() {
			if(!finish)
				throw new RuntimeException("��û�п���ѽ��");
			return score;
	}
	
}