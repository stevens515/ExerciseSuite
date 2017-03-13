package basic.day15;

import java.util.Scanner;

/**
 * A.���Ǽ���쳣��:������javac�����RuntimeException�����Ƿ��׳����Ƿ��� 
 * B.�����ڼ䣬�Ǽ���쳣���ǿ��ܳ��֣���Ӱ����������
 * C.�Ǽ���쳣��������try....catch���� ���Ը����� ���������� �쳣 
 * D.catch��Ӧ��дe.printStackTrace()
 */
public class UncheckExceptionDemo {
	public static void main(String[] args) {
		try {
			int age = readAge();
			System.out.println(age);
		} catch (NumberFormatException e) {
			// ���ǳ��ִ����쳣��һ����ӡ�쳣���ٶ�ջ
			e.printStackTrace();
			// System.out.println(e.getMessage());
		}
	}

	public static int readAge() {
		Scanner in = new Scanner(System.in);
		System.out.println("�������䣺");
		String str = in.nextLine();
		// parseInt���������׳����쳣��NumberFormatException
		// ������str���ܱ���������ʱ�������磺0xff;
		// NumberFormatException��RuntimeException��������

		// javac����飬�����ڼ䣬���ǿ��ܳ��֣���Ӱ����������
		int age = Integer.parseInt(str);
		return age;
	}
}
