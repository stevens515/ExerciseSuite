package test;

import exception.HeightLimitException;
import service.BMIService;

public class Test {
	public static void main(String[] args) {
		BMIService service = new BMIService()	;
		try {
			String rs = service.bmi(2.7, 180, "m");
			System.out.println(rs);
		} catch (Exception e) {
			// ��¼��־
			e.printStackTrace();
			//�����쳣���ͣ����д���
			//�����쳣������ϵͳ�쳣��ʾ�û��������Ӧ���쳣����ʾ�û���ȷ���롣
			if(e instanceof HeightLimitException){
				System.out.println("��߷�Χ�������0����С��2.5");
			}
		}
	}
}
