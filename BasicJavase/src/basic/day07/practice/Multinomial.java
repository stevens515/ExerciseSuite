package basic.day07.practice;
import java.util.Scanner;
public class Multinomial {

	/**
	  	��  a+aa+aaa+.......+aaaaaaaaa=?
      	����aΪ1��9֮�е�һ����������ҲҪ����ָ����
	 */
	public static void main(String[] args) {
		int a;//���������a
		int howMany;//��������һ���ж��ٸ�����
		Scanner scanner = new Scanner(System.in);
			System.out.println("������һ��1��9��aֵ");
		a = scanner.nextInt();
			System.out.println("����Ҫ��Ӷ����");
		howMany=scanner.nextInt();
		int sum=0;
		int a1=a;//��������a�ĳ�ʼֵ
		for(int i=1;i<=howMany;i++){
			sum+=a;
			a=10*a+a1;//���ʾa����һ��
	//ÿ��a����һ�����ǰһ�10���ټ��ϸ�����ʱ��a;ע�⣬��ʱ��a�Ѿ��仯��
		}
		System.out.println("sum="+sum);
	}

}
