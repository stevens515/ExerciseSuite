package service;

import exception.HeightLimitException;

/**
 * ģ�ͣ�����BMI�� ҵ���߼�
 * 
 * @author soft01
 * 
 */
public class BMIService {
	public String bmi(double height, double weight, String gender) throws Exception{

		// �Դ������Ĳ���Ҫ������֤
		if(height>2.5||height<0){
			//��Ӧ�����쳣
			throw new HeightLimitException();
		}
		double bmi = weight/height/height;
		String rs = "";
		if(gender.equals("m")){
			if(0<bmi&&bmi<20){
				rs="����";
			}else if(bmi>=20&&bmi<25){
				rs="����";
			}else if(bmi>=25&&bmi<30){
				rs="����";
			}else if(bmi>=30&&bmi<35){
				rs="����";
			}else if(bmi>=35&&bmi<40){
				rs="̫�з�������";
			}
		}else{
			if(bmi<20){
				rs="����";
			}else if(bmi>=20&&bmi<25){
				rs="����";
			}else if(bmi>=25&&bmi<30){
				rs="����";
			}else if(bmi>=30&&bmi<35){
				rs="����";
			}else if(bmi>=35&&bmi<40){
				rs="̫�з�������";
			}
		}
		return rs;
	}
}
