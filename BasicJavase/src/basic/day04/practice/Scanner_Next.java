package basic.day04.practice;
import java.util.Scanner;


public class Scanner_Next {

	/**
		Scanner�У�
				next():�����У���һ�����ո񱻵����ָ������Ҫ��Ч��ǲ��ܷ��أ�
				Ҳ����˵����������붫����Ҫ�ǲ�����ͻ�һֱ��ʾ����
				
				nextLine():�л�����һ�У��Ƕ�����ǰ�±��һ�У���������Ϊ��һ�У�
				������˵ÿ�о������ķָ��������Ҫ���ֻҪ�е�ǰ�о��ܷ���
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ϣ��");
		int arr = sc.nextInt();
//		String arr1=sc.next();
		String input = "1 fish 2 fish red fish blue fish";
	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
	     System.out.println(s.nextInt());
	     System.out.println(s.nextInt());
	     System.out.println(s.next());
	     System.out.println(s.next());
	     s.close(); 

	}

}
