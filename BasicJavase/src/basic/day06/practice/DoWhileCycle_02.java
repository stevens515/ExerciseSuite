package basic.day06.practice;
public class DoWhileCycle_02 {
	public static void main(String[] args) {
		int max = 0;		// ��ʾ���ֵ
		int i = 0;			// ѭ���Ĵ���
		int n1 = 0;		// �����
		System.out.println("������ɵ�10��������ֱ�Ϊ��");
		do {
			n1 = (int) (Math.random() * 100);	// ͨ��Math��random�Ĳ���0��99֮������������
			if (i == 0) {						// ����ǵ�һ��ѭ��
				max = n1;					// �����ֵΪ��ǰ�����
		// �����򽫵�ǰ�������max�ı���ֵ���бȽϣ������ֵ�����max������
			} else if (n1 > max) {
				max = n1;
			}
			i++;							// ѭ�������Զ���1
			System.out.print(n1 + "  ");
		} while (i < 10);
		System.out.println("\n\nֵ��������Ϊ��" + max);
	}
}

