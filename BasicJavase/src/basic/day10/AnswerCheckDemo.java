package basic.day10;
import java.util.Scanner;
import java.util.Arrays;
public class AnswerCheckDemo {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String reg = "^\\s*([A-Da-d](\\s+|,\\s*)?){1,4}\\s*$";
		String str;
		while(true){
			System.out.println("����ѡ��𰸣�A��D����");
			str = console.nextLine();
			if(str.matches(reg)){
				break;
			}
			System.out.println("���ˣ���������.");
		}
		reg = "\\s+";//�зֹ���
		String[] ans = str.split(reg);//�з��ַ���Ϊ����
		Arrays.sort(ans);//�����
		System.out.println(Arrays.toString(ans));
		
	}

}
