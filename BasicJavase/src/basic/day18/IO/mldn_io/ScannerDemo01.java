package basic.day18.IO.mldn_io;

import java.util.Scanner;

/**ʹ��Scanner����������
 * 	ʵ������һ��ʵ�ֻ�������������: 
 * ���⣺
 * 		���н�����Է��֣��ո�������û���ˣ�ԭ����Scanner���ո���һ���ָ�����
 * ����Ϊ�˱�֤�������ȷ�����Խ��ָ������޸�Ϊ��\n(�س�)".
 */
public class ScannerDemo01 {
	public static void main(String[] args) {
		//�汾һ��δ����ո�
//		Scanner scan =new Scanner(System.in);
//		System.out.println("�������ݣ�");
//		String str = scan.next();
//		System.out.println("���������Ϊ��"+str);
		
		//�汾�����ո���
		Scanner scan = new Scanner(System.in);//�Ӽ��̽�������
		//public Scanner useDelimiter(Pattern pattern)����ɨ�����ķָ�ģʽ����Ϊָ��ģʽ�� 
		scan.useDelimiter("\n");			//�޸��������ݵķָ���
		System.out.println("�������ݣ�");
		String str = scan.next();
		System.out.println("��������Ϊ��"+str);
	}
}
