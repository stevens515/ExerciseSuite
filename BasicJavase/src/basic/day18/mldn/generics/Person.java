package basic.day18.mldn.generics;

class Person <T extends Info9>{//�˴�ָ�������ޣ�������Info�ӿڵ�����
	private T info;//�˱������������ⲿ����

	public Person(T info) {//������Ϣ��������
		this.setInfo(info);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	
}
