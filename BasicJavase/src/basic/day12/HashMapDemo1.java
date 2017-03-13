package basic.day12;

import java.util.HashMap;

/*
 	HashMap
 */
public class HashMapDemo1 {
public static void main(String[] args) {
	HashMap hotel = new HashMap();//Ĭ������16��������75�����ż�����
	hotel.put("tom", 5);//����key:value,����key����hashλ��
	//���λ�þ��Ǵ洢�����е�λ��
	hotel.put("Jerry", 5);//key�ǹؼ��֣������ظ���value�����ظ�
	hotel.put("Andy", 2);
	hotel.put("Robin", 1);
	hotel.put("Mac", 3);//��һ�������
	hotel.put("Mac", 9);//�ڶ����Ǹ��ǣ��ظ���key��ͬһ��
	System.out.println(hotel.size());//5
	//get(key)�������Ǹ���key����ɢ��ֵ����value����
	int age = (Integer)hotel.get("Mac");//9
	System.out.println(age);
	
	System.out.println(hotel.containsKey("Tom"));//true
	System.out.println(hotel.containsValue(5));//true
	System.out.println(hotel.containsValue(3));//false
	//����ȫ���ģ�key:value)�Եļ���
	System.out.println(hotel.entrySet());//[Jerry=5, Mac=9, Robin=1, tom=5, Andy=2]
	System.out.println("ȫ��key:"+hotel.keySet());//ȫ��key:[Jerry, Mac, Robin, tom, Andy]
	System.out.println("ȫ��value:"+hotel.values());//ȫ��value:[5, 9, 1, 5, 2]
	
	hotel.remove("Mac");
	System.out.println(hotel.size());//4
	System.out.println(hotel.isEmpty());//false
	System.out.println(hotel);//{Jerry=5, Robin=1, tom=5, Andy=2}
	
	hotel.clear();
	System.out.println(hotel.size());//0
	System.out.println(hotel.isEmpty());//true
	System.out.println(hotel);//{}

}
}
