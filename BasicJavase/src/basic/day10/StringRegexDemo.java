package basic.day10;
import java.util.Arrays;
public class StringRegexDemo {

	public static void main(String[] args) {
		String name = "jerry56";
		
		String rule = "^\\w{6,10}$";
		boolean pass = name.matches(rule);//ƥ��
		System.out.println(pass);//true
		
		String str = "Tom|Jerry|Andy|John";
		String[] names = str.split("\\|");//�������������ַ�������
		System.out.println(Arrays.toString(names));//[Tom, Jerry, Andy, John]
		
		//str.replaceAll("\\|", ",");//�����⣡�õ���ֵû����
		str = str.replaceAll("\\|", ",");//ƥ�����
		System.out.println(str);//Tom,Jerry,Andy,John
		
		//�д�û���գ����ַ�
		name = " 	Tom 			t	";
		name.trim();
		System.out.println(name);// 	Tom 			t
		
		//�д�û����
		name = " 	Tom 			t	";
		name.trim().toLowerCase();
		System.out.println(name);// 	Tom 			t
		
		//�ַ���ֻҪ�б仯�����صĶ������ַ���
		name = " 	Tom 			t	";
		name=name.trim();
		System.out.println(name);//Tom
	}

}
