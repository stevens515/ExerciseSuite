package basic.day07.practice;

public class Sum {

	/**
	 * �� 2/1+3/2+5/3+8/5+13/8.....ǰ20��֮�ͣ�
	 */
	public static void main(String[] args) {
		double sum=0;
		double fenZi=2.0,fenMu=1.0;//��ʼ�ķ���(fenZi)=2,��ĸ(fenMu)=1
		for(int i=1;i<=20;i++){
			sum +=fenZi/fenMu;
			fenMu = fenZi;			//��һ��ķ�ĸ����һ��ķ���
			fenZi += fenMu;			//��һ��ķ��ӣ���һ��ķ��Ӽӷ�ĸ
		}
		System.out.println("sum="+sum);
	}

}
