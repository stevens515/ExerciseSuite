package basic.day18.mldn.generics;

public class Introduction implements Info9{//ʵ��Info9�ӿ�
	private String name;
	private String sex;
	private int age;
	public Introduction(String name, String sex, int age) {
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "������Ϣ��"+"\n"+
		"\t|-������"+this.name+"\n"+
		"\t|-�Ա�"+this.sex+"\n"+
		"\t|-���䣺"+this.age;//���ض�����Ϣ
	}
	
}
