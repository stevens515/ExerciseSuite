package basic.day04.practice;

public class ArrayCompare {

	/**
	 * �������е�������Сֵ
	 */
	public static void main(String[] args) {
		int score[] = { 67,89,87,69,90,100,75,90};//��̬��ʼ������
		int max = 0;//��������������ֵ
		int min = 0;//�������������Сֵ
		max = min = score[0];//�ѵ�һ��Ԫ�ص����ݸ�ֵ��max��min
		for (int x = 0;x<score.length;x++){
			if(score[x]>max){
				max = score[x];
			}
			if(score[x]<min){
				min = score[x];
			}
		}
		System.out.println("���ֵ��"+max);
		System.out.println("��Сֵ��"+min);

	}

}
