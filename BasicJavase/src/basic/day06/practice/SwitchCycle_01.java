package basic.day06.practice;

import java.io.IOException;

public class SwitchCycle_01 {
	public static void main(String[] args) throws IOException { 	// ��Ϊ����read()�������׳���IO�쳣
		System.out.println("��Ӽ�������һ��Сд��ĸ��");
		char ch = (char) System.in.read();					// �õ��Ӽ���������ַ�
		int num = (int) ch; 		// ��char��ǿ��ת����int��Ŀ���Ǹ��ݹ�ϣ��ֵ���ж��Ƿ���Сд��ĸ
		if (num < 97 || num > 122) { 	// a��z�Ĺ�ϣ��ֵ��97��122
			System.out.println("��������������������ȷ��Сд��ĸ����");
		} else {
			switch (ch) {			// ��switch������ж��Ƿ���Ԫ����ĸ��a,e,I,o,u��
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				System.out.println(ch + " ��Ԫ����ĸ");
				break;
			default:
				System.out.println(ch + " �Ǹ�����ĸ");
			}
		}
	}
}
