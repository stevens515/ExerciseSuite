package basic.day02.practice;

/**
 * ��д������ 1+3+5+7+����+99 �ĺ�ֵ��
 */

public class Odd {


	public static void main(String[] args) {
		int sum = 0;
		for(int j=1;j<100;j+=2){
			sum+=j;
		}
		System.out.println(sum);
	}
	//����2
//    public static void main(String[] args){
//        int number = 1;  //��ʼֵ1���Ժ���+2������ȥ
//        int sum = 0;
//        for ( ; number <100; number+=2 ){ sum += number; }
//        System.out.println("1+3+5+7+����+99= " +sum);
//    }
}
