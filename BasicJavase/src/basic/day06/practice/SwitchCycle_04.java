package basic.day06.practice;

public class SwitchCycle_04 {
	public static void main(String args[]) {
		int m = 8;
		String s;					// s��ʾ����
		switch (m) {				// ����m������ʾ�·�
		case 12:
		case 1:
		case 2:
			s = "Winter";			// ����
			break;
		case 3:
		case 4:
		case 5:
			s = "Spring";			// ����
			break;
		case 6:
		case 7:
		case 8:
			s = "Summer";			// �ļ�
			break;
		case 9:
		case 10:
		case 11:
			s = "Autumn";			// �＾
			break;
		default:
			s = "Bogus Month";		// ����·��Ǵ����
		}
		System.out.println("August is in the " + s + ".");
	}
}
