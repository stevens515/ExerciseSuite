package basic.day06.practice;

public class SwitchCycle_02 {
	public static void main(String[] args) {
		int level;
		level = (int) (Math.random() * 100);
		switch (level / 10) {
		case 6:
			System.out.println(level + "��һ���ոպϸ�ķ�����������Ŭ��Ŷ��");
			break;
		case 7:
			System.out.println(level + "��һ����Ϊ���ķ�������Ҫ�ӰѾ�����");
			break;
		case 8:
			System.out.println(level + "��һ����Ϊ���õķ��������Ͱ���");
			break;
		case 9:
			System.out.println(level + "��һ�������������ð�����");
			break;
		default:
			System.out.println(level + "��һ�����ϸ�ķ�����Ҫʮ��Ŭ�����У�");
			break;
		}
	}
}