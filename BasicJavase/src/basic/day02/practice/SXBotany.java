package basic.day02.practice;

public class SXBotany {

	/**
	 * ˮ�ɻ��ĸ�������λ������ÿλ�������;��������λ��
	 *�ٷ֣���ȡ�£�����������ȡ��
	 */
	public static void main(String[] args) {
		SXBotany sx = new SXBotany();
		int sum;
		System.out.println("100-999֮���ˮ�ɻ���Ϊ��");
		for(int i=100;i<=999;i++){
		int a = sx.getSumOfCubic(i/100);//��λ�ϵ�����
		int b =sx.getSumOfCubic((i/10)%10);//ʮλ�ϵ�����
		int c =sx.getSumOfCubic(i%10);//��λ�ϵ�����
		sum = a + b + c;
		if(sum==i){
			System.out.println("i="+i);
		}
		}
	}
	public int getSumOfCubic(int num){
		num=num*num*num;
		return num;
	}

}
