package basic.day02;

import java.util.Random;

public class CharDemo2 {

	/**
	 * char
	 */
	public static void main(String[] args) {
		//�κ�����������������int������0x4e2d��int�͵�
		//�����������ڲ�����char��Χ����£����Ը�char������ֵ
		System.out.println(0x4e2d);//20013,���͵�
		char c =0x4e2d;//��������ֱ����
//		c = 65536;//������󣬳���Χ��Type mismatch:cannot conver from int to char
		int a = 20013;
//		c = a;//Type mismatch:cannot conver from int to char
		//���⣺int ���Ը�char��ֵ��
		
		c = '5';//cֵ��53
		int n = c - '0';//n=53-48=5
		//��ֵ�ַ�c�ı�����(int)c, ��Ӧ������ֵn
		System.out.println((int)c);//53
		System.out.println(c);//'5'
		System.out.println(n);//��ֵ5
		System.out.println(c+1);//54
		System.out.println(n+1);//6
		Random random = new Random();
		int index = random.nextInt(26);//�������������0��26��
		c = (char)('A'+index);
		System.out.println(c);//����ַ�'A'~'Z'
	}

}
