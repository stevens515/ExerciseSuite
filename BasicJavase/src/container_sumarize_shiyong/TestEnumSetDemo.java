package container_sumarize_shiyong;

import java.util.EnumSet;

public class TestEnumSetDemo {
public static void main(String[] args) {
	//����һ������ָ��Ԫ�����͵�����Ԫ�ص�ö�� set�� 
	//����һ��EnumSet���ϣ�����Ԫ�ؾ���Seasonö�����ȫ��ö��ֵ
	EnumSet es = EnumSet.allOf(Season.class);
	System.out.println(es);//�������ö��ֵ������˳����ö�����ڲ�����˳��һ��
	//����һ���յ�EnumSet���ϣ�����ֻ�������Seasonö��ֵ
	EnumSet es1 = EnumSet.noneOf(Season.class);
	es1.add(Season.SPRING);//�ֶ����
	System.out.println(es1);//[SPRING]
	es1.add(Season.WINTER);
	es1.add(Season.SUMMER);
	System.out.println(es1);//���־����ȼ���winter,�������ʱwinter��Ȼ��summer֮��[SPRING, SUMMER, WINTER]
	
	//ָ��ö��ֵ��EnumSet����
	EnumSet es2 = EnumSet.of(Season.SPRING,Season.SUMMER);
	System.out.println(es2);//[SPRING, SUMMER]
	
	//����һ��������Χ��EnumSet����
	EnumSet es3 = EnumSet.range(Season.SPRING, Season.FALL);
	System.out.println(es3);//[SPRING, SUMMER, FALL]
	
	//����һ����es3�෴��EnumSet����
	EnumSet es4 = EnumSet.complementOf(es3);
	System.out.println(es4);//[WINTER]
}
}
enum Season{
	SPRING,SUMMER,FALL,WINTER
}