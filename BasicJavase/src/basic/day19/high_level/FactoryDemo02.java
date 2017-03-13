package basic.day19.high_level;

import java.util.Properties;
/**
 * fruit.properties
 * �������ļ���ʹ��apple��orange��ʾ�����İ�.�����ƣ�������ʹ��ʱֱ��ͨ���������Ƽ���
 */
public class FactoryDemo02 {
	public static void main(String[] args) {
		Properties pro = Init.getPro();//��ʼ��������
		//ͨ��������ȡ�ýӿ�ʵ����ͨ�����Ե�key���������İ�.������
		Fruit f = Factory.getInstance(pro.getProperty("apple"));
		if(f != null){//�ж��Ƿ�ȡ�ýӿ�ʵ��
			f.eat();//���÷���
		}
	}
}
