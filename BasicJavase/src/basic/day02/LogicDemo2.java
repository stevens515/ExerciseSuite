package basic.day02;

public class LogicDemo2 {

	/**
	 * ��·�߼��ж�
	 */
	public static void main(String[] args) {
		// ��·��������(&&),����60��������̫̫����������Ů�Ĳ��ң���60��
		int age = 68;
		char sex = '��';
		/**
		 * ��sex=='Ů'������falseʱ�򣬲�������age>=60ֱ����Ϊ�����false
		(sex=='Ů' && age>=60)
		 */
		if(sex=='Ů' && age>=60){
			System.out.println("��ӭ���٣�");
		}
		System.out.println("age="+age);//68,˵��age++>=60û�м���
		//֤����&&�Ƕ�·���߼�����
		//�Ƕ�·�������㣨����
		age = 68; 
		sex ='��';
		if(sex=='Ů' & age++>=60){
			System.out.println("��ӭ���٣�");
		}
		System.out.println("age="+age);//69
		
		//��·�Ļ�����(||):����Ů�Ļ���60��������ͷ����
//		û��ִ��age++>=60
		age = 28;
		sex ='Ů';
		if(sex=='Ů' || age++>=60){
			System.out.println("��ӭ���٣�");//��ӭ���٣�
		}
		System.out.println("age="+age);//age=28
		
		//ֻҪһ�����������ģ��ͽ���ѭ����ִ����age++>=60
		age = 78;
		sex ='Ů';
		if(sex=='��' | age++>=60){
			System.out.println("��ӭ���٣�");//��ӭ���٣�
		}
		System.out.println("age="+age);//age=79
	}

}
