package basic.day18.IO.mldn_io;

/**
 * ������ֱ��ʹ�������༴����������
 */
public class TestInputData {
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		InputData input = new InputData();
		i = input.getInt("�������һ�����֣�", "��������ݱ��������֣����������룡");
		j = input.getInt("������ڶ������֣�", "��������ݱ��������֣����������룡");
		System.out.println(i+"+"+j+"="+(i+j));
	}
}
