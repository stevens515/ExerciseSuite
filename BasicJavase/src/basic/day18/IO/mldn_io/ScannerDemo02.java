package basic.day18.IO.mldn_io;

import java.util.Scanner;

/**Scanner
 * ���Ҫ����int��float���͵����ݣ���Scanner��Ҳ��֧�֣���������֮ǰ�����ʹ��
 * hasNextXxx()����������֤���������£�
 */
public class ScannerDemo02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//�Ӽ��̽�������
		int  i = 0;
		float f = 0.0f;
		System.out.println("����������");
		if(scan.hasNextInt()){		//�ж�������Ƿ�������
			i = scan.nextInt();		//��������
			System.out.println("�������ݣ�"+i);
		}else{
			System.out.println("����Ĳ���������");
		}
		System.out.println("����С����");
		if(scan.hasNextFloat()){	//�ж�������Ƿ���С��
			f = scan.nextFloat();	//����С��
			System.out.println("С�����ݣ�"+f);
		}else{
			System.out.println("����Ĳ���С����");
		}
	}
}
