package com.tarena.elts.entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tarena.elts.util.Config;
import com.tarena.elts.util.InsertData;

/**
 * ʵ�����ݹ���
 * 	 ����е����ݹ���
 * 		�Ӵ���(�ļ�)�����û��Ϳ������ݵ��ڴ漯����
 * 		������ȡ�����ļ��ŵ��ڴ漯����
 */
public class EntityContextImpl implements EntityContext{
	
	private Config config;
	
	/**
	 * ͨ���û���Id  ����
	 * @param id
	 * @return
	 */
	public User findUserById(int id){
		return users.get(id);
	}
	/**
	 * ��������ĵȼ�   �õ�����ļ���
	 * @param level
	 * @return
	 */
	public List<Question> findQuestion(int level){
		//���¸�����  so ɾ����Ӱ��ԭ����
		return new ArrayList<Question>(questions.get(level));
	}
	/**
	 * �������ļ��� �õ�����ʱ�� 
	 * @return
	 */
	public int getTimeLimit(){
		return config.getInt("TimeLimit");
	}
	/**
	 * �������ļ��еõ�������Ϣ 
	 */
	public String getTitle() {
		return config.getString("PaperTitle");
	}
	public EntityContextImpl(Config config) {
		this.config = config;//����ǰ����Config  �����Ը�ǿ
		//ֻҪ����EntityContext �ͱ������Config
		loadUsers(config.getString("UserFile"));
		loadQuestions(config.getString("QuestionFile"));
//		loadMessage(config.getString("MessageFile"));
	}
	
	//ɢ�б�洢
	/**users �������洢�����û���Ϣ�� 
	 * key: �û���ID ��value���û�ʵ��
	 * �û���Ϣ�Ӵ����ļ�����
	 */
	private HashMap<Integer,User> users = 
		new HashMap<Integer,User>();
	
	/**
	 * ���ز������û��ļ����ݵ�users������
	 * @param file �û��ļ���
	 */
	private void loadUsers(String filename){
		try{
			BufferedReader in = new BufferedReader(//���ļ�
				new InputStreamReader(					//��ȡһ��
					new FileInputStream(filename),"GBK"));
			String line;
			while((line = in.readLine())!= null){
				line = line.trim();
				if(line.startsWith("#") || line.equals("")){
					continue;//���Կ��к�ע��(#)
				}
				User one = parseUser(line);
				users.put(one.getId(), one);
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//1002:����:1234:13810381038:zhangsan@tarena.con.cn
	//  0    1   2     3              4
	private User parseUser(String line) {
		//��һ�����ݽ���Ϊ����
		String[] data = line.split(":");
		User user = new User();
		user.setId(Integer.parseInt(data[0]));
		user.setName(data[1]);
		user.setPasswd(data[2]);
		user.setPhone(data[3]);
		user.setEmail(data[4]);
		return user;
	}
	
	/** ȫ������ļ���
	 * key :Level  �Ѷȼ���
	 * value: ��ͬһ��������ȫ������
	 */
//	���е�����
	private Map<Integer,List<Question>> questions =  
			new HashMap<Integer, List<Question>>();  
	
	/** ���������ļ�����questions������ */
	private void loadQuestions(String file) {
		try{
			BufferedReader in = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(file),"GBK"));
			String str;
			while((str = in.readLine())!=null){
				str = str.trim();
				if(str.startsWith("#") || str.equals("")){
					continue;
				}
				//parseQuestion(str,in)��������Ϣ��Question ����
				Question q = parseQuestion(str,in);
				addQuestion(q);//��ӵ�����
			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private void addQuestion(Question q){
//		if(questions.containsKey(q.getLevel())){
//			questions.get(q.getLevel()).add(q);
		//�ӿ��������ڼ�ᶯ̬�ﶨ�����ϣ�so .add(q) �����
//		}else{
//			List<Question> list = new ArrayList<Question>();
//			list.add(q);
//			questions.put(q.getLevel(), list);
//		}
		List<Question> list = questions.get(q.getLevel());//�Ѷȼ���
		if(list == null){  //��list Ϊnullʱ
			list = new ArrayList<Question>();//�ڴ���һ��list
			questions.put(q.getLevel(),list);//�����list�ӽ��Ѷȼ���
		}
		list.add(q);//�ӵ�����
//		System.out.println("q:"+q);
//		System.out.println("list:"+list);
//		System.out.println("questions:" + questions);
	}
	//�ַ���  ��
	private Question parseQuestion(String str,BufferedReader in)
		throws IOException{
		String[] data = str.split("[@,][a-z]+=");
		//@��,  a-z���ַ� �ɶ�γ���
		//str:@answer = 2/3,score = 5,level = 5
		//�����ַ��� ��Ϊ�����½��
		//data:{"","2/3","5","5"}
		//sun��˾�涨 split() ��ͷ��ʼ�� ����ֿմ�
		Question q = new Question();
		//��
		q.setAnswers(parseAnswer(data[1]));
		//����
		q.setScore(Integer.parseInt(data[2]));
		//����
		q.setLevel(Integer.parseInt(data[3]));
		//��ȡ���
		q.setTitle(in.readLine());
		
		List<String> options = new ArrayList<String>();
		//������ȡ4��ѡ��
		options.add(in.readLine());
		options.add(in.readLine());
		options.add(in.readLine());
		options.add(in.readLine());
		q.setOptions(options);
		q.setType(q.getAnswers().size() == 1? 
				Question.SINGLE_SELECTION:
				Question.MULTI_SELECTION);
		return q;
	}
	//answer:"2/3"
	private List<Integer> parseAnswer(String answer){
		List<Integer> list = new ArrayList<Integer>();
		String[] data = answer.split("/");
		for(String s:data){
			list.add(Integer.parseInt(s));
		}
		return list;
	}
	
	
	
//	public void loadMessage(String filename){
//		try{
//			BufferedReader in = new BufferedReader(//���ļ�
//				new InputStreamReader(					//��ȡһ��
//					new FileInputStream(filename),"GBK"));
//			String line;
//			while((line = in.readLine())!= null){
//				line.toString();
//			}
//			in.close();
//		}catch(IOException e){
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
	
	
	/**���� ����*/
	public static void main(String[] args){
		//EntityContext context = new EntityContext();
		Config config = new Config("client.properties");
		EntityContextImpl context = new EntityContextImpl(config);
//		for (User user : context.users.values()) {
//			InsertData.insertUser(user);
//		}
//		InsertData.showUsers();
		Collection<List<Question>> questions = context.questions.values();
		for (List<Question> list : questions) {
			for (Question question : list) {
				InsertData.insertQuestion(question);
			}
		}
	}
}
