package container_sumarize_shiyong;

import java.util.ArrayList;
	/**�ص㣺
	 	���³���ģ��java EE�����ѯ��ʾ���ܣ��Ȳ�ѯ���ݿ⣬ÿһ�����
	 	����¼����һ�����󱣴��ArrayList������������һ�����
	 	����ڵ�ÿһ����һ����¼
	 	
	 	�����
	 		-------------------
			|��  ��|����|�� ַ|
			|�����|500|����ɽ|
			|��˽�|300|����ׯ|
			|ɳ����|200|��ɳ��|
			------------------
	 */
public class TestArrayListDemo2 {
public static void main(String[] args) {
	String[] names = {"�����","��˽�","ɳ����"};
	int[] ages = {500,300,200};
	String[] addresses = {"����ɽ","����ׯ","��ɳ��"};
	
	ArrayList userList = new ArrayList();
	for(int i=0;i<3;i++){//��������ݽ��������while(rs.next())
		UserBean ub = new UserBean(names[i],ages[i],addresses[i]);
		userList.add(ub);
	}
	
	//��������list��������ʾ�������ʾ
	System.out.println("-------------------");
	//��ʾ��ͷ
	System.out.print("|");
	System.out.print("��  ��");
	System.out.print("|");
	System.out.print("����");
	System.out.print("|");
	System.out.print("�� ַ");
	System.out.println("|");
	for(int i=0;i<userList.size();i++){
		UserBean ub = (UserBean)userList.get(i);//ǿ������ת��
		System.out.print("|");
		System.out.print(ub.getName());
		System.out.print("|");
		System.out.print(ub.getAge());
		System.out.print("|");
		System.out.print(ub.getAddress());
		System.out.println("|");
	}
	System.out.println("------------------");
  }
}
class UserBean{
	private String name;
	private int age ;
	private String address;
	public UserBean(String name,int age,String address){
		this.name = name ;
		this.age = age;
		this.address = address;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
}