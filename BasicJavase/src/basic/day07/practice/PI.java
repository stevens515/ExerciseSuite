package basic.day07.practice;

public class PI {

	/**
	 	11������Բ����
  				PI��4��4/3+4/5-4/7.......
  				��ӡ����һ������ 3.1415С�� 3.1416��ֵ

	 */
	public static void main(String[] args) {
		double pi = 0;//�����ʼֵ
		double fenZi =4;//����Ϊ4
		double fenMu=1;//��ĸΪ1,��һ��4���ɿ�����ĸΪ1�ķ�ʽ���Ժ�ķ�ĸÿ�ε���2
		for(int i=0;i<1000000000;i++){//�����Ͼã�����ѭ���������ֻܶ࣬�Ǿ�ȷ��СЩ
			pi += (fenZi/fenMu);
			fenZi *= -1.0;//ÿ�η��ӵı仯��+4,-4,+4,-4....
			fenMu += 2.0;	//��ĸ�ı仯��1��3��5��7��....ÿ��ݼ�2
		}
		long a = System.currentTimeMillis();//��������ʱ��
		System.out.println(pi);
		long b =System.currentTimeMillis();//���Գ�������ʱ��
		System.out.println(b-a);
	}

}
