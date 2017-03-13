package com.tarena.elts.net;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.elts.util.Config;
/** ���Է������ͻ��� */
public class ExamServiceAgent implements ExamService{
	private Config config;
	private String host;
	private String sid;
	private int port;
	
	public void setConfig(Config config){
		this.config = config;
		this.host = config.getString("ServerIP");
		this.port = config.getInt("ServerPort");
	}
//	��¼��ť
	public User login(int id,String pwd) throws IdOrPwdException{
		//�õ�ID�б�����
		Request req = new Request("login",
				//���������б�
				new Class[]{int.class,String.class},
				//�����б�
				new Object[]{id,pwd});
//		�������װ��req
		req.setSessionID(sid);
//		Զ�̴���  remoteCall
		Response res = Utils.remoteCall(host,port,req);
		sid = res.getSessionID();
		if(res.isSuccess()){
			return (User)res.getValue();//�ѷ����������Ϊ����ֵ
		}else{
			Exception e = res.getException();
			if(e instanceof IdOrPwdException){
				throw (IdOrPwdException)e;
			}else{
				throw new RuntimeException(e); 
			}
		}
	}
	public QuestionInfo getQuestion(int index){
		Request req = new Request("getQuestion",
				new Class[]{int.class},
				new Object[]{index});
		req.setSessionID(sid);
		Response res = Utils.remoteCall(host, port, req);
		sid = res.getSessionID();
		if(res.isSuccess()){
			return (QuestionInfo)res.getValue();
		}else{
			Exception e = res.getException();
			throw new RuntimeException(e);
		}
	}
	public int getScore(){
		Request req = new Request("getScore",
				new Class[]{},
				new Object[]{});
		req.setSessionID(sid);
		Response res = Utils.remoteCall(host, port, req);
		sid = res.getSessionID();
		if(res.isSuccess()){
			return (Integer)res.getValue();
		}else{
			Exception e = res.getException();
			throw new RuntimeException(e);
		}
	}
	public void saveUserAnswers(int index,List<Integer> userAnswers){
		Request req = new Request("saveUserAnswers",
				new Class[]{int.class,List.class},
				new Object[]{index,userAnswers});
		//System.out.println(req);
		req.setSessionID(sid);//����ʱ���͵�id
		
		Response res = Utils.remoteCall(host, port, req);
		sid = res.getSessionID();//����ʱ����id
		if(res.isSuccess()){
			//return (Integer)res.getValue();
		}else{
			Exception e= res.getException();
			throw new RuntimeException(e);
		}
	}
	public int send(){
		Request req = new Request("send",
				new Class[]{},
				new Object[]{});
		req.setSessionID(sid);
		Response res = Utils.remoteCall(host, port, req);
		sid = res.getSessionID();
		if(res.isSuccess()){
			return (Integer)res.getValue();
		}else{
			Exception e = res.getException();
			throw new RuntimeException(e);
		}
	}
	public ExamInfo start(){
		Request req = new Request("start",
				new Class[]{},
				new Object[]{});
		req.setSessionID(sid);
		Response res = Utils.remoteCall(host, port, req);
		sid = res.getSessionID();
		if(res.isSuccess()){
			return (ExamInfo)res.getValue();
		}else{
			Exception e = res.getException();
			throw new RuntimeException(e);
		}
	}
	
}
