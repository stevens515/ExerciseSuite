package com.tarena.elts.service;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
/**����ҵ����ʵ����*/
public class ExamServiceImpl implements ExamService{

	//6. �����û�����ʵ�ֵ�¼ҵ���߼�->ʵ��EntityContext��ע�뷽��
	private EntityContext entityContext;
	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}
	public User login(int id, String pwd) throws IdOrPwdException {
		User user = entityContext.findUserById(id);
		if(user==null){
			throw new IdOrPwdException("���û�");
		}
		if(user.getPasswd().equals(pwd)){
			return user;//��½�ɹ�
		}
		throw new IdOrPwdException("�������");
	}
}